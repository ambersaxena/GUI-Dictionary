package demo;
import java.io.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class demo extends JFrame {

	private JPanel cp;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public demo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 300);
		cp = new JPanel();
		cp.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cp);
		t1 = new JTextField();
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		
		JLabel lblEnterTheWord = new JLabel("Enter the word");
		
		JLabel lblMeaning = new JLabel("Meaning");
		
			File file = new File("e:\\xyz.txt");
			File file1 = new File("e:\\pq.txt");
	
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str,str1,str2,str3;
				int n=1;
				str=t1.getText();
				str1=t2.getText();
				for(n=0;n<str.length();n++)
				{
					char ch=str.charAt(n);
					if(Character.isAlphabetic(ch)||ch==' ')
					{
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"invalid word");
						n=-1;
						break;
					}
				}
				for(n=0;n<str1.length();n++)
				{
					char ch=str1.charAt(n);
					if(Character.isAlphabetic(ch)||ch==' ')
					{
		
					}
					else
					{
						JOptionPane.showMessageDialog(null,"invalid meaning");
						n=-1;
						break;
					}
				}
				try
				{
					FileReader fw2 = new FileReader(file);
				char i;
				do
				{
					if(n==-1)
						break;
					str2="";
					do
					{
						n=fw2.read();
						if(n==-1)
							break;
						i=(char)n;
						if(i!=':')
						{
							str2=str2+i;
						}
						else
							break;
					}while(true);
					if(n==-1)
					{
						//JOptionPane.showMessageDialog(null,"word not found");
						break;
					}
						 str3="";
						 do
						 {
							 	i=(char)fw2.read();
								if(i!='#')
								{
									str3=str3+i;
								}
								else
									break;
						}while(true);
						 if(str.equals(str2))
						 {
						//t2.setText(str3);
						break;
					}
				}while(true);
				if(n==-1)
				{	FileWriter fw = new FileWriter(file,true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(t1.getText()+":"+t2.getText()+"#");
					bw.close();
					fw.close();
				}
				else
					JOptionPane.showMessageDialog(null,"word already present in dictionary");
				fw2.close();
				}
				catch(FileNotFoundException ie)
				{
					System.out.println(ie.toString());
				}
				catch(IOException i)
				{
					System.out.println(i.toString());
				}
				t1.setText("");
				t2.setText("");
				
			}
		});
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String str,str2,str3;
				str=t1.getText();
				try
				{
					FileReader fw2 = new FileReader(file);
				char i;
				do
				{
					int n=1;
					str2="";
					do
					{
						n=fw2.read();
						if(n==-1)
							break;
						i=(char)n;
						if(i!=':')
						{
							str2=str2+i;
						}
						else
							break;
					}while(true);
					if(n==-1)
					{
						JOptionPane.showMessageDialog(null,"word not found");
						break;
					}
						 str3="";
						 do
						 {
							 	i=(char)fw2.read();
								if(i!='#')
								{
									str3=str3+i;
								}
								else
									break;
						}while(true);
						 if(str.equals(str2))
						 {
						t2.setText(str3);
						break;
					}
				}while(true);
				fw2.close();
				}
				catch(FileNotFoundException ie)
				{
					System.out.println(ie.toString());
				}
				catch(IOException i)
				{
					System.out.println(i.toString());
				}
				//t1.setText("");
				//t2.setText("");
				
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str,str2,str3;
				str=t1.getText();
				try
				{
					FileReader fw2 = new FileReader(file);
				char i;
				do
				{
					int n=1;
					str2="";
					do
					{
						n=fw2.read();
						if(n==-1)
							break;
						i=(char)n;
						if(i!=':')
						{
							str2=str2+i;
						}
						else
							break;
					}while(true);
					if(n==-1)
					{
						//JOptionPane.showMessageDialog(null,"word not found");
						break;
					}
						 str3="";
						 do
						 {
							 	i=(char)fw2.read();
								if(i!='#')
								{
									str3=str3+i;
								}
								else
									break;
						}while(true);
						 if(str.equals(str2))
						 {
							 //t2.setText(str3);
							 //break;
						 }
						 else
						 {
							 	FileWriter fw = new FileWriter(file1,true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(str2+":"+str3+"#");
								bw.close();
								fw.close();
						 }
				}while(true);
				fw2.close();
				}
				catch(FileNotFoundException ie)
				{
					System.out.println(ie.toString());
				}
				catch(IOException i)
				{
					System.out.println(i.toString());
				}
				file.delete();
				file1.renameTo(file);
				t1.setText("");
				t2.setText("");
			}
		});
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String str,str2,str3;
				str=t1.getText();
				try
				{
					FileReader fw2 = new FileReader(file);
				char i;
				do
				{
					int n=1;
					str2="";
					do
					{
						n=fw2.read();
						if(n==-1)
							break;
						i=(char)n;
						if(i!=':')
						{
							str2=str2+i;
						}
						else
							break;
					}while(true);
					if(n==-1)
					{
						//JOptionPane.showMessageDialog(null,"word not found");
						break;
					}
						 str3="";
						 do
						 {
							 	i=(char)fw2.read();
								if(i!='#')
								{
									str3=str3+i;
								}
								else
									break;
						}while(true);
						 if(str.equals(str2))
						 {
							 //t2.setText(str3);
							 //break;
						 }
						 else
						 {
							 	FileWriter fw = new FileWriter(file1,true);
								BufferedWriter bw = new BufferedWriter(fw);
								bw.write(str2+":"+str3+"#");
								bw.close();
								fw.close();
						 }
				}while(true);
				fw2.close();
				}
				catch(FileNotFoundException ie)
				{
					System.out.println(ie.toString());
				}
				catch(IOException i)
				{
					System.out.println(i.toString());
				}
				file.delete();
				file1.renameTo(file);
				try{
					FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(t1.getText()+":"+t2.getText()+"#");
				bw.close();
				fw.close();
				}
				catch(FileNotFoundException ie)
				{
					System.out.println(ie.toString());
				}
				catch(IOException i)
				{
					System.out.println(i.toString());
				}
				t1.setText("");
				t2.setText("");
				
			}
		});
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
			}
		});
		GroupLayout gl_cp = new GroupLayout(cp);
		gl_cp.setHorizontalGroup(
			gl_cp.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cp.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cp.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cp.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_cp.createSequentialGroup()
								.addGroup(gl_cp.createParallelGroup(Alignment.LEADING, false)
									.addComponent(t1)
									.addComponent(t2, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_cp.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btnModify, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSearch, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblMeaning))
						.addComponent(lblEnterTheWord))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_cp.setVerticalGroup(
			gl_cp.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cp.createSequentialGroup()
					.addGap(23)
					.addComponent(lblEnterTheWord)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cp.createParallelGroup(Alignment.BASELINE)
						.addComponent(t1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addGroup(gl_cp.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cp.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMeaning)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(t2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cp.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_cp.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(11)
							.addComponent(btnDelete)
							.addGap(18)
							.addComponent(btnModify)
							.addGap(32))))
		);
		cp.setLayout(gl_cp);
	}
}
