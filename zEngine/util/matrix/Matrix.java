package zEngine.util.matrix;

import java.util.Arrays;
import zEngine.util.vector.*;
/** 
 * I gotta admit, matrices were really confusing to me.
 */ 
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

	public void setIdentity() {
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				set(x, y, 0);
			}
			set(x, x, 1);
		}
	}

	public float get(int row, int col) {
		return elements[row * cols + col];
	}

	public void set(int row, int col, float value) {
		elements[row * cols + col] = value;
	}

	public void set(Matrix matrix) {
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				elements[row * cols + col] = matrix.
					elements[row * cols + col];
			}
		}
	}

	public static Vector transform(Matrix matrix, Vector vector) {
		if (vector.size() != matrix.cols) throw new ArithmeticException();
		Vector result = VectorUtils.loadVector(vector.size());
		for (int row = 0; row < matrix.rows; row++) {
			float prod = 0;
			for (int col = 0; col < matrix.cols; col++) {
				prod += matrix.get(row, col) * vector.get(col);
			}
			result.set(row, prod);
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) { buf.append(get(row, col)).append(' '); }
			buf.append('\n');
		}
		return buf.toString();
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
