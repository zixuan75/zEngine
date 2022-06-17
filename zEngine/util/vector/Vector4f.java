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
}
