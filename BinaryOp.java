/**
*@author or
*@author zoarit
*@version 1.0
*Abstract superclass describing binary arithmetic operations tokens 
*seen when evaluating arithmetic expressions.
**/
public abstract class BinaryOp extends CalcToken {
	/**
	 * Return the result of this operation on its operands.
	 * @param left the left operand.
	 * @param right the right operand.
	 * @return the result of the operation.
	 */
	public abstract double operate(double left, double right);  
}