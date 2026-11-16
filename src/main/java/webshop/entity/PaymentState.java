package webshop.entity;

public enum PaymentState {
    SETTLED, // Korras makse
    FAILED, // Ebaõnnestunud makse
    ABANDONED, // Maksesesioooni aeg , ehk liiga kaua venitanud , pangalingil makse sooritamist!!
    VOIDED // vajutanud CANCEL nuppu , kasutaja ei ole nõus protsessi jätkama!!

}
