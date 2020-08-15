# 1、先建立一个购买的类
# 2、写好购买的属性
# 3、写好购买的方法
from .redeem import Redeem

class Purchase:
    def __init__(self, organ_code, tran_date, tran_time, 
                application_code, ta_code, prod_code, trade_quot, trade_code):
        self.organ_code = organ_code
        self.tran_date = tran_date
        self.tran_time = tran_time
        self.application_code = application_code
        self.ta_code = ta_code
        self.prod_code = prod_code
        self.trade_quot = trade_quot    # 交易份额
        self.trade_code = trade_code    

class Purchases:
    def __init__(self, purchases):
        # 列表，元素是Purchase
        self.purchases = purchases

    def sort(self):
        '''按照日期+时间排序'''

        #先将tran_date日期型转换为字符串型
        # p = [5, 3, 2, 8]
        # p.sort(key=lambda x: x)
        self.purchases.sort(key=lambda x: x.tran_date.strftime("%Y%m%d")+x.tran_time)

    def append(self, p: Purchase):
        '''
            增加一条购买记录
            p: Purchase
        '''

        self.purchases.append(p)

    def clean(self):
        '''清理交易份额（trade_quot）为0的记录'''

        # p = [5, 3, 2, 8]
        # [x for x in p if x > 3]
        self.purchases = [x for x in self.purchases if x.trade_quot != 0]
    
    def index(self, r: Redeem) -> int:
        '''根据赎回记录的时间找到对应一条购买记录的位置'''

        x = r.tran_date.strftime("%Y%m%d") + r.tran_time

        k = 0
        found = False
        for i, p in enumerate(self.purchases):
            y = p.tran_date.strftime("%Y%m%d") + p.tran_time
            if x < y:
                k = i - 1
                found = True
                break

        if found:
            return k
        else:
            # 赎回日期时间大于所有购买记录日期时间
            return len(self.purchases) - 1

    def find_application_code_index(self, r: Redeem) -> int:
        '''根据赎回记录的指定合同号找到对应的购买记录的位置'''

        app_code = r.appiont_application_code
        # -1代表没有找到指定合同号的标识
        k = -1 
        for i, p in enumerate(self.purchases):
            if p.application_code == app_code:
                k = i
                break

        return k

    def minus(self, r: Redeem):
        '''根据赎回记录的交易份额扣减购买记录的交易份额'''

        s = r.regeem_sequence
        if s == 1:
            # 指定赎回
            self.minus1(r)
        elif s == 2:
            # 先进先出赎回
            self.minus2(r)
        elif s == 3:
            # 后进先出赎回
            self.minus3(r)
        elif s == 4:
            # 全部赎回
            self.minus4(r)
    
    def minus1(self, r: Redeem):
        '''指定赎回是根据某一条购买记录的合同号'''

        i = self.find_application_code_index(r)
        self.purchases[i].trade_quot -= r.trade_quot

    def minus2(self, r: Redeem):
        '''先进先出赎回是根据时间日期的排序拿出先购买的金额'''

        pos = self.index(r)
        quot = r.trade_quot

        for p in self.purchases[:pos+1]:
            if p.trade_quot < quot:
                # 如果购买交易份额小于赎回交易份额
                quot -= p.trade_quot
                p.trade_quot = 0
            else:
                p.trade_quot -= quot
    
    def minus3(self, r: Redeem):
        '''后进先出赎回是根据时间日期的排序拿出后购买的金额'''

        i = self.index(r)
        quot = r.trade_quot

        while i >= 0:
            if self.purchases[i].trade_quot < quot:
                quot -= self.purchases[i].trade_quot
                self.purchases[i].trade_quot = 0
            else:
                self.purchases[i].trade_quot -= quot
            i -= 1

    def minus4(self, r: Redeem):
        '''全部赎回是将多次购买的理财产品全部赎回，全部为0'''

        pos = self.index(r)
        for p in self.purchases[:pos+1]:
            p.trade_quot = 0