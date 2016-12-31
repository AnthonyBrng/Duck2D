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

		strokeAll(255);
		rotate(45) ;
		rect(200,200, 50,300);


		rect(400,200, 50,300);

		rotate(45);
		ellipse(200,30,300,10);




	}
	
	
}
