package practic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FractionNumberOperationTest {

	@Before
	public void setA() {
		System.out.println("before test");
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
	}
	
	@Test(expected = NullPointerException.class)
	public void addTest1() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = null;
		fnoi.add(f1, f2);
	}
	
	@Test(expected = NullPointerException.class)
	public void addTest2() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = null;
		FractionNumberImpl f2 = new FractionNumberImpl(3,7);
		fnoi.add(f1, f2);
	}
	
	@Test
	public void addTest3() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = new FractionNumberImpl(4,5);
		Assert.assertEquals("43/35", fnoi.add(f1, f2).toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void subTest1() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = null;
		fnoi.sub(f1, f2);
	}
	
	@Test(expected = NullPointerException.class)
	public void subTest2() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = null;
		FractionNumberImpl f2 = new FractionNumberImpl(3,7);
		fnoi.sub(f1, f2);
	}
	
	@Test
	public void subTest3() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = new FractionNumberImpl(4,5);
		Assert.assertEquals("-13/35", fnoi.sub(f1, f2).toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void mulTest1() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = null;
		fnoi.mul(f1, f2);
	}
	
	@Test(expected = NullPointerException.class)
	public void mulTest2() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = null;
		FractionNumberImpl f2 = new FractionNumberImpl(3,7);
		fnoi.mul(f1, f2);
	}
	
	@Test
	public void mulTest3() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = new FractionNumberImpl(4,5);
		Assert.assertEquals("12/35", fnoi.mul(f1, f2).toString());
	}
	
	@Test(expected = NullPointerException.class)
	public void divTest1() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = null;
		fnoi.div(f1, f2);
	}
	
	@Test(expected = NullPointerException.class)
	public void divTest2() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = null;
		FractionNumberImpl f2 = new FractionNumberImpl(3,7);
		fnoi.div(f1, f2);
	}
	
	@Test
	public void divTest3() {
		FractionNumberOperationImpl fnoi = new FractionNumberOperationImpl();
		FractionNumberImpl f1 = new FractionNumberImpl(3,7);
		FractionNumberImpl f2 = new FractionNumberImpl(4,5);
		Assert.assertEquals("15/28", fnoi.div(f1, f2).toString());
	}
	
	
}
