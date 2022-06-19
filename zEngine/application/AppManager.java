package zEngine.application;

public class AppManager {
    /**
     * Runs the application
     * @param application the application
     */
    public static void runApplication(Application application) {
        application.start();
        while (!application.display.isCloseRequested() && !application.closed) {
            application.update();
            application.display.update();
        }
        application.end();
        application.display.close();
    }
}
