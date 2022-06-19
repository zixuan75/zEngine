package zEngine.application;

public class AppManager {
    /**
     * Runs the application
     * @param application the application
     */
    public static void runApplication(Application application) {
        application.start();
        while (!application.isCloseRequested() && !application.display.isCloseRequested()) {
            application.update();
            application.display.update();
        }
        application.end();
        application.display.close();
    }
}
