/**
* @author or
* @author zoarit
* @version 1.0
* class describing number token that will be seen when
*evaluating arithmetic expressions.
**/
public class ValueToken extends CalcToken {
	/**
	 * the value that the token represent.
	 **/
protected double value;
/**
 * creates new ValueToken
 * @param value the value of the ValueToken
 */
	ValueToken(double value)
	{
		this.value=value;
	}
/**
 * get the value of the token.
 * @return the value of the token
 */
	public double getValue()
	{
		return this.value;
	}
	/**
	 * creates string that represent the number that the token represent.
	 * @return the value of the token as a string. 
	 */
	public String toString() {
		return Double.toString(value);
	}

}
