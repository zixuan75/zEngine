package zEngine.util.math;


import zEngine.util.matrix.*;
import zEngine.util.vector.*;

public class zLinear {

	public static Vector2f translate(Vector2f a, Vector2f b) {
		return new Vector2f(a.x + b.x, a.y + b.y);
	}
	
	public static Vector3f translate(Vector3f a, Vector3f b) {
		return new Vector3f(a.x + b.x, a.y + b.y, a.z + b.z);
	}

	public static Vector2f diff(Vector2f a, Vector2f b) {
		return new Vector2f(a.x - b.x, a.y - b.y);
	}
	
	public static Vector3f diff(Vector3f a, Vector3f b) {
		return new Vector3f(a.x - b.x, a.y - b.y, a.z - b.z);
	}

	public static Vector2f scale(Vector2f a, float s) {
		return new Vector2f(a.x * s, a.y * s);
	}

	public static Vector3f scale(Vector3f a, float s) {
		return new Vector3f(a.x * s, a.y * s, a.z * s);
	}
	
	public static float dot(Vector2f a, Vector2f b) {
		return a.x * b.x + a.y * b.y;
	}
	
	public static float dot(Vector3f a, Vector3f b) {
		return a.x * b.x + a.y * b.y + a.z * b.z;
	}
	
	public static float dot(Vector4f a, Vector4f b) {
		return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
	}

	public static Vector2f normalize(Vector2f a) {
		float length = length(a);
		return new Vector2f(a.x / length, a.y / length);
	}

	public static Vector3f normalize(Vector3f a) {
		float length = length(a);
		return new Vector3f(a.x / length, a.y / length, a.z / length);
	}

    public static Vector4f normalize(Vector4f a) {
		float length = length(a);
		return new Vector4f(a.x / length, a.y / length, a.z / length, a.w / length);
	}
	
	public static float length(Vector2f a) {
		return (float) Math.sqrt(a.x * a.x + a.y * a.y);
	}

	public static float length(Vector3f a) {
		return (float) Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
	}

    public static float length(Vector4f a) {
        return (float) Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z + a.w * a.w);
    }

    public static Vector2f compMult(Vector2f a, Vector2f b) {
		return new Vector2f(a.x * b.x, a.y * b.y);
    }

	public static Vector3f compMult(Vector3f a, Vector3f b) {
		return new Vector3f(a.x * b.x, a.y * b.y, a.z * b.z);
	}
	
	public static Vector4f compMult(Vector4f a, Vector4f b) {
		return new Vector4f(a.x * b.x, a.y * b.y, a.z * b.z, a.w * b.w);
	}

	public static Vector3f cross(Vector3f a, Vector3f b) {
		Vector3f res = new Vector3f();
		res.x = a.y * b.z - a.z * b.y;
		res.y = a.z * b.x - a.x * b.z;
		res.z = a.x * b.y - a.y * b.x;
		return res;
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