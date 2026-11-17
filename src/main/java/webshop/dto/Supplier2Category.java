// Selle DTO väljad kirjeldavad teise tarnija toote sisse pesastatud kategooriat.
package webshop.dto;

// Lombok loob väljade lugemiseks ja määramiseks vajalikud meetodid.
import lombok.Data;

// Date on kategooria loomise ja uuendamise ajamärkide tüüp.
import java.util.Date;

// JSON-teisendus täidab kategooria objekti selle väljade põhjal.
@Data
// Supplier2.category viitab sellele klassile, mitte meie rakenduse Category olemile.
public class Supplier2Category {

    // Tarnija kategooria id, mis erineb meie andmebaasi kategooria id-st.
    private int id;
    // Kategooria nimi, mida saab kasutajaliideses kuvada.
    private String name;
    // URL-sõbralik kategooria nimetus, mille tarnija annab.
    private String slug;
    // Kategooriat illustreeriva pildi aadress.
    private String image;
    // Tarnija andmetes märgitud kategooria loomise aeg.
    private Date creationAt;
    // Tarnija andmetes märgitud kategooria viimase muutmise aeg.
    private Date updatedAt;
}
