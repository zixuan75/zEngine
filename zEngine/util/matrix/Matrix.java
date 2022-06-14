package zEngine.util.matrix;

import java.util.Arrays;

/*
 * ALl of this code was made months ago and I don't want to rewrite it or
 * provide any documentation because I'm too lazy to do so.
 */

public class Matrix {
	public int size;
	public float[] elements;
	
	public Matrix(int size) {
		this.size = size;
		elements = new float[size * size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				set(i, j, 0);
			}
			set(i, i, 1);
		}
	}
	
	public Matrix(int size, int n) {
		this.size = size;
		elements = new float[size * size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				set(i, j, 0);
			}
			set(i, i, n);
		}
	}
	
	public Matrix(int size, float[][] mat) {
		this.size = size;
		elements = new float[size * size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				set(i, j, mat[i][j]);
			}
		}
	}
	
	

	public float get(int x, int y) {
		return elements[x * size + y];
	}

	public void set(int x, int y, float value) {
		elements[x * size + y] = value;
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			System.out.print("( ");
			for (int j = 0; j < size; j++) {
				System.out.print(get(i, j) + " ");
			}
			System.out.print(")");
			System.out.println();
		}
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elements);
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
		Matrix other = (Matrix) obj;
		if (!Arrays.equals(elements, other.elements))
			return false;
		return true;
	}
}
