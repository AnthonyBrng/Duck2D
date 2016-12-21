package geom;

import stdio.Stdio;

/**
 * Simple 2D Vector-Object.
 * Containing two numbers X and Y.
 * Created by anthony on 20.12.2016.
 */
public class Vector2D
{
    public double x ;
    public double y ;

    /**
     * Constructor.
     * Creates a random vector with values between -1 and 1
     */
    public Vector2D()
    {
        this(0, 0) ;
    }

    /**
     * Constructor sets x and y accordingly.
     * @param x X-Value of the Vector
     * @param y Y-Value of the Vector
     */
    public Vector2D(double x, double y)
    {
        this.x = x ;
        this.y = y ;
    }

    /**
     * Calculates the length of the vector using
     * root(x^2 + y^2)
     * @return Length of the Vector.
     */
    public double length()
    {
        double result ;
        result = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y, 2)) ;
        return result ;
    }


    /**
     * Adds a Vector2D object by adding their x and y values.
     * @param vec Vector to add
     */
    public void add(Vector2D vec)
    {
        this.x += vec.x ;
        this.y += vec.y ;
    }


    /**
     * Subtracts a Vector2D object by subtracting their x and y values.
     * @param vec Vector to subtract.
     */
    public void sub(Vector2D vec)
    {
        vec.mult(-1) ;
        this.add(vec) ;
    }

    /**
     * Multiplies a number to a Vector by multiplying
     * their x and y values by this number.
     * @param number Multiplier
     */
    public void mult(double number)
    {
        this.x *= number ;
        this.y *= number ;
    }

    public double dist(Vector2D vec)
    {
        double result ;
        Vector2D diff = new Vector2D(Math.abs(vec.x - this.x), Math.abs(vec.y - this.y));
        result = diff.length() ;
        return result ;
    }


    /**
     * @return Creates a random Vector
     */
    public static Vector2D random()
    {
        return new Vector2D(Stdio.randomDbl(-1,1), Stdio.randomDbl(-1,1)) ;
    }

    /**
     * String representation is (x/y)
     * @return X and Y value of the Vector as String.
     */
    public String toString()
    {
        return String.format("(%f/%f)",this.x, this.y) ;
    }
}
