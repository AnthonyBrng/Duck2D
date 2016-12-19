package demo;

import core.Environment;

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
		textColor(200,0,0);
		text("Hello World", 50, 50);

		textColor(0, 200, 0);
		text("Hello World", 0, 0);

	}
	
	
}
