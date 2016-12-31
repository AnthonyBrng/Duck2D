package geom;

import core.CanvasProperties;

import java.awt.Color;

/**
 * 
 * @author anthony
 *
 */
public class Geometrie {
	protected double x ;
	protected double y ;
	protected double z ;
	protected Type geotype = Type.UNDEFINED;
	protected Color color;
	protected Color fillColor;
	protected Color textColor ;
	protected boolean fill ;
	protected double rotationAngle ;
	
	public static enum Type 
	{
		UNDEFINED,
		POINT,
		CIRCLE,
		LINE,
		ELLIPSE,
		TEXT,
		RECTANGLE
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
		this.fillColor = CanvasProperties.FILL_COLOR ;
		this.fill = CanvasProperties.FILL;
		this.color = CanvasProperties.STROKE_COLOR ;
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
	public Color getColor()
	{
		return color;
	}

	/**
	 * 
	 * @return
	 */
	public Color getFillColor()
	{
		return fillColor;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isFill()
	{
		return fill;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}

	/**
	 * 
	 * @param fill_color
	 */
	public void setFillColor(Color fill_color)
	{
		this.fillColor = fill_color;
	}

	/**
	 * 
	 * @param fill
	 */
	public void setFill(boolean fill)
	{
		this.fill = fill;
	}

	/**
	 *
	 * @return
	 */
	public Color getTextColor() {
		return textColor;
	}

	/**
	 *
	 * @param textColor
	 */
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}


	/**
	 *
	 * @param rotationAngle
	 */
	public void setRoatationAngle(double rotationAngle)
	{
		this.rotationAngle = rotationAngle ;
	}


	/**
	 *
	 * @return
	 */
	public double getRotationAngle()
	{
		return this.rotationAngle ;
	}
	
	
}
