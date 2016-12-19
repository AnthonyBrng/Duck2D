package geom;

import core.*;

/**
 * Circle-Object
 * @author anthony
 *
 */
public class Circle extends Geometrie 
{
	private double radius = 0 ;
	
	/**
	 * Constructor
	 * @param x X-Location 
	 * @param y Y-Location
	 * @param radius Radius of the circle
	 */
	public Circle(double x, double y, double radius)
	{
		super(x, y, 0, Type.CIRCLE);
		this.radius = radius ;
	}
	
	/**
	 * @return circle-radius
	 */
	public double radius()
	{
		return this.radius ;
	}
}
