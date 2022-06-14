package zEngine.util.camera;

import zEngine.glfw.Display;
import zEngine.util.math.zLinear;
import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector3f;

public class OrbitalCamera {
    public static PerspFrustum frustum;
    public static Vector3f position;
    public static Vector3f rotation;
    public static Matrix4f view;
    public static Matrix4f projection;

    static {
        frustum = new PerspFrustum(70.0f, 0.1f, 100f);
        position = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, -1);
        view = new Matrix4f();
        projection = new Matrix4f();
    }

    public static void update() {
        frustum.update((float) Display.getWidth() / (float) Display.getHeight());
        projection = frustum.getProjection();
        view = zLinear.view(position, rotation);
    }
}
