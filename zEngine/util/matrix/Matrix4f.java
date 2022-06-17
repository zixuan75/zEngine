package zEngine.util.matrix;

import zEngine.util.vector.Vector3f;
import zEngine.util.vector.Vector4f;
import static zEngine.util.vector.Vector4f.*;

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
	private static Matrix4f multiply(Matrix4f a, float b) {
		Matrix4f res = new Matrix4f();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				res.set(i, j, a.get(i, j) * b);
			}
		}
		return res;
	}
	public static Matrix4f translate(Vector3f translate) {
		Matrix4f result = new Matrix4f();
		result.set(3, 0, translate.x);
		result.set(3, 1, translate.y);
		result.set(3, 2, translate.z);
		return result;
	}
	public static Matrix4f rotate(float angle, Vector3f axis) {
		Matrix4f result = new Matrix4f();
		float cos = (float) Math.cos(Math.toRadians(angle));
		float sin = (float) Math.sin(Math.toRadians(angle));
		float C = 1 - cos;

		result.set(0, 0, cos + axis.x * axis.x * C);
		result.set(0, 1, axis.x * axis.y * C - axis.z * sin);
		result.set(0, 2, axis.x * axis.z * C + axis.y * sin);

		result.set(1, 0, axis.y * axis.x * C + axis.z * sin);
		result.set(1, 1, cos + axis.y * axis.y * C);
		result.set(1, 2, axis.y * axis.z * C - axis.x * sin);

		result.set(2, 0, axis.z * axis.x * C - axis.y * sin);
		result.set(2, 1, axis.z * axis.y * C + axis.x * sin);
		result.set(2, 2, cos + axis.z * axis.z * C);

		return result;
	}
	public static Matrix4f scale(Vector3f scalar) {
		Matrix4f result = new Matrix4f();

		result.set(0, 0, scalar.x);
		result.set(1, 1, scalar.y);
		result.set(2, 2, scalar.z);

		return result;
	}
	public static Matrix4f transform(Vector3f position, Vector3f rotation, Vector3f scale) {
		Matrix4f result = new Matrix4f();

		Matrix4f translationMatrix = translate(position);
		Matrix4f rotXMatrix = rotate(rotation.x, new Vector3f(1, 0, 0));
		Matrix4f rotYMatrix = rotate(rotation.y, new Vector3f(0, 1, 0));
		Matrix4f rotZMatrix = rotate(rotation.z, new Vector3f(0, 0, 1));
		Matrix4f scaleMatrix = scale(scale);

		Matrix4f rotationMatrix = multiply(rotXMatrix, multiply(rotYMatrix, rotZMatrix));

		result = multiply(scaleMatrix, multiply(rotationMatrix, translationMatrix));
		return result;
	}
	public static Matrix4f project(float fov, float aspect, float near, float far) {
		Matrix4f result = new Matrix4f();

		float tanFOV = (float) Math.tan(Math.toRadians(fov) / 2);
		float range = far - near;

		result.set(0, 0, 1.0f / (aspect * tanFOV));
		result.set(1, 1, 1.0f / tanFOV);
		result.set(2, 2, -((far + near) / range));
		result.set(2, 3, -1.0f);
		result.set(3, 2, -((2 * far * near) / range));
		result.set(3, 3, 0);

		return result;
	}
	public static Matrix4f view(Vector3f position, Vector3f rotation) {
		Matrix4f result = new Matrix4f();

		Vector3f negative = new Vector3f(-position.x, -position.y, -position.z);
		Matrix4f translationMatrix = translate(negative);
		Matrix4f rotXMatrix = rotate(rotation.x, new Vector3f(1, 0, 0));
		Matrix4f rotYMatrix = rotate(rotation.y, new Vector3f(0, 1, 0));
		Matrix4f rotZMatrix = rotate(rotation.z, new Vector3f(0, 0, 1));

		Matrix4f rotationMatrix = multiply(rotZMatrix, multiply(rotYMatrix, rotXMatrix));

		result = multiply(translationMatrix, rotationMatrix);

		return result;
	}
	public static Matrix4f invert(Matrix4f m) {
		float Coef00 = m.get(2, 2) * m.get(3, 3) - m.get(3, 2) * m.get(2, 3);
        float Coef02 = m.get(1, 2) * m.get(3, 3) - m.get(3, 2) * m.get(1, 3);
        float Coef03 = m.get(1, 2) * m.get(2, 3) - m.get(2, 2) * m.get(1, 3);

        float Coef04 = m.get(2, 1) * m.get(3, 3) - m.get(3, 1) * m.get(2, 3);
        float Coef06 = m.get(1, 1) * m.get(3, 3) - m.get(3, 1) * m.get(1, 3);
        float Coef07 = m.get(1, 1) * m.get(2, 3) - m.get(2, 1) * m.get(1, 3);

        float Coef08 = m.get(2, 1) * m.get(3, 2) - m.get(3, 1) * m.get(2, 2);
        float Coef10 = m.get(1, 1) * m.get(3, 2) - m.get(3, 1) * m.get(1, 2);
        float Coef11 = m.get(1, 1) * m.get(2, 2) - m.get(2, 1) * m.get(1, 2);

        float Coef12 = m.get(2, 0) * m.get(3, 3) - m.get(3, 0) * m.get(2, 3);
        float Coef14 = m.get(1, 0) * m.get(3, 3) - m.get(3, 0) * m.get(1, 3);
        float Coef15 = m.get(1, 0) * m.get(2, 3) - m.get(2, 0) * m.get(1, 3);

        float Coef16 = m.get(2, 0) * m.get(3, 2) - m.get(3, 0) * m.get(2, 2);
        float Coef18 = m.get(1, 0) * m.get(3, 2) - m.get(3, 0) * m.get(1, 2);
        float Coef19 = m.get(1, 0) * m.get(2, 2) - m.get(2, 0) * m.get(1, 2);

        float Coef20 = m.get(2, 0) * m.get(3, 1) - m.get(3, 0) * m.get(2, 1);
        float Coef22 = m.get(1, 0) * m.get(3, 1) - m.get(3, 0) * m.get(1, 1);
        float Coef23 = m.get(1, 0) * m.get(2, 1) - m.get(2, 0) * m.get(1, 1);

        Vector4f Fac0 = new Vector4f(Coef00, Coef00, Coef02, Coef03);
        Vector4f Fac1 = new Vector4f(Coef04, Coef04, Coef06, Coef07);
        Vector4f Fac2 = new Vector4f(Coef08, Coef08, Coef10, Coef11);
        Vector4f Fac3 = new Vector4f(Coef12, Coef12, Coef14, Coef15);
        Vector4f Fac4 = new Vector4f(Coef16, Coef16, Coef18, Coef19);
        Vector4f Fac5 = new Vector4f(Coef20, Coef20, Coef22, Coef23);

        Vector4f Vec0 = new Vector4f(m.get(1, 0), m.get(0, 0), m.get(0, 0), m.get(0, 0));
        Vector4f Vec1 = new Vector4f(m.get(1, 1), m.get(0, 1), m.get(0, 1), m.get(0, 1));
        Vector4f Vec2 = new Vector4f(m.get(1, 2), m.get(0, 2), m.get(0, 2), m.get(0, 2));
        Vector4f Vec3 = new Vector4f(m.get(1, 3), m.get(0, 3), m.get(0, 3), m.get(0, 3));

        Vector4f Inv0 = Vector4f.translate(diff(compMult(Vec1, Fac0), compMult(Vec2, Fac1)), compMult(Vec3, Fac2));
        Vector4f Inv1 = Vector4f.translate(diff(compMult(Vec0, Fac0), compMult(Vec2, Fac3)), compMult(Vec3, Fac4));
        Vector4f Inv2 = Vector4f.translate(diff(compMult(Vec0, Fac1), compMult(Vec1, Fac3)), compMult(Vec3, Fac5));
        Vector4f Inv3 = Vector4f.translate(diff(compMult(Vec0, Fac2), compMult(Vec1, Fac4)), compMult(Vec2, Fac5));

        Vector4f SignA = new Vector4f(+1, -1, +1, -1);
        Vector4f SignB = new Vector4f(-1, +1, -1, +1);
        Matrix4f Inverse = new Matrix4f(compMult(Inv0, SignA), compMult(Inv1, SignB), compMult(Inv2, SignA), compMult(Inv3, SignB));
//
        Vector4f Row0 = new Vector4f(Inverse.get(0, 0), Inverse.get(1, 0), Inverse.get(2, 0), Inverse.get(3, 0));
//
        Vector4f Dot0 = compMult(m.get(0), Row0);
        float Dot1 = (Dot0.x + Dot0.y) + (Dot0.z + Dot0.w);
//
        float OneOverDeterminant = 1f / Dot1;
//
        return multiply(Inverse, OneOverDeterminant);
	}
}
