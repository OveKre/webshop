// DTO asub dto-paketis, sest see kirjeldab rakenduse ja makseteenuse vahel liikuvat andmestikku.
package webshop.dto;

// @Data tekitab Lomboki abil väljadele getter'id ja setter'id ning vähendab käsitsi kirjutatavat koodi.
import lombok.Data;

// Selle klassi väljad moodustavad makse loomise POST-päringu JSON-keha.
@Data
// Iga väli vastab makseteenusele saadetava JSON-objekti samanimelisele võtmele.
public class PaymentBody {


    // Selle maksekonto nimi, mille alt makse luuakse; väärtus määratakse OrderService'is.
    private String account_name;
    // Ühe päringu eristav väärtus, mis aitab makseteenusel korduvaid päringuid ära tunda.
    private String nonce;
    // Päringu koostamise aeg tekstina; OrderService täidab selle ZonedDateTime väärtusega.
    private String timestamp;
    // Makstav summa, mis arvutatakse tellimuse toodete hindade põhjal.
    // double on siin olemasoleva koodi valik; rahasummade jaoks on ümarduse tõttu sageli sobivam BigDecimal.
    private double amount;
    // Meie tellimusega seotud viide, et makseteenuse andmed saaks hiljem õige tellimusega kokku viia.
    private String order_reference;
    // Aadress, kuhu klient saab pärast makseteenuses tegutsemist tagasi pöörduda.
    private String customer_url;
    // Makse API kasutajanimi, millega päringu saatja makseteenuses tuvastatakse.
    private String api_username;

}
