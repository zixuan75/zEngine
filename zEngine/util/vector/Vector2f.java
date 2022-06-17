package zEngine.util.vector;

import zEngine.util.math.zLinear;

/*
 * Most of this code was made months ago and I don't want to rewrite it or
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
	
	public void print() {
		System.out.println("(" + x + " " + y + ")");
	}

	public Vector2f project(Vector2f onto) {
		return zLinear.scale(zLinear.normalize(onto), zLinear.dot(this, onto));
	}
}
