package my.home.exercise.test;

public class Main {

    static final String regexArabicNum = "([1-9]|(10))[-/*+]([1-9]|10)";
    static final String regexRomanNum = "(I{1,3}|IV|[VX]|VI{1,3}|IX)[-/*+](I{1,3}|IV|[VX]|VI{1,3}|IX)";
    static final String EXCEPTION = "Исключение: Ошибка ввода";
    static final String INPUT = "Input:";
    static final String OUTPUT = "Output:";
    static final String EXIT = "exit";

    public static void main(String[] args) {
        UserView communication = new UserView();
        String userInput;

        communication.startCalcInfo();

        while (true) {

            userInput = communication.promptForInput();

            if (userInput.equalsIgnoreCase(EXIT)) {

                communication.finishCalcInfo();

                break;

            } else {
                System.out.println(OUTPUT + calc(userInput));
            }
        }
    }

    /**
     * Метод принимает строку с числовым выражением между двумя числами
     * и возвращает строку с результатом их выполнения.
     * Метод умеет работать с арабскими и римскими цифрами от 1 до 10 включительно
     * и выполнять 4 арифметические операции.
     */
    public static String calc(String input) {

        if (input.matches(regexArabicNum)) {

            return ArabicNumeralCalc.getResult(input);

        } else if (input.matches(regexRomanNum)) {

            String temp = RomanNumeral.converterRomanToArab(input);

            temp = ArabicNumeralCalc.getResult(temp);

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







