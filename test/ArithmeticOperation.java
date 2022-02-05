package my.home.exercise.test;

class ArithmeticOperation {
    
    static final int NUMBRofOPERATIONS = 4;
    static final char[] OPERATION = new char[NUMBRofOPERATIONS];

    static {

        OPERATION[0] = '+';
        OPERATION[1] = '-';
        OPERATION[2] = '/';
        OPERATION[3] = '*';
    }

    static int getIndexOperation(String input) {

        int index = -1;

        for (char temp : OPERATION) {

            index = input.indexOf(temp);

            if (index != -1) {
                break;
            }
        }
        return index;
    }
}
