package demo;


import core.Entity;
import core.Environment;

public class Auge extends Entity
{

	int x ;
	int y ;
	int max = 6 ;
	double offset_x = max ;
	double offset_y = 0 ;
	double incx = 0.5 ;
	double incy = 0.5 ;
	
	
	/**
	 * 
	 * @param env
	 */
	public Auge(Environment env, int x, int y) 
	{
		super(env);
		this.x = x ;
		this.y = y ;
	}
	
	
	/**
	 * 
	 */
	public void update()
	{
		offset_y +=incy ;
		offset_x +=incx ;
		
		if(offset_y > max || offset_y < -max)
			incy *= -1 ;
		
		if(offset_x > max || offset_x < -max)
			incx *= -1 ;
	}
	
	/**
	 * 
	 */
	public void show()
	{
		fill(0) ;
		circle(x, y, 50);
		
		noFill();
		stroke(0) ;
		ellipse(x + offset_x, y + offset_y,300, 150);
	}
	
}
