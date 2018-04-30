package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchZipView {
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
	
	public SearchZipView() {
		/*We declare the panels*/
		view = new JFrame("Search");
		view2 = new JPanel();
		pair1 = new JPanel();
		pair2 = new JPanel();
		pair3 = new JPanel();
		buttons = new JPanel();
		down = new JPanel();
		exit = new JPanel();
		
		/*We choose the layouts*/
		Container cont = view.getContentPane();
		cont.setLayout(new BorderLayout());
		view2.setLayout(new BorderLayout());
		pair1.setLayout(new FlowLayout());
		pair2.setLayout(new FlowLayout());
		pair3.setLayout(new FlowLayout());
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		down.setLayout(new FlowLayout());
		exit.setLayout(new FlowLayout());
		
		/*RadioButtons panel*/
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
		text = new JLabel("Introduce zip code");
		down.add(text);
		down.add(introduce);
		down.add(search);
		
		/*View2 panel*/
		view2.add(buttons,BorderLayout.NORTH);
		view2.add(down,BorderLayout.CENTER);
		
		/*Global panel*/
		back = new JButton("Back");
		exit.add(back);
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("TimeRoman",50,50));
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
		four.addActionListener(c);
		five.addActionListener(c);
		six.addActionListener(c);
		back.addActionListener(c);
	}
	
	
	
}
