// DTO kirjeldab ühe tarnija tooterealt saadud andmeid, mitte andmebaasitabelit.
package webshop.dto;

// Lombok aitab väärtusi JSON-ist objektile määrata ja neid hiljem objektist lugeda.
import lombok.Data;

// @Data loob muu hulgas getter'id, setter'id ja vajaliku konstruktori nende väljadega klassile.
@Data
// Väljade nimed vastavad esimese tarnija JSON-vastuse võtmetele.
public class Supplier1 {
    // Tootja nimi, näiteks automark või ettevõte, nagu tarnija selle saadab.
    private String tootja;
    // Toote mudeli või margi nimetus tarnija andmetes.
    private String mark;
    // Hind on siin tekstina, sest tarnija näidisvastuses on see jutumärkides; seda ei arvutata.
    private String hind;
    // Toote pildi veebiaadress, mida frontend saab pildi kuvamiseks kasutada.
    private String pilt;
    // Tarnija antud värvinimetus, näiteks ingliskeelne värv.
    private String varv;
    // Väljakommenteeritud varvEST ei ole praegu klassi väli ega ilmu Supplier1 vastuses.
    // private String varvEST;
    // Tarnija toote tunnus on tekstina; see ei ole meie andmebaasi Product.id.
    private String id;

}


// Näide ühe toote JSON-kujust: iga võti saab lugemisel samanimelise Java välja väärtuseks.
// {
//   "tootja": "Fiat",
//   "mark": "Panda",
//   "hind": "394.21",
//   "pilt": "https://example.com/auto.jpg",
//   "varv": "tan",
//   "id": "1"
// }
