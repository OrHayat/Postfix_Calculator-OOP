/**
*@author or
*@author zoarit
*@version 1.0
*Abstract class describing binary arithmetic multiplication operation.
**/
public class MultiplyOp extends BinaryOp {
	
	/**
	 * Return the result of the multiplication operation on the given operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the left operand multiplied by the right operand.
	 */
	public double operate(double left, double right) {
		double res=left*right;
		return res;
	}

	/**
	 * method that get token that symbol multiplication operation as string
	 * @return * as a string
	 **/	public String toString() {
	 String mul="*";
		return mul;
	}

}
