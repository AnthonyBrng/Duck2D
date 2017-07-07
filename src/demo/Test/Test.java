package demo.Test;

import core.Environment;
import geom.Vector2D;
import stdio.Stdio;


public class Test extends Environment
{

	Vector2D[] points = {
			new Vector2D(10,-20),
			new Vector2D(40,-50),
			new Vector2D(0,50),
			new Vector2D(100,20),
	} ;

	public static void main(String[] args)
	{
		new Test().show();
	}

	@Override
	public void settings() 
	{
		background(0);
		size(400,400);
		origin(OriginType.CARTESIAN);
	}

	/**
	 * 
	 */
	@Override
	public void draw() 
	{
		strokeAll(255,255,255) ;
		strokeWeight(2);
		polyline(this.points);

		for(Vector2D point : points)
		{
			fill(120,0,10);
			circle(point.x,point.y, 10);
		}


		shuffle();

	}

	private void shuffle()
	{
		for(int i=0; i < this.points.length ; i++)
		{
			Stdio.swap(this.points, i, random(0,this.points.length-1));
		}
	}
	
	
}
