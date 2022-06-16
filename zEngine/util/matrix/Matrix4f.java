package zEngine.util.matrix;

import zEngine.util.vector.Vector4f;

public class Matrix4f extends Matrix {
    public Matrix4f() {
		super(4, 4);
	}
	
	public Matrix4f(Vector4f a, Vector4f b, Vector4f c, Vector4f d) {
		super(4, 4);
		set(0, 0, a.x);
		set(1, 0, a.y);
		set(2, 0, a.z);
		set(3, 0, a.w);
		set(0, 1, b.x);
		set(1, 1, b.y);
		set(2, 1, b.z);
		set(3, 1, b.w);
		set(0, 2, c.x);
		set(1, 2, c.y);
		set(2, 2, c.z);
		set(3, 2, c.w);
		set(0, 3, d.x);
		set(1, 3, d.y);
		set(2, 3, d.z);
		set(3, 3, d.w);
	}

	public Vector4f get(int a) {
		return new Vector4f(get(a, 0), get(a, 1), get(a, 2), get(a, 3));
	}
}
