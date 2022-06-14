package zEngine.application;

public class AppManager {
    public static void runApplication(IApplication application) {
        application.start();
        while (!application.isCloseRequested()) {
            application.update();
        }
        application.end();
    }
}
