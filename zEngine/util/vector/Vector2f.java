package zEngine.util.vector;

public class Vector2f implements Vector {
	
	public float x;
	public float y;
	


	public Vector2f(float f) {
		this.x = f;
		this.y = f;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f() {
		this.x = 0;
		this.y = 0;
    }

	public Vector2f(Vector3f f) {
		this.x = f.x;
		this.y = f.y;
	}

    @Override
	public int size() {
		return 2;
	}

	public float[] getArray() {
		float[] res = new float[2];
		res[0] = x;
		res[1] = y;
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
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	

    public void set(Vector2f a) {
		this.x = a.x;
		this.y = a.y;
    }
	
	public void print() {
		System.out.println("(" + x + " " + y + ")");
	}

	public Vector2f project(Vector2f onto) {
		return Vector2f.scale(Vector2f.normalize(onto), Vector2f.dot(this, onto));
	}

	
	
	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public static Vector2f normalize(Vector2f a) {
		float length = a.length();
		return new Vector2f(a.x / length, a.y / length);
	}

	public void normalize() {
		float length = length();
		x /= length;
		y /= length;
	}
	
	public static float dot(Vector2f a, Vector2f b) {
		return a.x * b.x + a.y * b.y;
	}
	
	public static Vector2f translate(Vector2f a, Vector2f b) {
		return new Vector2f(a.x + b.x, a.y + b.y);
	}

	public static Vector2f diff(Vector2f a, Vector2f b) {
		return new Vector2f(a.x - b.x, a.y - b.y);
	}

	public static Vector2f diff(Vector2f a, Vector2f b, Vector2f res) {
		if (res == null)
			res = new Vector2f();
		res.set(a.x - b.x, a.y - b.y);
		return res;
	}

	public static Vector2f scale(Vector2f a, float s) {
		return new Vector2f(a.x * s, a.y * s);
	}

    public static Vector2f compMult(Vector2f a, Vector2f b) {
		return new Vector2f(a.x * b.x, a.y * b.y);
    }
}
