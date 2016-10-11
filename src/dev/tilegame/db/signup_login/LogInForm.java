package dev.tilegame.db.signup_login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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

import dev.tilegame.Game;

public class LogInForm extends JPanel {
	
	public LogInForm() {
		initComponents();
	}
	
	private void initComponents() {
		setBackground(new java.awt.Color(36, 51, 60));
		
        jLabel1 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel_Image = new javax.swing.JPanel();
	
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
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(0, 0, 0));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(26, 177, 136), 2));
        passwordField.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordField.setOpaque(false);

        jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Show password");
        jCheckBox1.setBorder(null);
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Remember my password");
        jCheckBox2.setBorder(null);
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
                            .addComponent(jCheckBox2)
                            .addComponent(usernameField)
                            .addComponent(passwordField)
                            .addComponent(jCheckBox1)
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
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanelLogInLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});
        
        try {
			Image image = ImageIO.read(new File("Data/File/Images/profile.jpg")).getScaledInstance(100, 100, 0);
			JLabel picLabel = new JLabel(new ImageIcon(image));
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
    	
    	Connection conn = Game.database.getConnection();
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
	    	else System.out.println("Wrong Nickname or Password");
		} catch (SQLException e) {}
  }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {}        
    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {}                                          
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {}                                          
    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {}
    
    public JPanel getJPanelImage() { return jPanel_Image; }
    
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;	
	private javax.swing.JButton jButton4;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JCheckBox jCheckBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel_Image;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JTextField usernameField;
     
}