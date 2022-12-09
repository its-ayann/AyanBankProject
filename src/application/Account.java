package application;

/**
 * The parts that make up of an Account.
 * @author Ayan Ahmed
 *
 */

public class Account {
	
	private String name;
	private int accountNumber;
	private double balance;
	private String accountType;
	private String accountTo;
	private String accountFrom;
	private double amount;
	
	
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
	
	public String getAccountTo() {
		return accountTo;
	}
	
	public String getAccountFrom() {
		return accountFrom;
	}
	
	public void setAccountTo(String account) {
		accountTo = account;
	}
	
	public void setAccountFrom(String account) {
		accountFrom = account;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double anAmount) {
		amount = anAmount;
	}
	
	Account () {
		
	}
	Account(String aName, int anAccountNumber, double aBalance, String anAccountType) {
		name = aName;
		accountNumber = anAccountNumber;
		balance = aBalance;
		accountType = anAccountType;
	}
	
	Account(String anAccountType, double aBalance) {
		accountType = anAccountType;
		balance = aBalance; 
	}
	
	Account(String anAccountType) {
		accountType = anAccountType;
	}
	
	Account(String aName, String anAccountType, double anAmount) {
		name = aName;
		accountType = anAccountType;
		amount = anAmount;
	}
	
	
	/**
	 * Add money to an account when the user chooses to deposit.
	 * @param amount the amount the user inputs to deposit will add to the current balance.
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	/**
	 * Subtract money to an account when the user chooses to withdraw.
	 * @param amount the amount the user inputs to withdraw will subtract to the current balance.
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	
	

}
