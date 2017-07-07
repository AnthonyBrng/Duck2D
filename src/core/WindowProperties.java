package core;

import java.awt.LayoutManager;

import javax.swing.JFrame;

/**
 * Defines static properties for the main Window.
 * @author anthony
 *
 */
class WindowProperties 
{
	/*
		package private
	 */
	static int WIDTH = 150 ;
	static int HEIGHT = 150 ;
	static boolean RESIZEABLE = false ;
	static LayoutManager LAYOUT_MANAGER = null ;
	static int CLOSING_OPERATION = JFrame.EXIT_ON_CLOSE ;
}
