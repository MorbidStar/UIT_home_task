package practic;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

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
				}

				if (i != j && getValueAt(i, j) != 0) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean isSquareMatrix() {
		if (rows == columns) {
			return true;
		}
		return false;
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
