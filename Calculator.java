/**
* @author or
* @author zoarit
* @version 1.0
* Abstract "super class" describing Calculator.
**/
public abstract class Calculator 
{
	/**
	 *the result of the calculation of the calculator.
	 *@see #getCurrentResult 
	 **/
	protected double res;
	/**
	 * By making this method abstract, all subclasses MUST implement it
	 * @param expr an expression the need to be evaluated  
	 **/
	abstract void evaluate(String expr);
	
	
	/**
	 * @return the value of the last Calculation that was made.  
	 */
	double getCurrentResult()
	{return this.res;}
	
}
