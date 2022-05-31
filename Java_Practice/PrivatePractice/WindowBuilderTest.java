import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class WindowBuilderTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String ID="chlwlgns";
	private static String PassWord="1234";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderTest frame = new WindowBuilderTest();
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
	public WindowBuilderTest() {
		setForeground(Color.WHITE);
		setTitle("DB 로그인 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.text);
		textField.setBounds(290, 100, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(290, 84, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(290, 131, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ID.equals(textField.getText())) {
						
				}
				 
			}
		});
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBounds(324, 190, 82, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(290, 146, 116, 21);
		
		contentPane.add(passwordField);
		
		//이미지를 실제로 가지고 있는 개체 생성
		ImageIcon icon=new ImageIcon("C:\\Users\\PC-21\\Pictures\\oracle.png");
		//이미지 객체 사이즈를 새롭게 생성
		Image img=icon.getImage();
		//새로 조절된 사이즈의 이미지(img2)를 가지는 ImageIcon 객체를 생성
		Image img2=img.getScaledInstance(227, 261, Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(img2);
		
		JLabel lblNewLabel_2 = new JLabel(icon2);
		lblNewLabel_2.setBounds(0, 0, 227, 261);
		contentPane.add(lblNewLabel_2);
	}
}
