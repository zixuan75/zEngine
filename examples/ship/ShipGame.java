package ship;

import zEngine.application.AppManager;
import zEngine.application.Application;
import zEngine.application.DisplaySettings;
import zEngine.application.Format;

public class ShipGame extends Application {

    private Ship ship;
    
    public static void main(String[] args) {
        ShipGame shipGame = new ShipGame();
        shipGame.createDisplay(new DisplaySettings(900, 900), new Format());
        AppManager.runApplication(shipGame);
    }

    @Override
    public void start() {
        ship = new Ship();
    }

    @Override
    public void update() {
        ship.render();
    }

    @Override
    public void end() {
        ship.destroy();
    }

    @Override
    public boolean isCloseRequested() {
        // TODO Auto-generated method stub
        return false;
    }

    
}
