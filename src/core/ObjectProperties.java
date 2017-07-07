package core;

import java.awt.*;

/**
 * Calss that defines static object properties which gets reset to its defaults
 * by adding an object to the main canvas.
 *
 * Created by anthony on 31.12.16.
 */
public class ObjectProperties
{
    public static double ROTATION_ANGLE = 0.0 ;
    public static Color FILL_COLOR = null ;
    public static Color STROKE_COLOR = null ;
    public static float STROKE_WEIGHT = 0 ;
    public static Color TEXT_COLOR = null;
    public static Boolean FILL = false ;

    /**
     * Resets alls properties to default.
     * See below for default values.
     */
    static void reset()
    {
        FILL = false;
        FILL_COLOR = null;
        STROKE_COLOR = null;
        TEXT_COLOR = null;
        ROTATION_ANGLE = 0.0 ;
        STROKE_WEIGHT = 0 ;

    }

}
