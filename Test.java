public class Test {
    private int tests = 0, passed = 0, failed = 0;

    /* Test whether two objects are equal.
       If test fails print the line number and class*/
    void is(Object x, Object y)
    {
        tests++;
        if (x == y || (x != null && x.equals(y))) {
            passed++;
        }
        else {
            failed++;
            StackTraceElement test = new Exception().getStackTrace()[1];
            System.out.println("Test in class " + test.getClassName() + " at line "
                    + test.getLineNumber() + " failed !");
        }
    }

    //Prints number of tests passed out of total
    void results()
    {
        StackTraceElement test = new Exception().getStackTrace()[1];
        System.out.println(test.getClassName() + " class tests passed: " + passed +
                " out of " + tests);
    }
}
