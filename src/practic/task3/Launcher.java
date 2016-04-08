package practic.task3;

import nedis.study.interfaces.t3.classes.IMatrix;

public class Launcher {

	public static void main(String[] args) {
		IMatrix var1 = new IMatrixImpl(2,3);
		IMatrix var2 = new IMatrixImpl(3,4);
		IMatrix var4 = new IMatrixImpl(3,3);
		var4.setValueAt(0, 0, 1);
		var4.setValueAt(0, 1, 4);
		var4.setValueAt(0, 2, -3);
		var4.setValueAt(1, 0, 6);   /// 4 3
		var4.setValueAt(1, 1, 4);   /// 6 3
		var4.setValueAt(1, 2, 2);
		var4.setValueAt(2, 0, 3);
		var4.setValueAt(2, 1, 5);
		var4.setValueAt(2, 2, 0);
		System.out.println(var4.determinant());
	}

}
