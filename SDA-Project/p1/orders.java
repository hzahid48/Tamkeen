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

public class orders extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	String u;
	private Object[] selectedRowData; // Variable to store data from the clicked row
	
	
	 private void openNextFrame(String username) 
		{
		    u = username;
			c_manage nextFrame = new c_manage(username);
	        nextFrame.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        c_hire nextFrame1 = new c_hire(username, "abc", "", 0);
	        nextFrame1.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        c_profile nextFrame2 = new c_profile(username);
	        nextFrame2.setVisible(true);
	        this.dispose(); // Close the current frame if needed
	        
	        c_search nextFrame3 = new c_search(username);
	        nextFrame3.setVisible(true);
	        this.dispose();
	    }
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orders frame = new orders("abc");
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
	public orders(String username) 
	{
		u = username;
		setTitle("Orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1407, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(53, 44, 68));
		panel.setBounds(0, 0, 1370, 112);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("تمکین");
		lblNewLabel_1.setBounds(1140, 11, 162, 80);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 68));
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				orders frame16 = new orders(username);
				frame16.setVisible(true);
			}
		});
		btnNewButton.setBounds(850, 40, 106, 23);
		btnNewButton.setBackground(new Color(53, 44, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton.setBackground(clr);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton.setBackground(clr);
			}
		});
		btnNewButton.setFont(new Font("Meiryo", Font.BOLD, 18));
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Notifications");
		btnNewButton_1.setBounds(950, 35, 178, 35);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_1.setBackground(clr);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_1.setBackground(clr);
			}
		});
		btnNewButton_1.setFont(new Font("Meiryo", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				notifications frame16 = new notifications(username);
				frame16.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(53, 44, 68));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\notification.JPG"));
		btnNewButton_1.setBorderPainted(false);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(31, 24, 66, 67);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\profile.JPG"));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(95, 53, 115, 31);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_2.setBackground(clr);
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_2.setBackground(clr);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome frame3 = new welcome();
                frame3.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(53, 44, 68));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Meiryo", Font.BOLD, 15));
		btnNewButton_2.setBorderPainted(false);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Profile");
		btnNewButton_3.setBounds(300, 38, 99, 28);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_profile frame3 = new f_profile(username);
                frame3.setVisible(true);
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_3.setBackground(clr);
			}
			
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_3.setBackground(clr);
			}
		});
		btnNewButton_3.setBackground(new Color(53, 44, 68));
		btnNewButton_3.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBorderPainted(false);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Manage Account");
		btnNewButton_4.setBounds(409, 37, 183, 30);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_manage frame3 = new f_manage(username);
                frame3.setVisible(true);
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_4.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_4.setBackground(clr);
			}
		});
		btnNewButton_4.setBackground(new Color(53, 44, 68));
		btnNewButton_4.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBorderPainted(false);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Dashboard\r\n");
		btnNewButton_5.setBounds(592, 38, 137, 28);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_5.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_5.setBackground(clr);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_dashboard frame29 = new f_dashboard(username);
				frame29.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(53, 44, 68));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_5.setBorderPainted(false);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Services");
		btnNewButton_6.setBounds(739, 37, 115, 30);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_services frame4 = new f_services(username);
                frame4.setVisible(true);
			}
		});
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_6.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_6.setBackground(clr);
			}
		});
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_6.setBackground(new Color(53, 44, 68));
		btnNewButton_6.setBorderPainted(false);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Home");
		btnNewButton_7.setBounds(201, 37, 89, 30);
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home_freelancer frame4 = new home_freelancer(username);
                frame4.setVisible(true);
			}
		});
		
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_7.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_7.setBackground(clr);
			}
		});
		btnNewButton_7.setBackground(new Color(53, 44, 68));
		btnNewButton_7.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_7.setBorderPainted(false);
		panel.add(btnNewButton_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(140, 140, 140));
		panel_1.setBounds(0, 112, 1370, 637);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(235, 30, 850, 480);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
	    
		 table = new JTable();
		 JScrollPane scrollPane = new JScrollPane(table);
	     scrollPane.setBounds(29, 160, 800, 200);
	     scrollPane.getViewport().setBackground(Color.WHITE);
	     //contentPane.add(scrollPane);
	     panel_3.add(scrollPane);
	     
	     String url = "jdbc:mysql://localhost:3306/project";
	        String un = "root";
	        String p = "210936";

	            try (Connection connection = DriverManager.getConnection(url, un, p))
	            {
	            	String query = "SELECT * FROM applications WHERE TRIM(Freelancer)  = ? and Status = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
	                {
	                    preparedStatement.setString(1, username);
	                    preparedStatement.setBoolean(2, false);
	                    try (ResultSet resultSet = preparedStatement.executeQuery())
	                    {
	                        DefaultTableModel model = new DefaultTableModel();

	                        ResultSetMetaData metaData = resultSet.getMetaData();
	                        int columnCount = metaData.getColumnCount();
	                        for (int i = 1; i <= columnCount; i++) {
	                            model.addColumn(metaData.getColumnName(i));
	                        }

	                        model.addColumn("");
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
	                        
	                        JLabel lblNewLabel_2 = new JLabel("Pending Applications");
	                        lblNewLabel_2.setFont(new Font("Meiryo", Font.BOLD, 32));
	                        lblNewLabel_2.setBounds(250, 55, 400, 40);
	                        panel_3.add(lblNewLabel_2);
	                        
	                        
	          
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
	                            JButton btnDetails = new JButton("Accept");
	                            btnDetails.setForeground(Color.WHITE);
	                            btnDetails.addActionListener(new ActionListener()
	                            {
	                                public void actionPerformed(ActionEvent e)
	                                {
	                                    int selectedRow = table.getSelectedRow();

	                                    if (selectedRow != -1) 
	                                    {
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
	                            columnModel.getColumn(columnModel.getColumnCount() - 2).setCellRenderer(new ButtonRenderer());
	                            columnModel.getColumn(columnModel.getColumnCount() - 2).setCellEditor(new ButtonEditor(new JCheckBox(), btnDetails));
	                            
	                            //model.addColumn("");
	                            
	                            JButton rejectButton = new JButton("Reject");
	                            rejectButton.setForeground(Color.WHITE);
	                            rejectButton.addActionListener(new ActionListener() {
	                                public void actionPerformed(ActionEvent e) {
	                                    int selectedRow = table.getSelectedRow();

	                                    if (selectedRow != -1) {
	                                        // Retrieve data from the clicked row
	                                        selectedRowData = new Object[table.getColumnCount()];
	                                        for (int i = 0; i < table.getColumnCount(); i++) {
	                                            selectedRowData[i] = table.getValueAt(selectedRow, i);
	                                        }

	                                        // Handle the "Reject" button click
	                                        handleRejectButtonClick(selectedRowData);
	                                    } else {
	                                        JOptionPane.showMessageDialog(null, "Please select a row to Reject.");
	                                    }
	                                }
	                            });
	                            columnModel.getColumn(columnModel.getColumnCount() - 1).setCellRenderer(new RejectButtonRenderer());
	                            columnModel.getColumn(columnModel.getColumnCount() - 1).setCellEditor(new RejectButtonEditor(new JCheckBox(), rejectButton));
	                        }
	                        
	                        
	                    }
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	     
    }
    
    private void handleButtonClick(Object[] rowData)
    {
        String cusername = rowData[1].toString(); 
        String Service = rowData[3].toString();
   	 
	        String url = "jdbc:mysql://localhost:3306/project";
	        String un = "root";
	        String p = "210936";

	            try (Connection connection = DriverManager.getConnection(url, un, p))
	            {
	            	String updateQuery = "UPDATE applications SET Status = ? WHERE TRIM(Freelancer) = ? AND TRIM(Customer) = ? AND TRIM(Service) = ?";
	                
	                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery))
	                {
	                    // Set the values for the parameters in the update query
	                    updateStatement.setBoolean(1, true);
	                    updateStatement.setString(2, u);
	                    updateStatement.setString(3, cusername);
	                    updateStatement.setString(4, Service);

	                    // Execute the update operation
	                    int rowsAffected = updateStatement.executeUpdate();

	                    if (rowsAffected > 0)
	                    {
	                    	JOptionPane.showMessageDialog(null, "Acception notification sent to " + cusername);
	                    } 
	                    else
	                    {
	                    	JOptionPane.showMessageDialog(null, "No matching row found for update.");
	                    }
	                }
	            }
	            catch (SQLException e) 
	           {
	             	e.printStackTrace();
	           }
            
    }
    
    private void handleRejectButtonClick(Object[] rowData)
    {
    	 String cusername = rowData[1].toString();
    	 String Service = rowData[3].toString();
    	 
    	 
	        String url = "jdbc:mysql://localhost:3306/project";
	        String un = "root";
	        String p = "210936";

	            try (Connection connection = DriverManager.getConnection(url, un, p))
	            {
	            	String query = "Delete FROM applications WHERE TRIM(Freelancer)  = ? and Trim(Customer) = ? and TRIM(Service) = ?";
	                
	            	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
	                {
	            		preparedStatement.setString(1,u);
	                    preparedStatement.setString(2, cusername); 
	                    preparedStatement.setString(3, Service); 

	                    // Execute the delete operation
	                    int rowsAffected = preparedStatement.executeUpdate();

	                    if (rowsAffected > 0) 
	                    {
	                    	 JOptionPane.showMessageDialog(null, "Rejected the application");
	                    }
	                    else 
	                    {
	                    	JOptionPane.showMessageDialog(null, "No matching row found for deletion.");
	                    }
	                }
	                
	            } 
	            
	            catch (SQLException e) 
	            {
	                e.printStackTrace();
	            }

         
    }
    
    class RejectButtonRenderer extends JButton implements TableCellRenderer {
        // ... (similar to ButtonRenderer)

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Reject");
            return this;
        }
    }
    
    class RejectButtonEditor extends DefaultCellEditor {
        private JButton rejectButton;

        public RejectButtonEditor(JCheckBox checkBox, JButton rejectButton) {
            super(checkBox);
            this.rejectButton = rejectButton;
            this.rejectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
            rejectButton.setBackground(Color.RED); // Set a color for the "Reject" button
            rejectButton.setForeground(Color.WHITE);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return rejectButton;
        }
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
        	setText("Accept"); 
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
