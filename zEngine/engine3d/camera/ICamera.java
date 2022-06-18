package zEngine.engine3d.camera;

import zEngine.util.matrix.Matrix4f;
import zEngine.util.vector.Vector3f;

public interface ICamera {
    IFrustum getFrustum();
    Vector3f getPosition();
    Vector3f getRotation();
    Matrix4f getProjectionMatrix();
    Matrix4f getViewMatrix();
    Matrix4f getProjectionViewMatrix();
    void update();
}
