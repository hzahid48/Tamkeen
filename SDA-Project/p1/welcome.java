package p1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class welcome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    //private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    welcome frame = new welcome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public welcome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1447, 636);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(53, 45, 68));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
                JLabel lblNewLabel = new JLabel("Elevate Your Projects Now – Find the Ideal Freelancer Instantly");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setBounds(373, 350, 520, 35);
                contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("CONNECTING TALENT WITH OPPORTUNITIES");
        lblNewLabel_2.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(230, 125, 950, 42);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_8 = new JLabel("تمکین");
        lblNewLabel_8.setForeground(new Color(228, 234, 0));
        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 60));
        lblNewLabel_8.setBounds(1150, 11, 231, 114);
        contentPane.add(lblNewLabel_8);

        JButton btnCustomer_1 = new JButton("Contact Us");
        btnCustomer_1.setFont(new Font("Meiryo", Font.BOLD, 16));
        btnCustomer_1.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		 ContactUs frame3 = new ContactUs();
                 frame3.setVisible(true);
        	}
        });
        btnCustomer_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnCustomer_1.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnCustomer_1.setBackground(clr);
			}
		});
        btnCustomer_1.setForeground(new Color(255, 255, 255));
        btnCustomer_1.setBackground(new Color(53, 45, 68));
        btnCustomer_1.setBounds(418, 200, 155, 54);
        btnCustomer_1.setBorderPainted(false); // Remove button border
        contentPane.add(btnCustomer_1);

        JButton btnCustomer_2 = new JButton("Sign In");
        btnCustomer_2.setFont(new Font("Meiryo", Font.BOLD, 16));
        btnCustomer_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		login frame6 = new login();
        		frame6.setVisible(true);
        	}
        });
        btnCustomer_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnCustomer_2.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnCustomer_2.setBackground(clr);
			}
		});
        btnCustomer_2.setForeground(new Color(255, 255, 255));
        btnCustomer_2.setBackground(new Color(53, 45, 68));
        btnCustomer_2.setBounds(574, 200, 155, 54);
        btnCustomer_2.setBorderPainted(false); // Remove button border
        contentPane.add(btnCustomer_2);

        JButton btnCustomer_3 = new JButton("Freelancer");
        btnCustomer_3.setFont(new Font("Meiryo", Font.BOLD, 16));
        btnCustomer_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		f_registration frame8 = new f_registration();
                frame8.setVisible(true);
        	}
        });
        btnCustomer_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnCustomer_3.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnCustomer_3.setBackground(clr);
			}
		});
        btnCustomer_3.setForeground(new Color(255, 255, 255));
        btnCustomer_3.setBackground(new Color(53, 45, 68));
        btnCustomer_3.setBounds(716, 200, 155, 59);
        btnCustomer_3.setBorderPainted(false); // Remove button border
        contentPane.add(btnCustomer_3);

        JButton btnCustomer_4 = new JButton("Customer");
        btnCustomer_4.setFont(new Font("Meiryo", Font.BOLD, 16));
        btnCustomer_4.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e)
        	{	
            		 registration frame4 = new registration();
                     frame4.setVisible(true);
        	}
        });
        btnCustomer_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnCustomer_4.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnCustomer_4.setBackground(clr);
			}
		});
        btnCustomer_4.setForeground(new Color(255, 255, 255));
        btnCustomer_4.setBackground(new Color(53, 45, 68));
        btnCustomer_4.setBounds(890, 200, 155, 54);
        btnCustomer_4.setBorderPainted(false); // Remove button border
        contentPane.add(btnCustomer_4);

        JButton btnCustomer_1_1 = new JButton("About Us");
        btnCustomer_1_1.setFont(new Font("Meiryo", Font.BOLD, 16));
        btnCustomer_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutUs frame2 = new AboutUs();
                frame2.setVisible(true);
            }
        });
        btnCustomer_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnCustomer_1_1.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnCustomer_1_1.setBackground(clr);
			}
		});
        btnCustomer_1_1.setForeground(Color.WHITE);
        btnCustomer_1_1.setBackground(new Color(53, 45, 68));
        btnCustomer_1_1.setBounds(250, 200, 155, 54);
        btnCustomer_1_1.setBorderPainted(false); // Remove button border
        contentPane.add(btnCustomer_1_1);

        textField = new JTextField();
        textField.setBounds(431, 389, 355, 42);
        setPlaceholder("    Search for Freelancers, Projects, or Skills");

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("     Search for Freelancers, Projects, or Skills")) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    setPlaceholder("     Search for Freelancers, Projects, or Skills");
                }
            }
        });

        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\search.JPG"));
        lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        lblNewLabel_1.setBounds(784, 389, 32, 42);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		welcome_search frame11 = new welcome_search(textField.getText());
        		frame11.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnNewButton.setBounds(580, 452, 89, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\logo_picture.JPG"));
        lblNewLabel_3.setBounds(960, 290, 231, 268);
        contentPane.add(lblNewLabel_3);
    }

    private void setPlaceholder(String text) {
        textField.setText(text);
        textField.setForeground(Color.GRAY);
    }
    }

