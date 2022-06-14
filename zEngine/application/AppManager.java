package zEngine.application;

import zEngine.util.camera.OrbitalCamera;

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
            OrbitalCamera.update();
        }
        application.end();
        application.display.close();
    }
}
