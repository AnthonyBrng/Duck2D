package geom;

import core.CanvasProperties;

/**
 * Created by anthony on 19.12.2016.
 */
public class Text extends Geometrie
{

    private String text ;
    private char[] text_chars ;
    /**
     * Default-Constructor
     */
    public Text(String text, double x, double y)
    {
        super(x, y, 0, Type.TEXT);
        this.text = text ;
        this.text_chars = this.text.toCharArray() ;
    }

    /**
     * @return The text as String.
     */
    public String getText()
    {
        return this.text ;
    }

    /**
     * @return The text as an array of characters.
     */
    public char[] getChars()
    {
        return this.text_chars ;
    }
}
