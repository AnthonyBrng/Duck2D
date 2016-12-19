package core;

import java.awt.Color;

import core.Environment.ShapeOrigin;

/**
 * Package-private
 * @author anthony
 *
 */
class CanvasProperties 
{
	static int WIDTH = 150 ;
	static int HEIGHT = 150 ;
	static int X = 0 ;
	static int Y = 0 ; 
	static boolean FILL = false ;
	static Color FILL_COLOR = new Color(70,70,70) ;
	static Color STROKE_COLOR = new Color(70,70,70) ;
	static Color BACKGROUND_COLOR = Color.WHITE;
	static ShapeOrigin SHAPE_ORIGIN = ShapeOrigin.CENTER ;
	
	/**
	 * Resets stroke-, fillcolor and the fill property
	 * to its defaults.
	 */
	static void resetColors()
	{
		boolean FILL = false ;
		Color FILL_COLOR = new Color(70,70,70) ;
		Color STROKE_COLOR = new Color(70,70,70) ;
	}
	
}
