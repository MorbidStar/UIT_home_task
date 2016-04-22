package practic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class FractionNumberTest {
	
	@Test
	public void value() {
		FractionNumberImpl fni = new FractionNumberImpl(15, 3);
		Assert.assertEquals(5.0, fni.value(), 0.01);
	}
	
	@Test
	public void tostring() {
		FractionNumberImpl fni = new FractionNumberImpl(4,3);
		Assert.assertEquals("4/3", fni.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setDivisor() {
		FractionNumberImpl fni = new FractionNumberImpl();
		fni.setDivisor(0);
	}
}
