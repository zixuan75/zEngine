package zEngine.util.vector;

import zEngine.util.math.zLinear;

public class Vector3f implements Vector {
	public float x, y, z;
	
	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector3f(float a) {
		this.x = a;
		this.y = a;
		this.z = a;
	}
	public Vector3f() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	public Vector3f(Vector2f a) {
		this.x = a.x;
		this.y = a.y;
		this.z = 0;
	}
	public Vector3f(Vector4f a) {
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
	}
	public Vector3f(Vector3f a) {
		this.x = a.x;
		this.y = a.y;
		this.z = a.z;
	}

	@Override
	public int size() {
		return 3;
	}
	public float[] getArray() {
		float[] res = new float[3];
		res[0] = x;
		res[1] = y;
		res[2] = z;
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
	}
	public void set(float i, float j, float k) {
		x = i;
		y = j;
		z = k;
	}

	public Vector3f project(Vector3f onto) {
		return zLinear.scale(zLinear.normalize(onto), zLinear.dot(this, onto));
	}

	@Override
	public String toString() {
		return "(" + x + " " + y + " " + z + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		return result;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3f other = (Vector3f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		return true;
	}

	public Vector3f translate(Vector3f f) {
		this.x += f.x;
		this.y += f.y;
		this.z += f.z;
		return this;
	}
	
	public Vector3f scale(float f) {
		this.x *= f;
		this.y *= f;
		this.z *= f;
		return this;
	}
}
