/**
* @author or
* @author zoarit
* @version 1.0
* class" describing PostFixCalculator.
**/
public class PostfixCalculator extends Calculator {
/**
 * the method evaluate an postfix expression value and calculate the result of the
 * expression and store the result
 * @param expr string that represent Postfix expression.
 * @throws ParseException if the expr is not postfix expression.
 */
	void evaluate(String expr)
	{
		if(expr.length()==0)
		  throw new ParseException("empty expression cannot calculate anything");
		StackAsArray calc_stack=new StackAsArray();
		ExpTokenizer exp=new ExpTokenizer(expr);
		while(exp.hasMoreTokens())
		{
			CalcToken tmp=(CalcToken) exp.nextElement();
			if(tmp instanceof BinaryOp)
			{
				double left_op = 0,right_op = 0;
				if(!calc_stack.isEmpty())
				right_op=((Double) calc_stack.pop()).doubleValue();
				else//stack is empty
					throw new ParseException("cannot preform operation "+((BinaryOp)tmp).toString());		

				if(!calc_stack.isEmpty())
				left_op=((Double) calc_stack.pop()).doubleValue();
				else
				throw new ParseException("cannot preform operation "+((BinaryOp)tmp).toString());	

				double res=((BinaryOp)tmp).operate(left_op,right_op);
				calc_stack.push(res);
			}
			else //its valuetoken
			{						
				calc_stack.push(((ValueToken) tmp).getValue());				
			}//push vlaue to stack
		}
		if(!calc_stack.isEmpty())//check if there are value tokens in the stack
		{
			double res=((Double)calc_stack.pop()).doubleValue();
					if(calc_stack.isEmpty())// check if there are value tokens in the stack
						this.res=res;
					else
						throw new ParseException("invalid expression");		
		}
		else
			throw new ParseException("invalid expression");	
		}
	}
