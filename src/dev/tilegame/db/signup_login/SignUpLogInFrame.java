package dev.tilegame.db.signup_login;

import javax.swing.JFrame;

public class SignUpLogInFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static LogInForm login = new LogInForm();
	private static SignUpForm signup = new SignUpForm();
	
	public SignUpLogInFrame() {
		setTitle("Sign Up / Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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
