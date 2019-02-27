/**
* @author or
* @author zoarit
* @version 1.0
* Abstract class describing binary arithmetic plus operation.
**/
public class AddOp extends BinaryOp {

	/**
	 * Return the result of the plus operation on the given operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the left operand plus the right operand.
	 */
	public double operate(double left, double right) {
		double res=left+right;
		return res;
	}
	/**
	 * method that get token that symbol plus operation as a string.
	 * @return + as a string
	 **/
	public String toString() {
		String plus="+";
		return plus;
	}

}
