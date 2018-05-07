package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddLivingView {
	private JFrame main;
	private JLabel addOffer;
	private JPanel view2;
	private JPanel view3;
	private JPanel add;
	private JPanel iniDate;
	private JTextField iniDateField;
	private JPanel price;
	private JTextField priceField;
	private JPanel months;
	private JTextField monthsField;
	private JPanel buttons;
	private JButton accept;
	private JButton cancel;
	private JLabel firma;
	
	public AddLivingView() {
		main = new JFrame("Add Living Offer");
		addOffer = new JLabel("Add the paramters to make an offer");
		add = new JPanel(new GridLayout(3,1,0,5));
		iniDate =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		iniDateField = new JTextField(10);
		price =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		priceField = new JTextField(10);
		months =  new JPanel(new FlowLayout(FlowLayout.LEFT));
		monthsField = new JTextField(10);
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		view2 = new JPanel();
		view3 = new JPanel();
		
		iniDate.add(new JLabel("Initial date (YYYY-MM-DD):  "));
		iniDate.add(iniDateField);
		
		  price.add(new JLabel("Price:           "));
		price.add(priceField);
		
		 months.add(new JLabel("Months:       "));
		months.add(monthsField);
		
		add.add(iniDate);
		add.add(price);
		add.add(months);
		
		addOffer.setFont(new Font("TimeRoman",30,30));
		
		buttons.add(accept);
		buttons.add(cancel);
		
		Container cont = main.getContentPane();
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		BorderLayout border2 = new BorderLayout();
		view2.setLayout(border2);
		BorderLayout border3 = new BorderLayout();
		view3.setLayout(border3);
		
		border.setVgap(50);
		border.setHgap(100);
		border2.setVgap(50);
		border2.setHgap(100);
		border3.setVgap(50);
		border3.setHgap(100);
		
		view3.add(addOffer, BorderLayout.NORTH);
		view3.add(add, BorderLayout.CENTER);		
		
		view2.add(view3, BorderLayout.CENTER);
		view2.add(buttons,BorderLayout.SOUTH);
		view2.add(new JPanel(),BorderLayout.WEST);
		view2.add(new JPanel(),BorderLayout.EAST);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(firma,BorderLayout.NORTH);
		cont.add(view2,BorderLayout.CENTER);
		/*This will center the JFrame*/
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - main.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - main.getHeight()) / 4);
	    main.setLocation(x, y);
	    
		main.pack();
		main.setSize(1000,500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
	
	public void setControlador(ActionListener c) {
		accept.addActionListener(c);
		cancel.addActionListener(c);
	}
	
	public String getIniDate() {
		return iniDateField.getText();
	}
	
	public String getPrice() {
		return priceField.getText();
	}
	
	public String getMonths() {
		return monthsField.getText();
	}
}
