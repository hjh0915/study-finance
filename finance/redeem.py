# 1、先建立一个赎回的类
# 2、写好赎回的属性
# 3、写好赎回的四种方法（函数）

class Redeem:
    def __init__(self, organ_code, tran_date, tran_time, application_code, ta_code, 
                prod_code, trade_quot, trade_code, regeem_sequence, appiont_application_code):
        self.organ_code = organ_code
        self.tran_date = tran_date
        self.tran_time = tran_time
        self.application_code = application_code
        self.ta_code = ta_code
        self.prod_code = prod_code
        self.trade_quot = trade_quot
        self.trade_code = trade_code
        self.regeem_sequence = regeem_sequence
        self.appiont_application_code = appiont_application_code

    # 指定赎回
    def assign_back(self):
        '''指定赎回是根据某一购买的合同号'''
    
    # 全部赎回
    def all_back(self):
        '''全部赎回是将多次购买的理财产品全部赎回'''

    # 先进先出赎回
    def first_back(self):
        '''先进先出赎回是根据合同号的排序拿出先购买的金额'''

    # 后进先出赎回
    def last_back(self):
        '''后进先出赎回是根据合同号的排序拿出后购买的金额'''