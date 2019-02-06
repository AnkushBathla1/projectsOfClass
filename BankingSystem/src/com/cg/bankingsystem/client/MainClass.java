package com.cg.bankingsystem.client;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.cg.*;
import com.cg.bankingsystem.beans.Account;
import com.cg.bankingsystem.beans.Customer;
import com.cg.bankingsystem.exceptions.AccountBlockedException;
import com.cg.bankingsystem.exceptions.InvalidAccountNumberException;
import com.cg.bankingsystem.exceptions.InvalidAccountTypeException;
import com.cg.bankingsystem.exceptions.InvalidAdharNoException;
import com.cg.bankingsystem.exceptions.InvalidAmountException;
import com.cg.bankingsystem.exceptions.InvalidDateOfBirthException;
import com.cg.bankingsystem.exceptions.InvalidPinNumberException;
import com.cg.bankingsystem.services.ServiceImpl;
import com.cg.bankingsystem.services.Services;

public class MainClass {
	
	long accountNumber,pinNumber;
	double amount;
	static  Scanner sc= new Scanner(System.in);
	static Services services=new ServiceImpl();
	public static void main(String args[]) throws InvalidAmountException, InvalidAccountTypeException, InvalidAccountNumberException, InvalidDateOfBirthException, InvalidPinNumberException, AccountBlockedException {
	
	mainScreen();
	int userChoice=sc.nextInt();
	startMenu(userChoice);
	
	}
	public static void startMenu(int userChoice) throws InvalidAmountException, InvalidAccountTypeException,  InvalidAccountNumberException, InvalidDateOfBirthException, InvalidPinNumberException, AccountBlockedException {
		long accountNumber,pinNumber;
		double amount;
		switch(userChoice) {
		case 1:    System.out.println("Enter first name:");
		                String fName = sc.next();
		                System.out.println("Enter last name:");
		                String lName  = sc.next();
		        
		                System.out.println("Enter Adhar Number:");
		            	String  adharNo = sc.next();
		                
		                System.out.println("Enter your pan number:");
		                String panNo = sc.next();
		                System.out.println("Enter mobile number:");
		                String mobileNo = sc.next();
		              
		                System.out.println("");
			            System.out.println("Enter the type of account you want to open:");
						System.out.println("Note: Savings or Current");
						String accountType=sc.next();
						System.out.println("Enter your client Balance");
						double accountBalance=sc.nextDouble();
						
						Account account = services.createAccount(accountType,accountBalance,fName,lName,adharNo,panNo,mobileNo);
						System.out.println("******ACCOUNT CREATED******");
						System.out.println(account);
						break;
		case 2:System.out.println("Enter the account number to deposit:");
					    accountNumber=sc.nextLong();
						System.out.println("Enter the amount to deposit:");
					    amount = sc.nextDouble();
						System.out.println(services.deposit(accountNumber,amount));
						break;
		case 3 : System.out.println("Enter the account number to withdraw");
		                accountNumber = sc.nextLong();
		                System.out.println("Enter the amount to withdraw");
		                amount = sc.nextDouble();
		                System.out.println("Enter the pin to withdraw");
		                pinNumber= sc.nextLong();
		        		break;
		case 4 :  System.out.println("Enter the account number from which to transfer:");
		                long  fromAccountNumber = sc.nextLong();
		                sc.nextLine();
		                System.out.println("Enter the account number to which to transfer:");
		                long toAccountNumber = sc.nextLong();
		                sc.nextLine();
		                System.out.println("Enter the pin of withdraw account");
		                long pinOfWithdrawAccount = sc.nextLong();
		                sc.hasNextLine();
		                System.out.println("Enter the amount:");
		                amount = sc.nextDouble();
		                
		                System.out.println(services.fundtransfer(fromAccountNumber,toAccountNumber,pinOfWithdrawAccount,amount));
	                     break;	
		case 5 : System.out.println(services.getAllAccount());
		                break;
		default: 
						System.out.println("Invalid Choice,Please Try Again!!!!!!");
		}
		System.out.println("What do you want to do now ?");
		System.out.println("1. Continue");
		System.out.println("2. Exit");
		int choice =sc.nextInt();
		if(choice==2)
			System.exit(0);
		main(null);
	}
	public static void mainScreen(){
		System.out.println("__________________________________BANK OF PEOPLE__________________________________");
		System.out.println("Please enter any one of the given choices :");
		System.out.println("1. Create a account");
		System.out.println("2. Deposit money");
		System.out.println("3. Withdraw money");
		System.out.println("4. Fund transfer:");
		System.out.println("5. Show all accounts:");
	}
}