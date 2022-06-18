package cube;

import zEngine.application.AppManager;
import zEngine.application.Application;
import zEngine.application.DisplaySettings;
import zEngine.application.Format;
import zEngine.engine3d.camera.impl.Camera;

public class CubeApp extends Application {

    private Camera camera;

    public static void main(String[] args) {
        CubeApp app = new CubeApp();
        app.createDisplay(new DisplaySettings(), new Format());
        AppManager.runApplication(app);
    }

    @Override
    public void start() {
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void end() {
        
    }

    @Override
    public boolean isCloseRequested() {
        return false;
    }
    
}
