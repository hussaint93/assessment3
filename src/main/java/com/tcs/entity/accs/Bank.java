package com.tcs.entity.accs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank {
	private static Logger logger = LogManager.getLogger(Bank.class);
	private static List<Account> acc = new ArrayList<Account>();
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost/test";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";

		Scanner sc = new Scanner(System.in);
		System.out.println("type of account user want to open");
		String accType = sc.nextLine();
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			if (accType.equalsIgnoreCase("savings")) {
				
				Account account = new SavingsAccount("hussain", 900L,new Date() , "Active", "Savings", new Address("Mumbai","Maharashtra",401105,"c/411,NewNavrang APt","Cabin Road").toString());
				create(statement, account);
			} else if (accType.equalsIgnoreCase("current")) {
				Account account = new CurrentAccount("atif", 900L, new Date(), "Active", "Current",  new Address("Mumbai","Maharashtra",401105,"c/411,NewNavrang APt","Cabin Road").toString());
				create(statement, account);
			} else if (accType.equalsIgnoreCase("Demat")) {
				Account account = new DematAccount("chetan", 900L, new Date(), "Active", "Demat",  new Address("Mumbai","Maharashtra",401105,"c/411,NewNavrang APt","Cabin Road").toString());
				create(statement, account);
			} else {
				logger.debug("enter proper type");
			}
			
			withdraw(statement,sc);//to withdraw from account
			deposit(statement,sc);// to deposit into account

		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
	}

	private static void deposit(Statement statement, Scanner sc)throws SQLException {
		
		ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
		logger.info("Enter the id you want to deposit to and amount to deposit");
		long useramnt=0;
		int id = sc.nextInt();
		Long amnt = sc.nextLong();
		while(resultSet.next()) {
			if(resultSet.getInt("id")==id)
			useramnt=resultSet.getLong("balance_amount");
		}
		long add=useramnt+amnt;
		statement.execute("UPDATE account SET balance_amount="+add+" WHERE id="+id+";");
	}

	private static void withdraw(Statement statement,Scanner sc) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * FROM account");
		logger.info("Enter the id you want to withdraw from and amount to be withdrawen");
		long useramnt=0;
		int id = sc.nextInt();
		Long amnt = sc.nextLong();
		while(resultSet.next()) {
			if(resultSet.getInt("id")==id)
			useramnt=resultSet.getLong("balance_amount");
		}
		if(useramnt-amnt>0L) {
			long left=useramnt-amnt;
			statement.execute("UPDATE account SET balance_amount="+left+" WHERE id="+id+";");
		}else {
			logger.info("low balance");
		}
		
	}

	private static void create(Statement statement, Account account) throws SQLException {
		statement.execute("insert into account(owner_name,balance_amount,stats,acc_type,address) values "
				+ "('"+account.getOwnerName()+"',"+account.getAmount()+",'Active','"+account.getType()+"','"+account.getAddress()+"')");
	}
}
