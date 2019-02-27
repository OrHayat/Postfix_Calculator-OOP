/**
*@author or
*@author zoarit
*@version 1.0
*Abstract class describing binary arithmetic division operation.
**/
public class DivideOp extends BinaryOp 
{
	/**
	 * Return the result of the division operation on the given operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the left operand divided the right operand.
	 */
	public double operate(double left, double right)
	{
		double res=left/right;
		return res;
	}

	/**
	 * method that get token that symbol division operator as a string
	 * @return / as a string
	 **/
	public String toString()
	{
		String div="/";
		return div;		

	}

}
