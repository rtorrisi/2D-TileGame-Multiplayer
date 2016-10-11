package dev.tilegame.db.signup_login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import dev.tilegame.Game;
import dev.tilegame.db.Database;

public class LogInForm extends JPanel {
	
	private Database database;
	
	public LogInForm() {
		database = Game.database;
		initComponents();
	}
	
	private void initComponents() {
		setBackground(new java.awt.Color(36, 51, 60));
		
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        showPass_Box = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel_Image = new javax.swing.JPanel();
	
        timer1 = new Timer(30, new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
			if(count++>30) {
				timer1.stop();
        		jLabel1.setText("Welcome Back!");
			}
        	}
		});
        
        //timer2
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Back!");

        usernameField.setForeground(new java.awt.Color(255, 255, 255));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameField.setToolTipText("");
        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 177, 136), 2));
        usernameField.setCaretColor(new java.awt.Color(255, 255, 255));
        usernameField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        usernameField.setOpaque(false);
        usernameField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				try {
					checkProfilePicture();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			public void keyPressed(KeyEvent e) {}
		});
        
        passwordField.setBackground(new java.awt.Color(0, 0, 0));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 177, 136), 2));
        passwordField.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordField.setOpaque(false);
        passwordField.setEchoChar('*');

        showPass_Box.setBackground(new java.awt.Color(0, 0, 0));
        showPass_Box.setForeground(new java.awt.Color(255, 255, 255));
        showPass_Box.setText("Show password");
        showPass_Box.setBorder(null);
        showPass_Box.setOpaque(false);
        showPass_Box.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPass_BoxActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nickname");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        jButton1.setBackground(new java.awt.Color(67, 82, 88));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign Up");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(26, 177, 136));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Log In");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);

        jButton4.setBackground(new java.awt.Color(26, 177, 136));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LOG IN");
        jButton4.setToolTipText("");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent evt) { LOGIN_ActionPerformed(); }
        		}
        );    
        

        javax.swing.GroupLayout jPanelLogInLayout = new javax.swing.GroupLayout(this);
        setLayout(jPanelLogInLayout);
        jPanelLogInLayout.setHorizontalGroup(
            jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogInLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLogInLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogInLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogInLayout.createSequentialGroup()
                        .addComponent(jPanel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLogInLayout.createSequentialGroup()
                        .addGroup(jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameField)
                            .addComponent(passwordField)
                            .addComponent(showPass_Box)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
        );

        jPanelLogInLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        jPanelLogInLayout.setVerticalGroup(
            jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLogInLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showPass_Box)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanelLogInLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});
        
        try {
			Image image = ImageIO.read(new File("Data/File/Images/profile.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(image.getScaledInstance(100, 100, 0)));
			jPanel_Image.add(picLabel);
			jPanel_Image.repaint();
        } catch (IOException e) {}
        
	}            
                                
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.remove(this);
		topFrame.add(SignUpLogInFrame.getSignUpForm());
		topFrame.pack();
		topFrame.repaint();
    }

    
    private void LOGIN_ActionPerformed() {                    
    	
    	Connection conn = database.getConnection();
    	PreparedStatement ps;
    	
    	try {
			ps = conn.prepareStatement("SELECT `nickname`, `password` FROM `users` WHERE `nickname` = ? AND `password` = ?");
	    	ps.setString(1, usernameField.getText());
	    	ps.setString(2, String.valueOf(passwordField.getPassword()));
	    	
	    	ResultSet result = ps.executeQuery();
	    	if(result.next()) {
	    		System.out.println("You have been successfully logged in");
	    		SwingUtilities.getWindowAncestor(this).dispose();
	    		Game game = new Game(result.getString("nickname"), "Shareland", 640, 360);
	    		game.start();
	    	}
	    	else {
	    		jLabel1.setText("Login Failed!  ");
	    		count=0;
	    		timer1.start();
	    	}
		} catch (SQLException e) {}
    }
    
    private void showPass_BoxActionPerformed(ActionEvent evt) {                                           
    	passwordField.setEchoChar( showPass_Box.isSelected() ? (char)0 : '*');
    }
    
    private void checkProfilePicture() throws IOException {
    	Connection conn = database.getConnection();
    	PreparedStatement ps;
    	
    	try {
			ps = conn.prepareStatement("SELECT picture FROM `users` WHERE `nickname` = ?");
	    	ps.setString(1, usernameField.getText());
	    	
	    	ResultSet result = ps.executeQuery();
	    	if(result.next()) {
	    		try {
	 	    		InputStream is = result.getBinaryStream(1);
	    			Image image = ImageIO.read(is);
	    			((JLabel)jPanel_Image.getComponent(0)).setIcon(new ImageIcon(image.getScaledInstance(100, 100, 0)));
	    			jPanel_Image.repaint();
	    		} catch (IOException e) {}
	    	}
	    	
	    	else {
	    		try {
	    			Image image = ImageIO.read(new File("Data/File/Images/profile.jpg"));
	    			((JLabel)jPanel_Image.getComponent(0)).setIcon(new ImageIcon(image.getScaledInstance(100, 100, 0)));
	    			jPanel_Image.repaint();
	            } catch (IOException e) {}
	    	}
		} catch (SQLException e) { e.printStackTrace();}
    }
    
    public JPanel getJPanelImage() { return jPanel_Image; }
    
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;	
	private javax.swing.JButton jButton4;
	private javax.swing.JCheckBox showPass_Box;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel_Image;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JTextField usernameField;
	private Timer timer1;
	private int count=0;
     
}