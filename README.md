针对理财产品的购买和赎回
====================
理财产品的三种类型
---------------
1、开放式（任何时间都可以购买和赎回）
2、封闭式（不能立即生效，确定时间自动赎回）
3、定开式（确定赎回金额开放时间）

赎回方式
-------
1、指定赎回
根据某次购买记录的合同号赎回，需要在赎回的属性中找到相应的购买合同号
2、全部赎回
将购买的所有理财产品一次性赎回，可不按顺序
3、先进先出赎回
根据每次购买记录的日期顺序，赎回先购买的理财产品
4、后进先出赎回
根据每次购买记录的日期顺序，赎回后购买的理财产品

问题：
----
一个客户可以多次购买理财产品，但是每一笔赎回只针对一个理财产品的购买。
需要针对一个购买产品，进行四种不同方式的赎回分析。

购买属性及类型
------------
OrganCode
TranDate                datetime
TranTime                string
ApplicationCode
TaCode
ProdCode
TradeQuot               Decimal
TradeCode

赎回属性及类型
------------
OrganCode
TranDate                datetime
TranTime                string
ApplicationCode
TaCode
ProdCode
TradeQuot               Decimal
TradeCode
RegeemSequence          int
AppiontApplicationCode

*购买属性类型同上类似*

购买中的需求
==========
1、赎回交易时存在先进先出、后进先出方式，在处理购买记录时需要排序
2、赎回交易时存在购买记录的交易份额为0的情况，下一次处理赎回记录时不可再将为0的记录赎回
3、需要根据赎回交易的日期时间找到相应的一条购买记录的位置
4、需要根据赎回记录的指定合同号找到对应的一条购买记录的位置

测试
===
pytest -s -v -k test_xxx(函数名) tests/test_purchase.py