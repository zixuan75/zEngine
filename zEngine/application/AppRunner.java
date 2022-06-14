package zEngine.application;

public class AppRunner {
    public static void runApplication(IApplication application) {
        application.start();
        while (!application.isCloseRequested()) {
            application.update();
        }
        application.end();
    }
}
