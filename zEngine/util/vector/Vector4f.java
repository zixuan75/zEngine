package zEngine.util.vector;

/*
 * ALl of this code was made months ago and I don't want to rewrite it or
 * provide any documentation because I'm too lazy to do so.
 */

public class Vector4f implements Vector {
	public float x, y, z, w;
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	public Vector4f(Vector3f a) {
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
		this.w = 1;
	}
	
	public Vector4f(Vector3f a, float b) {
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
		this.w = b;
	}
	
	public Vector4f(float a) {
		this.x = a;
		this.y = a;
		this.z = a;
		this.w = a;
	}
	
	@Override
	public int size() {
		return 4;
	}

	@Override
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
	
	@Override
	public Vector defVector() {
		return new Vector4f(1, 1, 1, 1);
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
