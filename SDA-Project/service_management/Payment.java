package service_management;

public class Payment
{
	double amount;
	
	public Payment()
	{
		amount = 0;
	}
	
	public Payment(double am)
	{
		amount = am;
	}
	
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	public double getAmount()
	{
		return amount;
	}
}
