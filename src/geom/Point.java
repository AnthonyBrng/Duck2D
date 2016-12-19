package geom;

public class Point extends Geometrie 
{
	private double size ;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param size
	 */
	public Point(double x, double y, double size)
	{
		super(x,y);
		this.size = size ;
		this.geotype = Type.POINT ;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public double size()
	{
		return this.size;
	}
}
