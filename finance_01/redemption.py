# 1、先建立一个赎回的类
# 2、写好赎回的属性
# 3、写好赎回的四种方法（函数）

class Redemption:
    def __init__(self, OrganCode, TradeDate, TradeTime, ApplicationCode, TaCode, 
                    ProdCode, TradeQuot, TradeCode, RegeemSequence, AppiontApplicationCode):
        self.OrganCode = OrganCode
        self.TranDate = TranDate
        self.TranTime = TranTime
        self.ApplicationCode = ApplicationCode
        self.TaCode = TaCode
        self.ProdCode = ProdCode
        self.TradeQuot = TradeQuot
        self.TradeCode = TradeCode
        self.RegeemSequence = RegeemSequence
        self.AppiontApplicationCode = AppiontApplicationCode

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