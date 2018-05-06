package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SearchDate2View {
	private JFrame view;
	private JPanel view2;
	private JPanel view3;
	private JPanel buttons;
	private JPanel down;
	private JPanel begin;
	private JPanel end;
	private JPanel exit;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton search;
	private JButton back;
	private JComboBox<String> days1;
	private JComboBox<String> days2;
	private JComboBox<String> months1;
	private JComboBox<String> months2;
	private JComboBox<String> years1;
	private JComboBox<String> years2;
	private JLabel text1;
	private JLabel text2;
	private JLabel firma;
	private JLabel welcome;
	private JPanel view4;
	
	public SearchDate2View() {
		/*We declare the panels*/
		view = new JFrame("Search");
		view2 = new JPanel();
		view3 = new JPanel();
		buttons = new JPanel();
		down = new JPanel();
		begin = new JPanel();
		end = new JPanel();
		exit = new JPanel();
		welcome = new JLabel("Choose a kind of search");
		welcome.setFont(new Font("TimeRoman",30,30));
		view4 = new JPanel();
		
		/*We choose the layouts*/
		Container cont = view.getContentPane();
		view2.setLayout(new BorderLayout());
		view3.setLayout(new BorderLayout());
		buttons.setLayout(new FlowLayout());
		down.setLayout(new BoxLayout(down, BoxLayout.PAGE_AXIS));
		begin.setLayout(new FlowLayout());
		end.setLayout(new FlowLayout());
		exit.setLayout(new FlowLayout());
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);		
		border.setVgap(20);
		border.setHgap(100);
		
		BorderLayout border2 = new BorderLayout();
		view4.setLayout(border2);		
		border2.setVgap(20);
		border2.setHgap(100);
		
		/*RadioButtons panel*/
		one = new JButton("Search by zip");
		two = new JButton("Search by date");
		three = new JButton("Search by type");	
		buttons.add(one);
		buttons.add(two);
		buttons.add(three);
		
		/*Down below panel*/
		search = new JButton("Search");
		String[] days = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String[] years = {"2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
		days1 = new JComboBox<String>(days);
		days2 = new JComboBox<String>(days);
		months1 = new JComboBox<String>(months);
		months2 = new JComboBox<String>(months);
		years1 = new JComboBox<String>(years);
		years2 = new JComboBox<String>(years);
		text1 = new JLabel("Select the beginning date");
		text2 = new JLabel("Select the ending date");
		begin.add(text1);
		begin.add(days1);
		begin.add(months1);
		begin.add(years1);
		end.add(text2);
		end.add(days2);
		end.add(months2);
		end.add(years2);
		down.add(begin);
		down.add(end);
		down.add(search);
		
		/*View2 panel*/
		view3.add(buttons,BorderLayout.NORTH);
		view3.add(down,BorderLayout.SOUTH);
		view2.add(view3,BorderLayout.NORTH);
		
		/*This will center the JFrame*/
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - view.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - view.getHeight()) / 4);
	    view.setLocation(x, y);
	    
	    view4.add(view2,BorderLayout.CENTER);
	    view4.add(welcome,BorderLayout.NORTH);
	    view4.add(new JPanel(),BorderLayout.EAST);
	    view4.add(new JPanel(),BorderLayout.WEST);
	    view4.add(new JPanel(),BorderLayout.SOUTH);
	    
		/*Global panel*/
		back = new JButton("Login");
		exit.add(back);
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(firma, BorderLayout.NORTH);
		cont.add(view4,BorderLayout.CENTER);
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
	
	public LocalDate getIniDate() throws Exception{
		LocalDate ini;
		String date;
		date = years1.getSelectedItem().toString() + "-" + months1.getSelectedItem().toString() + "-" + days1.getSelectedItem().toString();
		ini = LocalDate.parse(date);
		return ini;
	}
	
	public LocalDate getEndDate() throws Exception{
		LocalDate fin;
		String date;
		date = years2.getSelectedItem().toString() + "-" + months2.getSelectedItem().toString() + "-" + days2.getSelectedItem().toString();
		fin = LocalDate.parse(date);
		return fin;
	}
	
	public void setControlador(ActionListener c) {
		search.addActionListener(c);
		one.addActionListener(c);
		two.addActionListener(c);
		three.addActionListener(c);
		back.addActionListener(c);
	}
	
	
	
}