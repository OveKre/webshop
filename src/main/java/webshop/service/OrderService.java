// Teenuseklass paikneb service-paketis, kuhu on koondatud kontrollerist eraldatud tööloogika.
package webshop.service;

// HttpEntity ühendab maksepäringu JSON-keha ja HTTP päised üheks päringuobjektiks.
import org.springframework.http.HttpEntity;
// HttpHeaders võimaldab määrata autentimise ja saadetavate andmete sisutüübi.
import org.springframework.http.HttpHeaders;
// HttpMethod määrab, kas välisesse API-sse tehakse GET- või POST-päring.
import org.springframework.http.HttpMethod;
// MediaType.APPLICATION_JSON ütleb makse API-le, et päringu keha on JSON.
import org.springframework.http.MediaType;
// @Service laseb Springil selle klassi luua ja OrderControllerisse süstida.
import org.springframework.stereotype.Service;
// RestTemplate saadab HTTP-päringu teise rakendusse ja teisendab JSON-vastuse Java objektiks.
import org.springframework.web.client.RestTemplate;
// ParcelMachine kirjeldab ühe Omniva pakiautomaadi vastusest loetavaid välju.
import webshop.dto.ParcelMachine;
// PaymentBody kirjeldab makse API-le saadetava päringu välju.
import webshop.dto.PaymentBody;
// PaymentResponse kirjeldab makse API-lt saadava vastuse välju, sealhulgas makselinki.
import webshop.dto.PaymentResponse;
// Product sisaldab ostukorvi toote hinda, mida kogusumma arvutamisel kasutatakse.
import webshop.entity.Product;


// ZonedDateTime annab maksepäringule ajatembli ja osaleb nonce'i moodustamises.
import java.time.ZonedDateTime;
// List on meetodite tagastustüüp ja ostukorvi toodete kogum.
import java.util.List;

// Spring registreerib klassi teenusena ning võimaldab seda kontrolleris kasutada.
@Service
// Siin asuvad pakiautomaatide ja maksete välispäringud ning ostukorvi summa arvutamine.
public class OrderService {
    // Meetod hangib välisest teenusest kõik pakiautomaadid ja tagastab need Java loendina.
    public List<ParcelMachine> getParcelMachines() {
        // See aadress on Omniva JSON-andmete allikas, mille poole päring suunatakse.
        String url = "https://www.omniva.ee/locations.json";
        // Loome HTTP-kliendi, mis saab saata GET-päringu välisesse teenusesse.
        RestTemplate restTemplate = new RestTemplate();
        // exchange saadab GET-päringu ilma kehata (null) ja teisendab vastuse ParcelMachine[] massiiviks.
        // getBody võtab HTTP-vastusest andmed; järgnevad read eeldavad, et vastuse keha ei ole null.
        ParcelMachine[] parcelMachines = restTemplate.exchange(url, HttpMethod.GET, null, ParcelMachine[].class).getBody();
        // List.of teeb massiivist loendi, mille saab kontrolleri kaudu JSON-vastusena tagastada.
        return List.of(parcelMachines);
    }

    // Meetod alustab salvestatud tellimuse id ja summa põhjal makset ning tagastab tasumise lingi.
    public String makePayment(Long orderId, double sum) {
        // Makse loomise POST-päring saadetakse EveryPay testkeskkonna oneoff-lõpp-punkti.
        String url = "https://igw-demo.every-pay.com/api/v4/payments/oneoff";
        // Eraldi HTTP-klient saadab maksepäringu ja loeb selle vastuse.
        RestTemplate restTemplate = new RestTemplate();

        // Loome objekti, mille väljad saadetakse makse API-le JSON-päringu kehana.
        PaymentBody body = new PaymentBody();
        // API kasutajanimi näitab makseteenusele, millise testkonto alt päring tehakse.
        body.setApi_username("e36eb40f5ec87fa2");
        // Saadame arvestusliku ostukorvi summa makseteenusele makstava summana.
        body.setAmount(sum);
        // Konto nimi valib selle testkonto, mille kaudu makset töödeldakse.
        body.setAccount_name("EUR3D1");
        // Kliendi tagasipöördumise aadress viitab siin lokaalsele testirakendusele.
        body.setCustomer_url("http://localtest.me:8080/payment");
        // Nonce eristab päringuid: aeg ja juhuarv vähendavad sama väärtuse kordumise tõenäosust,
        // kuid Math.random() ei anna absoluutset unikaalsuse garantiid.
        body.setNonce("fqe" + ZonedDateTime.now() + Math.random());
        // Tellimuse id lisatakse viitesse, et makset oleks võimalik konkreetse tellimusega siduda.
        body.setOrder_reference("ove" +orderId.toString());
        // Ajatempel kirjeldab päringu koostamise hetke ISO-kujul koos ajavööndi infoga.
        body.setTimestamp(ZonedDateTime.now().toString());


        // HTTP päistesse pannakse autentimise ja andmevormingu teave.
        HttpHeaders headers = new HttpHeaders();
        // Basic Auth saadab testkonto kasutajanime ja salasõna HTTP Authorization-päises.
        // Pärisrakenduses tuleks need väärtused lugeda seadistusest, mitte hoida lähtekoodis.
        headers.setBasicAuth("e36eb40f5ec87fa2", "");
        // Content-Type: application/json ütleb, kuidas makseteenus päringu keha tõlgendab.
        headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity seob PaymentBody ja päised üheks POST-päringuga saadetavaks väärtuseks.
        HttpEntity bodyAndHeaders = new HttpEntity(body, headers);



        // exchange saadab POST-päringu ning teisendab vastuse PaymentResponse-objektiks.
        // getBody võib ebaõnnestunud või tühja vastuse korral olla null; see kood eeldab olemasolevat vastust.
        PaymentResponse paymentResponse = restTemplate.exchange(url, HttpMethod.POST, bodyAndHeaders, PaymentResponse.class).getBody();
        // Võtame vastusest makselingi, mille kontroller tagastab tellimuse loomise päringu vastusena.
        return paymentResponse.getPayment_link();
    }

    // Arvutab kõigi etteantud toodete hindade summa tavalise for-tsükliga.
    public double calculateCartSum(List<Product> products) {
        // Alustame nullist, et iga toote hind saaks senisele summale lisanduda.
        double sum = 0;
        // Tsükkel võtab products-loendist järjest ühe Product-objekti korraga.
        for (Product product : products) {
            // getPrice loeb praeguse toote hinna ning += liidab selle kogusummale.
            sum  += product.getPrice();
        }
        // Kui kõik tooted on läbi käidud, anname arvutatud kogusumma kutsujale tagasi.
        return sum;
    }

    // Sama arvutuse alternatiivne näide Java Stream API abil; addOrder kasutab eelmist meetodit.
    public double calculateCartSum2(List<Product> products) {

            // stream muudab toodete loendi järjest töödeldavaks vooks.
            return products.stream()
                    // mapToDouble loeb igast tootest hinna ja teeb neist arvudest DoubleStreami.
                    .mapToDouble(e -> e.getPrice())
                    // sum liidab voo hinnad kokku ning tagastab tulemuse double-väärtusena.
                    .sum();

    }
}
