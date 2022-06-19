package zEngine.engine3d.camera.controls;

import zEngine.engine3d.camera.impl.Camera;
import zEngine.util.vector.Vector2f;

public class CameraControls {
    public int orient = Orientation.EYE_ORIENT;
    private float x = 0f;
    private float z = 0f;
    private Camera camera;

    public CameraControls(Camera camera) {
        this.camera = camera;
    }
    public void resync(Camera cam) {
        cam.position = this.camera.position;
        cam.rotation = this.camera.rotation;
    }
    public void rotate(Vector2f delta) {
        x = (float) Math.sin(Math.toRadians(camera.rotation.y));
		z = (float) Math.cos(Math.toRadians(camera.rotation.y));
    }
    public void moveUp(float amount) {
        camera.position.y += amount;
    }
    public void moveDown(float amount) {
        camera.position.y -= amount;
    }
    public void moveLeft(float amount) {
        if (orient == Orientation.EYE_ORIENT)
            camera.position.translate(-z * amount, 0, x * amount);
        else if (orient == Orientation.WORLD_ORIENT) 
            camera.position.x -= amount;
    }
    public void moveRight(float amount) {
        if (orient == Orientation.EYE_ORIENT)
            camera.position.translate(z * amount, 0, -x * amount);
        else if (orient == Orientation.WORLD_ORIENT) 
            camera.position.x += amount;
    }
    public void moveForward(float amount) {
        if (orient == Orientation.EYE_ORIENT)
            camera.position.translate(-x * amount, 0, -z * amount);
        else if (orient == Orientation.WORLD_ORIENT) 
            camera.position.z -= amount;
    }
    public void moveBackward(float amount) {
        if (orient == Orientation.EYE_ORIENT)
            camera.position.translate(x * amount, 0, z * amount);
        else if (orient == Orientation.WORLD_ORIENT) 
            camera.position.z += amount;
    }
}
