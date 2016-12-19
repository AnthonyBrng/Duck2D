package stdio;

import java.util.Random;

/**
 * 
 * @author anthony
 *
 */
public class Stdio 
{
	/**
	 * Maps a value in a specific range to another range.
	 * For example the value 50 in the range from 0 to 100
	 * gets relativly maped to the range from -20 to 20, so the result
	 * would be 0. Or in other words. The two diffrent ranges get mapped and
	 * the inputvalue defines the äquivalent value in the other range.
	 * @param value	input-value which getting maped.
	 * @param lower_src lower bound of the source range
	 * @param upper_src upper bound of the source range
	 * @param lower_dest lower bound of the destiny range
	 * @param upper_dest upper bound of the destiny range
	 * @return the maped value.
	 */
	public static double map(double value, double lower_src, double upper_src, double lower_dest, double upper_dest )
	{
		double perc = value / (Math.abs(lower_src - upper_src)) ;
		double res = perc * (Math.abs(lower_dest - upper_dest)) ;
		double result ; 
		if(lower_dest > upper_dest)
			result  = lower_dest - res;
		else
			result = res - lower_dest ;
		
		return result ;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static int random(int lower_bound, int upper_bound)
	{
		Random r = new Random();
		
		int result = 0 ;
		if(lower_bound < 0)
			result = lower_bound + r.nextInt(upper_bound + (-1)*lower_bound + 1) ;
		else
			result = lower_bound + r.nextInt(upper_bound + (-1)*lower_bound + 1) ;
		return result ;
	}
	
}
