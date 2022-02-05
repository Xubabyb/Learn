package my.home.exercise.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Класс Римские цифры. Имеет два статических метода конвертера, римских цифр в арабские и обратно.
 * Поддерживает работу с римскими цифрами в диапозоне от 1 до 399.
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
     * Конвертер арабских цифр в римские. Поддерживает конвретацию арабских цифр в диапозоне от 1 до 399
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
     * Конвертер римских цифр в арабские. Поддерживает конвертацию алгебраических выражений
     * представленных ввиде двучлена.
     */
    static String converterRomanToArab(String input) {

        int isOperation = ArithmeticOperation.getIndexOperation(input);

        if (isOperation == -1) {

            return assistantForRoman(input);

        } else {

            String[] element = input.split("[-+/*]");

            return assistantForRoman(element[0]) + input.toCharArray()[isOperation]
                    + assistantForRoman(element[1]);
        }
    }

    // Это и есть сам конвертер из римских цифр в арабские
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

    // Метод возвращает ключ переданного значения
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

    //Метод возвращает ближайший наименьший ключ по отношению к переданому значению
    private static int getNearestKey(int num) {

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


