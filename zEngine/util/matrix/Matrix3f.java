package zEngine.util.matrix;

import zEngine.util.vector.Vector2f;

public class Matrix3f extends Matrix{
    public Matrix3f() {
		super(3, 3);
	}
	
	public static Matrix3f multiply(Matrix3f a, Matrix3f b, Matrix3f res) {
		if (res == null)
            res = new Matrix3f();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				float dotProduct = 0;
				for (int k = 0; k < 3; k++) {
					dotProduct += a.get(i, k) * b.get(k, j);
				}
				res.set(i, j, dotProduct);
			}
		}
		return res;
	}

    public static Matrix3f translate(Vector2f translate, Matrix3f from, Matrix3f to) {
        if (to == null)
            to = new Matrix3f();
        Matrix3f mat = new Matrix3f();
        mat.set(2, 0, translate.x);
        mat.set(2, 1, translate.y);
        Matrix3f.multiply(mat, from, to);
        return mat;
    }

    public static Matrix3f rotate(float angle, Matrix3f from, Matrix3f to) {
        if (to == null)
            to = new Matrix3f();
        Matrix3f mat = new Matrix3f();
        float cosX = (float) Math.cos(Math.toRadians(angle));
        float sinX = (float) Math.sin(Math.toRadians(angle));
        mat.set(0, 0, cosX);
        mat.set(1, 0, sinX);
        mat.set(0, 1, -sinX);
        mat.set(1, 1, cosX);
        System.out.println(mat.get(2, 2));
        Matrix3f.multiply(mat, from, to);
        return to;
    }
}
