package my.home.exercise.test;

/**
 * Калькулятор алгебраических выражений представленных ввиде двучлена арабских цифр,
 * доступны алгебраические операции сложение, вычитание, умножение, деление
 */
class ArabicNumeralCalc {

    private static int firstNumber;
    private static int secondNumber;
    private static char operation;

    /**
     * Метод возвращает результат арифметической операции
     */
    static String getResult(String input) {

        getFieldCalc(input);

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

    //Инициализации полей класса
    private static void getFieldCalc(String input) {

        String[] element = input.split("[-+/*]");

        operation = getOperation(input);

        firstNumber = Integer.parseInt(element[0]);

        secondNumber = Integer.parseInt(element[1]);
    }
    //Получение арифметической операции
    private static char getOperation(String input) {

        int index = ArithmeticOperation.getIndexOperation(input);

        return input.toCharArray()[index];
    }


}
