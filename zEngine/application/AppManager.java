package zEngine.application;

import zEngine.input.keys.KeyReceiver;

public class AppManager {
    /**
     * Runs the application
     * @param application the application
     */
    public static void runApplication(Application application) {
        application.start();
        
        application.display.kDevice.addReceiver((KeyReceiver) application);
        while (!application.isCloseRequested() && !application.display.isCloseRequested()) {
            application.update();
            application.display.update();
        }
        application.end();
        application.display.close();
    }
}
