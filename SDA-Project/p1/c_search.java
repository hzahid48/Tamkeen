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

public class c_search extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	String u;
	private Object[] selectedRowData; // Variable to store data from the clicked row
	//private Register r = demo.getSharedObject();
    public Register r = Register.getInstance();
		
	
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
					c_search frame = new c_search("abc");
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
	public c_search(String username) 
	{
		u = username;
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
		lblNewLabel_1.setBounds(1138, 11, 162, 80);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 68));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 24, 66, 67);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\profile.JPG"));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(74, 53, 110, 31);
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
		btnNewButton_3.setBounds(235, 41, 95, 28);
		btnNewButton_3.addMouseListener(new MouseAdapter()
		{
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
		btnNewButton_4.setBounds(340, 40, 181, 30);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_manage frame3 = new c_manage(username);
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
		btnNewButton_5.setBounds(515, 41, 137, 28);
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
				c_dashboard frame23 = new c_dashboard(username);
				frame23.setVisible(true);
			}
		});
		btnNewButton_5.setBackground(new Color(53, 44, 68));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Meiryo", Font.BOLD, 16));
		btnNewButton_5.setBorderPainted(false);
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Search Services");
		btnNewButton_6.setBounds(650, 40, 181, 30);
		btnNewButton_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				c_search frame8 = new c_search(username);
				frame8.setVisible(true);
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
		
		JButton btnNewButton_1_1 = new JButton("Notifications");
		btnNewButton_1_1.setBounds(845, 41, 187, 29);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				C_Notifications frame20 = new C_Notifications(username);
				frame20.setVisible(true);
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color clr = new Color(192,192,192);
				btnNewButton_1_1.setBackground(clr);
			}
			public void mouseExited(MouseEvent e) {
				Color clr = new Color(53,44,68);
				btnNewButton_1_1.setBackground(clr);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\notification.JPG"));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(new Color(53, 44, 68));
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(140, 140, 140));
		panel_1.setBounds(0, 112, 1370, 637);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
			
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(179, 11, 876, 500);
		panel_2.setBackground(new Color(240, 240, 240));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(294, 87, 307, 32);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		setPlaceholder("    Search for Freelancers, Projects, or Skills");

        textField_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_1.getText().equals("     Search for Freelancers, Projects, or Skills")) {
                    textField_1.setText("");
                    textField_1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_1.getText().isEmpty()) {
                    setPlaceholder("     Search for Freelancers, Projects, or Skills");
                }
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dell\\Downloads\\search.JPG"));
		lblNewLabel_2.setBounds(598, 87, 32, 32);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_7 = new JButton("Search");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				searchAndUpdateTable();
			}
		});
		btnNewButton_7.setFont(new Font("Meiryo", Font.BOLD, 15));
		btnNewButton_7.setBounds(407, 132, 117, 23);
		panel_2.add(btnNewButton_7);
	    
		 table = new JTable();
		 JScrollPane scrollPane = new JScrollPane(table);
	     scrollPane.setBounds(280, 300, 650, 200);
	     scrollPane.getViewport().setBackground(Color.WHITE);
	     contentPane.add(scrollPane);

      
		
    }

    private void setPlaceholder(String text) {
        textField_1.setText(text);
        textField_1.setForeground(Color.GRAY);
    }

    private void searchAndUpdateTable()
    {
    	
        String searchTerm = textField_1.getText().trim();
        boolean check = false;
        //Register r = new Register();
        check = r.search(searchTerm);

        String url = "jdbc:mysql://localhost:3306/project";
        String un = "root";
        String p = "210936";

        if (searchTerm.isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "You have not entered any service to search for");
        }

        if (check) {
            try (Connection connection = DriverManager.getConnection(url, un, p))
            {
                String query = "SELECT * FROM services WHERE Title LIKE ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) 
                {
                    preparedStatement.setString(1, "%" + searchTerm + "%");
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
        // Example: Open a new frame with the data
        String fusername = rowData[4].toString(); 
        int price = Integer.parseInt(rowData[3].toString());
        String searched = rowData[1].toString();
        c_hire frame11 = new c_hire(u, fusername,searched,price);
        
        System.out.println("Freelancer username : ");
        System.out.println(fusername);
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
