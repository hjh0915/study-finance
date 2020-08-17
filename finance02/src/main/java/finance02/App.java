package finance02;

import java.io.IOException;

import entities.Purchase;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.Impl.PurchaseServiceImpl;
import service.PurchaseService;
import java.time.*;

public class App {
    public static void main(String[] args) throws IOException {
        List<Purchase> purchases = new ArrayList<Purchase>();

        Purchase p1 = new Purchase(
            "36015828",
            LocalDate.of(2018, 2, 22),
            "120642",
            "180222710986153573",
            "710910010742065",
            "1300099C89",
            new BigDecimal(70000.00),
            "603302"
        );

        Purchase p2 = new Purchase(
            "36015828",
            LocalDate.of(2017, 10, 20),
            "132112",
            "171020710975085783",
            "710910010742065",
            "1300099C89",
            new BigDecimal(50000.00),
            "603302"
        );

        Purchase p3 = new Purchase(
            "36015828",
            LocalDate.of(2018, 2, 28),
            "125759",
            "180222710986153573",
            "710910010742065",
            "1300099C89",
            new BigDecimal(50000.00),
            "603302"
        );
        purchases.add(p1);
        purchases.add(p2);
        purchases.add(p3);

        PurchaseService pService = new PurchaseServiceImpl(purchases);
        pService.sort();

        List<Purchase> ps = pService.getPurchases();

        for(Purchase p: ps) {
            System.out.println(p.getTranDate());
        }
    }
}