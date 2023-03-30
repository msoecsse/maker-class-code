package wk4;

public class UnitTestableStuffRunner {
    public static void main(String[] args) {
        String[] debuggingARunnerListExample = new String[3];
        debuggingARunnerListExample[0] = "1";
        debuggingARunnerListExample[1] = "2";
        debuggingARunnerListExample[2] = "3";

        System.out.println(new UnitTestableStuff().findAverageFromStrings(debuggingARunnerListExample));
    }
}
