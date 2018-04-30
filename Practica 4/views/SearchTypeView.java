package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchTypeView {
	private JFrame view;
	private JPanel view2;
	private JPanel pair1;
	private JPanel pair2;
	private JPanel pair3;
	private JPanel radiobuttons;
	private JPanel down;
	private JRadioButton one;
	private JRadioButton two;
	private JRadioButton three;
	private JRadioButton four;
	private JRadioButton five;
	private JRadioButton six;
	private JButton search;
	private JComboBox combo;
	private JLabel text;
	private JLabel firma;
	
	public SearchTypeView() {
		/*We declare the panels*/
		view = new JFrame("Search");
		view2 = new JPanel();
		pair1 = new JPanel();
		pair2 = new JPanel();
		pair3 = new JPanel();
		radiobuttons = new JPanel();
		down = new JPanel();
		
		/*We choose the layouts*/
		Container cont = view.getContentPane();
		cont.setLayout(new BorderLayout());
		view2.setLayout(new BorderLayout());
		pair1.setLayout(new FlowLayout());
		pair2.setLayout(new FlowLayout());
		pair3.setLayout(new FlowLayout());
		radiobuttons.setLayout(new BoxLayout(radiobuttons, BoxLayout.PAGE_AXIS));
		down.setLayout(new FlowLayout());
		
		/*RadioButtons panel*/
		JRadioButton one = new JRadioButton("Search by zip");
		JRadioButton two = new JRadioButton("Search by date");
		JRadioButton three = new JRadioButton("Search by type");
		JRadioButton four = new JRadioButton("Search by mark");
		JRadioButton five = new JRadioButton("Search reserved");
		JRadioButton six = new JRadioButton("Search bought");
		ButtonGroup group = new ButtonGroup();
		group.add(one);
		group.add(two);
		group.add(three);
		group.add(four);
		group.add(five);
		group.add(six);
		pair1.add(one);
		pair1.add(four);
		pair2.add(two);
		pair2.add(five);
		pair3.add(three);
		pair3.add(six);		
		radiobuttons.add(pair1);
		radiobuttons.add(pair2);
		radiobuttons.add(pair3);
		two.setSelected(true);
		
		/*Down below panel*/
		search = new JButton("Search");
		String[] types = {"Living", "Vacational"};
		JComboBox<String> combo = new JComboBox<String>(types);
		text = new JLabel("Select the type");
		down.add(text);
		down.add(combo);
		down.add(search);
		
		/*View2 panel*/
		view2.add(radiobuttons,BorderLayout.NORTH);
		view2.add(down,BorderLayout.CENTER);
		
		/*Global panel*/
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("TimeRoman",50,50));
		cont.add(firma, BorderLayout.NORTH);
		cont.add(view2,BorderLayout.CENTER);
		view.pack();
		view.setSize(1000,500);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setVisible(boolean dec) {
		view.setVisible(dec);
	}
	
	public String getTyoe() {
		return combo.getActionCommand();
	}
	
	public void setControlador(ActionListener c) {
		search.addActionListener(c);
		two.addActionListener(c);
		three.addActionListener(c);
		four.addActionListener(c);
		five.addActionListener(c);
		six.addActionListener(c);
	}
	
	
	
}