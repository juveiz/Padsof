package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchMarkView {
	private JFrame view;
	private JPanel view2;
	private JPanel pair1;
	private JPanel pair2;
	private JPanel pair3;
	private JPanel buttons;
	private JPanel down;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton search;
	private JTextField introduce;
	private JLabel text;
	private JLabel firma;
	private JButton back;
	private JPanel exit;
	private JLabel welcome;
	private JPanel view3;
	
	public SearchMarkView() {
		/*We declare the panels*/
		view = new JFrame("Search");
		view2 = new JPanel();
		pair1 = new JPanel();
		pair2 = new JPanel();
		pair3 = new JPanel();
		buttons = new JPanel();
		down = new JPanel();
		exit = new JPanel();
		welcome = new JLabel("Choose a kind of search");
		welcome.setFont(new Font("TimeRoman",30,30));
		view3 = new JPanel();
		
		/*We choose the layouts*/
		Container cont = view.getContentPane();
		view2.setLayout(new BorderLayout());
		pair1.setLayout(new FlowLayout());
		pair2.setLayout(new FlowLayout());
		pair3.setLayout(new FlowLayout());
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		down.setLayout(new FlowLayout());
		exit.setLayout(new FlowLayout());
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);		
		border.setVgap(20);
		border.setHgap(100);
		
		BorderLayout border2 = new BorderLayout();
		view3.setLayout(border2);		
		border2.setVgap(20);
		border2.setHgap(100);
		
		/*Buttons panel*/
		one = new JButton("Search by zip");
		two = new JButton("Search by date");
		three = new JButton("Search by type");
		four = new JButton("Search by mark");
		five = new JButton("Search reserved");
		six = new JButton("Search bought");
		pair1.add(one);
		pair1.add(four);
		pair2.add(two);
		pair2.add(five);
		pair3.add(three);
		pair3.add(six);		
		buttons.add(pair1);
		buttons.add(pair2);
		buttons.add(pair3);
		
		/*Down below panel*/
		search = new JButton("Search");
		introduce = new JTextField(10);
		text = new JLabel("Introduce mark");
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
	    
	    view3.add(view2,BorderLayout.CENTER);
	    view3.add(welcome,BorderLayout.NORTH);
	    view3.add(new JPanel(),BorderLayout.EAST);
	    view3.add(new JPanel(),BorderLayout.WEST);
	    view3.add(new JPanel(),BorderLayout.SOUTH);
	    
		/*Global panel*/
		back = new JButton("Back");
		exit.add(back);
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(firma, BorderLayout.NORTH);
		cont.add(view3,BorderLayout.CENTER);
		cont.add(exit, BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.EAST);
	    cont.add(new JPanel(),BorderLayout.WEST);
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
		four.addActionListener(c);
		five.addActionListener(c);
		six.addActionListener(c);
		back.addActionListener(c);
	}
	
	
	
}

