import java.util.Enumeration;
/*
 * if direction is true, we will tokenize from left to right,
 * if direction is false, then we will tokenize from right to left.
 */
/**
 *class that create tokens that are used when evaluating expression.
  */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	//fields
	private String [] result;
	private boolean direction;
	private int index;
	
	//constructor
	/**
	 * tokenize string into tokens and store the tokens with default direction(from left to right)).
	 * @param exp the string that need to be tokenized
	 */
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	
	/**
	 * tokenize string into tokens and store the tokens with default direction.
	 * @param exp the string that need to be tokenized
	 * @param direction the direction that the string will be tokenize
	 * if direction is true, we will tokenize from left to right,
	 * if direction is false, then we will tokenize from right to left
	 */
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}
	/**
	 * get next token that stored 
	 * @return object that represent an legal token of an expression.
	 * @throws ParseException if token that was stored is not legal token.
	 */
	public Object nextElement() {
		CalcToken resultToken = null;
		String token =  nextToken();//get next token from array and compared  it's string value to the operators value.
		if (token.equals("+"))
			resultToken =  new AddOp();
		else if (token.equals("*"))
			resultToken =  new MultiplyOp();
		else if(token.equals("-"))
			resultToken= new SubtractOp();
		else if(token.equals("/"))
			resultToken=new DivideOp();
		else if(token.equals("^"))
			resultToken=new PowOp();
		else // check if the token is a number or throw  error
		{
			int point=0;
			String tmp=new String(token);
			if(tmp.length()==0)
				throw new ParseException("is not legal expression(too many spaces betwen tokens)");//an empty token was created from the string
				if((tmp.length()==1)&&(tmp.charAt(0)<'0'||tmp.charAt(0)>'9'))//not legal token 1 char that isnt known token.
					throw new ParseException(tmp.charAt(0)+" is not legal token");
				else//test for legal number
				{
					for(int i=0;i<tmp.length();i=i+1){
						char letter=tmp.charAt(i);
						if(letter=='.')//checks for rational number
							point=point+1;
						if((letter=='.')&& (i==0))//number cant start with . letter
						{
							throw new ParseException(token+" is not legal number");
						}
						if((letter=='-')&&(i!=0))//number cant have - letter in middle
						{
							throw new ParseException(token+" is not legal number");
						}
						if((letter<'0'||letter>'9'))//checks if not legal letters for number.
							{
							if(letter!='-' && letter!='.')
							throw new ParseException(token+" is not legal number");	
							}
					}
					if(point>1)// number can have only 1 . letter if its  
						throw new ParseException(token+" is not legal number");		
				}
				resultToken = new ValueToken(Double.parseDouble(token));//parse the string into number and create value token with the number.			
			}
				return resultToken;	
	}

	/**
	 * checks if done  to process all the elements that are stored
	 * @return true if still have unprocessed elements stored.
	 */
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}
			
		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}
	/**
	 * checks if done  to process all the tokens that are stored
	 * @return true if still have unprocessed tokens stored.
	 */
	public boolean hasMoreTokens() {
		return hasMoreElements();
	}
	/**
	 * count how many unprocessed tokens are in stored
	 * @return how many unprocessed tokens are stored
	 */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
}