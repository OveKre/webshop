// DTO asub dto-paketis, sest see kannab makseteenuselt saadud andmed Java koodi sisse.
package webshop.dto;

// @Data loob väljade lugemiseks getter'id ja väärtuste määramiseks setter'id.
import lombok.Data;

// Date tüüp hoiab makseteenuse tagastatud makse loomise aega.
import java.util.Date;

// Springi JSON-teisendus täidab selle klassi väljad makse API vastusest.
@Data
// Klassis on ka välju, mida praegune teenus ei kasuta, sest need kuuluvad API vastuse tervikusse.
public class PaymentResponse {


    // Konto nimi näitab, millise maksekontoga vastuses kirjeldatud makse on seotud.
    private String account_name;
    // Tellimuse viide aitab vastuse siduda algses maksepäringus saadetud tellimusega.
    private String order_reference;
    // Kliendi e-posti väärtus, kui makseteenus selle annab; Object ei määra siin täpset andmetüüpi.
    private Object email;
    // Kliendi IP-aadressi väärtus, kui see on vastuses olemas; Object lubab ka nulli.
    private Object customer_ip;
    // Kliendi tagasipöördumise aadress, mis anti maksepäringus makseteenusele.
    private String customer_url;
    // Aeg, millal makseteenus makse lõi; Jackson teisendab JSON-i väärtuse Date-objektiks.
    private Date payment_created_at;
    // Algselt maksmiseks saadetud summa makseteenuse vastuses.
    private double initial_amount;
    // Makseteenuse näidatud veel tasumata või makse seisuga seotud summa.
    private double standing_amount;
    // Makseteenuse loodud makse viitenumber, millega saab sama makset hiljem ära tunda.
    private String payment_reference;
    // Link makselehele; OrderService tagastab just selle väärtuse tellimuse loomise vastusena.
    private String payment_link;
    // API kasutajanimi, mille konto alt makse tehti.
    private String api_username;
    // Makseteenuse võimalik lisaväli; Object jätab tüübi lahtiseks, sest kood seda ei töötle.
    private Object stan;
    // Makseteenuse võimalik pettuseriski hinnang; siin seda ei tõlgendata ega kontrollita.
    private Object fraud_score;
    // Makseteenuse teatatud makseolek tekstina; see ei muuda automaatselt Order.state välja.
    private String payment_state;
    // Kasutatud makseviisi kirjeldus, kui makseteenus selle tagastab; täpne kuju on siin määramata.
    private Object payment_method;
    // Makse valuuta tähis, näiteks EUR, nagu makseteenus selle vastuses edastab.
    private String currency;
    // Apple Pay kaupmehe tunnus juhul, kui vastus seda sisaldab; käesolev kood seda ei kasuta.
    private Object applepay_merchant_identifier;
    // Vastuses esitatud riigi tähis, mida makse kirjelduses kasutatakse.
    private String descriptor_country;
    // Google Pay kaupmehe tunnus juhul, kui vastus seda sisaldab; käesolev kood seda ei kasuta.
    private Object googlepay_merchant_identifier;
}
