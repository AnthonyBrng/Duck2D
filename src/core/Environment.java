package core;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import geom.Vector2D;

import geom.*;
import stdio.Stdio;

/**
 * @author anthony
 */
public abstract class Environment
{
    private static int FPS = 60;
    private static Dimension ORIGIN = new Dimension(0, 0);

    public enum ShapeOrigin
    {
        CENTER,
        TOP_LEFT
    }

    public enum OriginType
    {
        STANDARD,
        CARTESIAN // @TODO muss noch angepasst werden. Aktuell ist (1/2) = (1/-2)
    }

    private Window window;
    private Canvas canvas;

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
     * <p>
     * Canvas-default-settings:
     * Size : equal to Windowsize
     * Positioning : (0,0)
     * Background-color : Color.White
     */
    private void createFrame()
    {
        window = new Window();
        canvas = new Canvas();
        window.add(canvas);
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
        boolean running = true;
        while(running)
        {
            draw();
            this.canvas.repaint();

            waitingPeriod();
            this.canvas.resetGeos();
            CanvasProperties.reset();
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
            Thread.sleep(1000 / FPS);
        }
        catch(InterruptedException e)
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
            WindowProperties.WIDTH = width;
            WindowProperties.HEIGHT = height;
            this.window.applySettings();
        }

        CanvasProperties.WIDTH = width;
        CanvasProperties.HEIGHT = height;
        this.canvas.applySettings();
    }

    /**
     * Sets the background-color for the canvas
     *
     * @param c one colorvalue for red and green and blue
     */
    public void background(int c)
    {
        background(c, c, c);
    }

    /**
     * Sets the background-color for the canvas
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void background(int r, int g, int b)
    {
        CanvasProperties.BACKGROUND_COLOR = new Color(r, g, b);
        this.canvas.applySettings();
    }


    /**
     * Sets the flag indicating an object to fill to true.
     */
    public void fill()
    {
        ObjectProperties.FILL = true ;
    }

    /**
     * Sets the fill-color for the next drawing shape that should be filled
     * with a color. By calling this method the next shape gets filled
     * (if possible).
     *
     * @param c one colorvalue for red and green and blue
     */
    public void fill(int c)
    {
        this.fill(c, c, c);
    }

    /**
     * Sets the fill-color for the next drawing shape that should be filled
     * with a color. By calling this method the next shape gets filled
     * (if possible).
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void fill(int r, int g, int b)
    {
        ObjectProperties.FILL_COLOR = new Color(r, g, b);
        ObjectProperties.FILL = true;
    }

    /**
     * Deactivates the filling of the next shape.
     */
    public void noFill()
    {
        ObjectProperties.FILL = false;
    }


    /**
     * Sets the flag indicating an object to fill to true.
     */
    public void fillAll()
    {
        CanvasProperties.FILL = true ;
    }

    /**
     * Sets the fill-color for drawing shapes that should be filled
     * with a color.By calling this method every shape gets filled
     * (if possible) until noFill() is called.
     *
     * @param c one colorvalue for red and green and blue
     */
    public void fillAll(int c)
    {
        this.fillAll(c, c, c);
    }

    /**
     * Sets the fill-color for drawing shapes that should be filled
     * with a color. By calling this method every shape gets filled
     * (if possible) until noFill() is called.
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void fillAll(int r, int g, int b)
    {
        CanvasProperties.FILL_COLOR = new Color(r, g, b);
        CanvasProperties.FILL = true;
    }

    /**
     * Deactivates the filling of shapes.
     */
    public void noFillAll()
    {
        CanvasProperties.FILL = false;
    }

    /**
     * Sets the drawing/line color of shapes.
     *
     * @param c colorvalue for red and green and blue
     */
    public void stroke(int c)
    {
        this.stroke(c, c, c);
    }

    /**
     * Sets the drawing/line color of the next shapes.
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void stroke(int r, int g, int b)
    {
        ObjectProperties.STROKE_COLOR = new Color(r, g, b);
    }

    /**
     * Sets the drawing/line color of all following shapes.
     *
     * @param c colorvalue for red and green and blue
     */
    public void strokeAll(int c)
    {
        this.strokeAll(c, c, c);
    }

    /**
     * Sets the drawing/line color of all following shapes.
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void strokeAll(int r, int g, int b)
    {
        CanvasProperties.STROKE_COLOR = new Color(r, g, b);
    }

    /**
     * Sets the weight of the next stroke.
     *
     * @param weight new stroke weight value.
     */
    public void strokeWeight(float weight)
    {
        ObjectProperties.STROKE_WEIGHT = weight ;
    }

    /**
     * Sets the weight of all following strokes.
     *
     * @param weight new stroke weight value.
     */
    public void strokeWeightAll(float weight)
    {
        CanvasProperties.STROKE_WEIGHT = weight ;
    }

    /**
     * Sets the text color of the next text obeject.
     *
     * @param c
     */
    public void textColor(int c)
    {
        this.textColor(c, c, c);
    }


    /**
     * Sets the text color of the next text obeject.
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void textColor(int r, int g, int b)
    {
        ObjectProperties.TEXT_COLOR = new Color(r, g, b);
    }


    /**
     * Sets the text color of all text obeject.
     *
     * @param c
     */
    public void textColorAll(int c)
    {
        this.textColorAll(c, c, c);
    }


    /**
     * Sets the text color of all text obeject.
     *
     * @param r Red value between 0 and 255.
     * @param g Green value between 0 and 255.
     * @param b Blue value between 0 and 255.
     */
    public void textColorAll(int r, int g, int b)
    {
        CanvasProperties.TEXT_COLOR = new Color(r, g, b);
    }


    /**
     * Rotates the next shape by an angle in degrees.
     */
    public void rotate(double angle)
    {
        ObjectProperties.ROTATION_ANGLE = angle ;
    }


    /**
     * Translated the origin of the underlying coordinate system to a new
     * origin. (for drawing shapes)
     *
     * @param w width offset.
     * @param h height offset.
     */
    public void origin(int w, int h)
    {
        ORIGIN = new Dimension(w, h);
    }

    /**
     * Translates the origin so that the canvas behaves like
     * a cartesian coordinate system.
     *
     * @param origin Origintype.
     */
    public void origin(OriginType origin)
    {
        switch (origin) {
            case STANDARD:
                this.origin(0,0);
                break;
            case CARTESIAN:
                this.origin(CanvasProperties.WIDTH/2, CanvasProperties.HEIGHT/2);
                break;
            default:
                    System.out.println("OriginType is unknown");
        }

    }

    /**
     * @param origin
     */
    public void shapeOrigin(ShapeOrigin origin)
    {
        switch(origin)
        {
            case CENTER:
                CanvasProperties.SHAPE_ORIGIN = ShapeOrigin.CENTER;
                break;
            case TOP_LEFT:
                CanvasProperties.SHAPE_ORIGIN = ShapeOrigin.TOP_LEFT;
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
        return CanvasProperties.WIDTH;
    }

    /**
     * @return the height of the canvas
     */
    public int height()
    {
        return CanvasProperties.HEIGHT;
    }


    /****************
     * STDIO imported functions
     */

    /**
     * Maps a value in a specific range to another range.
     * For example the value 50 in the range from 0 to 100
     * gets relativly maped to the range from -20 to 20, so the result
     * would be 0. Or in other words. The two diffrent ranges get mapped and
     * the inputvalue defines the equivalent value in the other range.
     *
     * @param value      input-value which getting maped.
     * @param lower_src  lower bound of the source range
     * @param upper_src  upper bound of the source range
     * @param lower_dest lower bound of the destiny range
     * @param upper_dest upper bound of the destiny range
     * @return the maped value.
     */
    public double map(double value, double lower_src, double upper_src, double lower_dest, double upper_dest)
    {
        return Stdio.map(value, lower_src, upper_src, lower_dest, upper_dest);
    }

    /**
     * Generates a randomInt number in a specific range.
     *
     * @param lower_bound lowest possible number
     * @param upper_bound highest possible number
     * @return genereted randomInt number.
     */
    public int random(int lower_bound, int upper_bound)
    {
        return Stdio.randomInt(lower_bound, upper_bound);
    }


    /****************
     * Shapes
     */


    /**
     * Draws a point with size 1 on the underlying canvas.
     *
     * @param x X-Location of the point (depends on origin-offset)
     * @param y Y-Location of the point (depends on origin-offset)
     */
    public void point(double x, double y)
    {
        point(x, y, 1);
    }


    /**
     * Draws a Point on the underlying canvas.
     *
     * @param x    X-Location of the point (depends on origin-offset)
     * @param y    Y-Location of the point (depends on origin-offset)
     * @param size Size of the dot.
     */
    public void point(double x, double y, double size)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();
        this.canvas.add(new Point(x, y, size));
    }


    /**
     * Draws a circle with radius 5 on the underlying canvas.
     *
     * @param x X-Location of the point (depends on origin-offset)
     * @param y Y-Location of the point (depends on origin-offset)
     */
    public void circle(double x, double y)
    {
        circle(x, y, 5);
    }

    /**
     * Draws a Circle on the underlying canvas..
     *
     * @param x      X-Location of the point (depends on origin-offset)
     * @param y      Y-Location of the point (depends on origin-offset)
     * @param diameter diameter of the Circle.
     */
    public void circle(double x, double y, int diameter)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();
        this.canvas.add(new Circle(x, y, diameter));
    }


    /**
     * Draws an ellipse on the underlying canvas..
     *
     * @param x    X-Location of the point (depends on origin-offset)
     * @param y    Y-Location of the point (depends on origin-offset)
     * @param size width and height of the surrounding rectangle.
     */
    public void ellipse(double x, double y, double size)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();
        this.canvas.add(new Ellipse(x, y, size, size));
    }

    /**
     * Draws an ellipse on the underlying canvas..
     *
     * @param x      X-Location of the point (depends on origin-offset)
     * @param y      Y-Location of the point (depends on origin-offset)
     * @param width  width of the surrounding rectangle.
     * @param height height of the surrounding rectangle.
     */
    public void ellipse(double x, double y, double width, double height)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();
        this.canvas.add(new Ellipse(x, y, width, height));
    }

    /**
     * Draws a line
     *
     * @param x      X-Location of the point (depends on origin-offset)
     * @param y      Y-Location of the point (depends on origin-offset)
     * @param x_dest Destination X-Location of the point (depends on origin-offset)
     * @param y_dest Destination Y-Location of the point (depends on origin-offset)
     */
    public void line(double x, double y, double x_dest, double y_dest)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();
        x_dest = x_dest + ORIGIN.getWidth();
        y_dest = y_dest + ORIGIN.getHeight();

        this.canvas.add(new Line(x, y, x_dest, y_dest));
    }

    /**
     * Draws a String on the canvas
     *
     * @param obj String of an object to be drawn.
     * @param x   X-Location of the text-baseline.
     * @param y   Y-Location of the text-baseline.
     */
    public void text(Object obj, double x, double y)
    {
        this.text(obj.toString(), x, y);
    }

    /**
     * Draws a String on the canvas
     *
     * @param text String to be drawn.
     * @param x    X-Location of the text-baseline.
     * @param y    Y-Location of the text-baseline.
     */
    public void text(String text, double x, double y)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();

        this.canvas.add(new Text(text, x, y));
    }


    /**
     * Draws a rectangle on the underlying canvas.
     *
     * @param x      X-Location of the text-baseline.
     * @param y      Y-Location of the text-baseline.
     * @param width  Width of the rectangle.
     * @param height Height of the rectangle.
     */
    public void rect(double x, double y, double width, double height)
    {
        x = x + ORIGIN.getWidth();
        y = y + ORIGIN.getHeight();

        this.canvas.add(new Rectangle(x, y, width, height));
    }

    /**
     * Draws a polyline through all points in the given point array.
     *
     * @param points    List of Vector2D objects, containing point location for the polyline.
     * @TODO inefficient as fuck
     */
    public void polyline(Vector2D[] points)
    {
        Vector2D[] transPoints = new Vector2D[points.length] ;

        for(int i=0 ; i<points.length; i++)
        {
            transPoints[i] = new Vector2D(points[i].x+ORIGIN.getWidth(), points[i].y+ORIGIN.getHeight()) ;
        }
        this.canvas.add(new Polyline<Vector2D>(transPoints));
    }

    /**
     * Draws a polyline through all points in the given point list.
     *
     * @param points    List of Vector2D objects, containing point location for the polyline.
     */
    public void polyline(List<Vector2D> points)
    {
        polyline(((Vector2D[])points.toArray()));
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
