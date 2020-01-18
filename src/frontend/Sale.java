package frontend;

public class Sale 
{
	String myName;
	double myMoney;
	
	public Sale(String name, double money)
	{
		myName = name;
		myMoney = money;
	}
	
	public double getMoney()
	{
		return myMoney;
	}
	
	public String getName()
	{
		return myName;
	}
	
	public void setMoney(double d)
	{
		myMoney = d;
	}
	
	public void setName(String s)
	{
		myName = s;
	}
}
