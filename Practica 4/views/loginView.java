package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class loginView {
	private JFrame view2;
	private JPanel view;
	private JPanel buttons;
	private JPanel texts;
	private JPanel userp;
	private JPanel passwordp;
	private JButton login;
	private JButton nologin;
	private JLabel usuario;
	private JLabel contrasenia;
	private JLabel firma;
	private JTextField user;
	private JPasswordField password;

	public loginView() {
		view2 = new JFrame("Login");
		view = new JPanel();
		buttons = new JPanel();
		texts = new JPanel();
		userp = new JPanel();
		passwordp = new JPanel();
		
		
		Container cont=view2.getContentPane();
		cont.setLayout(new BorderLayout());
		view.setLayout(new BorderLayout());
		texts.setLayout(new BorderLayout());
		buttons.setLayout(new FlowLayout());
		userp.setLayout(new FlowLayout());
		passwordp.setLayout(new FlowLayout());

		login = new JButton("Login");
		nologin = new JButton("No Login");
		buttons.add(login);
		buttons.add(nologin);

		user = new JTextField(10);
		password = new JPasswordField(10);
		user.setText("54444111D");
		password.setText("olvidame");
		usuario = new JLabel("User: ");
		contrasenia = new JLabel("Password: ");
		userp.add(usuario);
		userp.add(user);
		passwordp.add(contrasenia);
		passwordp.add(password);		
		
		texts.add(userp, BorderLayout.NORTH);
		texts.add(passwordp, BorderLayout.SOUTH);

		view.add(texts, BorderLayout.NORTH);
		view.add(buttons, BorderLayout.CENTER);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("TimeRoman",50,50));
		cont.add(firma, BorderLayout.NORTH);
		cont.add(view, BorderLayout.CENTER);
		
		view2.pack();
		view2.setSize(1000,500);
		
		view2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		view2.setVisible(dec);
	}
	
	public String getUser() {
		return user.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return password.getText();
	}
	
	public void setControlador(ActionListener c) {
		login.addActionListener(c);
		nologin.addActionListener(c);
	}
}
