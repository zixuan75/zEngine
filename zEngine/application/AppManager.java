package zEngine.application;

public class AppManager {
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
