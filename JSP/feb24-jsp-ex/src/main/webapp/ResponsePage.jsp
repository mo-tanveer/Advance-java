<%
	//String value = request.getParameter("varname");
	//out.print("Hye My name is "+value);
	
	//int value = Integer.parseInt(request.getParameter("number"));
	//out.print("Hye My value is "+value);

%>

<%!

   public long calculateFactorial(int num)
   {
	int result =1 ;
	
	for(int i=1; i<=num; i++)
		result = result*i;
	
	    return result;

   }


//Prime number

/*

public boolean checkPrimeNum(int num)
{
	boolean isPri = true;
	
	for(int i=2; i<num; i++)
	{
		if(num%i == 0)
		{
			isPri = false;
			break;
		}
	}
	return isPri;
	
	
}
*/
%>


<%
String value = request.getParameter("number");

if (value != null && !value.isEmpty()) {
    int num = Integer.parseInt(value);

    if (num < 0) {
        out.println("Factorial is not defined for negative numbers.");
    } else {
        long fact = calculateFactorial(num);
        out.println("Factorial of " + num + " is " + fact);
    }
}
%>



