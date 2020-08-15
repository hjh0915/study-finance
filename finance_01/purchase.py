# 1、先建立一个购买的类
# 2、写好购买的属性
# 3、写好购买的方法（函数）

class Purchase:
    def __init__(self, OrganCode, TradeDate, 
                    TradeTime, ApplicationCode, TaCode, ProdCode, TradeQuot, TradeCode):
        self.OrganCode = OrganCode
        self.TranDate = TranDate
        self.TranTime = TranTime
        self.ApplicationCode = ApplicationCode
        self.TaCode = TaCode
        self.ProdCode = ProdCode
        self.TradeQuot = TradeQuot
        self.TradeCode = TradeCode

    def get_series_products(self):
        '''一个客户可购买多个（多次）理财产品'''
        products = []
        # 建模