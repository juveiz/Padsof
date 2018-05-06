package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import comments.*;

public class CommentListView {
	private int firstComment;
	private List<Comment> comments;
	private JFrame main;
	private List<JPanel> offerPanel;
	private List<JButton> offerButtons;
	private JPanel north;
	private JLabel title;
	private JLabel header;
	private JPanel center;
	private JPanel view2;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JLabel firma;
	
	public CommentListView(List<Comment> comments,int firstComment) {
		this.comments = comments;
		this.firstComment = firstComment;
		
		main = new JFrame("Offers");
		center = new JPanel();
		view2 = new JPanel();
		north = new JPanel(new BorderLayout());
		title = new JLabel("Comments");
		header = new JLabel(" Comment/Rate                                          User");
		buttons = new JPanel(new FlowLayout());
		next = new JButton(">>>");
		previous = new JButton("<<<");
		back = new JButton("Back");
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		offerPanel = new ArrayList<>();
		offerButtons = new ArrayList<>();
		
		int maxComments = 5;
		if(comments.size() - firstComment < 5) {
			maxComments = comments.size() - firstComment;
		}
		
		for(int i = 0; i < maxComments; i++) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel user;
			JTextArea comment;
			JButton seeComments,makeComment;
			
			datos = new JPanel(new GridLayout(0,2,10,0));
			buttonsp = new JPanel(new GridLayout(0,2,5,0));
			
			user = new JLabel(comments.get(i + this.firstComment).getGuest().getName());
			if (comments.get(i + this.firstComment).isText()) {
				comment = new JTextArea(((Text) comments.get(i + this.firstComment)).getText());
			}else {
				comment = new JTextArea(((Numerical) comments.get(i + this.firstComment)).getRate() + "");
			}
			
			comment.setEditable(false);
			comment.setLineWrap(true);
			comment.setWrapStyleWord(true);
			JScrollPane pan = new JScrollPane(comment);
			
			datos.add(pan);
			datos.add(user);
			
			seeComments = new JButton("See comments " + i);
			makeComment = new JButton("Make comment " + i);
			
			buttonsp.add(seeComments);
			offerButtons.add(seeComments);
			buttonsp.add(makeComment);
			offerButtons.add(makeComment);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
			
			offerPanel.add(panel);
			
		}
		
		buttons.add(previous);
		buttons.add(next);
		buttons.add(back);
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(20);
		border.setHgap(20);
		cont.setLayout(border);
		BorderLayout border2 = new BorderLayout();
		view2.setLayout(border2);
		
		GridLayout grid = new GridLayout(5,1,0,10);
		center.setLayout(grid);
		for(JPanel panel: offerPanel) {
			center.add(panel);
		}
		
		view2.add(center,BorderLayout.CENTER);
		title.setFont(new Font("TimeRoman",30,30));
		header.setFont(new Font("TimeRoman",20,20));
		north.add(title,BorderLayout.NORTH);
		north.add(header,BorderLayout.SOUTH);
		
		view2.add(buttons, BorderLayout.SOUTH);
		view2.add(new JPanel(),BorderLayout.EAST);
		view2.add(new JPanel(),BorderLayout.WEST);
		view2.add(north,BorderLayout.NORTH);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(view2,BorderLayout.CENTER);
		cont.add(firma,BorderLayout.NORTH);
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		
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
		for(JButton button: offerButtons) {
			button.addActionListener(c);
		}
		next.addActionListener(c);
		back.addActionListener(c);
		previous.addActionListener(c);
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
}
