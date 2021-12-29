package main.phrase3;

public class Util {
    private static long startTime;
    private static long endTime;
    private static long lastTime;
    private static final int MILLIS_TO_MIN = 60000;

    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    public static void endTimer() {
        endTime = System.currentTimeMillis();
        lastTime = (endTime - startTime) / MILLIS_TO_MIN;
    }

    public static long getLastTime() {
        return lastTime;
    }
}
