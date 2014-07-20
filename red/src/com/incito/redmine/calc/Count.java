package com.incito.redmine.calc;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.incito.redmine.util.ChooseFile;
import com.incito.redmine.util.ConditionalsAfterClick;

public class Count extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502123845419068490L;
	  public static File file = null;
	private JPanel contentPane;
	private JTextField filePathText;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Count frame = new Count();
					//设置在屏幕中央显示
					frame.setLocationRelativeTo(null);
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
	public Count() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("./resource/logo.png"));
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("Bug量化统计 v1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 234);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		final JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		contentPane.add(panel);
		panel.setLayout(null);
		//文件路径label
		JLabel filePathLabel = new JLabel("文件路径：");
		filePathLabel.setHorizontalAlignment(SwingConstants.LEFT);
		filePathLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		filePathLabel.setBounds(10, 10, 70, 15);
		filePathLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(filePathLabel);
		//文件路径显示的区域
		filePathText = new JTextField();
		filePathText.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		filePathText.setEditable(false);
		filePathText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChooseFile.choose(file, filePathText);
			}
		});
		filePathText.setToolTipText("这是文件路径");
		filePathText.setBounds(83, 8, 249, 21);
		panel.add(filePathText);
		filePathText.setColumns(10);
		final ButtonGroup group = new ButtonGroup();
		final JRadioButton radioButton = new JRadioButton("物流标准板");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(radioButton)){
				    if(radioButton.isSelected()){
			             System.out.println("你选择了物流标准板");
			        }
					
				}
			}
		});
		radioButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		radioButton.setBounds(80, 48, 93, 23);
		group.add(radioButton);
		panel.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("物流企业版");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(radioButton_1)){
				    if(radioButton_1.isSelected()){
			             System.out.println("你选择了物流企业版");
			        }
					
				}
			}
		});
		radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		radioButton_1.setBounds(176, 48, 93, 23);
		group.add(radioButton_1);
		panel.add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("景淳金融");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(radioButton_2)){
				    if(radioButton_2.isSelected()){
			             System.out.println("你选择了景淳金融");
			        }
					
				}
			}
		});
		radioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		radioButton_2.setBounds(271, 48, 84, 23);
		group.add(radioButton_2);
		panel.add(radioButton_2);
		
		JButton button = new JButton("浏览");
		button.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e)  {
			
				ChooseFile.choose(file, filePathText);
				
				
			}
		});
		button.setToolTipText("选择你要统计的量化bug统计表");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button.setBounds(348, 7, 79, 23);
		panel.add(button);
		
		final JProgressBar progressBar = new JProgressBar(0,100);
		progressBar.setForeground(new Color(255, 0, 0));
		progressBar.setStringPainted(true); // 显示百分比字符
		progressBar.setIndeterminate(false); // 不确定的进度条
		progressBar.setBackground(new Color(144, 238, 144));
		progressBar.setToolTipText("统计进度");
		progressBar.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		progressBar.setBounds(83, 77, 257, 14);
		panel.add(progressBar);
		
		JButton btnNewButton = new JButton("统计");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConditionalsAfterClick.judge(filePathText,group , progressBar);
		
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBounds(83, 105, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.setBounds(247, 105, 93, 23);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("项目选择：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setBounds(10, 52, 70, 15);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("INCITO 2014");
		lblNewLabel_1.setBounds(173, 177, 79, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(192, 192, 192));
		textField.setText("说明：先选择文件路径，然后再选择项目，最后点击统计按钮");
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField.setBounds(56, 138, 334, 21);
		panel.add(textField);
		textField.setColumns(10);
		

		


		
	}
}
