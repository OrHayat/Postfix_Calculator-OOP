/**
*@author or
*@author zoarit
*@version 1.0
*class describing binary arithmetic power operation
***/
public class PowOp extends BinaryOp 
{
	/**
	 * Return the result of the power operation on the given operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the left operand powered by the right operand.
	 */
public double operate(double left, double right) 
		{
		double res=Math.pow(left,right);
		return res;
		}
/**
 * method that get token that symbol  power operator as string
 * @return ^ as a string
 **/
public String toString()
	{
		String pow="^";
		return pow;
	}

}