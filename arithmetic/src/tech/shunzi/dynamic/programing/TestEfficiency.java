package tech.shunzi.dynamic.programing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Version:v1.0 (description:  )
 */
public class TestEfficiency {

    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        getRunTimeResults(null, TestEfficiency.class.getMethod("mod", int.class, int.class), 323,
                10);

        getRunTimeResults(null, TestEfficiency.class.getMethod("add", int.class, int.class), 321,
                10);
    }

    public static void mod(int a, int b) {
        int c = a % b;
    }

    public static void add(int a, int b) {
        int c = a + b;
    }

    public static String getRunTimeResults(Object object, Method method, Object... args)
            throws InvocationTargetException, IllegalAccessException {
        long startTime = System.nanoTime();

        Object returnValue = method.invoke(object, args);
        System.out.println(returnValue);

        long endTime = System.nanoTime();
        long runTimeWithNS = endTime - startTime;
        long runTimeWithMS = runTimeWithNS / 1000000;
        long runTimeWithS = (endTime - startTime) / 1000000000;

        String nsResult = "It costs " + runTimeWithNS + "ns!\n";
        String msResult = "It costs " + runTimeWithMS + "ms!\n";
        String sResult = "It costs " + runTimeWithS + "s!\n";

        StringBuilder result = new StringBuilder();
        if (runTimeWithS >= 1)
        {
            result.append(sResult);
        }
        else
        {
            result.append(msResult);
            result.append(nsResult);
        }

        if (100 >= runTimeWithS && runTimeWithS >= 1)
        {
            result.append(msResult);
        }


        System.out.println(result.toString());
        return result.toString();
    }

}
