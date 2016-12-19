package geom;

import java.awt.Color;

/**
 * 
 * @author anthony
 *
 */
public class Geometrie 
{
	protected double x ;
	protected double y ;
	protected double z ;
	protected Type geotype = Type.UNDEFINED;
	protected Color stroke_color ;
	protected Color fill_color ;
	protected boolean fill ;
	
	public static enum Type 
	{
		UNDEFINED,
		POINT,
		CIRCLE,
		LINE,
		ELLIPSE
	}
	
	/**
	 * Creates an UNDEFINED Geometrie with 
	 * x=0
	 * y=0
	 * z=0
	 */
	public Geometrie()
	{
		this(0,0,0, Type.UNDEFINED) ;
	}
	
	/**
	 * Creates an UNDEFINED Geometrie with z=0 ;
	 * @param x  X-Location
	 * @param y  Y-Location
	 */
	public Geometrie(double x, double y)
	{
		this(x,y,0, Type.UNDEFINED) ;
	}
	
	/**
	 * Create a UNDEFINED Geometrie.
	 * @param x  X-Location
	 * @param y  Y-Location
	 * @param z  Z-Location
	 */
	public Geometrie(double x, double y, double z)
	{
		this(x,y,z,Type.UNDEFINED);
	}
	
	
	/**
	 * @param x  X-Location
	 * @param y  Y-Location
	 * @param z  Z-Location
	 * @param type Geometrie Type
	 */
	public Geometrie(double x, double y, double z, Type type)
	{
		this.x = x ;
		this.y = y ;
		this.z = z ;
		this.geotype = type ;
	}
	
	/**
	 * 
	 * @return  X-Location 
	 */
	public double x()
	{
		return this.x ;
	}
	
	/**
	 * 
	 * @return  Y-Location
	 */
	public double y()
	{
		return this.y ;
	}
	
	/**
	 * @return  Z-Location
	 */
	public double z()
	{
		return this.z ;
	}
	
	/**
	 * @return Geometrie Type
	 */
	public Type getType()
	{
		return this.geotype ;
	}

	/**
	 * 
	 * @return
	 */
	public Color getStroke_color() {
		return stroke_color;
	}

	/**
	 * 
	 * @return
	 */
	public Color getFill_color() {
		return fill_color;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isFill() {
		return fill;
	}

	/**
	 * 
	 * @param stroke_color
	 */
	public void setStroke_color(Color stroke_color) {
		this.stroke_color = stroke_color;
	}

	/**
	 * 
	 * @param fill_color
	 */
	public void setFill_color(Color fill_color) {
		this.fill_color = fill_color;
	}

	/**
	 * 
	 * @param fill
	 */
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	
}
