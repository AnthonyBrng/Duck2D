package geom;

/**
 * 
 * @author anthony
 *
 */
public class Line extends Geometrie
{
	double x_dest ;
	double y_dest ;
	
	/**
	 * 
	 * @param x_src X-Location
	 * @param y_src Y-Location
	 * @param x_dest Destination X-Location 
	 * @param y_dest Destination Y-Location
	 */
	public Line(double x_src, double y_src, double x_dest, double y_dest)
	{
		super(x_src, y_src);
		this.x_dest = x_dest ;
		this.y_dest = y_dest ;
		this.geotype = Type.LINE ;
	}
	
	
	/**
	 * @return Destination X-Location 
	 */
	public double x_dest()
	{
		return this.x_dest ;
	}
	
	
	/**
	 * @return Destination Y-Location 
	 */
	public double y_dest()
	{
		return this.y_dest ;
	}
}
