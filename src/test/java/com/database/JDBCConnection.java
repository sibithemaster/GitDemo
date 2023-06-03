package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		
		String host="localhost";
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":"+ port +"/sakila", "root", "root");
		
		Statement stmt=con.createStatement();
		
	    ResultSet rst=stmt.executeQuery("select * from sakila.actor where first_name='NICK' ");
		
	    while(rst.next())
	    {
		System.out.println(rst.getString("first_name")+ " " + rst.getString("last_name"));
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys(rst.getString("first_name"));
		driver.findElement(By.id("pass")).sendKeys(rst.getString("last_name"));
		
	    }
		
		
	
	
	}
}
