package geom;

public class Ellipse extends Geometrie
{
	private double width ;
	private double height ;
	
	public Ellipse(double x, double y, double width, double height)
	{
		super(x, y, 0, Type.ELLIPSE);
		this.width = width ;
		this.height = height ;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getWidth()
	{
		return this.width ;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getHeight()
	{
		return this.height ;
	}

}
