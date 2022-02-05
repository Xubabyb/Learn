package my.home.exercise.test;

import java.util.Scanner;

class UserView {

    void startCalcInfo() {
        System.out.println("\t\t\tКалькулятор A&R v1.0");
        System.out.println("\tКалькулятор умеет выполнять четыре арифметические операции:");
        System.out.println("сложение, вычитание, умножение и деление, для арабских или римских цифр");
        System.out.println("в диапозоне от 1 до 10 включительно.");
        System.out.println();
        System.out.println("\tДля работы с калькулятором введите в поле Input: числовое выражение");
        System.out.println("в формате '2+3' либо 'V*IX'. Для завершения работы введите в поле Input: Exit");
    }

    void finishCalcInfo() {
        System.out.println("Калькулятор завершает работу");
    }

    String promptForInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print(Main.INPUT);
        return scan.nextLine();
    }
}

