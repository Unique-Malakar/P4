package cubicpoly;

import utility.DoubleWithAppx;

/**
 * A general representation of a Cubic polynomial of the form:
 *     (a*x^3 + b*x^2 + c*x + d)
 * 
 * @author 
 * @date October-November 2018
 */


public class CubicPoly {
	private final DoubleWithAppx a;
	private final DoubleWithAppx b;
	private final DoubleWithAppx c;
	private final DoubleWithAppx d;
	
	
	
	// 5th// no arg constructo
	public CubicPoly() {

		

		this.a=DoubleWithAppx.ZERO;
		this.b=DoubleWithAppx.ZERO;
		this.c=DoubleWithAppx.ZERO;
		this.d=DoubleWithAppx.ZERO;
	
	}
	//4th//
	public CubicPoly(DoubleWithAppx dIn) {
		

		this.a=DoubleWithAppx.ZERO;
		this.b=DoubleWithAppx.ZERO;
		this.c=DoubleWithAppx.ZERO;
		this.d=dIn;
		
	}

	//3rd//
	public CubicPoly(DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		
		this.a=DoubleWithAppx.ZERO;
		this.b=DoubleWithAppx.ZERO;
		this.c=cIn;
		this.d=dIn;
		
	}

	//2nd //
	public CubicPoly(DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		
		this.a=DoubleWithAppx.ZERO;
		this.b=bIn;
		this.c=cIn;
		this.d=dIn;
	}
	
	// 1st//
	public CubicPoly(DoubleWithAppx aIn, DoubleWithAppx bIn, DoubleWithAppx cIn, DoubleWithAppx dIn) {
		
		this.a=aIn;
		this.b=bIn;
		this.c=cIn;
		this.d=dIn;
	}
	
	// copy constructor//
	public CubicPoly(CubicPoly other) {
		
		this(other.getA(),other.getB(),other.getC(),other.getD());
	
	}
	
	public DoubleWithAppx getA() {
		
		return a;
	}
	
	public DoubleWithAppx getB() {
		return b;

	}
	
	public DoubleWithAppx getC() {

		return c;
	}
	
	public DoubleWithAppx getD() {

		return d;
	}
	
	
	public DoubleWithAppx eval(DoubleWithAppx x) {
	
	
		
		DoubleWithAppx Solve= a.multiply(x.multiply(x.multiply(x))).add(b.multiply(x.multiply(x))).add(c.multiply(x)).add(d);

		return Solve;
		
		}
	
	
	public CubicPoly add(CubicPoly cubicPolyIn) {
		
		CubicPoly sol = new CubicPoly(this.a.add(cubicPolyIn.getA()),this.b.add(cubicPolyIn.getB()),this.c.add(cubicPolyIn.getC()),this.d.add(cubicPolyIn.getD()));
		
		return sol;
		
	}

	public CubicPoly subtract(CubicPoly cubicPolyIn) {


CubicPoly sol = new CubicPoly(this.a.subtract(cubicPolyIn.getA()),this.b.subtract(cubicPolyIn.getB()),this.c.subtract(cubicPolyIn.getC()),this.d.subtract(cubicPolyIn.getD()));
		
		return sol;
	
	
	}


	// release test failed . use cubicPlyIn=null to see if it passes
	public CubicPoly mult(CubicPoly cubicPolyIn) {
		
		
		// e,f,g,h are the coeficient of cubicPolyIn
		DoubleWithAppx e=cubicPolyIn.a;
		DoubleWithAppx f=cubicPolyIn.b;
		DoubleWithAppx g=cubicPolyIn.c;
		DoubleWithAppx h=cubicPolyIn.d;
		
		
		if(a.equals(DoubleWithAppx.ZERO) && b.equals(DoubleWithAppx.ZERO) && c.equals(DoubleWithAppx.ZERO) && d.equals(DoubleWithAppx.ZERO))
		{
			cubicPolyIn = null;
			
		}
		else if (e.equals(DoubleWithAppx.ZERO) && f.equals(DoubleWithAppx.ZERO) && g.equals(DoubleWithAppx.ZERO) && h.equals(DoubleWithAppx.ZERO))
		{
			cubicPolyIn = null;
		}
		else if (e.equals(DoubleWithAppx.ZERO) && f.equals(DoubleWithAppx.ZERO) && g.equals(DoubleWithAppx.ZERO))
		{
			cubicPolyIn = new CubicPoly(f.multiply(a),f.multiply(b),f.multiply(c),f.multiply(d)); 
			
		}
		else if(e.equals(DoubleWithAppx.ZERO) && f.equals(DoubleWithAppx.ZERO))
		{
			cubicPolyIn = new CubicPoly(g.multiply(b), (g.multiply(c).add(b.multiply(h))), (g.multiply(d).add(c.multiply(h))), h.multiply(d));
			
		}
		else if(e.equals(DoubleWithAppx.ZERO))

		{
			cubicPolyIn = new CubicPoly(f.multiply(c),(g.multiply(c).add(d.multiply(f))),(h.multiply(c).add(d.multiply(g))),h.multiply(d));
			
		}
		else if(a.equals(DoubleWithAppx.ZERO) && b.equals(DoubleWithAppx.ZERO) && c.equals(DoubleWithAppx.ZERO))
		{
			cubicPolyIn = new CubicPoly(e.multiply(d),f.multiply(d),g.multiply(d),h.multiply(d));
		}
		else
		{
			cubicPolyIn= null;
		}
		
		return cubicPolyIn;
		
		
	}

	
	
	
	public CubicPoly deriv() {
		
		CubicPoly deriv = new CubicPoly(DoubleWithAppx.ZERO,(a.add(a.add(a))),(b.add(b)),c);		
		return deriv;
	}


	// i could make a private method for zero for CubicPoly
	public int compareTo(CubicPoly cubicPolyIn) {
		

		DoubleWithAppx e = cubicPolyIn.a;
		DoubleWithAppx f=cubicPolyIn.b;
		DoubleWithAppx g=cubicPolyIn.c;
		DoubleWithAppx h=cubicPolyIn.d;
		int i=0;
		int cubic;
		if(!(a.equals(e))){
			cubic = a.compareTo(e);
			return cubic;
		}
		else if (!(b.equals(f))){

			cubic = b.compareTo(f);
			return cubic;
		}
		else if (!(c.equals(g))){

			cubic = c.compareTo(g);
			return cubic;
		}
		else if (!(d.equals(h))){

			cubic = d.compareTo(h);
			return cubic;
		}
		else {
			cubic =i;
			return cubic;
		}



	}

	
	
	//Challenge Problem
    public String toString() { 
    	return "a:"+a+", b:"+b+", c:"+c+", d:"+d;
		//You only need to implement this for a challenge.
    } 
	

	
    
    
    
    
    
    
	
	
	
	
	//NOTE: THIS JAVA EQUALS METHOD IS WRITTEN FOR YOU - DO NOT CHANGE
	@Override
	public boolean equals (Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			CubicPoly casted = (CubicPoly)other;
			return (
					a.equals(casted.a) && 
					b.equals(casted.b) && 
					c.equals(casted.c) && 
					d.equals(casted.d)
			);
		}
	}
	
	
}