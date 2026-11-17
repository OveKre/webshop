// See DTO on ühe teise tarnija toote andmete Java-kujuline esitus.
package webshop.dto;

// Lombok loob väljadele getter'id ja setter'id, mida JSON-teisendus ja teenus kasutavad.
import lombok.Data;


// ArrayList hoiab tarnija ühest tootest saadud piltide aadresse.
import java.util.ArrayList;
// Date hoiab tarnija antud loomise ja uuendamise ajamärke.
import java.util.Date;

// @Data võimaldab SupplierService'il lugeda hinda ja määrata arvutatud jaehinna.
@Data
// Klass vastab ühe toote kujule välise API JSON-massiivis.
public class Supplier2 {

    // Tarnija enda toote id; seda ei tohi automaatselt samastada meie andmebaasi toote id-ga.
    private int id;
    // Toote kuvatav nimi tarnija vastuses.
    private String title;
    // URL-is või otsingus kasutatav lühike tekstkuju, mille tarnija kaasa annab.
    private String slug;
    // Tarnija esitatud hind, mida teenus kasutab filtreerimiseks ja 20% juurdehindluse alusena.
    private int price;
    // Meie arvutatud jaehind: SupplierService määrab sellele price * 1,2.
    private double retailPrice;
    // Toote kirjeldav tekst, mida saab kliendile kuvada.
    private String description;
    // Pesastatud kategooria andmed loetakse eraldi Supplier2Category DTO-sse.
    private Supplier2Category category;
    // Ühe toote mitme pildi veebiaadressid tarnija JSON-massiivist.
    private ArrayList<String> images;
    // Aeg, mil tarnija tooterekordi lõi.
    private Date creationAt;
    // Aeg, mil tarnija tooterekordit viimati muutis.
    private Date updatedAt;
}
