package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import base.*;
import blog.*;

public class BlogGUI implements ActionListener, KeyListener{
	
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private JLabel label;
	int wordlength = 140;
	private User user = new User(1, "Ocean", "hyyungaa@ust.hk");
	private Blog myBlog = new Blog(user);
	
	public BlogGUI(){
		
	}
	
	public void setWindow(){
		mainFrame = new JFrame("Your Name");
		mainFrame.setSize(800, 850);
		mainFrame.setLayout(new BorderLayout());
		
		Dimension prefreredSize = new Dimension(385,80);
		Dimension pTASize = new Dimension(700,360);
		Dimension pTCSize = new Dimension(700,360);
		
		label = new JLabel("You can still input " + wordlength + " Characters");
//		Border pTABorder = new TitledBorder(null, "Please input your text here:");
		
		
		postTextArea = new JTextArea("");
		postTextArea.setPreferredSize(pTASize);
//		postTextArea.setBorder(pTABorder);
		postTextArea.setBackground(Color.white);
		postTextArea.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e){				
			}
			
			@Override
			public void keyPressed(KeyEvent e){				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				wordlength = 140 - postTextArea.getText().length();
				if(wordlength>=0){
					label.setText("You can still input " + wordlength + " Characters");
				}
				else
					label.setText("Your post length has exceeded 140!");
				
			}
		});
		
		JPanel pTAmix = new JPanel();
		pTAmix.setLayout(new BorderLayout());
		pTAmix.add(label, BorderLayout.NORTH);
		pTAmix.add(postTextArea, BorderLayout.SOUTH);
		
		JPanel ButtonPanel = new JPanel();
		post = new JButton("post");
		post.setPreferredSize(prefreredSize);
		post.setFont(post.getFont().deriveFont(25.0f));
		post.setBorder(BorderFactory.createLineBorder(Color.black));
		post.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String content = postTextArea.getText();
				if(content.isEmpty()||content.length()>140){
					System.out.println("Please input a proper message!");
				}
				else{
					Date date = new Date();
					Post post = new Post(date, content);
					myBlog.post(post);
					String savefilepath="C:/Users/hyyungaa.CSD/Desktop/"+user.getUserName()+".blog";
					myBlog.save(savefilepath);
					postContent.setText(myBlog.print());
					postTextArea.setText("");
					wordlength = 140;
					label.setText("You can still input " + wordlength + " Characters");
				}
			}
		});
		refresh = new JButton("refresh");
		refresh.setPreferredSize(prefreredSize);
		refresh.setFont(post.getFont().deriveFont(25.0f));
		refresh.setBorder(BorderFactory.createLineBorder(Color.black));
		refresh.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
				String loadfilepath="C:/Users/hyyungaa.CSD/Desktop/"+user.getUserName()+".blog";
				Blog newblog = new Blog(user);
				newblog.load(loadfilepath);
				myBlog = newblog;
				postContent.setText(myBlog.print());
				}catch(Exception q){
					System.out.println("It is a error!!");
				}
			}
		});
		ButtonPanel.add(post);
		ButtonPanel.add(refresh);
//		ButtonPanel.setPreferredSize(new Dimension(800, 80));
		
		postContent = new JTextArea("Here is all the post");
		postContent.setPreferredSize(pTCSize);
		postContent.setBorder(new TitledBorder(null, "Here is all of posts:"));
		postContent.setEditable(false);
//		postContent.setHorizontalAlignment(JTextField.LEFT);
		postContent.setFont(post.getFont().deriveFont(25.0f));
		
		mainFrame.add(pTAmix, BorderLayout.NORTH);
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

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
