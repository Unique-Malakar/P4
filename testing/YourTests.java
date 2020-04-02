package testing;
import static org.junit.Assert.*;

import org.junit.Test;

import cubicpoly.CubicPoly;
import utility.DoubleWithAppx;


public class YourTests {
	//Some example JUnit tests to get you started thinking about 
	//  writing your own JUnit tests.
	@Test
	public void testDefaultConstructor() {
		CubicPoly testCubicPoly = new CubicPoly();
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().isZero()
				&& testCubicPoly.getD().isZero());
	}
	
	
	@Test
	public void testSingleValConstructor() {
		DoubleWithAppx dVal = new DoubleWithAppx(27.8);
				
		CubicPoly testCubicPoly = new CubicPoly(dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().isZero()
				&& testCubicPoly.getD().equals(dVal));
	}

	
	@Test
	public void testTwoValConstructor() {
		DoubleWithAppx cVal = new DoubleWithAppx(23.2);
		DoubleWithAppx dVal = new DoubleWithAppx(-4.7);
				
		CubicPoly testCubicPoly = new CubicPoly(cVal, dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().isZero()
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}

	
	@Test
	public void testThreeValConstructor() {
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		CubicPoly testCubicPoly = new CubicPoly(bVal, cVal, dVal);
		assertTrue(testCubicPoly.getA().isZero()
				&& testCubicPoly.getB().equals(bVal)
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}
	
	
	@Test
	public void testFourValConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(43.1);
		DoubleWithAppx bVal = new DoubleWithAppx(15.7);
		DoubleWithAppx cVal = new DoubleWithAppx(-23.7);
		DoubleWithAppx dVal = new DoubleWithAppx(4.3);
				
		CubicPoly testCubicPoly = new CubicPoly(aVal, bVal, cVal, dVal);
		assertTrue(testCubicPoly.getA().equals(aVal)
				&& testCubicPoly.getB().equals(bVal)
				&& testCubicPoly.getC().equals(cVal)
				&& testCubicPoly.getD().equals(dVal));
	}
	
	
	

	@Test
	public void testCopyConstructor() {
		DoubleWithAppx aVal = new DoubleWithAppx(-19.2);
		DoubleWithAppx bVal = new DoubleWithAppx(24.2);
		DoubleWithAppx cVal = new DoubleWithAppx(-3.2);
		DoubleWithAppx dVal = new DoubleWithAppx(18.7);
		
		CubicPoly testCubicPoly = new CubicPoly(aVal, bVal, cVal, dVal);
		CubicPoly testCopyCubic = new CubicPoly(testCubicPoly);
		
		// Check to be sure they are not aliased!
		assertTrue(testCubicPoly != testCopyCubic);     
		
		assertTrue(testCubicPoly.getA().equals(testCopyCubic.getA())
				&& testCubicPoly.getB().equals(testCopyCubic.getB())
				&& testCubicPoly.getC().equals(testCopyCubic.getC())
				&& testCubicPoly.getD().equals(testCopyCubic.getD()));
		
		assertEquals(testCubicPoly, testCopyCubic);
	}
	
	
	@Test
	public void testGetters() {
		DoubleWithAppx one = new DoubleWithAppx(1.1);
		DoubleWithAppx two = new DoubleWithAppx(2.2);
		DoubleWithAppx three = new DoubleWithAppx(3.3);
		DoubleWithAppx four = new DoubleWithAppx(4.4);
		
		CubicPoly p = new CubicPoly(one, two, three, four);

		assertTrue(p.getA().equals(one));
		assertTrue(p.getB().equals(two));
		assertTrue(p.getC().equals(three));
		assertTrue(p.getD().equals(four));
	}
	

	@Test 
	public void testEval() {
		CubicPoly mc1 = new CubicPoly(
				new DoubleWithAppx(5),
				new DoubleWithAppx(-3),
				new DoubleWithAppx(2),
				new DoubleWithAppx(4)
			);
		
		assertEquals(new DoubleWithAppx(564), mc1.eval(new DoubleWithAppx(5)));
	}
	
	
	//YOU NEED TO IMPLEMENT AT LEAST THREE JUNIT TESTS BELOW
	@Test
	public void testAdd() {
		
		CubicPoly t1 = new CubicPoly( new DoubleWithAppx(5),
				new DoubleWithAppx(-3),
				new DoubleWithAppx(2),
				new DoubleWithAppx(1)
				);
		
		CubicPoly t2 = new CubicPoly( new DoubleWithAppx(2),
				new DoubleWithAppx(1),
				new DoubleWithAppx(6),
				new DoubleWithAppx(-4)
				);
	//	assertEquals()	
		CubicPoly ans= new CubicPoly (new DoubleWithAppx(7),
				new DoubleWithAppx(-2),
				new DoubleWithAppx(8),
				new DoubleWithAppx(-3)
				);
		assertEquals(ans,t2.add(t1));
	}

	@Test
	public void testSubtract() {
		
		CubicPoly t1 = new CubicPoly( new DoubleWithAppx(5),
				new DoubleWithAppx(-3),
				new DoubleWithAppx(2),
				new DoubleWithAppx(1)
				);
		
		CubicPoly t2 = new CubicPoly( new DoubleWithAppx(2),
				new DoubleWithAppx(1),
				new DoubleWithAppx(6),
				new DoubleWithAppx(-4)
				);
	//	assertEquals()	
		CubicPoly ans= new CubicPoly (new DoubleWithAppx(3),
				new DoubleWithAppx(-4),
				new DoubleWithAppx(-4),
				new DoubleWithAppx(5)
				);
		assertEquals(ans,t1.subtract(t2));
	}

	@Test
	public void testDeriv() {
		
		CubicPoly t1 = new CubicPoly( new DoubleWithAppx(5),
				new DoubleWithAppx(-3),
				new DoubleWithAppx(2),
				new DoubleWithAppx(1)
				);
		
		CubicPoly ans= new CubicPoly ( DoubleWithAppx.ZERO,
				new DoubleWithAppx(15),
				new DoubleWithAppx(-6),
				new DoubleWithAppx(2)
				);
		
		assertEquals(ans,t1.deriv());
		
		//fail(); //replace this with your actual test
	}

	@Test
	public void testCompareTo() {
		
		
		fail(); //replace this with your actual test
	}
	


	
}
