package service;

import entities.*;
import java.util.List;

public interface PurchaseService {
    List<Purchase> getPurchases();
    void sort();  
    void append(Purchase p);
    List<Purchase> clean(List<Purchase> ps);
    int index(Redeem r);
    int findApplicationCodeIndex(Redeem r);
    void minus(Redeem r);
    void minus1(Redeem r);    //指定赎回
    void minus2(Redeem r);    //先进先出赎回
    void minus3(Redeem r);    //后进先出赎回
    void minus4(Redeem r);    //全部赎回
}