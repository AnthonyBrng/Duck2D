package core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;

import javax.swing.JPanel;

import core.Environment.ShapeOrigin;
import geom.*;

/**
 * 
 * @author anthony
 *
 */
public class Canvas extends JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Geometrie> geos = new ArrayList<>() ;
	
	/**
	 * Default-Contructor
	 */
	public Canvas(){
		super();
		applySettings(); 
	}
	
	/**
	 * Paints all Components in the geos-ArrayList where all
	 * Geometries get drawn. Each Geometrie gets his own 
	 * drawMethod to make individual adjustments.
	 */
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		for(Geometrie geo : geos)
		{
			if(geo instanceof Point)
				drawPoint(g, geo);
			else if(geo instanceof Circle)
				drawCircle(g, geo);
			else if(geo instanceof Line)
				drawLine(g, geo);
			else if(geo instanceof Ellipse)
				drawEllipse(g, geo);
			else if(geo instanceof Text)
				drawText(g, geo);
		}
		
	}
	
	/**
	 * 
	 */
	public void applySettings()
	{
		this.setBounds(CanvasProperties.X, CanvasProperties.Y, CanvasProperties.WIDTH, CanvasProperties.HEIGHT);
		this.setBackground(CanvasProperties.BACKGROUND_COLOR);
		
	}
	
	/**
	 * Adds a Geometrie-Object to the geos-ArrayList
	 * @param geo Geometrie-Object to add.
	 */
	public void add(Geometrie geo)
	{
		geo.setFill(CanvasProperties.FILL);
		geo.setFillColor(CanvasProperties.FILL_COLOR);
		geo.setColor(CanvasProperties.STROKE_COLOR);
		geo.setTextColor(CanvasProperties.TEXT_COLOR);
		geos.add(geo) ;
	}
	
	
	/**
	 * Resets the whole geos-ArrayList
	 */
	public void resetGeos()
	{
		geos = new ArrayList<>();
	}
	
	
	/**********************************
	 * 
	 * Draw-Methoden
	 * 
	 */
	
	
	/**
	 * Draws a Point on the specified Location in the Point-Object.
	 * Color of use : FillColor
	 * @param g Graphics to draw on.
	 * @param geo Geometrie Object
	 */
	private void drawPoint(Graphics g, Geometrie geo)
	{
		Point point;
		
		if(geo instanceof Point)
			point = (Point) geo ;
		else
			throw new WrongMethodTypeException("Wrong Method was called Canvas.drawPoint() for Type " + geo.getType() + "!") ;
		
		g.setColor(point.getFillColor());
		g.fillOval((int)point.x(), (int)point.y(), (int)point.size()*2, (int)point.size()*2);
		
	}
	
	
	/**
	 * Draws a Circle on the specified Location in the Circle-Object.
	 * Color of use: Draw and / or Fill Color
	 * @param g Graphics to draw on.
	 * @param geo Geometrie Object
	 */
	private void drawCircle(Graphics g, Geometrie geo)
	{
		Circle circle;
		
		/*
		 * Error-Handling
		 */
		if(geo instanceof Circle)
			circle = (Circle) geo ;
		else
			throw new WrongMethodTypeException("Wrong Method was called Canvas.drawCircle() for Type " + geo.getType() + "!") ;
		
		/*
		 * Calculates the x and y coordinates
		 * depending on the choosen shape-origin
		 */
		Dimension pos = getCenteredPos((int)circle.x(), (int)circle.y(), (int)circle.radius()*2, (int)circle.radius()*2) ;
		
		
		/*
		 * Drawing
		 */
		if(circle.isFill())
		{
			g.setColor(geo.getFillColor());
			g.fillOval(pos.width, pos.height, (int)circle.radius()*2, (int)circle.radius()*2);
		}
		else
		{
			g.setColor(circle.getColor());
			g.drawOval(pos.width, pos.height, (int)circle.radius()*2, (int)circle.radius()*2);
		}
		
	}
	
	
	/**
	 * Draws an ellipse on the specified Location in the Ellipse-Object.
	 * Color of use: Draw and / or Fill Color
	 * @param g Graphics to draw on.
	 * @param geo Geometrie Object
	 */
	private void drawEllipse(Graphics g, Geometrie geo)
	{
		Ellipse ellipse;
		
		/*
		 * Error-Handling
		 */
		if(geo instanceof Ellipse)
			ellipse = (Ellipse) geo ;
		else
			throw new WrongMethodTypeException("Wrong Method was called Canvas.drawEllipse() for Type " + geo.getType() + "!") ;
		
		/*
		 * Calculates the x and y coordinates
		 * depending on the choosen shape-origin
		 */
		Dimension pos = getCenteredPos((int)ellipse.x(), (int)ellipse.y(), (int)ellipse.getWidth(), (int)ellipse.getHeight()) ;
		
		
		/*
		 * Drawing
		 */
		if(ellipse.isFill())
		{
			g.setColor(geo.getFillColor());
			g.fillOval(pos.width, pos.height, (int)ellipse.getWidth(), (int)ellipse.getHeight());
		}
		else
		{
			g.setColor(ellipse.getColor());
			g.drawOval(pos.width, pos.height, (int)ellipse.getWidth(), (int)ellipse.getHeight());
		}
		
	}
	
	
	/**
	 * Draws a Line on the specified Location in the Line-Object.
	 * Color of use: Drawcolor
	 * @param g Graphics to draw on.
	 * @param geo Geometrie Object
	 */
	private void drawLine(Graphics g, Geometrie geo)
	{
		Line line;
		
		/*
		 * Error-Handling
		 */
		if(geo instanceof Line)
			line = (Line) geo ;
		else
			throw new WrongMethodTypeException("Wrong Method was called Canvas.drawLine() for Type " + geo.getType() + "!") ;
		
		g.setColor(CanvasProperties.STROKE_COLOR);
		g.drawLine((int)line.x(), (int)line.y(), (int)line.x_dest(), (int)line.y_dest());
	}


	/**
	 *
	 * @param g
	 * @param geo
	 */
	private void drawText(Graphics g, Geometrie geo)
	{
		Text text;

		/*
		 * Error-Handling
		 */
		if(geo instanceof Text)
			text = (Text) geo ;
		else
			throw new WrongMethodTypeException("Wrong Method was called Canvas.drawText() for Type " + geo.getType() + "!") ;

		g.setColor(text.getTextColor());
		g.drawChars(text.getChars(),0, text.getChars ().length, (int)text.x(), (int)text.y());
	}




	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @return
	 */
	private Dimension getCenteredPos(int x, int y, int width, int height)
	{
		Dimension result = new Dimension(x, y) ; 
		
		if(CanvasProperties.SHAPE_ORIGIN == ShapeOrigin.TOP_LEFT)
			return result ;
		else if (CanvasProperties.SHAPE_ORIGIN == ShapeOrigin.CENTER)
			return new Dimension(x-width/2, y-height/2) ; 


		return result ;
		
	}
	
	
	
	
}
