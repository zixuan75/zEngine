package zEngine.util.matrix;

import zEngine.util.vector.Vector4f;

public class Matrix4f extends Matrix {
    public Matrix4f() {
		super(4, 4);
	}
	

	public static Vector4f transform(Matrix4f op, Vector4f vic) {
		return (Vector4f) Matrix.transform(op, vic);
	}

	public static Matrix4f multiply(Matrix4f a, Matrix4f b) {
		Matrix4f res = new Matrix4f();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				float dotProduct = 0;
				for (int k = 0; k < 4; k++) {
					dotProduct += a.get(i, k) * b.get(k, j);
				}
				res.set(i, j, dotProduct); 
			}
		}
		return res;
	}
}
