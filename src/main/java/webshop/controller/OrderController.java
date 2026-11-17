package webshop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
// Teenuse tagastatud pakiautomaatide andmed teisendatakse selle DTO abil HTTP vastuseks.
import webshop.dto.ParcelMachine;
import webshop.entity.Order;
// Uus tellimus saab enne makse alustamist algse makseoleku.
import webshop.entity.PaymentState;
import webshop.repository.OrderRepository;
// Arvutused ja väliste teenuste päringud on koondatud OrderService'i.
import webshop.service.OrderService;

// Date annab tellimuse loomise hetke, mis salvestatakse koos tellimusega.
import java.util.Date;
import java.util.List;
@Log4j2
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    // Lomboki @RequiredArgsConstructor annab sellele final-väljale konstruktori kaudu väärtuse.
    private final OrderService orderService;

    @GetMapping("orders")
    public List<Order> getOrders() {
        System.out.println("xxx vaata Orders");   /// Vaälja print konsooli
        log.info("Orders GET request made by: xx");
        return orderRepository.findAll();
    }

    @PostMapping("orders")
    // @RequestBody muudab päringu JSON-sisu Order-objektiks; vastuseks antakse makselink.
    public String addOrder(@RequestBody Order order) {
      // Liidame tellimuses olevate toodete hinnad, et maksele saadetav summa tuleks toodetest.
      double sum = orderService.calculateCartSum(order.getProducts());
      // Salvestame arvutatud summa tellimusse, et andmebaasi jääks sama summa, mille eest makset alustame.
      order.setSum(sum);
      // INITIAL tähendab, et makse on alles algatamisel; see ei kinnita veel raha laekumist.
      order.setState(PaymentState.INITIAL);
      // Uus Date fikseerib käesoleva hetke tellimuse loomise ajana.
      order.setCreated(new Date());
      // Isikut ja tooteid siin eraldi ei määrata: need peavad tulema @RequestBody kaudu saadud order-objektist.
      // Järgmised kaks vana näidisrida on välja kommenteeritud ega mõjuta programmi tööd.
      // order.setPerson();
      // order.setProducts();
      // Salvestame tellimuse enne maksepäringut, sest andmebaas annab sellele makseviiteks vajaliku id.
       Order dbOrder = orderRepository.save(order);
      // Kasutame salvestatud tellimuse id-d ja summat makse algatamiseks ning tagastame saadud makselingi.
     return orderService.makePayment(dbOrder.getId(), sum);

    }

    // Seob GET /parcel-machines päringu alloleva meetodiga.
    @GetMapping("parcel-machines")
    // List<ParcelMachine> määrab, et vastus sisaldab pakiautomaatide loendit.
    public List<ParcelMachine> getParcelMachines() {
        // Teenus küsib pakiautomaatide andmed välisest API-st; Spring tagastab loendi JSON-ina.
        return orderService.getParcelMachines();
    }

}
