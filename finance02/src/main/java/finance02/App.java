package finance02;

import java.io.IOException;

import entities.*;
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

        Redeem r1 = new Redeem(
            "36015828", 
            LocalDate.of(2018, 2, 27),
            "141759", 
            "180225710987050869", 
            "710910010742065",
            "1300099C89",
            new BigDecimal(50000.00),
            "603302",
            1,
            "171020710975085783"
        );

        Redeem r2 = new Redeem(
            "36015828", 
            LocalDate.of(2018, 2, 27), 
            "141759", 
            "180225710987050869", 
            "710910010742065",
            "1300099C89",
            new BigDecimal(80000.00),
            "603302",
            2,
            "171020710975085783"
        );

        Redeem r3 = new Redeem(
            "36015828", 
            LocalDate.of(2018, 2, 27), 
            "141759", 
            "180225710987050869", 
            "710910010742065",
            "1300099C89",
            new BigDecimal(80000.00),
            "603302",
            3,
            "171020710975085783"
        );

        Redeem r4 = new Redeem(
            "36015828", 
            LocalDate.of(2018, 2, 27), 
            "141759", 
            "180225710987050869", 
            "710910010742065",
            "1300099C89",
            new BigDecimal(120000.00),
            "603302",
            4,
            "171020710975085783"
        );

        purchases.add(p1);
        purchases.add(p2);
        purchases.add(p3);

        PurchaseService pService = new PurchaseServiceImpl(purchases);
        pService.sort();
        // pService.minus1(r1);
        // pService.minus2(r2);
        // pService.minus3(r3);
        pService.minus4(r4);
        List<Purchase> ps = pService.getPurchases();
        for(Purchase p: ps) {
            System.out.println(p.getTradeQuot());
        }

        List<Purchase> nps = pService.clean(ps);
        for(Purchase p: nps) {
            System.out.println(p.getTradeQuot());
        }
    }
}