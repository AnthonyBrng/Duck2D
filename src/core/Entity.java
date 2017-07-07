package core;

import geom.Vector2D;

import java.util.List;

/**
 * Objects that extend this class are able to call Environment methods, like drawing
 * shapes and stuff like that.
 */
public abstract class Entity
{
    protected Environment env;

    /**
     * Constructor
     *
     * @param env The environment where this entity lives in.
     */
    public Entity(Environment env)
    {
        this.env = env;
    }

    /**
     * Sets the background-color for the canvas
     *
     * @param c one colorvalue for red and green and blue
     */
    public void background(int c)
    {
        this.env.background(c);
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
        this.env.background(r, g, b);
    }

    /**
     * Sets the flag indicating an object to fill to true.
     */
    public void fill()
    {
        this.env.fill();
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
        this.env.fill(c);
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
        this.env.fill(r,g,b);
    }

    /**
     * Deactivates the filling of the next shape.
     */
    public void noFill()
    {
        this.env.noFill();
    }


    /**
     * Sets the flag indicating an object to fill to true.
     */
    public void fillAll()
    {
        this.env.fillAll();
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
        this.env.fillAll(c);
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
        this.env.fillAll(r,g,b);
    }

    /**
     * Deactivates the filling of shapes.
     */
    public void noFillAll()
    {
        this.env.noFillAll();
    }

    /**
     * Sets the drawing/line color of shapes.
     *
     * @param c colorvalue for red and green and blue
     */
    public void stroke(int c)
    {
        this.env.stroke(c);
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
        this.env.stroke(r,g,b);
    }

    /**
     * Sets the drawing/line color of all following shapes.
     *
     * @param c colorvalue for red and green and blue
     */
    public void strokeAll(int c)
    {
        this.env.strokeAll(c);
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
        this.env.strokeAll(r,g,b);
    }


    /**
     * Sets the weight of the next stroke.
     *
     * @param weight new stroke weight value.
     */
    public void strokeWeight(float weight)
    {
        this.env.strokeWeight(weight);
    }

    /**
     * Sets the weight of all following strokes.
     *
     * @param weight new stroke weight value.
     */
    public void strokeWeightAll(float weight)
    {
        this.env.strokeWeightAll(weight);
    }


    /**
     * Sets the text color of the next text obeject.
     *
     * @param c
     */
    public void textColor(int c)
    {
        this.env.textColor(c);
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
        this.env.textColor(r,g,b);
    }


    /**
     * Sets the text color of all text obeject.
     *
     * @param c
     */
    public void textColorAll(int c)
    {
        this.env.textColorAll(c);
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
        this.env.textColorAll(r,g,b);
    }


    /**
     * Rotates the next shape by an angle in degrees.
     */
    public void rotate(double angle)
    {
       this.env.rotate(angle);
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
        this.env.origin(w, h);
    }


    /**
     * @return the width of the canvas.
     */
    public int width()
    {
        return this.env.width();
    }

    /**
     * @return the height of the canvas
     */
    public int height()
    {
        return this.env.height();
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
        return this.env.map(value, lower_src, upper_src, lower_dest, upper_dest);
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
        return this.env.random(lower_bound, upper_bound);
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
        this.env.point(x, y);
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
        this.env.point(x, y, size);
    }


    /**
     * Draws a circle with radius 5 on the underlying canvas.
     *
     * @param x X-Location of the point (depends on origin-offset)
     * @param y Y-Location of the point (depends on origin-offset)
     */
    public void circle(double x, double y)
    {
        this.env.circle(x, y);
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
        this.env.circle(x, y, diameter);
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
        this.env.ellipse(x, y, size);
    }

    /**
     * Draws an ellipse on the underlying canvas..
     *
     * @param x      X-Location of the point (depends on origin-offset)
     * @param y      Y-Location of the point (depends on origin-offset)
     * @param width  width of the surrounding rectangle.
     * @param height height of the surrounding rectangle.
     *               TODO widht an height doc
     */
    public void ellipse(double x, double y, double width, double height)
    {
        this.env.ellipse(x, y, width, height);
    }

    /**
     * @param x      X-Location of the point (depends on origin-offset)
     * @param y      Y-Location of the point (depends on origin-offset)
     * @param x_dest Destination X-Location of the point (depends on origin-offset)
     * @param y_dest Destination Y-Location of the point (depends on origin-offset)
     */
    public void line(double x, double y, double x_dest, double y_dest)
    {
        this.env.line(x, y, x_dest, y_dest);
    }

    /**
     * Draws a polyline through all points in the given point array.
     *
     * @param points    List of Vector2D objects, containing point location for the polyline.
     */
    public void polyline(Vector2D[] points)
    {
        this.env.polyline(points);
    }

    /**
     * Draws a polyline through all points in the given point list.
     *
     * @param points    List of Vector2D objects, containing point location for the polyline.
     */
    public void polyline(List<Vector2D> points)
    {
        this.env.polyline(points);
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
        this.env.text(text, x, y);
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
        this.env.text(obj.toString(), x, y);
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
        this.env.rect(x, y, width, height);
    }

    /**
     *
     */
    public abstract void show();

    /**
     *
     */
    public abstract void update();

}
