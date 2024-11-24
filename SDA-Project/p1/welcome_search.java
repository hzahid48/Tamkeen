package p1;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import user_management.Register;

public class welcome_search extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	String u;
	private Object[] selectedRowData; // Variable to store data from the clicked row
	private JTextField textField;
	
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
    
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome_search frame = new welcome_search("abc");
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
	public welcome_search(String searched) 
	{
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
              lblNewLabel.setBounds(373, 270, 520, 35);
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
      btnCustomer_1.setBounds(416, 200, 155, 54);
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
      btnCustomer_2.setBounds(569, 200, 155, 54);
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
      btnCustomer_3.setBounds(699, 200, 155, 59);
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
      btnCustomer_4.setBounds(864, 200, 155, 54);
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
      btnCustomer_1_1.setBounds(269, 200, 155, 54);
      btnCustomer_1_1.setBorderPainted(false); // Remove button border
      contentPane.add(btnCustomer_1_1);
			
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(179, 11, 876, 500);
		panel_2.setBackground(new Color(240, 240, 240));
		//panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(294, 87, 307, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		//setPlaceholder("    Search for Freelancers, Projects, or Skills");
		setPlaceholder(searched);
		
        textField_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) 
            {
                //if (textField_1.getText().equals("     Search for Freelancers, Projects, or Skills"))
            	if (textField_1.getText().equals(searched))
                {
                    textField_1.setText("");
                    textField_1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) 
            {
                if (textField_1.getText().isEmpty())
                {
                    //setPlaceholder("     Search for Freelancers, Projects, or Skills");
                	 setPlaceholder(searched);
                }
            }
        });
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\search.JPG"));
		lblNewLabel_21.setBounds(598, 87, 32, 32);
		panel_2.add(lblNewLabel_21);
		
		
	    
		 table = new JTable();
		 JScrollPane scrollPane = new JScrollPane(table);
	     scrollPane.setBounds(300, 400, 650, 180);
	     scrollPane.getViewport().setBackground(Color.WHITE);
	     contentPane.add(scrollPane);
	     
	     textField = new JTextField();
	     textField.setText(searched);
	     textField.setForeground(Color.GRAY);
	     textField.setColumns(10);
	     textField.setBounds(426, 305, 355, 42);
	     contentPane.add(textField);
	     
	     JLabel lblNewLabel_1 = new JLabel("");
	     lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\search.JPG"));
	     lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	     lblNewLabel_1.setBounds(779, 305, 32, 42);
	     contentPane.add(lblNewLabel_1);
	     
	     searchAndUpdateTable(searched);
	     
	     JButton btnNewButton = new JButton("Search");
	     btnNewButton.addActionListener(new ActionListener() 
	     {
	     	public void actionPerformed(ActionEvent e)
	     	{
	     		String searchTerm = textField.getText().trim();
				searchAndUpdateTable(searchTerm);
	     	}
	     });
	     btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
	     btnNewButton.setBounds(575, 358, 89, 23);
	     contentPane.add(btnNewButton);
	     
	     JButton btnNewButton_1 = new JButton("");
	     btnNewButton_1.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) 
	     	{
	     		welcome frame29 = new welcome();
	     		frame29.setVisible(true);
	     	}
	     });
	     btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Color clr = new Color(192,192,192);
					btnNewButton_1.setBackground(clr);
				}
				public void mouseExited(MouseEvent e) {
					Color clr = new Color(53,44,68);
					btnNewButton_1.setBackground(clr);
				}
			});
	     btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\back.png"));
	     btnNewButton_1.setBackground(new Color(53, 44, 68));
	     btnNewButton_1.setBounds(10, 11, 89, 23);
	     btnNewButton_1.setBorderPainted(false);
	     contentPane.add(btnNewButton_1);
	     
	     JLabel lblNewLabel_3 = new JLabel("");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\logo_picture.JPG"));
	        lblNewLabel_3.setBounds(1000, 340, 231, 268);
	        contentPane.add(lblNewLabel_3);
	     
	     searchAndUpdateTable(searched);
	     
      
		
    }

    private void setPlaceholder(String text)
    {
        textField_1.setText(text);
        textField_1.setForeground(Color.GRAY);
    }

    private void searchAndUpdateTable(String searched)
    {
    	
        //String searchTerm = textField_1.getText().trim();
        boolean check = false;
        //Register r = new Register();
        check = r.search(searched);

        String url = "jdbc:mysql://localhost:3306/project";
        String un = "root";
        String p = "210936";

        if (searched.isEmpty()) 
        {
            JOptionPane.showInternalMessageDialog(null, "You have not entered any service to search for");
        }

        if (check) {
            try (Connection connection = DriverManager.getConnection(url, un, p))
            {
                String query = "SELECT * FROM services WHERE Title LIKE ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
                {
                    preparedStatement.setString(1, "%" + searched + "%");
                    try (ResultSet resultSet = preparedStatement.executeQuery())
                    {
                        DefaultTableModel model = new DefaultTableModel();

                        ResultSetMetaData metaData = resultSet.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            model.addColumn(metaData.getColumnName(i));
                        }

                        model.addColumn("");
                        
                        while (resultSet.next()) {
                            Object[] rowData = new Object[columnCount];
                            for (int i = 1; i <= columnCount; i++)
                            {
                                rowData[i - 1] = resultSet.getObject(i);
                            }
                            model.addRow(rowData);
                        }
                        
                        table.setModel(model);
          
                        if (table == null)
                        {
                            //table = new JTable(model);
                            //JScrollPane scrollPane = new JScrollPane(table);
                            //scrollPane.setBounds(280, 300, 650, 200);
                            //scrollPane.getViewport().setBackground(Color.WHITE);
                            //contentPane.add(scrollPane);
                        }
                        else
                        {
                            //table.setModel(model);
                         // Create the "Details" button
                            JButton btnDetails = new JButton("Hire");
                            btnDetails.setForeground(Color.WHITE);
                            btnDetails.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    int selectedRow = table.getSelectedRow();

                                    if (selectedRow != -1) {
                                        // Retrieve data from the clicked row
                                        selectedRowData = new Object[table.getColumnCount()];
                                        for (int i = 0; i < table.getColumnCount(); i++) {
                                            selectedRowData[i] = table.getValueAt(selectedRow, i);
                                        }

                                        // Handle the button click (e.g., open a new frame with the data)
                                        handleButtonClick(selectedRowData);
                                    } 
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Please select a row to Hire.");
                                    }
                                }
                            });

                            // Add a button column to the table
                            TableColumnModel columnModel = table.getColumnModel();
                            columnModel.getColumn(columnModel.getColumnCount() - 1).setCellRenderer(new ButtonRenderer());
                            columnModel.getColumn(columnModel.getColumnCount() - 1).setCellEditor(new ButtonEditor(new JCheckBox(), btnDetails));
                        }
                        
                        
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void handleButtonClick(Object[] rowData)
    {
    	JOptionPane.showMessageDialog(null, "Login to hire the freelancer");
        login frame11 = new login();
        frame11.setVisible(true);
    }


    // Additional classes for the button renderer and editor

    class ButtonRenderer extends JButton implements TableCellRenderer 
    {

    	public ButtonRenderer() {
            setOpaque(false);
            //setBackground(Color.BLACK);
            setForeground(Color.BLACK);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        	setText("Hire"); 
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private JButton button;

        public ButtonEditor(JCheckBox checkBox, JButton button) {
            super(checkBox);
            this.button = button;
            this.button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
}
