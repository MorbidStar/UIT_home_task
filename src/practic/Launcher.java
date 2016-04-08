package practic;

import nedis.study.interfaces.t2.core.FractionNumber;
import nedis.study.interfaces.t2.core.FractionNumberOperation;
import nedis.study.interfaces.t3.classes.IMatrix;

public class Launcher {

	public static void main(String[] args) {
		FractionNumber f1 = new FractionNumberImpl(3,4);
		FractionNumber f2 = new FractionNumberImpl(5,2);
		FractionNumberOperation fno = new FractionNumberOperationImpl();
		System.out.println(fno.add(f1, f2));
		System.out.println(fno.sub(f1, f2));
		System.out.println(fno.mul(f1, f2));
		System.out.println(fno.div(f1, f2));
		
	}

}
