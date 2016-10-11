package dev.tilegame.db;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	private Connection conn;
	private Statement stat;
	
	public Database() {
		conn = connect();
		stat = createStatement();
		updatePicture("Helias", "Data/File/Images/Helias.jpg");
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
	
	public byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        
        return bos != null ? bos.toByteArray() : null;
    }
	
	
	   public void updatePicture(String nickname, String filename) {
	        String updateSQL = "UPDATE Users "
	                + "SET picture = ? "
	                + "WHERE nickname = ?";
	 
	        try {
	            PreparedStatement ps = conn.prepareStatement(updateSQL);
	 
	            // set parameters
	            ps.setBytes(1, readFile(filename));
	            ps.setString(2, nickname);
	            ps.executeUpdate();
	            
	            System.out.println("Stored the file in the BLOB column.");
	 
	        } catch (SQLException e) { System.out.println(e.getMessage()); }
	    }
	public Connection getConnection() { return conn; }
	public Statement getStatement() { return stat; }
}
/*
Connection connection = null;
//ResultSet resultSet = null;
PreparedStatement ps = null;
String file = "C:\\Fingerprint\\histoImg_med.png";
Properties prop = new Properties();
int s = 0;
byte[] person_image = null;
File image = new File(file);
FileInputStream fis = new FileInputStream(image);
ByteArrayOutputStream bos = new ByteArrayOutputStream();
byte[] buf = new byte[1024];

try {
    for (int readNum; (readNum = fis.read(buf)) != -1;)
    {
        bos.write(buf, 0, readNum);
        //no doubt here is 0
        /*Writes len bytes from the specified byte array starting at offset
        off to this byte array output stream.
        System.out.println("read " + readNum + " bytes,");
    }
} catch (IOException ex) {
    System.err.println(ex.getMessage());
}
person_image = bos.toByteArray();

try {
    prop.load(new FileInputStream("C:\\dbconfig.properties"));  
    Class.forName(prop.getProperty("driver"));
    connection = DriverManager.getConnection(prop.getProperty("url"));

    ps = connection.prepareStatement("INSERT INTO epmc_tbl_test_img (hhld_photo) VALUES (?)");
    ps.setBytes(1, person_image);
    s = ps.executeUpdate();
    if (s > 0)
    {
        System.out.println("Image Uploaded");
    }
    ps.close();
} catch (Exception e) {
    e.printStackTrace();
} finally {
    try {
        ps.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
*/