package stdio;

import javax.sql.rowset.serial.SerialRef;
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
	 * Generates a random integer number in a specific range.
	 * @param lower_bound  lowest possible number.
	 * @param upper_bound  highest possible number
	 * @return randomInt number between lower_bound and upper_bound.
	 */
	public static int randomInt(int lower_bound, int upper_bound)
	{
		Random r = new Random();
		int result ;
		result = lower_bound + r.nextInt(upper_bound + (-1)*lower_bound + 1) ;
		return result ;
	}


	/**
	 * Generates a random double number between 0 (incl.) and 1(excl.)
	 * @return generated random number
	 */
	public static double randomDbl()
	{
		return randomDbl(1) ;
	}

	/**
	 * Generates a randomInt double number between 0 (incl.) and a upper bound(excl.)
	 * @param upper_bound upper bound of the result range.
	 * @return generated random number
	 */
	public static double randomDbl(double upper_bound)
	{
		return Math.random() * upper_bound ;
	}

	/**
	 * Generates a randomInt integer number in a specific range.
	 * @param lower_bound  lowest possible number.
	 * @param upper_bound  highest possible number
	 * @return generated random double number.
	 */
	public static double randomDbl(double lower_bound, double upper_bound)
	{
		double result ;

		double dist = Math.abs(lower_bound - upper_bound ) ;
		result = lower_bound + randomDbl(dist);
		return result ;
	}


	/**
	 * Swaps two elements in an array.
	 *
	 * @param array 	array where the elements should be swapped
	 * @param index1	first index.
	 * @param index2	second index.
	 */
	public static void swap(Object[] array, int index1, int index2)
	{
		try
		{
			Object tmp = array[index2];
			array[index2] = array[index1];
			array[index1] = tmp;
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.err.println(String.format("Index went out of bounce, while swapping index '%1' and index '%2'. in Stdio.swap()",index1, index2));
		}


	}

	/**
	 * Alias-method for System.out.println().
	 * @param obj Object to print.
	 */
	public static void print(Object obj)
	{
		System.out.println(obj.toString());
	}
	
}
