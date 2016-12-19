package core;

import javax.swing.JFrame;

/**
 * Eigenes JFrame Objekt.
 * Bis jetzt noch keine Funktionalität geaddet.
 * 
 * @author anthony
 *
 */
public class Window extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default-Contructor without title 
	 */
	public Window()
	{
		this("") ;
	}
	
	/**
	 * Construcot with title
	 * @param title Sets the title of the Frame.
	 */
	public Window(String title)
	{
		super(title) ;
		applySettings();
		
	}
	
	/**
	 * Refreshes all windowProperties defined in 
	 * Windowproperties.
	 */		
	public void applySettings()
	{
		this.setDefaultCloseOperation(WindowProperties.CLOSING_OPERATION);
		this.setSize(WindowProperties.WIDTH, WindowProperties.HEIGHT);
		this.setResizable(WindowProperties.RESIZEABLE);
		this.setLayout(WindowProperties.LAYOUT_MANAGER);
		
	}
	
}
