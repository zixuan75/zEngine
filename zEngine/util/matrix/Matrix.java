package zEngine.util.matrix;

import java.util.Arrays;
import zEngine.util.vector.Vector;

public class Matrix {
	public int rows;
	public int cols;
	public float[] elements;
	
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		elements = new float[rows * cols];
		setIdentity();
	}

	/**
	 * Sets the matrix to the identity matrix
	 * @throws RuntimeException
	 */
	public void setIdentity() {
		if (rows != cols) {
			throw new ArithmeticException("Cannot set rectangular matrix to identity: Matrix.setIdentity");
		}
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				set(x, y, 0);
			}
			set(x, x, 1);
		}
	}
	
	

	public float get(int x, int y) {
		return elements[x * rows + y];
	}
	public void set(int x, int y, float value) {
		elements[x * rows + y] = value;
	}
	
	public void print() {
		for (int x = 0; x < cols; x++) {
			System.out.print("( ");
			for (int y = 0; y < rows; y++) {
				System.out.print(get(y, x) + " ");
			}
			System.out.print(")");
			System.out.println();
		}
	}

	

	public static Vector multiply(Matrix matrix, Vector vector) {
		Vector res = vector.defVector();
		if (matrix.cols != vector.size())
			throw new ArithmeticException("Matrix.multiply");
		for (int i = 0; i < matrix.rows; i++) {
			float dotProduct = 0;
			for (int j = 0; j < matrix.cols; j++) {
				dotProduct += matrix.get(i, j) * vector.get(j);
			}
			res.set(i, dotProduct);
		}
		return res;
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
