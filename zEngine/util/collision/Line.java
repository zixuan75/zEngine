package zEngine.util.collision;

import zEngine.util.math.zLinear;
import zEngine.util.vector.Vector2f;

public class Line {
    public Vector2f normal;
    public Vector2f center;

    public Line(Vector2f normal, Vector2f center) {
        this.normal = normal;
        this.center = center;
    }

    public boolean inLine(Vector2f point) {
        Vector2f delta = zLinear.diff(point, center);
        float dotProduct = zLinear.dot(delta, normal);
        return (dotProduct < 0);
    }
}
