package practic;

import nedis.study.interfaces.t2.core.FractionNumber;
import nedis.study.interfaces.t2.core.FractionNumberOperation;

public class FractionNumberOperationImpl implements FractionNumberOperation {

	@Override
	public FractionNumber add(FractionNumber a, FractionNumber b)
			throws NullPointerException {

		ifNullThrowException(a, b);

		FractionNumber result = new FractionNumberImpl();
		result.setDividend(a.getDividend() * b.getDivisor() + b.getDividend()
				* a.getDivisor());
		result.setDivisor(a.getDivisor() * b.getDivisor());
		return result;
	}

	@Override
	public FractionNumber sub(FractionNumber a, FractionNumber b)
			throws NullPointerException {

		ifNullThrowException(a, b);

		FractionNumber result = new FractionNumberImpl();
		result.setDividend(a.getDividend() * b.getDivisor() - b.getDividend()
				* a.getDivisor());
		result.setDivisor(a.getDivisor() * b.getDivisor());
		return result;
	}

	@Override
	public FractionNumber mul(FractionNumber a, FractionNumber b)
			throws NullPointerException {

		ifNullThrowException(a, b);

		FractionNumber result = new FractionNumberImpl();
		result.setDividend(a.getDividend() * b.getDividend());
		result.setDivisor(a.getDivisor() * b.getDivisor());
		return result;
	}

	@Override
	public FractionNumber div(FractionNumber a, FractionNumber b)
			throws NullPointerException, ArithmeticException {
		
		ifNullThrowException(a, b);

		FractionNumber result = new FractionNumberImpl();
		result.setDividend(a.getDividend() * b.getDivisor());
		result.setDivisor(b.getDividend() * a.getDivisor());

		if (result.getDivisor() == 0) {
			throw new ArithmeticException();
		}

		return result;
	}
	
	private void ifNullThrowException(FractionNumber a, FractionNumber b) {
		if (a == null || b == null) {
			throw new NullPointerException();
		}
	}

}
