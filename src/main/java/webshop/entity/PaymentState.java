package webshop.entity;

public enum PaymentState {
    // Tellimus on loodud ja makse algatamine käib; edukat ega ebaõnnestunud makset pole veel kinnitatud.
    INITIAL,
    SETTLED, // Korras makse
    FAILED, // Ebaõnnestunud makse
    ABANDONED, // Maksesesioooni aeg , ehk liiga kaua venitanud , pangalingil makse sooritamist!!
    VOIDED // vajutanud CANCEL nuppu , kasutaja ei ole nõus protsessi jätkama!!

}
