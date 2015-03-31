package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import base.*;
import blog.*;

public class BlogGUI implements ActionListener{
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	
	public BlogGUI(){
		
	}
	
	public void setWindow(){
		mainFrame = new JFrame("Your Name");
		mainFrame.setSize(800, 850);
		mainFrame.setLayout(new BorderLayout());
		
		Dimension prefreredSize = new Dimension(385,80);
		Dimension pTASize = new Dimension(700,360);
		Dimension pTCSize = new Dimension(700,360);
		
		Border pTABorder = new TitledBorder(null, "Please input your text here:");
		
		postTextArea = new JTextArea("");
		postTextArea.setPreferredSize(pTASize);
		postTextArea.setBorder(pTABorder);
		postTextArea.setBackground(Color.white);
		
		JPanel ButtonPanel = new JPanel();
		post = new JButton("post");
		post.setPreferredSize(prefreredSize);
		post.setFont(post.getFont().deriveFont(25.0f));
		post.setBorder(BorderFactory.createLineBorder(Color.black));
		post.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				postContent.setText("you click the post!");
			}
		});
		refresh = new JButton("refresh");
		refresh.setPreferredSize(prefreredSize);
		refresh.setFont(post.getFont().deriveFont(25.0f));
		refresh.setBorder(BorderFactory.createLineBorder(Color.black));
		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				postContent.setText("Refresh!");
			}
		});
		ButtonPanel.add(post);
		ButtonPanel.add(refresh);
//		ButtonPanel.setPreferredSize(new Dimension(800, 80));
		
		postContent = new JTextField("Here is all the post");
		postContent.setPreferredSize(pTCSize);
		postContent.setBorder(new TitledBorder(null, "Here is all of posts:"));
		postContent.setEditable(false);
		postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setFont(post.getFont().deriveFont(25.0f));
		
		mainFrame.add(postTextArea, BorderLayout.NORTH);
//		mainFrame.add(post, BorderLayout.WEST);
//		mainFrame.add(refresh, BorderLayout.EAST);
		mainFrame.add(ButtonPanel, BorderLayout.CENTER);
		mainFrame.add(postContent, BorderLayout.SOUTH);
		mainFrame.setVisible(true);
	}
	
	
	
	public static void main(String[] args){
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
