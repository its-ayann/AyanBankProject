package application;

public class Transaction {
	private String name;
	private String accountType;
	private String type;
	private double amount;
	
	public String getName() {
		return name;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public String getType() {
		return type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	Transaction(String aName, String anAccountType, String aType, double anAmount) {
		name = aName;
		accountType = anAccountType;
		type = aType;
		amount = anAmount;
	}
	
	

}
