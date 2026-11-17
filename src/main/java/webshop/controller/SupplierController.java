// Kontroller kuulub controller-paketti: siin seotakse veebiaadressid Java meetoditega.
package webshop.controller;

// Lombok loob konstruktori final-välja jaoks, et Spring saaks teenuse kontrollerile anda.
import lombok.RequiredArgsConstructor;
// CrossOrigin määrab, milliselt veebiaadressilt brauser tohib neid lõpp-punkte kutsuda.
import org.springframework.web.bind.annotation.CrossOrigin;
// GetMapping seob HTTP GET-päringu konkreetse meetodiga.
import org.springframework.web.bind.annotation.GetMapping;
// RestController tagastab meetodite tulemused HTTP vastusena, siin JSON-kujul.
import org.springframework.web.bind.annotation.RestController;
// Esimese tarnija vastuse ühe toote andmeid kirjeldab Supplier1.
import webshop.dto.Supplier1;
// Teise tarnija vastuse ühe toote andmeid kirjeldab Supplier2.
import webshop.dto.Supplier2;
// SupplierService teeb tegelikud väliste API-de päringud ja andmete töötlemise.
import webshop.service.SupplierService;

// List tähendab, et kummastki lõpp-punktist tagastatakse mitu toodet.
import java.util.List;

// Spring loob sellest klassist REST-kontrolleri ja teisendab tagastatavad objektid JSON-iks.
@RestController
// Final-väljaga konstruktori loob Lombok; seda kasutab Spring sõltuvuse süstimiseks.
@RequiredArgsConstructor
// Brauseripäring on lubatud aadressilt, kus töötab projekti kohalik frontend.
@CrossOrigin(origins = "http://localhost:5173")
// Kontroller võtab päringu vastu ja annab töö edasi teenusele.
public class SupplierController {

    // Teenus on final, seega antakse see konstruktorisse ning seda ei vahetata hiljem välja.
    private final SupplierService supplierService;

    // GET /supplier1 kutsub alloleva meetodi, kui klient küsib esimese tarnija tooteid.
    @GetMapping("supplier1")
    // Tagastustüüp näitab, et vastuses on Supplier1-kujuliste toodete loend.
    public List<Supplier1> getProductsFromSupplier1() {
        // Kontroller ei tee välispäringut ise, vaid annab selle SupplierService'i teha.
        return supplierService.getProductsFromSupplier1();
    }

    // GET /supplier2 kutsub alloleva meetodi teise tarnija toodete küsimiseks.
    @GetMapping("supplier2")
    // Teise tarnija JSON teisendatakse Supplier2-objektide loendiks.
    public List<Supplier2> getProductsFromSupplier2() {
        // Teenus hangib tooted, filtreerib need ja arvutab jaehinna enne vastuse tagastamist.
        return supplierService.getProductsFromSupplier2();
    }

}
