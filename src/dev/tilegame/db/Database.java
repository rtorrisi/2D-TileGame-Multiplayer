package dev.tilegame.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private Connection conn;
	private Statement stat;
	
	public Database() {
		conn = connect();
		stat = createStatement();
	}
	
	public Connection connect() {
		 try {
			return DriverManager.getConnection("jdbc:sqlite:Data/Shareland.sqlite"); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		 return null;
	}
	
	public Statement createStatement() {
		if(conn!=null) {
			try { return conn.createStatement();
			} catch (SQLException e) {}
		}
		return null;
	}
	
	public Connection getConnection() { return conn; }
	public Statement getStatement() { return stat; }
}
