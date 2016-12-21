package geom;

/**
 * Created by anthony on 20.12.2016.
 */
public class Rectangle extends Geometrie
{

    private double width;
    private double height;

    /**
     * Creates an UNDEFINED Geometrie with z=0 ;
     *
     * @param x X-Location
     * @param y Y-Location
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    public Rectangle(double x, double y, double width, double height)
    {
        super(x, y, 0);
        this.width = width;
        this.height = height;
        this.geotype = Type.RECTANGLE;
    }

    /**
     * @return
     */
    public double width()
    {
        return this.width;
    }

    /**
     * @return
     */
    public double height()
    {
        return this.height;
    }


}
