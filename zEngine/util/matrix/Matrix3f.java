package zEngine.util.matrix;

import zEngine.util.vector.Vector2f;
import zEngine.util.vector.Vector3f;

public class Matrix3f extends Matrix{
    public Matrix3f() {
		super(3, 3);
	}

    public static void translate(Vector2f translate, Matrix3f from, Matrix3f to) {
        if (to == null)
            to = new Matrix3f();
            
        float x = translate.x;
        float y = translate.y;
        /* We have to set these beforehand */
        float a = from.get(0, 0);
        float b = from.get(0, 1);
        float c = from.get(0, 2);
        float d = from.get(1, 0);
        float e = from.get(1, 1);
        float f = from.get(1, 2);
        float g = from.get(2, 0);
        float h = from.get(2, 1);
        float i = from.get(2, 2);
        to.set(from);
        to.set(0, 0, a + x * g);
        to.set(1, 0, b + x * h);
        to.set(2, 0, c + x * i);
        to.set(0, 1, d + y * g);
        to.set(1, 1, e + y * h);
        to.set(2, 1, f + y * i);
    }

    public static void rotate(float angle, Matrix3f from, Matrix3f to) {
        if (to == null)
            to = new Matrix3f();
        float cosX = (float) Math.cos(Math.toRadians(angle));
        float sinX = (float) Math.sin(Math.toRadians(angle));
        /* We have to set these beforehand */
        float a = from.get(0, 0);
        float b = from.get(0, 1);
        float c = from.get(0, 2);
        float d = from.get(1, 0);
        float e = from.get(1, 1);
        float f = from.get(1, 2);
        to.set(from);
        to.set(0, 0, cosX * a - sinX * d);
        to.set(0, 1, cosX * b - sinX * e);
        to.set(0, 2, cosX * c - sinX * f);
        to.set(1, 0, sinX * a + cosX * d);
        to.set(1, 1, sinX * b + cosX * e);
        to.set(1, 2, sinX * c + cosX * f);
    }

    public static void scale(Vector2f scale, Matrix3f from, Matrix3f to) {
        if (to == null)
            to = new Matrix3f();
        float x = scale.x;
        float y = scale.y;
        /* We have to set these beforehand */
        float a = from.get(0, 0);
        float b = from.get(0, 1);
        float c = from.get(0, 2);
        float d = from.get(1, 0);
        float e = from.get(1, 1);
        float f = from.get(1, 2);
        to.set(from);
        to.set(0, 0, x * a);
        to.set(0, 1, x * b);
        to.set(0, 2, x * c);
        to.set(1, 0, y * d);
        to.set(1, 1, y * e);
        to.set(1, 2, y * f);
    }

    public static Vector2f multiply(Matrix3f op, Vector2f vec) {
        return new Vector2f((Vector3f) Matrix.multiply(op, new Vector3f(vec)));
    }
}
