package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class MainFrame extends JFrame {

	private MainFrame frame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel.add(panel_2, "name_126632756863113");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton);
		
		SimpleTable table = new SimpleTable();
		table.setOpaque(true); // content panes must be opaque
	
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.info);
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_4.add(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnUpload = new JButton("Upload");
		panel_1.add(btnUpload, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblSchedule = new JLabel("Schedule:");
		panel_5.add(lblSchedule);
		
		JRadioButton rdbtnMeetings = new JRadioButton("Meetings");
		panel_5.add(rdbtnMeetings);
		
		JRadioButton rdbtnSession = new JRadioButton("Session");
		panel_5.add(rdbtnSession);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMeetings);
		group.add(rdbtnSession);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.SOUTH);
		
		JButton btnStart = new JButton("Start");
		panel_6.add(btnStart);
		
		


		// Display the window.
		//contentPane.pack();
		contentPane.setVisible(true);
		
		
		
		
	}

}
