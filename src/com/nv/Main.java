package com.nv;

public class Main {

    public static void main(String[] args) {

        TComplex x = new TComplex(2,-3);
        TComplex y = new TComplex(-2, 5);

        System.out.print("x = " + x + "\n");
        System.out.print("y = " + y + "\n");

        TComplex z;

        System.out.print("-----------------------\n");
        System.out.print("Сумма комплексных чисел\n");
        z = TComplex.sum(x,y);
        System.out.print("x + y = " + z + "\n");

        System.out.print("-----------------------\n");
        System.out.print("Разность комплексных чисел\n");
        z = TComplex.sub(x,y);
        System.out.print("x - y = " + z + "\n");

        System.out.print("-----------------------\n");
        System.out.print("Произведение комплексных чисел\n");
        z = TComplex.mul(x,y);
        System.out.print("x * y = " + z + "\n");

        System.out.print("-----------------------\n");
        System.out.print("Частное комплексных чисел\n");
        z = TComplex.divide(x,y);
        System.out.print("x / y = " + z + "\n");

        System.out.print("-----------------------\n");
        System.out.print("Аргумент комплексного числа\n");
        double arg = x.getArg();
        System.out.print("Arg x = " + arg + "\n");

        System.out.print("-----------------------\n");
        System.out.print("Квадратный корень из комплексного числа\n");
        TComplex _sqrt[] = x.sqrt();
        for (int _i = 0; _i < _sqrt.length; _i++){
            System.out.print(_sqrt[_i] + "\n");
        }
    }
}
