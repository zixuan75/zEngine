package zEngine.util.vector;

public class Vector4f implements Vector {
	public float x, y, z, w;

	public Vector4f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	@Override
	public int size() {
		return 4;
	}

	public float[] getArray() {
		float[] res = new float[4];
		res[0] = x;
		res[1] = y;
		res[2] = z;
		res[3] = w;
		return res;
	}

	@Override
	public float get(int i) {
		return getArray()[i];
	}
	@Override
	public void set(int i, float a) {
		if (i == 0) {
			x = a;
		}
		if (i == 1) {
			y = a;
		}
		if (i == 2) {
			z = a;
		}
		if (i == 3) {
			w = a;
		}
	}
	
	public void print() {
		System.out.println("(" + x + " " + y + " " + z + " " + w + ")");
	}
	public void set(float x2, float y2, float i, float j) {
		x = x2;
		y = y2;
		z = i;
		w = j;
	}
	public static Vector4f translate(Vector4f a, Vector4f b) {
		return new Vector4f(a.x + b.x, a.y + b.y, a.z + b.z, a.w + b.w);
	}
	public static Vector4f diff(Vector4f a, Vector4f b) {
		return new Vector4f(a.x - b.x, a.y - b.y, a.z - b.z, a.w - b.w);
	}
	public static Vector4f scale(Vector4f a, float s) {
		return new Vector4f(a.x * s, a.y * s, a.z * s, a.w * s);
	}
	public static Vector4f compMult(Vector4f a, Vector4f b) {
		return new Vector4f(a.x * b.x, a.y * b.y, a.z * b.z, a.w * b.w);
	}
    public static float length(Vector4f a) {
        return (float) Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z + a.w * a.w);
    }
    public static Vector4f normalize(Vector4f a) {
		float length = length(a);
		return new Vector4f(a.x / length, a.y / length, a.z / length, a.w / length);
	}
	public static float dot(Vector4f a, Vector4f b) {
		return a.x * b.x + a.y * b.y + a.z * b.z + a.w * b.w;
	}
}
