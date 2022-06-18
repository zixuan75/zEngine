package zEngine.engine3d.camera.impl;

import zEngine.engine3d.camera.ICamera;
import zEngine.engine3d.camera.IFrustum;
import zEngine.glfw.Display;
import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector3f;

public class Camera implements ICamera {
    public Vector3f position = new Vector3f(0, 0, -1);
    public Vector3f rotation = new Vector3f();
    public Matrix4f view = new Matrix4f();
    public PerspFrustum frustum = new PerspFrustum(70f, 0.1f, 500f);

    @Override
    public IFrustum getFrustum() {
        return frustum;
    }
    @Override
    public Vector3f getPosition() {
        return position;
    }
    @Override
    public Vector3f getRotation() {
        return rotation;
    }
    @Override
    public Matrix4f getProjectionMatrix() {
        return frustum.getProjection();
    }
    @Override
    public Matrix4f getViewMatrix() {
        return view;
    }
    @Override
    public Matrix4f getProjectionViewMatrix() {
        return Matrix4f.multiply(frustum.getProjection(), view);
    }
    @Override
    public void update() {
        frustum.update((float) Display.getWidth() / (float) Display.getHeight());
        Matrix4f.view(position, rotation, view);
    }
}
