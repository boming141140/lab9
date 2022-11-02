/*
BomingZheng
112203270
CSE114
Lab9_P1
 */
public class MyInteger {
    int value;
    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return this.value%2 == 0;
    }

    public boolean isOdd() {
        return this.value%2 == 1;
    }

    public boolean isPrime() {
        if(value <= 1){
            return false;
        }
        for(int i = 2; i <= value/2 ;i++){
            if((value % i)==0)
                return  false;
        }
        return true;
    }

    public boolean equals(int test){
        return value == test;
    }

    public static boolean isEven(MyInteger obj) {
        return obj.getValue()%2 == 0;
    }

    public static boolean isOdd(MyInteger obj) {
        return obj.getValue()%2 == 1;
    }

    public static boolean isPrime(MyInteger obj) {
        int integer = obj.getValue();
        if(integer <= 1)
        {
            return false;
        }
        for(int i = 2; i <= integer/2; i++)
        {
            if((integer % i)==0)
                return  false;
        }
        return true;
    }

    public boolean equals(MyInteger obj){
        return value == obj.getValue();
    }

    public static void main(String []args) {
        int testNum = 11;
        MyInteger obj1 = new MyInteger(11);
        MyInteger obj2 = new MyInteger(4);
        //Test isEven
        System.out.println("Test#IsEven");
        System.out.println(obj1.isEven());
        System.out.println(obj2.isEven());
        System.out.println(MyInteger.isEven(obj1));
        System.out.println(MyInteger.isEven(obj2));
        //Test isOdd
        System.out.println("Test#IsOdd");
        System.out.println(obj1.isOdd());
        System.out.println(obj2.isOdd());
        System.out.println(MyInteger.isOdd(obj1));
        System.out.println(MyInteger.isOdd(obj2));
        //Test isPrime
        System.out.println("Test#IsPrime");
        System.out.println(obj1.isPrime());
        System.out.println(obj2.isPrime());
        System.out.println(MyInteger.isPrime(obj1));
        System.out.println(MyInteger.isPrime(obj2));
        //Test Equal
        System.out.println("Test#Equal");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(testNum));
    }
}
