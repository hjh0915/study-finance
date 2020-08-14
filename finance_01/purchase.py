# 1、先建立一个购买的类
# 2、写好购买的属性
# 3、写好购买的方法（函数）

class Purchase:
    def __init__(self, netCode, tranDate, 
                    tranTime, contractCode, otherNumber, productCode, tranShare, tranCode):
        self.netCode = netCode
        self.tranDate = tranDate
        self.tranTime = tranTime
        self.contractCode = contractCode
        self.otherNumber = otherNumber
        self.productCode = productCode
        self.tranShare = tranShare
        self.tranCode = tranCode

    def get_series_products(self):
        '''一个客户可购买多个（多次）理财产品'''
        products = []
        # 建模