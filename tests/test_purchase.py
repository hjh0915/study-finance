import unittest
from finance import purchase, redeem
from datetime import datetime
from decimal import Decimal

class TestPurchase(unittest.TestCase):
    def setUp(self):
        p1 = purchase.Purchase(
            '36015828', 
            datetime(2018, 2, 22, 0, 0, 0), 
            '120642', 
            '180222710986153573', 
            '710910010742065',
            '1300099C89',
            Decimal('70000.00'),
            '603302'
        )
        p2 = purchase.Purchase(
            "36015828", 
            datetime(2017, 10, 20, 0, 0, 0), 
            '132112', 
            '171020710975085783', 
            '710910010742065',
            '1300099C89',
            Decimal('50000.00'),
            '603302'
        )
        p3 = purchase.Purchase(
            "36015828", 
            datetime(2018, 2, 28, 0, 0, 0), 
            '125759', 
            '180228710987050869', 
            '710910010742065',
            '1300099C89',
            Decimal('50000.00'),
            '603302'
        )

        self.r1 = redeem.Redeem(
            "36015828", 
            datetime(2018, 2, 27, 0, 0, 0), 
            '141759', 
            '180225710987050869', 
            '710910010742065',
            '1300099C89',
            Decimal('50000.00'),
            '603302',
            1,
            '171020710975085783'
        )

        self.r2 = redeem.Redeem(
            "36015828", 
            datetime(2018, 2, 27, 0, 0, 0), 
            '141759', 
            '180225710987050869', 
            '710910010742065',
            '1300099C89',
            Decimal('80000.00'),
            '603302',
            2,
            ''
        )

        self.r3 = redeem.Redeem(
            "36015828", 
            datetime(2018, 2, 27, 0, 0, 0), 
            '141759', 
            '180225710987050869', 
            '710910010742065',
            '1300099C89',
            Decimal('80000.00'),
            '603302',
            3,
            ''
        )

        self.r4 = redeem.Redeem(
            "36015828", 
            datetime(2018, 2, 27, 0, 0, 0), 
            '141759', 
            '180225710987050869', 
            '710910010742065',
            '1300099C89',
            Decimal('120000.00'),
            '603302',
            4,
            ''
        )

        x = [p1, p2, p3]
        self.cpur = purchase.Purchases(x)

    def test_sort(self):
        self.cpur.sort()
        for x in self.cpur.purchases:
            print(x.tran_date)
    
    def test_index(self):
        self.cpur.sort()
        print(self.cpur.index(self.r1))

    def test_find_application_code_index(self):
        self.cpur.sort()
        print(self.cpur.find_application_code_index(self.r1))

    def test_minus1(self):
        self.cpur.sort()
        self.cpur.minus1(self.r1)
        for x in self.cpur.purchases:
            print(x.trade_quot)
        self.cpur.clean()
        for x in self.cpur.purchases:
            print(x.trade_quot)

    def test_minus2(self):
        self.cpur.sort()
        self.cpur.minus2(self.r2)
        for x in self.cpur.purchases:
            print(x.trade_quot)
        self.cpur.clean()
        for x in self.cpur.purchases:
            print(x.trade_quot)

    def test_minus3(self):
        self.cpur.sort()
        self.cpur.minus3(self.r3)
        for x in self.cpur.purchases:
            print(x.trade_quot)

    def test_minus4(self):
        self.cpur.sort()
        self.cpur.minus4(self.r4)
        for x in self.cpur.purchases:
            print(x.trade_quot)

if __name__ == '__main__':
    unittest.main()