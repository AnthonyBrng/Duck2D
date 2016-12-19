package core;

import java.awt.Color;
import java.awt.Dimension;

import geom.*;
import stdio.Stdio;

/**
 * 
 * @author anthony
 *
 */
public abstract class Environment 
{
	private static int FPS = 100 ;
	private static Dimension ORIGIN = new Dimension(0,0) ;
	
	static enum ShapeOrigin
	{
		CENTER,
		TOP_LEFT
	}
	
	private Window window ;
	private Canvas canvas ;
	
	/**
	 * Contructor.
	 * Creating the frame without showing it.
	 */
	public Environment()
	{
		createFrame();
	}
		
	
	/**
	 * Calls all methods needed to 
	 * show the Window, the canvas and all other
	 * components.
	 */
	public void show()
	{
		settings_internal();
		
		this.window.setVisible(true);
		
		draw_internal();
	}
	
	
	/**
	 * Default-settings for creating the Window
	 * and the underlying canvas.
	 * Window-default-settings:
	 * Size : 150+16, 150+39 
	 * Close-Operation : Exit
	 * Resizeable : false 
	 * Layout: absolute positioning
	 * 
	 * Canvas-default-settings:
	 * Size : equal to Windowsize
	 * Positioning : (0,0)
	 * Background-color : Color.White 
	 */
	private void createFrame()
	{
		window = new Window() ;
		canvas = new Canvas() ;
		window.add(canvas) ;				
	}
	
	
	/**
	 * Calling the user defined and implemented settings-method.
	 * And creates spaces for internals setttings.
	 * Gets called before draw_internal().
	 */
	private void settings_internal()
	{
		settings(); 
	}
	
	/**
	 * Handles the FPS loop and is calling the user defined and 
	 * implemented draw().
	 * Simply calls the paint method from the main canvas
	 * then wait the amount of time to fit the fps
	 * and clear the drawn Shapes and forms and repeat.
	 */
	private void draw_internal()
	{
		boolean running = true ;
		while(running)
		{
			draw();
			this.canvas.repaint();
			
			waitingPeriod();
			this.canvas.resetGeos();
			CanvasProperties.resetColors();
		}
		
	}
	
	/**
	 * Just sourced the Thread.Sleep out to get rid of the
	 * Exceptionhandling inside the draw_internal() 
	 */
	private void waitingPeriod()
	{
		try 
		{
			Thread.sleep(1000/FPS);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	/***************************
	 * User-Call-Section 
	 */
	
	/****************
	 * Config
	 */
	
	/**
	 * Sets the Size of the CANVAS and enlarges the window
	 * if the canvas doesnt fit into the display of the window.
	 */
	public void size(int width, int height)
	{
		if(WindowProperties.WIDTH < width || WindowProperties.HEIGHT < height)
		{
			WindowProperties.WIDTH = width ;
			WindowProperties.HEIGHT = height ;
			this.window.applySettings(); 
		}
		
		CanvasProperties.WIDTH = width ;
		CanvasProperties.HEIGHT = height ;
		this.canvas.applySettings(); 
	}
	
	/**
	 * Sets the background-color for the canvas
	 * @param c one colorvalue for red and green and blue
	 */
	public void background(int c)
	{
		background(c,c,c);
	}
	
	/**
	 * Sets the background-color for the canvas
	 * @param r Red value between 0 and 255.
	 * @param g Green value between 0 and 255.
	 * @param b Blue value between 0 and 255.
	 */
	public void background(int r, int g, int b)
	{
		CanvasProperties.BACKGROUND_COLOR= new Color(r, g, b) ;
		this.canvas.applySettings();
	}
	
	
	public void fill()
	{
		Color c = CanvasProperties.STROKE_COLOR ;
		this.fill(c.getRed(),c.getGreen(),c.getBlue());
	}
	
	/**
	 * Sets the fill-color for drawing shapes that should be filled
	 * with a color.By calling this method every shape gets filled
	 * (if possible) until noFill() is called.
	 * @param c one colorvalue for red and green and blue
	 */
	public void fill(int c)
	{
		this.fill(c,c,c);
	}
	
	/**
	 * Sets the fill-color for drawing shapes that should be filled
	 * with a color. By calling this method every shape gets filled
	 * (if possible) until noFill() is called.
	 * @param r Red value between 0 and 255.
	 * @param g Green value between 0 and 255.
	 * @param b Blue value between 0 and 255.
	 */
	public void fill(int r, int g, int b)
	{
		CanvasProperties.FILL_COLOR = new Color(r, g, b) ;
		CanvasProperties.FILL = true ;
	}
	
	/**
	 * Deactivates the filling of shapes.
	 */
	public void noFill()
	{
		CanvasProperties.FILL = false ;
	}
	
	/**
	 * Sets the drawing/line color of shapes.
	 * @param c colorvalue for red and green and blue
	 */
	public void stroke(int c)
	{
		this.stroke(c,c,c);
	}
	
	/**
	 * Sets the drawing/line color of shapes.
	 * @param r Red value between 0 and 255.
	 * @param g Green value between 0 and 255.
	 * @param b Blue value between 0 and 255.
	 */
	public void stroke(int r, int g, int b)
	{
		CanvasProperties.STROKE_COLOR = new Color(r, g, b) ;
	}

	/**
	 *
	 * @param c
	 */
	public void textColor(int c)
	{
		this.textColor(c,c,c);
	}


	/**
	 * Sets the text color of Text objects.
	 * @param r Red value between 0 and 255.
	 * @param g Green value between 0 and 255.
	 * @param b Blue value between 0 and 255.
	 */
	public void textColor(int r, int g, int b)
	{
		CanvasProperties.TEXT_COLOR = new Color(r,g,b) ;
	}
	
	
	
	/**
	 * Translated the origin of the underlying coordinate system to a new
	 * origin. (for drawing shapes)
	 * @param w width offset.
	 * @param h height offset.
	 */
	public void origin(int w, int h)
	{
		ORIGIN = new Dimension(w, h) ;
	}
	
	
	/**
	 * 
	 * @param origin
	 */
	public void shapeOrigin(ShapeOrigin origin)
	{
		switch (origin) {
		case CENTER:
			CanvasProperties.SHAPE_ORIGIN = ShapeOrigin.CENTER ;
			break;
		case TOP_LEFT:
			CanvasProperties.SHAPE_ORIGIN = ShapeOrigin.TOP_LEFT ;
			break;
		default:
			System.out.println("Shapeorigin is unknown");
			break;
		}
	}
	
	/**
	 * @return the width of the canvas.
	 */
	public int width()
	{
		return CanvasProperties.WIDTH ;
	}
	
	/**
	 * @return the height of the canvas
	 */
	public int height()
	{
		return CanvasProperties.HEIGHT ;
	}
	
	
	/****************
	 * STDIO
	 */
	
	/**
	 * Maps a value in a specific range to another range.
	 * For example the value 50 in the range from 0 to 100
	 * gets relativly maped to the range from -20 to 20, so the result
	 * would be 0. Or in other words. The two diffrent ranges get mapped and
	 * the inputvalue defines the äquivalent value in the other range.
	 * @param value	input-value which getting maped.
	 * @param lower_src lower bound of the source range
	 * @param upper_src upper bound of the source range
	 * @param lower_dest lower bound of the destiny range
	 * @param upper_dest upper bound of the destiny range
	 * @return the maped value.
	 */
	public double map(double value, double lower_src, double upper_src, double lower_dest, double upper_dest )
	{
		return Stdio.map(value, lower_src, upper_src, lower_dest, upper_dest) ;
	}
	
	/**
	 * Generates a random number in a specific range.
	 * @param lower_bound lowest possible number
	 * @param upper_bound highest possible number
	 * @return genereted random number.
	 */
	public int random(int lower_bound, int upper_bound)
	{
		return Stdio.random(lower_bound, upper_bound);
	}
	
	
	/****************
	 * Shapes 
	 */
	
	
	/**
	 * Draws a point with size 1 on the underlying canvas.
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 */
	public void point(double x, double y)
	{
		point(x,y,1);
	}
	
	
	/**
	 * Draws a Point on the underlying canvas.
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 * @param size Size of the dot.
	 */
	public void point(double x, double y, double size)
	{	
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;
		this.canvas.add(new Point(x, y, size));
	}
	
	
	/**
	 * Draws a circle with radius 5 on the underlying canvas.
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 */
	public void circle(double x, double y)
	{
		circle(x, y, 5);
	}
	
	/**
	 * Draws a Circle on the underlying canvas..
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 * @param radius radius of the Circle.
	 */
	public void circle(double x, double y, int radius)
	{
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;
		this.canvas.add(new Circle(x, y, radius)) ;
	}
	
	
	/**
	 * Draws an ellipse on the underlying canvas..
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 * @param size width and height of the surrounding rectangle.
	 */
	public void ellipse(double x, double y, double size)
	{
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;
		this.canvas.add(new Ellipse(x, y, size, size)) ;
	}
	
	/**
	 * Draws an ellipse on the underlying canvas..
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 * @param width width of the surrounding rectangle.
	 * @param height height of the surrounding rectangle.
	 * TODO widht and height doc
	 */
	public void ellipse(double x, double y, double width, double height)
	{
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;
		this.canvas.add(new Ellipse(x, y, width, height)) ;
	}
	
	/**
	 * Draws a line
	 * @param x X-Location of the point (depends on origin-offset)
	 * @param y Y-Location of the point (depends on origin-offset)
	 * @param x_dest Destination X-Location of the point (depends on origin-offset)
	 * @param y_dest Destination Y-Location of the point (depends on origin-offset)
	 */
	public void line(double x, double y, double x_dest, double y_dest)
	{
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;
		x_dest = x_dest + ORIGIN.getWidth() ;
		y_dest = y_dest + ORIGIN.getHeight() ;
		
		this.canvas.add(new Line(x, y, x_dest, y_dest)) ;
	}

	/**
	 * Draws a String on the canvas
	 * @param text String to be drawn.
	 * @param x X-Location of the text-baseline.
	 * @param y Y-Location of the text-baseline.
	 */
	public void text(String text, double x, double y)
	{
		x = x + ORIGIN.getWidth() ;
		y = y + ORIGIN.getHeight() ;

		this.canvas.add(new Text(text, x, y));
	}
	
	
	/***************************
	 * Abstract-Section 
	 */
	
	
	/**
	 * This Method is used to apply core-settings to the window or canvas. 
	 */
	public abstract void settings();
	
	
	/**
	 * This method is called frequently and is used to draw things on the canvas.
	 */
	public abstract void draw();
	
}
