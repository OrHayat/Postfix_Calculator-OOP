/**
* @author or
* @author zoarit
* @version 1.0
* Abstract class describing ParseException that you might get when using
* PostfixCalculator not correctly.
**/
public class ParseException extends RuntimeException {

	/**
	 * @param message the error message of the exception.
	 */
	public ParseException(String message)
	{super(message);}
}
