package service.Impl;

import entities.*;
import entities.Purchase;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import service.PurchaseService;
import java.time.*;
import java.math.BigDecimal;

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
    public List<Purchase> clean(List<Purchase> ps) {
        List<Purchase> newPurchases = new ArrayList<Purchase>();
        for(Purchase p : ps) {
            int flag = (p.getTradeQuot()).compareTo(BigDecimal.ZERO);
            if(flag != 0) {
                newPurchases.add(p);
            }
        }
        return newPurchases;
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
                i = purchases.indexOf(p);
                break;
            }
        }
        return i;
    }

    @Override
    public void minus(Redeem r) {
        int s = r.getRegeemSequence();
        switch(s){
            case 1:
                // 指定赎回
                minus1(r);
                break;
            case 2:
                // 先进先出赎回
                minus2(r);
                break;
            case 3:
                // 先进后出赎回
                minus3(r);
                break;
            case 4:
                // 全部赎回    
                minus4(r);
                break;
            default:
                System.out.println("default");
        }
    }

    @Override
    // 指定赎回
    public void minus1(Redeem r) {
        int i = findApplicationCodeIndex(r);
        BigDecimal x = (purchases.get(i).getTradeQuot()).subtract(r.getTradeQuot());
        purchases.get(i).setTradeQuot(x);
    }

    @Override
    // 先进先出赎回
    public void minus2(Redeem r) {
        int pos = index(r);
        BigDecimal quot = r.getTradeQuot();
        List<Purchase> purchases2 = purchases.subList(0, pos+1);
        for(Purchase p: purchases2) {
            int flag = p.getTradeQuot().compareTo(quot);
            if(flag < 0) {
                // 如果购买交易份额小于赎回交易份额
                quot = quot.subtract(p.getTradeQuot());
                p.setTradeQuot(BigDecimal.ZERO);
            } else {
                p.setTradeQuot(p.getTradeQuot().subtract(quot));
            }
        }
    }

    // 后进先出赎回
    public void minus3(Redeem r) {
        int i = index(r);
        BigDecimal quot = r.getTradeQuot();
        while(i >= 0) {
            int flag = (purchases.get(i).getTradeQuot()).compareTo(quot);
            if(flag < 0) {
                quot = quot.subtract(purchases.get(i).getTradeQuot());
                purchases.get(i).setTradeQuot(BigDecimal.ZERO);
            } else {
                purchases.get(i).setTradeQuot((purchases.get(i).getTradeQuot()).subtract(quot));
            }
            i -= 1;
        }
    } 

    // 全部赎回 
    public void minus4(Redeem r) {
        int pos = index(r);
        List<Purchase> purchases2 = purchases.subList(0, pos+1);
        for(Purchase p: purchases2) {
            p.setTradeQuot(BigDecimal.ZERO);
        }
    }
}