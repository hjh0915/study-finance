# 1、先建立一个赎回的类
# 2、写好赎回的属性
# 3、写好赎回的四种方法（函数）

class Redemption:
    def __init__(self, netCode, tranDate, tranTime, contractCode, 
                    otherNumber, productCode, tranShare, tranCode, redNumber, purchaseCode):
        self.netCode = netCode
        self.tranDate = tranDate
        self.tranTime = tranTime
        self.contractCode = contractCode
        self.otherNumber = otherNumber
        self.productCode = productCode
        self.tranShare = tranShare
        self.tranCode = tranCode
        self.redNumber = redNumber
        self.purchaseCode = purchaseCode

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