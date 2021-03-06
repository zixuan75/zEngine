package zEngine.engine3d.camera.impl;

import zEngine.engine3d.camera.IFrustum;
import zEngine.util.matrix.Matrix4f;

public class PerspFrustum implements IFrustum {
    private float fov;
    private float near;
    private float far;
    private Matrix4f projection;

    public PerspFrustum(float fov, float near, float far) {
        this.fov = fov;
        this.near = near;
        this.far = far;
        this.projection = new Matrix4f();
    }
    public void update(float aspect) {
        Matrix4f.project(fov, aspect, near, far, projection);
    }
    @Override
    public Matrix4f getProjection() {
        return projection;
    }
    public float getFov() {
        return fov;
    }
    public void setFov(float fov) {
        this.fov = fov;
    }
    public float getNear() {
        return near;
    }
    public void setNear(float near) {
        this.near = near;
    }
    public float getFar() {
        return far;
    }
    public void setFar(float far) {
        this.far = far;
    }
}
