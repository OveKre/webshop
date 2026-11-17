// DTO kannab ühe pakiautomaadi välise API JSON-andmed Java objekti.
package webshop.dto;

// JsonProperty seob API suurtähtedega väljanime vastava Java väljaga.
import com.fasterxml.jackson.annotation.JsonProperty;
// Lombok loob väljade lugemiseks ja määramiseks getter'id ning setter'id.
import lombok.Data;

// Date hoiab API antud viimase muutmise ajamärki.
import java.util.Date;


// Springi JSON-teisendus täidab selle klassi väljad pakiautomaatide API vastusest.
@Data
// Üks ParcelMachine objekt vastab ühele pakiautomaadi kirjele vastuse massiivis.
public class ParcelMachine {

    // JSON-i ZIP-võti seotakse alloleva väljaga; siin hoitakse API antud asukohakoodi.
    @JsonProperty("ZIP")
    private String zIP;
    // NAME on pakiautomaadi kuvatav nimi, mille järgi klient saab asukoha ära tunda.
    @JsonProperty("NAME")
    private String nAME;
    // TYPE salvestab API antud asukoha või teenuspunkti liigi.
    @JsonProperty("TYPE")
    private String tYPE;
    // A0_NAME on esimese asukohataseme nimi välise API andmestruktuuris.
    @JsonProperty("A0_NAME")
    private String a0_NAME;
    // A1_NAME on järgmise asukohataseme nimi; kui API väärtust ei anna, jääb väli nulliks.
    @JsonProperty("A1_NAME")
    private String a1_NAME;
    // A2_NAME säilitab API kolmanda asukohataseme nimetuse.
    @JsonProperty("A2_NAME")
    private String a2_NAME;
    // A3_NAME säilitab API neljanda asukohataseme nimetuse.
    @JsonProperty("A3_NAME")
    private String a3_NAME;
    // A4_NAME säilitab API viienda asukohataseme nimetuse.
    @JsonProperty("A4_NAME")
    private String a4_NAME;
    // A5_NAME säilitab API kuuenda asukohataseme nimetuse.
    @JsonProperty("A5_NAME")
    private String a5_NAME;
    // A6_NAME säilitab API seitsmenda asukohataseme nimetuse.
    @JsonProperty("A6_NAME")
    private String a6_NAME;
    // A7_NAME säilitab API kaheksanda asukohataseme nimetuse.
    @JsonProperty("A7_NAME")
    private String a7_NAME;
    // A8_NAME säilitab API üheksanda asukohataseme nimetuse.
    @JsonProperty("A8_NAME")
    private String a8_NAME;
    // X_COORDINATE on asukoha esimene koordinaat; see salvestatakse API kuju järgi tekstina.
    @JsonProperty("X_COORDINATE")
    private String x_COORDINATE;
    // Y_COORDINATE on asukoha teine koordinaat; koos X-väljaga saab määrata punkti kaardil.
    @JsonProperty("Y_COORDINATE")
    private String y_COORDINATE;
    // SERVICE_HOURS sisaldab API tavapärast lahtiolekuaega kirjeldavat väärtust.
    @JsonProperty("SERVICE_HOURS")
    private String sERVICE_HOURS;
    // TEMP_SERVICE_HOURS kirjeldab võimalikke ajutisi lahtiolekuaegu.
    @JsonProperty("TEMP_SERVICE_HOURS")
    private String tEMP_SERVICE_HOURS;
    // TEMP_SERVICE_HOURS_UNTIL annab esimese ajutise ajakava kehtivuse lõpu.
    @JsonProperty("TEMP_SERVICE_HOURS_UNTIL")
    private String tEMP_SERVICE_HOURS_UNTIL;
    // TEMP_SERVICE_HOURS_2 võimaldab API-l edastada teise ajutise ajakava.
    @JsonProperty("TEMP_SERVICE_HOURS_2")
    private String tEMP_SERVICE_HOURS_2;
    // TEMP_SERVICE_HOURS_2_UNTIL annab teise ajutise ajakava kehtivuse lõpu.
    @JsonProperty("TEMP_SERVICE_HOURS_2_UNTIL")
    private String tEMP_SERVICE_HOURS_2_UNTIL;
    // Eestikeelne lisateave või märkus, kui API selle sama nimega väljana annab.
    private String comment_est;
    // Ingliskeelne lisateave või märkus sama pakiautomaadi kohta.
    private String comment_eng;
    // Venekeelne lisateave või märkus sama pakiautomaadi kohta.
    private String comment_rus;
    // Lätikeelne lisateave või märkus sama pakiautomaadi kohta.
    private String comment_lav;
    // Leedukeelne lisateave või märkus sama pakiautomaadi kohta.
    private String comment_lit;
    // MODIFIED on aeg, millal pakiautomaadi kirjet välises andmeallikas viimati muudeti.
    @JsonProperty("MODIFIED")
    private Date mODIFIED;
}
