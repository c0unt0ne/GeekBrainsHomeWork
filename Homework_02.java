/**
* author is Anton Avraamov
*/

import java.util.*;

class Homework_02 {

public static void main(String[] args){
    //Scanner in = new Scanner(System.in);
    //Задание 1.
    int binArr[] = new int [10];
    System.out.print("Array 01: ");
    fillArr(binArr, 2);
    printArr(binArr);

    // Задание 2.
    System.out.print("Array 02: ");
    revBinArr(binArr);
    printArr(binArr);
    separation();
    
    // Задание 3.
    int plusThrArr[] = new int[8];
    System.out.print("Array 03: ");
    plusThree(plusThrArr);
    printArr(plusThrArr);
    separation();

    //  Задание 4.
    int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    int maxDig = 6;
    System.out.print("Array 04: ");
    multBySix(mas, maxDig);
    printArr(mas);
    separation();

    // Задание 5*.
    int minMaxArr[] = new int[10];
    System.out.print("Array 05: ");
    int max = 0;
    int min;
    fillArr(minMaxArr, 100);
    printArr(minMaxArr);
    max = maxValue(minMaxArr, max);
    min = minValue(minMaxArr, max);

    System.out.println("MAX: " + minMaxArr[max] + "  MIN: " + minMaxArr[min]);
    separation();

    // Задание 6**.
    calcCons();


    /*
    // Консольный калькулятор. Одно из возможных решений. Оставил для себя 
    System.out.println("Calculator: ");
    int fn, sn;
    double result = 0;
    String sign;
    
    fn = Integer.parseInt(in.next("\\d+"));
    sign = in.next("\\+|\\-|\\*|\\/");
    sn = Integer.parseInt(in.next("\\d+"));
    
    if ("+".equals(sign)) {
        result = fn + sn;
        } else if ("-".equals(sign)) {
          result = fn - sn;
        } else if ("*".equals(sign)) {
          result = fn * sn;
        } else if ("/".equals(sign)) {
          result = (double) fn / sn;
        }
 
    System.out.println(" = " + result);
    */

    } 
    // Разделитель
    static void separation(){
        System.out.println("************************************");
        System.out.println();
    }
    // Метод для заполнения массивов
    static void fillArr(int[] name, int length){
        for (int i=0; i<name.length; i++){
            name[i] = (int) (Math.random() * length);
        }
    }
    // Метод для вывода массива в консоль
    static void printArr(int[] name){
        for (int i=0; i<name.length; i++){
            System.out.print(name[i] + " ");
        }
        System.out.println();
    }
    // Метод для задания 2.
    static void revBinArr(int[] name){
        for (int i=0; i<name.length; i++){
            if (name[i] == 0){
                name[i] = 1;
            } else {
                name[i] = 0;
            }
        }
    }
    // Метод для задания 3.
    static void plusThree(int[] name){
        for (int i=0, j=1; i<name.length; i++, j+=3){
            name[i] = j;    
        }
    }
    // Метод для задания 4.
    static void multBySix(int[] name, int max){
        for (int i=0; i<name.length;i++){
            if (name[i] < max){
                name[i] = name[i] * 2;
            }
        }
    }
    // Методы для задания 5*
    // Метод для нахождения максимального элемента массива
    static int maxValue(int[] name, int max){
        for (int i=0; i<name.length; i++){
            if (name[max] < name[i]){
                max = i;
            }
        }
    return max;
    }
    // Метод для нахождения минимального элемента массива
    static int minValue(int[] name, int min){
        for (int i=0; i<name.length; i++){
            if (name[min] > name[i]){
                min = i;
            }
        }
    return min;
    }

    // Метод для задания 6**.
    static void calcCons(){

        Scanner in = new Scanner(System.in);

        System.out.println("Calculator: ");

        int fn = in.nextInt();
        String op = in.next();
        int sn = in.nextInt();


        switch(op){
            case "+":
                System.out.println("= " + (fn + sn));
                break;
            case "-":
                System.out.println("= " + (fn - sn));
                break;
            case "*":
                System.out.println("= " + (fn * sn));
                break;
            case "/":
                if (sn != 0){
                    System.out.println("= " + (fn / sn));
                } else {
                    System.out.println("Error (Division by zero!)");
                }
                break;
            default:
                System.out.println("Error (Undefined operation!)");
        }
    }
}