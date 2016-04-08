package practic.task3;

import java.util.Arrays;

import nedis.study.interfaces.t3.classes.IMatrix;

public class IMatrixImpl implements IMatrix {

	private double[][] matrix;
	private int rows;
	private int columns;

	public IMatrixImpl() {
		this(DEFAULT_MATRIX_SIZE, DEFAULT_MATRIX_SIZE);
	}

	public IMatrixImpl(int rows, int columns) {
		super();

		if (rows < 0 || columns < 0) {
			throw new IllegalArgumentException();
		}

		this.rows = rows;
		this.columns = columns;
		matrix = new double[rows][columns];
	}

	@Override
	public int getRows() {
		return rows;
	}

	@Override
	public int getColumns() {
		return columns;
	}

	@Override
	public double getValueAt(int rowIndex, int colIndex)
			throws IndexOutOfBoundsException {

		ifIllegalArgumentThrowException(rowIndex, colIndex);

		return matrix[rowIndex][colIndex];
	}

	@Override
	public void setValueAt(int rowIndex, int colIndex, double value)
			throws IndexOutOfBoundsException {

		ifIllegalArgumentThrowException(rowIndex, colIndex);

		matrix[rowIndex][colIndex] = value;
	}

	@Override
	public IMatrix add(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {

		ifNotEqualRowColumnsThrowException(otherMatrix);

		IMatrix result = new IMatrixImpl(rows, columns);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result.setValueAt(i, j,
						getValueAt(i, j) + otherMatrix.getValueAt(i, j));
			}
		}

		return result;
	}

	@Override
	public IMatrix sub(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {

		ifNotEqualRowColumnsThrowException(otherMatrix);

		IMatrix result = new IMatrixImpl(rows, columns);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result.setValueAt(i, j,
						getValueAt(i, j) - otherMatrix.getValueAt(i, j));
			}
		}

		return result;
	}

	@Override
	public IMatrix mul(IMatrix otherMatrix) throws IllegalArgumentException,
			NullPointerException {
		if (otherMatrix == null) {
			throw new NullPointerException();
		} else if (columns != otherMatrix.getRows()) {
			throw new IllegalArgumentException();
		}
		IMatrix result = new IMatrixImpl(rows, otherMatrix.getColumns());

		for (int i = 0; i < result.getRows(); i++) {
			for (int j = 0; j < result.getColumns(); j++) {
				double cij = 0.;
				for (int k = 0; k < otherMatrix.getRows(); k++) {
					cij += getValueAt(i, k) * otherMatrix.getValueAt(k, j);
				}
				result.setValueAt(i, j, cij);
			}
		}

		return result;
	}

	@Override
	public IMatrix mul(double value) {
		IMatrix result = new IMatrixImpl(rows, columns);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result.setValueAt(i, j, getValueAt(i, j) * value);
			}
		}

		return result;
	}

	@Override
	public IMatrix transpose() {
		IMatrix result = new IMatrixImpl(columns, rows);

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				result.setValueAt(i, j, getValueAt(j, i));
			}
		}

		return result;
	}

	@Override
	public void fillMatrix(double value) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				setValueAt(i, j, value);
			}
		}
	}

	@Override
	public double determinant() {
		double result = 0.0;
		double[][] tmp = new double[getRows()][getColumns()];
		
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getColumns(); j++) {
				tmp[i][j] = getValueAt(i, j);
			}
		}

		if (rows == 2 & columns == 2) {
			return getValueAt(0, 0) * getValueAt(1, 1) - getValueAt(0, 1)
					* getValueAt(1, 0);
		} else if (rows == 3 & columns == 3) {
			return getValueAt(0, 0) * getValueAt(1, 1) * getValueAt(2, 2)
					+ getValueAt(0, 1) * getValueAt(1, 2) * getValueAt(2, 0)
					+ getValueAt(0, 2) * getValueAt(1, 0) * getValueAt(2, 1)
					- getValueAt(0, 2) * getValueAt(1, 1) * getValueAt(2, 0)
					- getValueAt(0, 0) * getValueAt(1, 2) * getValueAt(2, 1)
					- getValueAt(0, 1) * getValueAt(1, 0) * getValueAt(2, 2);
		} //else {
			//for (int j = 1; j < rows; j++) {
				//result += sign(1+j)*getValueAt(0, j)*createMatrix(tmp, 0, j);
			//}
		//}

		return 0;
	}

//	private double[][] createMatrix(double[][] matr, int rows, int columns) {
//		int a = getRows() - 1;
//		int b = getColumns() - 1;
//		double[][] result = new double[a][b];
//		int skipRow = 0;
//
//		for (int i = 0; i < a; i++) {
//			int skipColumn = 0;
//			for (int j = 0; j < b; j++) {
//				if (skipRow == rows) {
//					++skipRow;
//				}
//
//				if (skipColumn == columns) {
//					++skipColumn;
//				}
//				result[i][j] = matr[skipRow][skipColumn++];
//			}
//			skipRow++;
//		}
//
//		return result;
//	}
//
//	private double sign(int k) {
//		return Math.pow(-1, 1 + k);
//	}

	@Override
	public boolean isNullMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (getValueAt(i, j) != 0) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean isIdentityMatrix() {
		if (!isSquareMatrix()) {
			return false;
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == j && getValueAt(i, j) != 1) {
					return false;
				} else if (i != j && getValueAt(i, j) != 0) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean isSquareMatrix() {
		return rows == columns;
	}

	@Override
	public void printToConsole() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(getValueAt(i, j) + " ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				result.append(matrix[i][j] + " ");
			}
			result.append("\n");
		}
		return result.toString();
	}

	private void ifIllegalArgumentThrowException(int rowIndex, int colIndex) {
		if (rowIndex < 0 || rowIndex >= matrix.length || colIndex < 0
				|| colIndex >= matrix[rowIndex].length) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void ifNotEqualRowColumnsThrowException(IMatrix otherMatrix) {
		if (otherMatrix == null) {
			throw new NullPointerException();
		}

		if (getRows() != otherMatrix.getRows()
				&& getColumns() != otherMatrix.getColumns()) {
			throw new IllegalArgumentException();
		}
	}

}
