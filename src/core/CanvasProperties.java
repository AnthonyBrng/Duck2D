package core;

import java.awt.Color;

import core.Environment.ShapeOrigin;

/**
 *
 * @author anthony
 *
 */
public class CanvasProperties
{
	static int WIDTH = 150 ;
	static int HEIGHT = 150 ;
	static int X = 0 ;
	static int Y = 0 ; 
	static ShapeOrigin SHAPE_ORIGIN = ShapeOrigin.CENTER ;
	static Color BACKGROUND_COLOR = Color.WHITE;

	/*
	 * This properties are for all shapes, if no
	 * specific object propertie is set
	 */
	public static Boolean FILL = false ;
	public static Color FILL_COLOR = new Color(70,70,70) ;
	public static Color STROKE_COLOR = new Color(70,70,70) ;
	public static float STROKE_WEIGHT = 1 ;
	public static Color TEXT_COLOR = Color.BLACK ;

	/**
	 * Resets stroke-, fillcolor and the fill property
	 * to its defaults.
	 */
	static void reset() {
		FILL = false;
		FILL_COLOR = new Color(70, 70, 70);
		STROKE_COLOR = new Color(70, 70, 70);
		TEXT_COLOR = Color.BLACK;
		STROKE_WEIGHT = 1 ;
	}
	
}
