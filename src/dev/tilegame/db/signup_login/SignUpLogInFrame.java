package dev.tilegame.db.signup_login;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dev.tilegame.Game;

public class SignUpLogInFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static LogInForm login = new LogInForm();
	private static SignUpForm signup = new SignUpForm();
	
	public SignUpLogInFrame(Game game) {
		login.setGame(game);
		setTitle("Shareland LogIn/SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(400, 50);
		setBackground(new java.awt.Color(36, 51, 60));
		setForeground(new java.awt.Color(36, 51, 60));
		setResizable(false);
		
		add(SignUpLogInFrame.login);
		pack();


		setServerInfo();
		setVisible(true);
	}
	
	public static LogInForm getLoginForm() { return SignUpLogInFrame.login; }
	public static SignUpForm getSignUpForm() { return SignUpLogInFrame.signup; }
	
	private void setServerInfo() {
		Game.serverAddress = JOptionPane.showInputDialog("Please enter server ip address (es. 192.168.1.1)");
		if(Game.serverAddress!=null){
			String port = JOptionPane.showInputDialog("Please enter server port (es. 1331)");
			if(port!=null) {
				try { Game.serverPort = Integer.parseInt(port);
				} catch(Exception e) { System.exit(0); }
			}
			else System.exit(0);
		}
		else System.exit(0);
	}
}