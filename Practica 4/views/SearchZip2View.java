package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchZip2View {
	private JFrame view;
	private JPanel view2;
	private JPanel buttons;
	private JPanel down;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton search;
	private JTextField introduce;
	private JLabel text;
	private JLabel firma;
	private JButton back;
	private JPanel exit;
	
	public SearchZip2View() {
		/*We declare the panels*/
		view = new JFrame("Search");
		view2 = new JPanel();
		buttons = new JPanel();
		down = new JPanel();
		exit = new JPanel();
		
		/*We choose the layouts*/
		Container cont = view.getContentPane();
		cont.setLayout(new BorderLayout());
		view2.setLayout(new BorderLayout());
		buttons.setLayout(new FlowLayout());
		down.setLayout(new FlowLayout());
		exit.setLayout(new FlowLayout());
		
		/*RadioButtons panel*/
		one = new JButton("Search by zip");
		two = new JButton("Search by date");
		three = new JButton("Search by type");	
		buttons.add(one);
		buttons.add(two);
		buttons.add(three);		
		
		/*Down below panel*/
		search = new JButton("Search");
		introduce = new JTextField(10);
		text = new JLabel("Introduce zip code");
		down.add(text);
		down.add(introduce);
		down.add(search);
		
		/*View2 panel*/
		view2.add(buttons,BorderLayout.NORTH);
		view2.add(down,BorderLayout.CENTER);
		
		/*This will center the JFrame*/
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - view.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - view.getHeight()) / 4);
	    view.setLocation(x, y);
	    
		/*Global panel*/
		back = new JButton("Login");
		exit.add(back);
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(firma, BorderLayout.NORTH);
		cont.add(view2,BorderLayout.CENTER);
		cont.add(exit, BorderLayout.SOUTH);
		view.pack();
		view.setSize(1000,500);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setVisible(boolean dec) {
		view.setVisible(dec);
	}
	
	public String getZip() {
		return introduce.getText();
	}
	
	public void setControlador(ActionListener c) {
		search.addActionListener(c);
		one.addActionListener(c);
		two.addActionListener(c);
		three.addActionListener(c);
		back.addActionListener(c);
	}
	
	
	
}
