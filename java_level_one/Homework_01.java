/*
*  author is Anton Avraamov
*/

import java.util.*;

class Homework_01{

    public static void main(String[] args){
        // Задание 1.
        int i;
        byte bt;
        short s;
        long l;
        float f;
        double db;
        boolean flag;
        char ch;

        i = 55;
        bt = 2;
        f = 3.6f;
        db = 2.34;
        flag = false;
        ch = 'H';

        Scanner in = new Scanner(System.in);

        // Задание 2.
        double a, b, c, d;
        
        print("Enter a: ");
        a = in.nextDouble();
        print("Enter b: ");
        b = in.nextDouble();
        print("Enter c: ");
        c = in.nextDouble();
        print("Enter d: ");
        d = in.nextDouble();

        print("-------------------------------");
        print(a + " * (" + b + " + (" + c + " / " + d + ")) = "  + solvExpression(a,b,c,d));

        // Задание 3.
        int firstNum, secondNum;
        print("Enter first number: ");
        firstNum = in.nextInt();
        print("Enter second number: ");
        secondNum = in.nextInt();

        print("Result is: " + digSum(firstNum, secondNum));

        // Задание 4*.
        int year;
        print("Enter year: ");
        year = in.nextInt();
        print("This is " + yearType(year));

    }
    // Так будет проще :)
    static void print(String str) { 

        System.out.println(str);
    }

    // Метод для задания 2.
    static double solvExpression (double a, double b, double c, double d){

        return a * (b + ( c / d));
    }

    // Метод для задания 3.
    static boolean digSum (int firstNum, int secondNum){
        boolean flagSum;
        int result = firstNum + secondNum;
        
        if ((result >= 10) && (result <= 20)){
            flagSum = true;
        } else {
            flagSum = false;
        }
        return flagSum;
    }

    // Метод для задания 4*.
    static String yearType(int year){
        String yearResult;
        
        if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0){
            yearResult = "usual year";
        } else {
            yearResult = "leap year";
        }
        return yearResult;

    }


}