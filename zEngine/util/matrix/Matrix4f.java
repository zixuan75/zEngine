package zEngine.util.matrix;

import zEngine.util.vector.Vector4f;

public class Matrix4f extends Matrix {
    public Matrix4f() {
		super(4, 4);
	}
	
	public Matrix4f(Vector4f a, Vector4f b, Vector4f c, Vector4f d) {
		super(4, 4);
		set(0, 0, a.x);
		set(0, 1, a.y);
		set(0, 2, a.z);
		set(0, 3, a.w);
		set(1, 0, b.x);
		set(1, 1, b.y);
		set(1, 2, b.z);
		set(1, 3, b.w);
		set(2, 0, c.x);
		set(2, 1, c.y);
		set(2, 2, c.z);
		set(2, 3, c.w);
		set(3, 0, d.x);
		set(3, 1, d.y);
		set(3, 2, d.z);
		set(3, 3, d.w);
	}

	public Vector4f get(int a) {
		return new Vector4f(get(0, a), get(1, a), get(2, a), get(3, a));
	}
}
