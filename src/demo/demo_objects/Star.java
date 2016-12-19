package demo.demo_objects;

import java.util.Random;

import core.Entity;
import core.Environment;

/**
 * Simple star Object, belongs to the Universe Demo.
 * @author anthony
 *
 */
public class Star extends Entity
{
	double x = 0 ;
	double y = 0 ;
	double z = 0 ;
	double pz  ;
	double time = 0 ;
	double warpTime = 20;
	double maxspeed = 60 ;
	double minspeed = 7 ;
	boolean warpspeed = true ;
	
	Random r = new Random() ;
	double speed = 7 ;
	
	public Star(Environment env)
	{
		super(env);
		
		x = random(-width(), width()) ;
		y = random(-height(), height()) ;
		z = random(0, width()) ;

		pz = z ;
	}
	
	/**
	 * Updates speed and Coordinates.
	 */
	public void update()
	{
		z -= speed ; 
		if(z < 1)
		{
			x = random(-width(), width()) ;
			y = random(-height(), height()) ;
			z = width() ;
			pz = z ;
		}
		
		if(warpspeed)
			calculateWarpspeed();
		
	}
	
	/**
	 * Calculates the Position of the Star depening on z-coordinate.
	 * And depending on the Travel-Speed, draws a circle or a line.
	 */
	@Override
	public void show() 
	{
		double sx = map(this.x / this.z, -1, 1, 0, width()) ;
		double sy = map(this.y / this.z, -1, 1, 0, height()) ;
		double r =  map(this.z , 0, width(), 8, 0) ;
		
		double px = map(this.x / this.pz, -1, 1, 0, width()) ;
		double py = map(this.y / this.pz, -1, 1, 0, height()) ;
		
		this.pz = this.z ;
		
		if(this.speed <35)
		{
			fill(255);
			point(sx, sy, r);
		} 
		if (this.speed > 25)
		{
			stroke(120) ;
			line(px, py, sx, sy) ;
		}
	}
	
	
	/**
	 * Calculates the warpspeed so that you start slow and
	 * increase your speed to warpspeed and the comeback to normal
	 * speed.
	 */
	private void calculateWarpspeed()
	{
		if(time >= warpTime)
		{
			if(speed < minspeed)
			{
				speed = minspeed ;
			}
			else if(speed > maxspeed)
			{
				speed = maxspeed ;
			}
			
			else if(speed < 15)
			{
				speed -= 0.5 ;
			}
			else 
			{
				speed -= speed * speed * 0.00085;
			}
		}
		else
		{
			if(speed > maxspeed)
			{
				speed = maxspeed ;
				time += 0.1 ;
			}
			// normal speed
			else if(speed < 15)
			{
				speed += 0.05 ;
			}
			else // warp speed
			{
				speed += speed * speed * 0.009;
			}
		}
	}

	
	
	
}
