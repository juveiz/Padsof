package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import comments.Comment;
import comments.Text;
import exception.GuestException;
import system.Application;
import views.CommentListView;

public class CommentListController implements ActionListener {
	
	private Application app;
	private CommentListView view;
	private int firstComment;
	private List<Comment> comments;
	
	public CommentListController(CommentListView view,int firstComment,List<Comment> comments) {
		app = Application.getInstance();
		this.view = view;
		this.firstComment = firstComment;
		this.comments = comments;
	}
	
	private void aux1(int i) {
		if(this.comments.get(i + this.firstComment).isText()) {
			CommentListView nV = new CommentListView(((Text) this.comments.get(i + this.firstComment)).getComments(), 0);
			CommentListController nC = new CommentListController(nV, 0, ((Text) this.comments.get(i + this.firstComment)).getComments());
			nV.setControlador(nC);
			this.view.setVisible(false);
			nV.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "There are no comments to a rate", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void aux2(int i) {
		String comment = JOptionPane.showInputDialog(null, "Introduce the comment");
		if (comment == "") {
			JOptionPane.showMessageDialog(null, "Please, introduce a comment", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (comment == null) {
			return;
		}
		if(this.comments.get(i + this.firstComment).isText()) {
			try {
				((Text) this.comments.get(i + this.firstComment)).commentComments(comment, app.getLoggedUser());
				JOptionPane.showMessageDialog(null, "Comment added");
			} catch (GuestException e) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(null, "You can't comment a rate", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		switch (button.getActionCommand()) {
		case "See comments 0":
			this.aux1(0);
			break;
		case "See comments 1":
			this.aux1(1);
			break;
		case "See comments 2":
			this.aux1(2);
			break;
		case "See comments 3":
			this.aux1(3);
			break;
		case "See comments 4":
			this.aux1(4);
			break;
		case "Make comment 0":
			this.aux2(0);
			break;
		case "Make comment 1":
			this.aux2(1);
			break;
		case "Make comment 2":
			this.aux2(2);
			break;
		case "Make comment 3":
			this.aux2(3);
			break;
		case "Make comment 4":
			this.aux2(4);
			break;
		case ">>>":
			if(this.firstComment + 5 >= view.getComments().size()) {
				JOptionPane.showMessageDialog(null, "There are no more comments", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				CommentListView nV = new CommentListView(this.view.getComments(), this.firstComment + 5);
				CommentListController nC = new CommentListController(nV, this.firstComment + 5, this.view.getComments());
				nV.setControlador(nC);
				this.view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "<<<":
			if(this.firstComment - 5 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more comments", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				CommentListView nV = new CommentListView(this.view.getComments(), this.firstComment - 5);
				CommentListController nC = new CommentListController(nV, this.firstComment - 5, this.view.getComments());
				nV.setControlador(nC);
				this.view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "Back":
		}

	}

}
