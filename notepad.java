package pack2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class notepad extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollpane;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JButton btnNewButton_2;
	private JLabel words;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notepad frame = new notepad();
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
	public notepad() {
		setFont(new Font("Dialog", Font.BOLD, 15));
		setTitle("Notepad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 787);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(1, 30, 970, 623);
//		textArea.setBounds(0, 0, 690, 530);
		contentPane.add(textArea,BorderLayout.CENTER);
		
//		contentPane.setLayout(null);
		scrollpane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(5, 5, 989, 671);
		
		menuBar = new JMenuBar();
		scrollpane.setColumnHeaderView(menuBar);
		
		mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Save as");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				jfc.showSaveDialog(null);
		
					try {
						
						FileWriter fw = new FileWriter(jfc.getSelectedFile().getAbsolutePath());
						fw.write(textArea.getText());
						fw.close();
					}
				
					catch (IOException e1) {
						e1.printStackTrace();
					} 
					
//			}
			}
		});
		
		mntmNewMenuItem_2 = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		
		
		JLabel finpath = new JLabel("Path :");
		finpath.setBounds(513, 674, 257, 34);
		finpath.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JFileChooser open=new JFileChooser();
//				int choice=open.showOpenDialog(null);
//				File path=open.getSelectedFile();
//				String path1=path.getAbsolutePath();
//				finpath.setText("Path : "+path1);
//				if(choice==JFileChooser.OPEN_DIALOG) {
//					try {
//						Scanner sc=new Scanner(new FileReader(open.getSelectedFile().getPath()));
//						
//						while(sc.hasNext()) {
//							textArea.append(sc.nextLine()+"\n");
//						}
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, e1);
//					}
//				}
				JFileChooser jfc=new JFileChooser();
				int b=jfc.showOpenDialog(null);
				if(b==JFileChooser.OPEN_DIALOG) {
					File fil=jfc.getSelectedFile();
					String path=fil.getAbsolutePath();
					finpath.setText(path);
					
				try {
					FileInputStream f1=new FileInputStream(fil);
					int i=0;
					String filda="";
					while((i=f1.read())!=-1) {
						filda=filda+(char)i;
					}
					f1.close();
					textArea.setText(textArea.getText()+"\n"+filda);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Save");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser();
				int r=jfc.showSaveDialog(null);
				if(r==JFileChooser.APPROVE_OPTION) {
					File fi=new File(jfc.getSelectedFile().getAbsolutePath());
					try {
						FileWriter fw=new FileWriter(fi,false);
						BufferedWriter bw=new BufferedWriter(fw);
						bw.write(textArea.getText());
						bw.flush();
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Print");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
	
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem Copy = new JMenuItem("Copy ");
		Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textArea.copy();
			}
		});
		
		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});
		mnNewMenu_1.add(cut);
		mnNewMenu_1.add(Copy);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Paste ");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("View");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Undo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Status");
		mnNewMenu_2.add(chckbxmntmNewCheckItem);
		JLabel chars = new JLabel("Characters : ");
		chars.setBounds(15, 674, 104, 35);
		chars.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JMenu format = new JMenu("Format");
		menuBar.add(format);
		
		JMenuItem word = new JMenuItem("WordWrap");
		word.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				word.setFont("Arial",Font.BOLD,12);
//				textArea.setWrapStyleWord(true);
			}
		});
		format.add(word);
		
		JButton btnNewButton = new JButton("Count Characters");
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textArea.getText();
				chars.setText("Character : "+(name.length()));
//				JOptionPane.showMessageDialog(null, "character : "+name.length());
//				lblNewLabel.setText("Characters : "+(name.length()));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		words = new JLabel("Words : ");
		words.setBounds(230, 674, 113, 35);
		words.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnNewButton_2 = new JButton("Count Words");
		menuBar.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton bcgc = new JButton("Background Color");
		bcgc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color=JColorChooser.showDialog(null, "Select Background Color", Color.BLUE);
				textArea.setBackground(color);
//				bcgc.setBackground(color);
			}
		});
		bcgc.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(bcgc);
		
		JButton txtc = new JButton("Text Color");
		txtc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color col=JColorChooser.showDialog(null, "Select Foreground Color ",Color.red);
				textArea.setForeground(col);
			}
		});
		
		
	
		
		txtc.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(txtc);
		
		JToggleButton tgl = new JToggleButton("Dark Theme");
		tgl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tgl.isSelected()) {
				textArea.setBackground(Color.black);
				textArea.setForeground(Color.white);
//				bulb.setIcon(new ImageIcon(getClass().getResource("E:\\\\Rental Page\\\\on bulb.png")));
				
				}else {
					textArea.setBackground(Color.white);
					textArea.setForeground(Color.black);					
				}
			}
		});
		tgl.setFont(new Font("Tahoma", Font.BOLD, 15));
		menuBar.add(tgl);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String name=textArea.getText();
//				String d[]=name.split(" ");
//				String e1[]=name.split("\n");
				String s=textArea.getText();
				System.out.println(s.length());
//				chars.setText("Character : "+(name.length()));
//				int j=1,k=0;
//				for(int i=0;i<name.length();i++){
//					if((name.charAt(i)==' ') && name.charAt(i+1)!=' ') {
//						j++;
//					}else if(name.charAt(i)=='\n' ) {
//						k++;
//						System.out.println(k);
//					}
//				}
				int j=0;
				for(int i=0;i<s.length();i++) {
					char ch=s.charAt(i);
//					char ch1=s.charAt(i+1);
					if(ch==' ' || ch=='\n') {
						j++;
					}
				}
				words.setText("Words : "+(j+1));
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBounds(800, 677, 94, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollpane);
		contentPane.add(finpath);
		contentPane.add(chars);
		contentPane.add(words);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
	
		
	
		
	}
}
