package practic;

import nedis.study.interfaces.t2.core.FractionNumber;

public class FractionNumberImpl implements FractionNumber {
	
	private int dividend;
	private int divisor;
	
	public FractionNumberImpl() {
		super();
		divisor = DEFAULT_DIVISOR_VALUE;
	}
	
	public FractionNumberImpl(int dividend, int divisor) {
		super();
		this.dividend = dividend;
		setDivisor(divisor);
	}

	@Override
	public void setDividend(int dividend) {
		this.dividend = dividend;
	}

	@Override
	public int getDividend() {
		return dividend;
	}

	@Override
	public void setDivisor(int divisor) throws IllegalArgumentException {
		if (divisor == 0) {
			throw new IllegalArgumentException();
		} else {
			this.divisor = divisor;
		}
	}

	@Override
	public int getDivisor() {
		return divisor;
	}

	@Override
	public double value() {
		return dividend/(double)divisor;
	}

	@Override
	public String toString() {
		return dividend + "/" + divisor;
	}
	
	

}
