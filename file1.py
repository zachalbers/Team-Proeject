class C1:
    def m1(self):
        print('A')
    def m2(self):
        self.m1()
class C2(C1):
    def m1(self):
        print('B')

x = C1()
y = C2()
x.m2()
y.m2()

