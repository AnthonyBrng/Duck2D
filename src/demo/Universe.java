package demo;
import core.Environment;
import demo.demo_objects.Star;

/**
 * Demo-Class.
 * Shows a walkthrough through the univers using warpspeed for
 * short amount of time.
 * @author anthony
 *
 */
public class Universe extends Environment 
{
	private Star[] stars = new Star[2000] ;
	private int widht = 1600 ;
	private int height = 1000 ;
			
	/**
	 * Set the with and the height of the canvas.
	 * Initialize the Star array.
	 */
	@Override
	public void settings() 
	{
		size(widht,height) ;
		background(0);
		origin(width()/2, height()/2);
		
		/*
		 * Init star-Array 
		 */
		for(int i=0 ; i<stars.length ; i++ )
			stars[i] = new Star(this) ;
	}
	
	/**
	 * Draw.
	 * An animated Background (colorchanging)
	 * translate the origin to the center of the canvas.
	 * display alls Stars in the Stars-Array.
	 */
	@Override
	public void draw() 
	{
		for(int i=0 ; i<stars.length ; i++ )
		{
			stars[i].update();
			stars[i].show();
		}	
	}
	
	/**
	 * Stars the Universe
	 */
	public static void main(String[] args)
	{
		new Universe().show();
	}

}



