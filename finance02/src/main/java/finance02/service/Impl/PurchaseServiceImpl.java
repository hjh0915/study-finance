package service.Impl;

import entities.*;
import entities.Purchase;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import service.PurchaseService;
import java.time.*;

public class PurchaseServiceImpl implements PurchaseService {
    List<Purchase> purchases;

    public PurchaseServiceImpl(List<Purchase> p) {
        this.purchases = p;
    }

    @Override
    public List<Purchase> getPurchases() {
        return purchases;
    }

    //根据日期+时间排序
    @Override
    public void sort() {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        if (purchases.size() > 1) {
            //list 集合排序
            purchases.sort((a1, a2) -> {
                return (sdf.format(a1.getTranDate())+a1.getTranTime()).compareTo(sdf.format(a2.getTranDate())+a2.getTranTime());
            });
        }
    }

    // 增加一条购买记录
    @Override
    public void append(Purchase p) {
        purchases.add(p);
    }

    // 清理交易份额（trade_quot）为0的记录
    @Override
    public void clean() {
        List<Purchase> newPurchases = new ArrayList<Purchase>();
        for(Purchase p : purchases) {
            if(p.getTradeQuot().equals(0)) {
                newPurchases.add(p);
            }
        }
        purchases = newPurchases;
    }

    // 根据赎回记录的时间找到对应一条购买记录的位置
    @Override
    public int index(Redeem r) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String rtime = sdf.format(r.getTranDate()) + r.getTranTime();
        int i = 0;
        for (Purchase p: purchases) {
            String ptime = sdf.format(p.getTranDate()) + p.getTranTime();
            int res = rtime.compareTo(ptime);
            if(res < 0) {
                i = purchases.indexOf(p) - 1;
                return i;
            }
        }
        if(purchases.contains(rtime)) {
            return i;
        } else {
            return purchases.size() - 1;
        }
    }

    // 根据赎回记录的指定合同号找到对应的购买记录的位置
    @Override
    public int findApplicationCodeIndex(Redeem r) {
        String appCode = r.getAppiontApplicationCode();
        int i = -1;
        for(Purchase p: purchases) {
            if(p.getApplicationCode().equals(appCode)) {
                i = purchases.indexOf(p)-1;
                break;
            }
        }
        return i;
    }
}