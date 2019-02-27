/**
*@author or
*@author zoarit
*@version 1.0
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// Each function here should test a different class.
		testAddOp();
		testValueToken();
		testBinaryOp();
		testCalcToken();
		testSubOp();
		testMultiplyOp();
		testExpTokenizer();
		testDivideOp();
		testPowOp();
		testCalculator();
		testPostfixCalculator();
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) 
	{
		testNum++;
		if (!exp)
		{
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}
	
	/**
	 * Checks the ValueToken class.
	 */
	private static void testAddOp()
	{
		BinaryOp op1=new AddOp();
		test(op1.toString().equals("+")," should return +");//check that the class return correct string
		test(op1.operate(-2, 3.4)==1.4,"should return 1.4");//check that the class return right results
		
	}
	/**
	 * checks CalcToken class
	 **/
	private static void testCalcToken()
	{
		CalcToken token1=new ValueToken(3);
		test(token1.toString().equals("3.0"),"should be 3");
	}
	/**
	* checks BinaryOp class
	**/
	private static void testBinaryOp()
	{
		BinaryOp op1=new DivideOp();
		test(op1.toString().equals("/")," should return /");
		test(op1.operate(40,2)==20,"should return 2.0");
		 op1=new MultiplyOp();
		test(op1.toString().equals("*")," should return *");
		test(op1.operate(25,2)==50.0,"should return 50.0");

	}
	/**
	* checks DivideOp class
	**/
	private static void testDivideOp(){
		DivideOp op1=new DivideOp();
		test(op1.toString().equals("/")," should return /");
		test(op1.operate(4,2)==2.0,"should return 2.0");
	}
	/**
	* checks MultiplyOp class
	**/
	private static void testMultiplyOp()
	{
		MultiplyOp op1=new MultiplyOp();
		test(op1.toString().equals("*")," should return *");
		test(op1.operate(25,2)==50.0,"should return 50.0");
	}
	/**
	 *  test  SubOp class.
	 **/
	private static void testSubOp()
	{
		BinaryOp op1=new SubtractOp();
		test(op1.toString().equals("-")," should return -");
		test(op1.operate(25,-5)==30,"should return 30");
	}

	/**
	*test PowOp class
	**/
	private static void testPowOp()
	{
		BinaryOp op1=new PowOp();
		test(op1.toString().equals("^")," should return ^");
		test(op1.operate(2,4)==16,"should return 16");
		test(op1.operate(3,0)==1,"should return 1");
		test(op1.operate(2,-1)==0.5,"should return 16");
		test(op1.operate(0.5,2)==0.25,"should return 16");


	}
	/**
	 * test ExpTokenizer class
	 */
	private static void testExpTokenizer()
	{
		ExpTokenizer token1=new ExpTokenizer("^");
		test(token1.countTokens()==1,"should have only 1 token in the tokenizer");
		test(token1.hasMoreElements(),"should have more elements in the token storage");
		Object obj=token1.nextElement();
		test((obj instanceof PowOp),"should be instance of PowOp class");
		test(!token1.hasMoreElements(),"should not have anymore elements stored");
		if(token1.hasMoreElements())
			{
		token1=new ExpTokenizer(" 4  s ");
		try
		{
			token1.nextElement();
		}
		catch(ParseException ex)
		{
			test(ex.getMessage().equals("is not legal expression(too many spaces betwen tokens"),"shold"
					+"thow error of too many spaces btween tokens");
		}
			}
	}
	/**
	*test the ValueToken class
	**/
	private static void testValueToken() 
	{
		ValueToken t1 = new ValueToken(5.1);
		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");
		t1=new ValueToken(-5);
		test(t1.getValue()==-5,"value should be -5");
		test(t1.toString().equals("-5.0"), "Value toString should be -5");
		t1=new ValueToken(((double)-1/3));
		test(t1.getValue()==((double)-1/3),"value should be -1/3");
		test(t1.toString().equals(Double.toString(((double)-1/3))), "Value toString should be -1/3");
	}
	/**
	 * test Calculator class
	 **/
	private static void testCalculator()
	{
	Calculator calc=new PostfixCalculator();
	try{
	calc.evaluate("7");
	test(calc.getCurrentResult()==7,"value should be 7");
	calc.evaluate("0 11.2 *");
	test(calc.getCurrentResult()==0,"value should be 0");
	calc.evaluate("2 -1 2 + +");
	test(calc.getCurrentResult()==3,"value should be 3");
	}
	catch(ParseException ex)
	{
		test(false,"test failled should not throw expection");//if exception was thrown error exist.
	}	
	try
	{
	calc.evaluate("+");
	}
	catch(ParseException ex)
	{
		String s=ex.getMessage();
		test(s.equals("cannot preform operation +"), "should return error messege of: of cannot preform operation *");
	}
	try
	{
	calc.evaluate("/");
	}
	catch(ParseException ex)
	{
		String s=ex.getMessage();
		test(s.equals("cannot preform operation /"), "should return error messege of: of cannot preform operation ^");
	}
	
	try{
		calc.evaluate("0 2 -3.4 5");
	}
	catch(ParseException ex)
	{
		String s=ex.getMessage();
		test(s.equals("invalid expression"),"should return error messege of: invalid expression");		
	}
	try{
		calc.evaluate("L");
	}
	catch(ParseException ex)
	{
		String s=ex.getMessage();
		test(s.equals("L is not legal token"),"should return error messege of: not legal token");		
	}
	}

	/**
	 * test the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {
		double epsilon=0.0000000001;//how close numbers need to be in order to be equals
		PostfixCalculator calc=new PostfixCalculator();
		try{
		calc.evaluate("3");
		test(calc.getCurrentResult()==3,"value should be 3");//test if calculator can deal with only number token as expression
		calc.evaluate("2 11.2 *");
		test(calc.getCurrentResult()==22.4,"value should be 22.4");
		calc.evaluate("2 1 2 + +");
		test(calc.getCurrentResult()==5,"value should be 5");
		calc.evaluate("1 44 -");
		test(calc.getCurrentResult()==-43,"value should be -43");
		calc.evaluate("2 8 ^ 1 - ");
		test(calc.getCurrentResult()==255,"value should be 255");
		calc.evaluate("2 7 ^ -0.5 /");
		test(calc.getCurrentResult()==-256,"value should be -256");
		calc.evaluate("4 4 + 2 / 2 ^ 2 -");
		test(calc.getCurrentResult()==14,"value should be 14");
		calc.evaluate("1 0.3 / 2 +");
		double c=calc.getCurrentResult();
		test(Math.abs(c-(16.0/3.0))<epsilon,"value should be equal to 5.3333");//Determinate if the numbers are close enough
		calc.evaluate("2 4 4 2 1 1 + * / * ^");
		test(calc.getCurrentResult()==16.0,"value should be 16");
		calc.evaluate("2 2 2 2 * * /");
		test(calc.getCurrentResult()==0.25,"value should be 0.25");//test rational numbers calc
		}
		catch(ParseException ex)
		{test(false,"test failled should not throw expection");}
		//checking for bad calculations  now should catch all exceptions.
		try
		{
		calc.evaluate("*");
		}
		catch(ParseException ex)
		{
			String s=ex.getMessage();
			test(s.equals("cannot preform operation *"), "should return error messege of: of cannot preform operation *");
		}
		try
		{
		calc.evaluate("^");
		}
		catch(ParseException ex)
		{
			String s=ex.getMessage();
			test(s.equals("cannot preform operation ^"), "should return error messege of: of cannot preform operation ^");
		}
		
		try{
			calc.evaluate("5 4 3");
		}
		catch(ParseException ex)
		{
			String s=ex.getMessage();
			test(s.equals("invalid expression"),"should return error messege of: invalid expression");		
		}
		try{
			calc.evaluate("!");
		}
		catch(ParseException ex)
		{
			String s=ex.getMessage();
			test(s.equals("! is not legal token"),"should return error messege of: not legal token");		
		}
		try{
		calc.evaluate("");
		}
		catch(ParseException ex)
		{
			String s=ex.getMessage();
			test(s.equals("empty expression cannot calculate anything"),"should return error messege of: empty expression cannot calculate anything");
		}
		try{
			calc.evaluate("5 +");
			}
			catch(ParseException ex)
			{
				String s=ex.getMessage();
				test(s.equals("cannot preform operation +"),"should return error messege of: cannot preform operation");
			}
		
		try{
			calc.evaluate("542-42");
			}
			catch(ParseException ex)
			{
				String s=ex.getMessage();
				test(s.equals("542-42 is not legal number"),"should return error messege of: is not legal number ");
			}
		try{
			calc.evaluate("1.2.3");
			}
			catch(ParseException ex)
			{
				String s=ex.getMessage();
				test(s.equals("1.2.3 is not legal number"),"should return error messege of: is not legal number ");
			}
		try{
			calc.evaluate(".324");
			}
			catch(ParseException ex)
			{
				String s=ex.getMessage();
				test(s.equals(".324 is not legal number"),"should return error messege of: is not legal number ");
			}
		try
		{
			calc.evaluate(" 2  4 + ");
		}
		catch(ParseException ex)
		{
		String s=ex.getMessage();
		test(s.equals("is not legal expression(too many spaces betwen tokens)"),"should retrun error of too many spaces between tokens");
		}
	}
}