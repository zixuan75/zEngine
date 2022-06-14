package zEngine.util.vector;

/*
 * ALl of this code was made months ago and I don't want to rewrite it or
 * provide any documentation because I'm too lazy to do so.
 */

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

    @Override
	public int size() {
		return 2;
	}

	@Override
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
	
	public static Vector2f swapY(Vector2f a) {
		return new Vector2f(a.x, -a.y);
	}
	
	@Override
	public Vector defVector() {
		return new Vector2f(1, 1);
	}
	
	public void print() {
		System.out.println("(" + x + " " + y + ")");
	}

	
}
