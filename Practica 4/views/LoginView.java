package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView {
	private JFrame view2;
	private JPanel view3;
	private JPanel view;
	private JPanel buttons;
	private JPanel texts;
	private JPanel userp;
	private JPanel passwordp;
	private JPanel south;
	private JButton login;
	private JButton adminLogin;
	private JButton nologin;
	private JLabel usuario;
	private JLabel contrasenia;
	private JLabel firma;
	private JTextField user;
	private JPasswordField password;
	private JLabel authors;

	public LoginView() {
		view2 = new JFrame("Login");
		view3 = new JPanel();
		view = new JPanel();
		buttons = new JPanel();
		texts = new JPanel();
		userp = new JPanel();
		passwordp = new JPanel();
		south = new JPanel();
		
		BorderLayout border = new BorderLayout();
		Container cont=view2.getContentPane();
		cont.setLayout(border);
		border.setVgap(100);
		border.setHgap(100);
		
		BorderLayout border2 = new BorderLayout();
		south.setLayout(border2);
		border.setVgap(100);
		border.setHgap(100);
		
		south.setLayout(new FlowLayout());
		view.setLayout(new BorderLayout());
		texts.setLayout(new BorderLayout());
		buttons.setLayout(new FlowLayout());
		userp.setLayout(new FlowLayout());
		passwordp.setLayout(new FlowLayout());
		view3.setLayout(new BorderLayout());
		
		login = new JButton("Login");
		adminLogin = new JButton("Admin Login");
		nologin = new JButton("No Login");
		buttons.add(login);
		buttons.add(adminLogin);
		buttons.add(nologin);

		user = new JTextField(10);
		password = new JPasswordField(10);
		user.setText("51999111X");
		password.setText("pezEspada");
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
		firma.setFont(new Font("Brush Script MT",50,50));
		firma.setHorizontalAlignment(JTextField.CENTER);		
		view3.add(firma, BorderLayout.NORTH);
		view3.add(view, BorderLayout.CENTER);
		
		authors = new JLabel("A proyect by Juan Velasco and Miguel Angel Sanchez");
		south.add(authors,BorderLayout.CENTER);
		
		cont.add(new JPanel(),BorderLayout.NORTH);
		cont.add(view3,BorderLayout.CENTER);
		cont.add(south,BorderLayout.SOUTH);
		
		/*This will center the JFrame*/
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - view2.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - view2.getHeight()) / 4);
	    view2.setLocation(x, y);
		
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
		adminLogin.addActionListener(c);
		nologin.addActionListener(c);
	}
}
