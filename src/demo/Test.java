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
		origin(width()/2, height()/2);
		

	}

	/**
	 * 
	 */
	@Override
	public void draw() 
	{
		Stdio.print(Stdio.randomDbl(1,2));

	}
	
	
}
