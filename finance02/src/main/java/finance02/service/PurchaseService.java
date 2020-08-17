package service;

import entities.*;
import java.util.List;

public interface PurchaseService {
    List<Purchase> getPurchases();
    void sort();  
    void append(Purchase p);
    void clean();
    int index(Redeem r);
    int findApplicationCodeIndex(Redeem r);
    // List<Purchase> minus1(Redeem r);    //指定赎回
    // List<Purchase> minus2(Redeem r);    //先进先出赎回
    // List<Purchase> minus3(Redeem r);    //后进先出赎回
    // List<Purchase> minus4(Redeem r);    //全部赎回
}