package application;

public class Account {
	
	private String name;
	private int accountNumber;
	private double balance;
	private String accountType;
	
	public static String selectedAccount;
	
	public String getName() {
		return name;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String anAccountType) {
		accountType = anAccountType;
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public void setAccountNumber(int newAccountNumber) {
		accountNumber = newAccountNumber;
	}
	
	public void setBalance(double aBalance) {
		balance = aBalance;
	}
	
	Account () {
		
	}
	Account(String aName, int anAccountNumber, double aBalance, String anAccountType) {
		name = aName;
		accountNumber = anAccountNumber;
		balance = aBalance;
		accountType = anAccountType;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw1(double amount) {
		balance = balance - amount;
	}
	
	
	

}
