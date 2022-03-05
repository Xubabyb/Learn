package platform.kata.academy.task4;

public class Test {
    static class BadCreditHistoryException extends Exception {

    }

    public static void main(String[] args) {
        try {
            throw new BadCreditHistoryException();
        } catch (BadCreditHistoryException e) {
            //System.out.println("BadHistory");
        } 
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            if (stackTraceElements.length >= 10) {
                return null;
            } else {
                return stackTraceElements[2].getClassName() + "#" +
                        stackTraceElements[2].getMethodName();
            }
        }


        // ...
        //return  null;
    }
}
