package my.home.exercise.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static final String regexArabicNum = "([1-9]|(10))[-/*+]([1-9]|10)";
    static final String regexRomanNum = "(I{1,3}|IV|[VX]|VI{1,3}|IX)[-/*+](I{1,3}|IV|[VX]|VI{1,3}|IX)";
    static final String EXCEPTION = "Исключение: Ошибка ввода";


    public static void main(String[] args) {

        startCalc();

        calculate();

        finishCalc();
    }

    static void calculate() {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Input:");

            String input = scan.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Output:" + calc(input));
        }
        scan.close();
    }

    static void startCalc() {
        System.out.println("\tКалькулятор умеет выполнять четыре арифметические операции:\n" +
                "сложение, вычитание, умножение и деление, для арабских или римских цифр\n" +
                "в диапозоне от 1 до 10 включительно.\n" +
                "\tДля работы с калькулятором введите в поле Input: числовое выражение\n" +
                "в формате 2+3 либо V+IX. Для завершения работы введите в поле Input: Exit");
    }

    static void finishCalc() {
        System.out.println("Калькулятор завершает работу");
    }

    /**
     * Метод принимает строку с числовым выражением между двумя числами
     * и возвращает строку с результатом их выполнения.
     * Метод умеет работать с арабскими и римскими цифрами от 1 до 10 включительно
     * и выполнять 4 арифметические операции.
     */
    public static String calc(String input) {

        if (input.matches(regexArabicNum)) {

            ArabicNumeralCalc arabicNumeralCalc = new ArabicNumeralCalc(input);

            return arabicNumeralCalc.getResult();

        } else if (input.matches(regexRomanNum)) {

            String temp = RomanNumeral.converterRomanToArab(input);

            ArabicNumeralCalc arabicNumeralCalc = new ArabicNumeralCalc(temp);

            temp = arabicNumeralCalc.getResult();

            try { //Ловим исключение при вводе выражение (римскими цифрами) результат вычисления корого <1

                return RomanNumeral.converterArabicToRoman(temp);

            } catch (InputErrorException e) {

                return EXCEPTION + " Результат вычисления меньше 1";
                //e.printStackTrace();
            }
        } else {

            try { // Ловим исключение при вводе выражения с разным представлением чисел,
                // недопустимой операцией и другими ошибками ввода.(p.s. может лучше при вводе их отсеять)

                throw new InputErrorException();

            } catch (InputErrorException e) {

                return EXCEPTION;
                //e.printStackTrace();
            }
        }
    }
}

/**
 * Класс Римские цифры (...)
 */
class RomanNumeral {

    static final HashMap<Integer, String> romanNum = new HashMap<>();

    static {
        romanNum.put(1, "I");
        romanNum.put(4, "IV");
        romanNum.put(5, "V");
        romanNum.put(9, "IX");
        romanNum.put(10, "X");
        romanNum.put(40, "XL");
        romanNum.put(50, "L");
        romanNum.put(90, "XC");
        romanNum.put(100, "C");
    }

    /**
     * Метод возвращает ключ переданного значения
     */
    private static int getKeyMap(String numRoman) {

        int result = 0;

        Set<Map.Entry<Integer, String>> entries = romanNum.entrySet();

        for (Map.Entry<Integer, String> map : entries) {

            String value = map.getValue();
            Integer keyValue = map.getKey();

            if (numRoman.equals(value)) {

                result = keyValue;
            }
        }
        return result;
    }

    /**
     * Конвертер Римских цифр в арабские. Корректно работает с римскими цифрами от 1 до 10.
     * При необходимости можно  расширять диапозон работы, дополнив метод assistantForRoman.
     */
    static String converterRomanToArab(String input) {

        int isOperation = ArithmeticOperation.getIndexOperation(input);

        if (isOperation == -1) {                  //Это блок if для работы калькулятора не нужен,
            //жалко было удалять, позволял получать арабское
            return assistantForRoman(input);      //представление одного римского числа

        } else {

            String[] element = input.split("[-+/*]");

            return assistantForRoman(element[0]) + input.toCharArray()[isOperation]
                    + assistantForRoman(element[1]);
        }
    }

    /**
     * Метод помошник конвертера "converterRomanToArab" римских цифр в арабские.
     * (p.s. Он и есть конвертер по сути.)
     */
    private static String assistantForRoman(String input) {

        int result = 0;

        for (int i = 0; i < input.length(); i++) {

            String value = String.valueOf(input.charAt(i));

            String valueNext;

            if (i != input.length() - 1) {

                valueNext = String.valueOf(input.charAt(i + 1));

                if (getKeyMap(valueNext) > getKeyMap(value)) {

                    result += getKeyMap(valueNext) - getKeyMap(value);

                    i++;

                    continue;
                }
            }
            result += getKeyMap(value);
        }
        return String.valueOf(result);
    }

    /**
     * Конвертер арабских цифр в римские.
     * На вход принимает строку содержащую арабские цифры
     * (рабочий диапозон от 1 до 100 (до 399 делает все правильно)).
     */
    static String converterArabicToRoman(String input) {

        int arabNum = Integer.parseInt(input);

        if (arabNum < 1) {
            throw new InputErrorException();
        }
        int key = getNearestKey(arabNum);

        if (key == arabNum) {

            return romanNum.get(key);
        }
        return romanNum.get(key) + converterArabicToRoman(Integer.toString(arabNum - key));

    }

    /**
     * Метод возвращает ближайший наименьший ключ по отношению к переданому значению
     */
    static int getNearestKey(int num) {

        if (romanNum.containsKey(num)) {

            return num;
        }

        int temp = 0;

        for (int key : romanNum.keySet()) {

            if (key < num) {

                if (key > temp) {

                    temp = key;
                }
            }
        }
        return temp;
    }
}

/**
 * Класс разбирает переданное выражение на члены и на символ арифметической операции
 */
class ArabicNumeralCalc {

    int firstNumber;
    int secondNumber;
    char operation;

    ArabicNumeralCalc(String input) {
        getFieldCalc(input);
    }

    /**
     * Метод инициализации полей класса
     */
    void getFieldCalc(String input) {

        String[] element = input.split("[-+/*]");

        operation = getOperation(input);


        firstNumber = Integer.parseInt(element[0]);

        secondNumber = Integer.parseInt(element[1]);
    }

    char getOperation(String input) {

        int index = ArithmeticOperation.getIndexOperation(input);

        return input.toCharArray()[index];
    }

    /**
     * Метод возвращает результат арифметической операции
     */
    String getResult() {

        switch (operation) {
            case '+': {
                return String.valueOf(firstNumber + secondNumber);
            }
            case '-': {
                return String.valueOf(firstNumber - secondNumber);
            }
            case '/': {
                return String.valueOf(firstNumber / secondNumber);
            }
            case '*': {
                return String.valueOf(firstNumber * secondNumber);
            }
            default:
                throw new InputErrorException();
        }
    }
}

class InputErrorException extends RuntimeException {

}

class ArithmeticOperation {

    static char[] chars = new char[4];

    static {

        chars[0] = '+';
        chars[1] = '-';
        chars[2] = '/';
        chars[3] = '*';
    }

    static int getIndexOperation(String input) {

        int index = -1;

        for (char temp : chars) {

            index = input.indexOf(temp);

            if (index != -1) {
                break;
            }
        }
        return index;
    }

}
