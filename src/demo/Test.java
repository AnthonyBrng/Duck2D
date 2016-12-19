package demo;

import core.Environment;

public class Test extends Environment
{
	
	Auge auge1 ;
	Auge auge2 ;
	
	public static void main(String[] args)
	{
		new Test().show();
		
	}

	@Override
	public void settings() 
	{
		size(800, 800);	
		origin(width()/2, height()/2);
		
		auge1 = new Auge(this, -180, -80) ;
		auge2 = new Auge(this, 180, -80) ;
		
	}

	/**
	 * 
	 */
	@Override
	public void draw() 
	{
		auge1.show();
		auge2.show();
		
		auge1.update();
		auge2.update();
	}
	
	
}
