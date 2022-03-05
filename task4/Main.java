package platform.kata.academy.task4;

public class Main {
    public static void main(String[] args)
    {
        test();
    }

    public static void test()
    {
        Thread current = Thread.currentThread();
        StackTraceElement[] methods = current.getStackTrace();

       /* for(int i = 0;i<methods.length;i++)
        {*/
            System.out.println(methods[1].getClassName());
            System.out.println(methods[1].getMethodName());

            System.out.println(methods[1].getFileName());
            System.out.println(methods[1].getLineNumber());

            System.out.println(methods[1].getModuleName());
            System.out.println(methods[1].getModuleVersion());
            System.out.println();
        //}
    }
}

