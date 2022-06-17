package zEngine.util.matrix;

public interface Matrix {
	/**
	 * Returns the value of matrix entry with <b>row</b> row and <b>column</b> column
	 * @param row row number
	 * @param column column number
	 * @return value
	 */
	float get(int row, int column);

	/**
	 * Sets the matrix entry with <b>row</b> row and <b>column</b> column to <b>value</b>
	 * @param row row number
	 * @param column column number
	 * @param value float value
	 */
	void set(int row, int column, float value);

	int getNumRows();
	int getNumCols();
}