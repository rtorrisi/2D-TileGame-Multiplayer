package dev.tilegame.db.signup_login;

import javax.swing.JFrame;

public class SignUpLogInFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static LogInForm login = new LogInForm();
	private static SignUpForm signup = new SignUpForm();
	
	public SignUpLogInFrame() {
		
		setTitle("Shareland LogIn/SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 50);
		setBackground(new java.awt.Color(36, 51, 60));
		setForeground(new java.awt.Color(36, 51, 60));
		setResizable(false);
		
		add(SignUpLogInFrame.login);
		pack();

		setVisible(true);
	}
	
	public static LogInForm getLoginForm() { return SignUpLogInFrame.login; }
	public static SignUpForm getSignUpForm() { return SignUpLogInFrame.signup; }
}


/*
public class Java_Form_Login extends javax.swing.JFrame {
                             
    private void initComponents() {
        jLabel1.setText("Username :");
        jLabel2.setText("Password :");
        jTextField_Username.setFont(new java.awt.Font("Tahoma", 0, 14));
        jCheckBox1.setText("Show Password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
                                     

    private void jButton_OkActionPerformed(java.awt.event.ActionEvent evt) {                                           
    
        timer2.start();
    }                                          

// Show And Hide Password Using jCheckBox
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           

        if(jCheckBox1.isSelected()){
            jPasswordField_Password.setEchoChar((char)0);
        }else{
          jPasswordField_Password.setEchoChar('*');
        }
    }                                          

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Java_Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java_Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java_Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java_Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java_Form_Login().setVisible(true);
            }
        });
                    
}*/
