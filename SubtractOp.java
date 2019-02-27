/**
*@author or
*@author zoarit
*@version 1.0
*Abstract class describing binary arithmetic minus operation.
**/
public class SubtractOp extends BinaryOp {

	/**
	 * Return the result of the minus operation on the given operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the left operand minus the right operand.
	 */
	public double operate(double left, double right) {
		double res=left-right;
		return res;
	}
	/**
	 * method that get token that symbol minus operation as string
	 * @return - string
	 **/
	public String toString() {
		String minus="-";
		return minus;
	}
}
