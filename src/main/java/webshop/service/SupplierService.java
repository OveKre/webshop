// Teenuseklass asub service-paketis, sest siin toimub andmete hankimine ja töötlemine.
package webshop.service;

// HttpMethod.GET märgib, et mõlemast välisest API-st ainult loetakse andmeid.
import org.springframework.http.HttpMethod;
// Service märgib klassi Springi hallatavaks teenuseks, mida kontroller saab kasutada.
import org.springframework.stereotype.Service;
// RestTemplate saadab HTTP-päringu ja teisendab JSON-vastuse Java objektideks.
import org.springframework.web.client.RestTemplate;
// Esimese tarnija toodete väljad vastavad Supplier1 DTO-le.
import webshop.dto.Supplier1;
// Teise tarnija toodete väljad vastavad Supplier2 DTO-le.
import webshop.dto.Supplier2;

// Arrays.stream võimaldab teise tarnija vastuse massiivi filtreerida ja töödelda.
import java.util.Arrays;
// Mõlemad meetodid tagastavad tooted List-kujul.
import java.util.List;

// Spring loob ühe SupplierService'i eksemplari ja süstib selle SupplierControllerisse.
@Service
// Kontroller seob URL-id meetoditega; siin tehakse välispäringud ja hinna arvutamine.
public class SupplierService {

    // Hangib esimese tarnija kõik tooted ja tagastab need loendina.
    public List<Supplier1> getProductsFromSupplier1() {
        // URL osutab esimese tarnija test-API lõpp-punktile, kust toodete JSON loetakse.
        String url = "https://6a917d307751d35ce47e88a4.mockapi.io/autod";
        // Selle objektiga saadame GET-päringu teise rakendusse.
        RestTemplate restTemplate = new RestTemplate();
        // exchange võtab URL-i, päringu meetodi, päringu keha/päised ja oodatava vastusetüübi.
        // GET-päringu puhul on kolmas argument null; JSON-vastus teisendatakse Supplier1[] massiiviks.
        Supplier1[] supplier1Products =  restTemplate.exchange(url , HttpMethod.GET, null, Supplier1[].class).getBody();
        // List.of teeb massiivist loendi. See eeldab, et getBody() ei tagastanud nulli.
        return List.of(supplier1Products);


    }
    // Hangib teise tarnija tooted, jätab odavaimad välja ja lisab ülejäänutele jaehinna.
    public List<Supplier2> getProductsFromSupplier2() {
        // Selle välise API lõpp-punkti vastus sisaldab teise tarnija toodete andmeid.
        String url = "https://api.escuelajs.co/api/v1/products";
        // Loome HTTP-kliendi, mis pärib tarnijalt toodete loendi.
        RestTemplate restTemplate = new RestTemplate();
        // Vastuse JSON-massiiv teisendatakse Supplier2[] massiiviks; tühi vastusekeha annaks nulli.
        Supplier2[] supplier2Products =  restTemplate.exchange(url , HttpMethod.GET, null, Supplier2[].class).getBody();
        // stream võimaldab massiivi elemente järjest filtreerida ja muuta.
           return Arrays.stream(supplier2Products)
        // Alles jäävad ainult tooted, mille tarnijahind on suurem kui 2.
        .filter(e ->e.getPrice() > 2)
              // Iga alles jäänud toote jaehind on tarnijahind * 1,2 ehk 20% kõrgem.
              // peek muudab sama Supplier2 objekti välja; seda kasutatakse siin õppenäitena kõrvalmõjuga.
              .peek(e -> e.setRetailPrice(e.getPrice()*1.2))
    //               .map(e -> {
    //                   e.setRetailPrice(e.getPrice()*1.2);
    //                   return e; // Väljakommenteeritud map-variant tagastaks muudetud sama objekti.
    //               })
                // toList kogub alles jäänud tooted loendisse, mille kontroller JSON-ina tagastab.
                .toList();
    }
}

     // Allolev tsükliga lahendus on välja kommenteeritud ega käivitu.
     // See näitab Stream API-le alternatiivset loendi läbimist, kuid kasutab jaehinna arvutamisel
     // getRetailPrice() väärtust. Uuel Supplier2 objektil on see algul 0, seega õige alus oleks getPrice().
        //        List<Supplier2> supplier2List = new ArrayList<>();
        //    for (Supplier2 supplier2Product: supplier2Products) {
        //        if (supplier2Product.getPrice() > 2) {
        //            supplier2Product.setRetailPrice(supplier2Product.getRetailPrice()*1.2);
        //            supplier2List.add(supplier2Product);    ///
        //        }
        //    }
        //        return supplier2List;



