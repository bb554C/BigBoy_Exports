import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class HomePage extends JFrame {

	int rowMaxSize = 100000;
	int fullDataColumnMaxSize = 13;
	int yearlyDataColumnMaxSize = fullDataColumnMaxSize - 3;
	int monthlyDataColumnMaxSize = fullDataColumnMaxSize - 2;
	int intFullData2dArray[][] = new int [rowMaxSize][fullDataColumnMaxSize];
	int intYearData2dArray[][] = new int [rowMaxSize][yearlyDataColumnMaxSize];
	int intMonthData2dArray[][] = new int [rowMaxSize][monthlyDataColumnMaxSize];
	/**
	 * 
	 */
	private databaseConnection dbConnection = new databaseConnection();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table1;
	private JTable table2;
	private JTable table3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 786, 562);
		contentPane.add(tabbedPane);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		tabbedPane.addTab("Full Data", null, panel1, null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane1.setBounds(10, 10, 761, 480);
		panel1.add(scrollPane1);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Year", "Month", "Day", "Pacific_Northwest_Wheat", "Pacific_Northwest_Corn", "Pacific_Northwest_Soybeans", "Mississippi_Gulf_Wheat", "Mississippi_Gulf_Corn", "Mississippi_Gulf_Soybeans", "Texas_Gulf_Wheat", "Texas_Gulf_Corn", "Texas_Gulf_Soybeans"
				}
				) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table1.getColumnModel().getColumn(0).setMinWidth(40);
		table1.getColumnModel().getColumn(0).setMaxWidth(100);
		table1.getColumnModel().getColumn(1).setPreferredWidth(40);
		table1.getColumnModel().getColumn(1).setMinWidth(40);
		table1.getColumnModel().getColumn(1).setMaxWidth(100);
		table1.getColumnModel().getColumn(2).setPreferredWidth(40);
		table1.getColumnModel().getColumn(2).setMinWidth(40);
		table1.getColumnModel().getColumn(2).setMaxWidth(100);
		table1.getColumnModel().getColumn(3).setPreferredWidth(40);
		table1.getColumnModel().getColumn(3).setMinWidth(40);
		table1.getColumnModel().getColumn(3).setMaxWidth(100);
		scrollPane1.setViewportView(table1);
		
		JProgressBar progressBar1 = new JProgressBar();
		progressBar1.setMaximum(100000);
		progressBar1.setBounds(20, 500, 285, 25);
		progressBar1.setStringPainted(true);
		panel1.add(progressBar1);
		
		JButton btnRefresh1 = new JButton("REFRESH");
		btnRefresh1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				refreshButton1(progressBar1);
			}
		});
		
		
		btnRefresh1.setBounds(315, 500, 150, 25);
		panel1.add(btnRefresh1);
		
		JLabel lblNewLabel1 = new JLabel("Export in units of 1000 Bushels");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(475, 500, 296, 25);
		panel1.add(lblNewLabel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		tabbedPane.addTab("Yearly SUM", null, panel2, null);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(10, 10, 761, 480);
		panel2.add(scrollPane2);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Year", "Pacific_Northwest_Wheat", "Pacific_Northwest_Corn", "Pacific_Northwest_Soybeans", "Mississippi_Gulf_Wheat", "Mississippi_Gulf_Corn", "Mississippi_Gulf_Soybeans", "Texas_Gulf_Wheat", "Texas_Gulf_Corn", "Texas_Gulf_Soybeans"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table2.getColumnModel().getColumn(0).setPreferredWidth(40);
		table2.getColumnModel().getColumn(0).setMinWidth(40);
		table2.getColumnModel().getColumn(0).setMaxWidth(100);
		scrollPane2.setViewportView(table2);
		
		JProgressBar progressBar2 = new JProgressBar();
		progressBar2.setStringPainted(true);
		
		JButton btnRefresh2 = new JButton("REFRESH");
		btnRefresh2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				refreshButton2(progressBar2);
			}
		});
		progressBar2.setMaximum(100000);
		progressBar2.setBounds(20, 500, 285, 25);
		panel2.add(progressBar2);
		btnRefresh2.setBounds(315, 500, 150, 25);
		panel2.add(btnRefresh2);
		
		JLabel lblNewLabel2 = new JLabel("Export in units of 1000 Bushels");
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(475, 500, 296, 25);
		panel2.add(lblNewLabel2);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		tabbedPane.addTab("Monthly SUM", null, panel3, null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane3.setBounds(10, 10, 761, 480);
		panel3.add(scrollPane3);
		
		table3 = new JTable();
		table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Year", "Month", "Pacific_Northwest_Wheat", "Pacific_Northwest_Corn", "Pacific_Northwest_Soybeans", "Mississippi_Gulf_Wheat", "Mississippi_Gulf_Corn", "Mississippi_Gulf_Soybeans", "Texas_Gulf_Wheat", "Texas_Gulf_Corn", "Texas_Gulf_Soybeans"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
					Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table3.getColumnModel().getColumn(0).setPreferredWidth(40);
		table3.getColumnModel().getColumn(0).setMinWidth(40);
		table3.getColumnModel().getColumn(0).setMaxWidth(100);
		table3.getColumnModel().getColumn(1).setPreferredWidth(40);
		table3.getColumnModel().getColumn(1).setMinWidth(40);
		table3.getColumnModel().getColumn(1).setMaxWidth(100);
		table3.getColumnModel().getColumn(2).setPreferredWidth(40);
		table3.getColumnModel().getColumn(2).setMinWidth(40);
		table3.getColumnModel().getColumn(2).setMaxWidth(100);
		scrollPane3.setViewportView(table3);
		
		JProgressBar progressBar3 = new JProgressBar();
		progressBar3.setStringPainted(true);
		JButton btnRefresh3 = new JButton("REFRESH");
		btnRefresh3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				refreshButton3(progressBar3);
			}
		});
		
		
		progressBar3.setMaximum(100000);
		progressBar3.setBounds(10, 500, 285, 25);
		panel3.add(progressBar3);
		btnRefresh3.setBounds(315, 500, 150, 25);
		panel3.add(btnRefresh3);
		
		JLabel lblNewLabel3 = new JLabel("Export in units of 1000 Bushels");
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setBounds(475, 500, 296, 25);
		panel3.add(lblNewLabel3);
	}
	
	public void clearTable(DefaultTableModel model)
	{
		int rows = model.getRowCount(); 
		for(int i = rows - 1; i >=0; i--)
		{
		   model.removeRow(i); 
		}
	}
	
	public void refreshButton1(JProgressBar progressBartemp)
	{
		progressBartemp.setValue(0);
		DefaultTableModel model1 = (DefaultTableModel)table1.getModel();
		clearTable(model1);
		intFullData2dArray = dbConnection.selectAll();
		Object intArray[] = new Object[fullDataColumnMaxSize];
		int i = 0;
		while (i < rowMaxSize && intFullData2dArray[i][0] != 0)
		{
			for (int j = 0; j < fullDataColumnMaxSize; j++)
			{
				intArray[j] = intFullData2dArray[i][j];
			}
			model1.addRow(intArray);
			progressBartemp.setValue(i);
			i++;
		}
		progressBartemp.setValue(rowMaxSize);
	}
	
	public void refreshButton2(JProgressBar progressBartemp)
	{
		progressBartemp.setValue(0);
		DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
		clearTable(model2);
		intYearData2dArray = dbConnection.selectYearly();
		yearSUMmultiThread yearSUMmtc = new yearSUMmultiThread();
		yearSUMmtc.setValue(intYearData2dArray);
		yearSUMmtc.setPanel(table2, progressBartemp);
		Thread thread1 = new Thread(yearSUMmtc);
		thread1.start();
	}
	
	public void refreshButton3(JProgressBar progressBartemp)
	{
		progressBartemp.setValue(0);
		DefaultTableModel model3 = (DefaultTableModel)table3.getModel();
		clearTable(model3);
		intMonthData2dArray = dbConnection.selectMonthly();
		monthSUMmultiThread monthSUMmtc = new monthSUMmultiThread();
		monthSUMmtc.setValue(intMonthData2dArray);
		monthSUMmtc.setPanel(table3, progressBartemp);
		Thread thread2 = new Thread(monthSUMmtc);
		thread2.start();
	}
}