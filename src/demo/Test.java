package demo;

import core.Environment;
import stdio.Stdio;

public class Test extends Environment
{
	public static void main(String[] args)
	{
		new Test().show();
		
	}

	@Override
	public void settings() 
	{
		size(800, 800);
		background(0);

		

	}

	/**
	 * 
	 */
	@Override
	public void draw() 
	{

		stroke(255);
		circle(200,200, 50);


	}
	
	
}
