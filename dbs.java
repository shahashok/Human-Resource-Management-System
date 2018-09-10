import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
@SuppressWarnings("serial")
public class dbs extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTable table_1;
	private JTextField textField_27;
	public static Connection conn;
	public static String query;
	public static Statement st;
	public static ResultSet rs;
	public static String valueInCellDepartment,columnDepartment,valueInCellDependent,columnDependent,valueInCellEmpLevel,columnEmpLevel;
	public static String valueInCellEmployee,columnEmployee,valueInCellPosition,columnPosition,valueInCellQualification,columnQualification;
	public static String updateInCellDepartment,updatecolumnDepartment;
	public static String updateInCellDependent,updatecolumnDependent;
	public static String updateInCellEmpLevel,updatecolumnEmpLevel;
	public static String updateInCellEmployee,updatecolumnEmployee;
	public static String updateInCellPosition,updatecolumnPosition;
	public static String updateInCellQualification,updatecolumnQualification;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	public static String tablename;
	private JTextField textField_28;
	private JTable table;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbs frame = new dbs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public dbs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout());
		contentPane.setBackground(new Color(139 ,134, 130));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1232, 653);
		contentPane.add(tabbedPane);
		tabbedPane.setBorder(new EmptyBorder(20,20,20,20));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216 ,191 ,216));
		tabbedPane.addTab("  Connect  ", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(174, 83, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 139, 117, 22);
		panel.add(passwordField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(65, 86, 71, 16);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 142, 71, 16);
		panel.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Connection Status");
		lblNewLabel.setBounds(483, 100, 116, 16);
		panel.add(lblNewLabel);
		
		textField_27 = new JTextField();
		textField_27.setBounds(634, 97, 156, 22);
		panel.add(textField_27);
		textField_27.setColumns(10);		
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try
			    {
			      String myDriver =textField_29.getText();
			      String myUrl = textField_30.getText();
			      Class.forName(myDriver);
			      String user=textField.getText();
			      @SuppressWarnings("deprecation")
				  String pass=passwordField.getText();
			      conn = DriverManager.getConnection(myUrl, user, pass);
			      textField_27.setText("Connected");
			      JOptionPane.showMessageDialog(null,"Connection Established","Success",JOptionPane.INFORMATION_MESSAGE);
			    }
			    catch (Exception ex)
			    {
			      textField_27.setText("Not Connected");
			      JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			    }				
			}
		});
		btnConnect.setBounds(329, 377, 97, 25);
		panel.add(btnConnect);		
		
		textField_29 = new JTextField();
		textField_29.setBounds(174, 242, 270, 22);
		panel.add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setBounds(174, 303, 270, 22);
		panel.add(textField_30);
		textField_30.setColumns(10);
		
		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setBounds(65, 245, 56, 16);
		panel.add(lblDriver);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(65, 306, 56, 16);
		panel.add(lblUrl);
		
		textField_29.setText("oracle.jdbc.driver.OracleDriver");
	    textField_30.setText("jdbc:oracle:thin:@localhost:1521:xe");
	    textField.setText("system");
	    passwordField.setText("amith15cs008");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("  Create  ", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(216 ,191 ,216));
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(32, 56, 82, 16);
		panel_1.add(lblDepartment);
		
		JLabel lblDependent = new JLabel("Dependent");
		lblDependent.setBounds(32, 124, 82, 16);
		panel_1.add(lblDependent);
		
		JLabel lblEmplevel = new JLabel("EmpLevel");
		lblEmplevel.setBounds(32, 192, 82, 16);
		panel_1.add(lblEmplevel);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(32, 260, 82, 16);
		panel_1.add(lblEmployee);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(32, 328, 82, 16);
		panel_1.add(lblPosition);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setBounds(32, 396, 82, 16);
		panel_1.add(lblQualification);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(158, 56, 417, 20);
		panel_1.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(158, 124, 417, 20);
		panel_1.add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(158, 192, 417, 20);
		panel_1.add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(158, 260, 417, 20);
		panel_1.add(textPane_3);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(158, 328, 417, 20);
		panel_1.add(textPane_4);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(158, 396, 417, 20);
		panel_1.add(textPane_5);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "create table Department(DeptId number(2) primary key, DeptName varchar2(10),Location varchar2(10),ManagementId number(3))";
				    st = conn.createStatement();
				    st.executeQuery(query);
				textPane.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						textPane.setText("Not Connected to db");
					else
						textPane.setText(e1.getMessage());
				}				
				try{
					query = "create table EmpLevel(LevelNo number(6) primary key, Lowsalary integer,Highsalary integer)";
				    st = conn.createStatement();
				      st.executeQuery(query);
				textPane_2.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						textPane_2.setText("Not Connected to db");
					else
						textPane_2.setText(e1.getMessage());
				}
				try{
					query = "create table Position(PositionId number(4) primary key, PosDesc varchar2(10))";
				    st = conn.createStatement();
				      st.executeQuery(query);
				textPane_4.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						textPane_4.setText("Not Connected to db");
					else
						textPane_4.setText(e1.getMessage());
				}
				try{
					query = "create table Qualification(QualId number(4) primary key,QualDesc varchar2(10))";
				    st = conn.createStatement();
				      st.executeQuery(query);
				textPane_5.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
					else
						textPane_5.setText(e1.getMessage());;
				}
				try{
					query = "create table Employee(EmployeeId number(4) primary key,Lname varchar2(10),Fname varchar2(10),PositionId number(4) references Position(PositionId) on delete cascade,QualId number(4) references Qualification(QualId) on delete cascade,DeptId number(2) references Department(DeptId) on delete cascade,Salary integer,Comission integer,HireDate date,BirthDate date)";
				    st = conn.createStatement();
				      st.executeQuery(query);
				textPane_3.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						textPane_3.setText("Not Connected to db");
					else
						textPane_3.setText(e1.getMessage());
				}
				try{
					query = "create table Dependent(EmployeeId number(4) references Employee(EmployeeId) on delete cascade, DependentId number(5) primary key,DependentDOB date,Relation varchar2(10))";
				      st = conn.createStatement();
				      st.executeQuery(query);
				textPane_1.setText("Table Created");
				}catch(Exception e1)
				{
					if(conn==null)
						textPane_1.setText("Not Connected to db");
					else
						textPane_1.setText(e1.getMessage());
				}				
			}
		});
		btnCreate.setBounds(346, 455, 97, 25);
		panel_1.add(btnCreate);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("  Insert  ", null, panel_2, null);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(216 ,191 ,216));
		
		JButton btnDepartment = new JButton("Department");
		btnDepartment.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JInternalFrame Insert = new JInternalFrame("Department");
				Insert.setBounds(167, 50, 750, 439);
				panel_2.add(Insert);
				Insert.getContentPane().setLayout(null);
				Insert.setBackground(new Color(205 ,193, 197));
				
				textField_1 = new JTextField();
				textField_1.setBounds(298, 47, 116, 22);
				Insert.getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(298, 103, 116, 22);
				Insert.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(298, 157, 116, 22);
				Insert.getContentPane().add(textField_3);
				textField_3.setColumns(10);
				
				textField_4 = new JTextField();
				textField_4.setBounds(298, 214, 116, 22);
				Insert.getContentPane().add(textField_4);
				textField_4.setColumns(10);
				
				JLabel lblDeptid = new JLabel("DeptID");
				lblDeptid.setBounds(117, 50, 93, 16);
				Insert.getContentPane().add(lblDeptid);
				
				JLabel lblDeptname = new JLabel("DeptName");
				lblDeptname.setBounds(117, 106, 93, 16);
				Insert.getContentPane().add(lblDeptname);
				
				JLabel lblLocation = new JLabel("Location");
				lblLocation.setBounds(117, 160, 93, 16);
				Insert.getContentPane().add(lblLocation);
				
				JLabel lblManagementid = new JLabel("ManagementID");
				lblManagementid.setBounds(117, 217, 93, 16);
				Insert.getContentPane().add(lblManagementid);
				
				JButton btnInsert = new JButton("Insert");
				btnInsert.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try{
							String DeptID=textField_1.getText();
							String DeptName=textField_2.getText();
							String Location=textField_3.getText();
							String ManagementID=textField_4.getText();
							query = "insert into Department values('"+DeptID+"','"+DeptName+"','"+Location+"','"+ManagementID+"')";
						    st = conn.createStatement();
						      st.execute(query);
						      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
						      textField_1.setText("");
						      textField_2.setText("");
						      textField_3.setText("");
						      textField_4.setText("");	
						}catch(Exception e1)
						{
							if(conn==null)
								JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnInsert.setBounds(244, 301, 97, 25);
				Insert.getContentPane().add(btnInsert);
				Insert.setClosable(true);
				Insert.setVisible(true);
			}
		});
		btnDepartment.setBounds(33, 56, 113, 25);
		panel_2.add(btnDepartment);
		
		JButton btnDependent = new JButton("Dependent");
		btnDependent.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Dependent");
				internalFrame.setBounds(167, 50, 674, 459);
				panel_2.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_5 = new JTextField();
				textField_5.setBounds(329, 81, 116, 22);
				internalFrame.getContentPane().add(textField_5);
				textField_5.setColumns(10);
				
				textField_6 = new JTextField();
				textField_6.setBounds(329, 141, 116, 22);
				internalFrame.getContentPane().add(textField_6);
				textField_6.setColumns(10);
				
				textField_7 = new JTextField();
				textField_7.setBounds(329, 194, 116, 22);
				internalFrame.getContentPane().add(textField_7);
				textField_7.setColumns(10);
				
				textField_8 = new JTextField();
				textField_8.setBounds(329, 251, 116, 22);
				internalFrame.getContentPane().add(textField_8);
				textField_8.setColumns(10);
				
				JLabel lblEmployeeid = new JLabel("EmployeeID");
				lblEmployeeid.setBounds(174, 84, 89, 16);
				internalFrame.getContentPane().add(lblEmployeeid);
				
				JLabel lblDependentid = new JLabel("DependentID");
				lblDependentid.setBounds(174, 144, 89, 16);
				internalFrame.getContentPane().add(lblDependentid);
				
				JLabel lblDependentdob = new JLabel("DependentDOB");
				lblDependentdob.setBounds(174, 197, 89, 16);
				internalFrame.getContentPane().add(lblDependentdob);
				
				JLabel lblRelation = new JLabel("Relation");
				lblRelation.setBounds(174, 254, 89, 16);
				internalFrame.getContentPane().add(lblRelation);
				
				JButton btnInsert_1 = new JButton("Insert");
						btnInsert_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent arg0) {
								try{
									String EmployeeID=textField_5.getText();
									String DependentID=textField_6.getText();
									String DependentDOB=textField_7.getText();
									String Relation=textField_8.getText();
									query = "insert into Dependent values('"+EmployeeID+"','"+DependentID+"','"+DependentDOB+"','"+Relation+"')";
								    st = conn.createStatement();
								      st.execute(query);
								      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
								      textField_5.setText("");
								      textField_6.setText("");
								      textField_7.setText("");
								      textField_8.setText("");
			
								}catch(Exception e2)
								{
									if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
									else
										JOptionPane.showMessageDialog(null,e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
								}
							}
						});
				btnInsert_1.setBounds(329, 332, 97, 25);
				internalFrame.getContentPane().add(btnInsert_1);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
			}
		});
		btnDependent.setBounds(33, 459, 113, 25);
		panel_2.add(btnDependent);
		
		JButton btnEmplevel = new JButton("EmpLevel");
		btnEmplevel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("EmpLevel");
				internalFrame.setBounds(167, 50, 711, 485);
				panel_2.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_9 = new JTextField();
				textField_9.setBounds(332, 73, 116, 22);
				internalFrame.getContentPane().add(textField_9);
				textField_9.setColumns(10);
				
				textField_10 = new JTextField();
				textField_10.setBounds(332, 145, 116, 22);
				internalFrame.getContentPane().add(textField_10);
				textField_10.setColumns(10);
				
				textField_11 = new JTextField();
				textField_11.setBounds(332, 216, 116, 22);
				internalFrame.getContentPane().add(textField_11);
				textField_11.setColumns(10);
				
				JLabel lblLevelno = new JLabel("LevelNo");
				lblLevelno.setBounds(191, 76, 71, 16);
				internalFrame.getContentPane().add(lblLevelno);
				
				JLabel lblLowsalary = new JLabel("Lowsalary");
				lblLowsalary.setBounds(191, 148, 71, 16);
				internalFrame.getContentPane().add(lblLowsalary);
				
				JLabel lblHighsalary = new JLabel("Highsalary");
				lblHighsalary.setBounds(191, 219, 71, 16);
				internalFrame.getContentPane().add(lblHighsalary);
				
				JButton btnInsert_2 = new JButton("Insert");
				btnInsert_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try{
							String LevelNo=textField_9.getText();
							String Lowsalary=textField_10.getText();
							String Highsalary=textField_11.getText();
							query = "insert into EmpLevel values('"+LevelNo+"','"+Lowsalary+"','"+Highsalary+"')";
						    st = conn.createStatement();
						      st.execute(query);
						      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
						      textField_9.setText("");
						      textField_10.setText("");
						      textField_11.setText("");
	
						}catch(Exception e3)
						{
							if(conn==null)
								JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,e3.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnInsert_2.setBounds(338, 337, 97, 25);
				internalFrame.getContentPane().add(btnInsert_2);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
			}
		});
		btnEmplevel.setBounds(33, 136, 113, 25);
		panel_2.add(btnEmplevel);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JInternalFrame internalFrame = new JInternalFrame("Employee");
				internalFrame.setBounds(167, 30, 682, 550);
				panel_2.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_12 = new JTextField();
				textField_12.setBounds(341, 13, 116, 22);
				internalFrame.getContentPane().add(textField_12);
				textField_12.setColumns(10);
				
				textField_13 = new JTextField();
				textField_13.setBounds(341, 48, 116, 22);
				internalFrame.getContentPane().add(textField_13);
				textField_13.setColumns(10);
				
				textField_14 = new JTextField();
				textField_14.setBounds(341, 83, 116, 22);
				internalFrame.getContentPane().add(textField_14);
				textField_14.setColumns(10);
				
				textField_15 = new JTextField();
				textField_15.setBounds(341, 118, 116, 22);
				internalFrame.getContentPane().add(textField_15);
				textField_15.setColumns(10);
				
				textField_16 = new JTextField();
				textField_16.setBounds(341, 153, 116, 22);
				internalFrame.getContentPane().add(textField_16);
				textField_16.setColumns(10);
				
				textField_17 = new JTextField();
				textField_17.setBounds(341, 188, 116, 22);
				internalFrame.getContentPane().add(textField_17);
				textField_17.setColumns(10);
				
				textField_19 = new JTextField();
				textField_19.setBounds(341, 223, 116, 22);
				internalFrame.getContentPane().add(textField_19);
				textField_19.setColumns(10);
				
				textField_20 = new JTextField();
				textField_20.setBounds(341, 258, 116, 22);
				internalFrame.getContentPane().add(textField_20);
				textField_20.setColumns(10);
				
				textField_21 = new JTextField();
				textField_21.setBounds(341, 293, 116, 22);
				internalFrame.getContentPane().add(textField_21);
				textField_21.setColumns(10);
				
				textField_22 = new JTextField();
				textField_22.setBounds(341, 328, 116, 22);
				internalFrame.getContentPane().add(textField_22);
				textField_22.setColumns(10);
				
				JLabel lblEmployeeid_1 = new JLabel("EmployeeId");
				lblEmployeeid_1.setBounds(167, 16, 82, 16);
				internalFrame.getContentPane().add(lblEmployeeid_1);
				
				JLabel lblLname = new JLabel("Lname");
				lblLname.setBounds(167, 51, 82, 16);
				internalFrame.getContentPane().add(lblLname);
				
				JLabel lblFname = new JLabel("Fname");
				lblFname.setBounds(167, 86, 82, 16);
				internalFrame.getContentPane().add(lblFname);
				
				JLabel lblPositionid = new JLabel("PositionID");
				lblPositionid.setBounds(167, 121, 82, 16);
				internalFrame.getContentPane().add(lblPositionid);
				
				JLabel lblQualid = new JLabel("QualID");
				lblQualid.setBounds(167, 156, 82, 16);
				internalFrame.getContentPane().add(lblQualid);
				
				JLabel lblDeptid_1 = new JLabel("DeptID");
				lblDeptid_1.setBounds(167, 191, 82, 16);
				internalFrame.getContentPane().add(lblDeptid_1);
				
				JLabel lblSalary = new JLabel("Salary");
				lblSalary.setBounds(167, 226, 82, 16);
				internalFrame.getContentPane().add(lblSalary);
				
				JLabel lblCommission = new JLabel("Commission");
				lblCommission.setBounds(167, 261, 82, 16);
				internalFrame.getContentPane().add(lblCommission);
				
				JLabel lblHiredate = new JLabel("HireDate");
				lblHiredate.setBounds(167, 296, 82, 16);
				internalFrame.getContentPane().add(lblHiredate);
				
				JLabel lblBirthdate = new JLabel("BirthDate");
				lblBirthdate.setBounds(167, 331, 82, 16);
				internalFrame.getContentPane().add(lblBirthdate);
				
				JButton btnInsert_3 = new JButton("Insert");
				btnInsert_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try{
							String EmployeeId=textField_12.getText();
							String Lname=textField_13.getText();
							String Fname=textField_14.getText();
							String PositionID=textField_15.getText();
							String QualID=textField_16.getText();
							String DeptID=textField_17.getText();
							String Salary=textField_19.getText();
							String Commission=textField_20.getText();
							String HireDate=textField_21.getText();
							String BirthDate=textField_22.getText();
							query = "insert into Employee values('"+EmployeeId+"','"+Lname+"','"+Fname+"','"+PositionID+"','"+QualID+"','"+DeptID+"','"+Salary+"','"+Commission+"','"+HireDate+"','"+BirthDate+"')";
						    st = conn.createStatement();
						      st.execute(query);
						      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
						      textField_12.setText("");
						      textField_13.setText("");
						      textField_14.setText("");
						      textField_15.setText("");
						      textField_16.setText("");
						      textField_17.setText("");
						      textField_19.setText("");
						      textField_20.setText("");
						      textField_21.setText("");
						      textField_22.setText("");
	
						}catch(Exception e4)
						{
							if(conn==null)
								JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,e4.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnInsert_3.setBounds(341, 419, 97, 25);
				internalFrame.getContentPane().add(btnInsert_3);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
			}
		});
		btnEmployee.setBounds(33, 377, 113, 25);
		panel_2.add(btnEmployee);
		
		JButton btnPosition = new JButton("Position");
		btnPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Position");
				internalFrame.setBounds(167, 50, 756, 285);
				panel_2.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_23 = new JTextField();
				textField_23.setBounds(240, 37, 116, 22);
				internalFrame.getContentPane().add(textField_23);
				textField_23.setColumns(10);
				
				textField_24 = new JTextField();
				textField_24.setBounds(240, 90, 116, 22);
				internalFrame.getContentPane().add(textField_24);
				textField_24.setColumns(10);
				
				JLabel lblPositonid = new JLabel("PositonID");
				lblPositonid.setBounds(123, 40, 56, 16);
				internalFrame.getContentPane().add(lblPositonid);
				
				JLabel lblPosdesc = new JLabel("PosDesc");
				lblPosdesc.setBounds(123, 93, 56, 16);
				internalFrame.getContentPane().add(lblPosdesc);
				
				JButton btnInsert_4 = new JButton("Insert");
				btnInsert_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try{
							String PositonID=textField_23.getText();
							String PosDesc=textField_24.getText();
							query = "insert into Position values('"+PositonID+"','"+PosDesc+"')";
						    st = conn.createStatement();
						      st.execute(query);
						      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
						      textField_23.setText("");
						      textField_24.setText("");
	
						}catch(Exception e5)
						{
							if(conn==null)
								JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,e5.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnInsert_4.setBounds(240, 154, 97, 25);
				internalFrame.getContentPane().add(btnInsert_4);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
			}
		});
		btnPosition.setBounds(33, 216, 113, 25);
		panel_2.add(btnPosition);
		
		JButton btnQualification = new JButton("Qualification");
		btnQualification.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Qualification");
				internalFrame.setBounds(167, 50, 735, 275);
				panel_2.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_25 = new JTextField();
				textField_25.setBounds(266, 27, 116, 22);
				internalFrame.getContentPane().add(textField_25);
				textField_25.setColumns(10);
				
				textField_26 = new JTextField();
				textField_26.setBounds(266, 83, 116, 22);
				internalFrame.getContentPane().add(textField_26);
				textField_26.setColumns(10);
				
				JLabel lblQualid_1 = new JLabel("QualID");
				lblQualid_1.setBounds(130, 30, 56, 16);
				internalFrame.getContentPane().add(lblQualid_1);
				
				JLabel lblQualdesc = new JLabel("QualDesc");
				lblQualdesc.setBounds(130, 86, 56, 16);
				internalFrame.getContentPane().add(lblQualdesc);
				
				JButton btnInsert_5 = new JButton("Insert");
				btnInsert_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						try{
							String QualID=textField_25.getText();
							String QualDesc=textField_26.getText();
							query = "insert into Qualification values('"+QualID+"','"+QualDesc+"')";
						    st = conn.createStatement();
						      st.execute(query);
						      JOptionPane.showMessageDialog(null,"Inserted","Success",JOptionPane.INFORMATION_MESSAGE);
						      textField_25.setText("");
						      textField_26.setText("");
	
						}catch(Exception e6)
						{
							if(conn==null)
								JOptionPane.showMessageDialog(null,"Not Connect to DB","Error",JOptionPane.ERROR_MESSAGE);
							else
								JOptionPane.showMessageDialog(null,e6.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnInsert_5.setBounds(270, 153, 97, 25);
				internalFrame.getContentPane().add(btnInsert_5);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
			}
		});
		btnQualification.setBounds(33, 300, 113, 25);
		panel_2.add(btnQualification);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("  Display  ", null, panel_3, null);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(216 ,191 ,216));
		
		JButton btnDepartment_1 = new JButton("Department");
		btnDepartment_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Department");
				internalFrame.setBounds(196, 30, 701, 462);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_32 = new JTextField();
				textField_32.setBounds(257, 401, 116, 22);
				internalFrame.getContentPane().add(textField_32);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellDepartment = (String)table_1.getValueAt(row, 0);
				            columnDepartment=(String)table_1.getColumnName(0);
				        }
				    }
				});
				
				table_1.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 626, 379);
				internalFrame.getContentPane().add(scrollPane);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnDepartment=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellDepartment = textField_32.getText();
							 String query1 = "update Department set "+updatecolumnDepartment+"='"+updateInCellDepartment+"' where "+columnDepartment+"='"+valueInCellDepartment+"'";
						     Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     String query = "select * from Department";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("DeptId");
						        String b = rs.getString("DeptName");
						        String c = rs.getString("Location");
						        String d = rs.getString("ManagementId");
						        
						        String[] columnNames = {"DeptId","DeptName", "Location", "ManagementId"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c, d });
						        table_1.setModel(model);
						        
						      }
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 401, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							 query = "delete from Department where "+columnDepartment+"='"+valueInCellDepartment+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     String query = "select * from Department";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("DeptId");
						        String b = rs.getString("DeptName");
						        String c = rs.getString("Location");
						        String d = rs.getString("ManagementId");
						        
						        String[] columnNames = {"DeptId","DeptName", "Location", "ManagementId"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c, d });
						        table_1.setModel(model);
						        
						      }
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 401, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from Department";

			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("DeptId");
			        String b = rs.getString("DeptName");
			        String c = rs.getString("Location");
			        String d = rs.getString("ManagementId");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"DeptId","DeptName", "Location", "ManagementId"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a, b, c, d });
			        table_1.setModel(model);
			      }
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }
			      
			}
		});
		btnDepartment_1.setBounds(30, 56, 121, 25);
		panel_3.add(btnDepartment_1);
		
		JButton btnDependent_1 = new JButton("Dependent");
		btnDependent_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Dependent");
				internalFrame.setBounds(196, 30, 701, 482);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_33 = new JTextField();
				textField_33.setBounds(257, 421, 116, 22);
				internalFrame.getContentPane().add(textField_33);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellDependent = (String)table_1.getValueAt(row,1);
				            columnDependent=(String)table_1.getColumnName(1);
				        }
				    }
				});
				table_1.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(scrollPane);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnDependent=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellDependent = textField_33.getText();
							 String query1 = "update Dependent set "+updatecolumnDependent+"='"+updateInCellDependent+"' where "+columnDependent+"='"+valueInCellDependent+"'";
						     Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     String query = "select * from Dependent";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("EmployeeId");
						        String b = rs.getString("DependentId");
						        String c = rs.getString("DependentDOB");
						        String d = rs.getString("Relation");

						        String[] columnNames = {"EmployeeId","DependentId", "DependentDOB", "Relation"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c, d });
						        table_1.setModel(model);
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 418, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							 query = "delete from Dependent where "+columnDependent+"='"+valueInCellDependent+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     String query = "select * from Dependent";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("EmployeeId");
						        String b = rs.getString("DependentId");
						        String c = rs.getString("DependentDOB");
						        String d = rs.getString("Relation");

						        String[] columnNames = {"EmployeeId","DependentId", "DependentDOB", "Relation"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c, d });
						        table_1.setModel(model);   
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 418, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from Dependent";

			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("EmployeeId");
			        String b = rs.getString("DependentId");
			        String c = rs.getString("DependentDOB");
			        String d = rs.getString("Relation");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"EmployeeId","DependentId", "DependentDOB", "Relation"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a, b, c, d });
			        table_1.setModel(model);
			      }
			      //st.close();
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }			
			}
		});
		btnDependent_1.setBounds(30, 459, 121, 25);
		panel_3.add(btnDependent_1);
		
		JButton btnEmplevel_1 = new JButton("EmpLevel");
		btnEmplevel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("EmpLevel");
				internalFrame.setBounds(196, 30, 701, 482);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_34 = new JTextField();
				textField_34.setBounds(257, 421, 116, 22);
				internalFrame.getContentPane().add(textField_34);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellEmpLevel = (String)table_1.getValueAt(row,0);
				            columnEmpLevel=(String)table_1.getColumnName(0);
				        }
				    }
				});
				table_1.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(scrollPane);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnEmpLevel=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellEmpLevel = textField_34.getText();
							 String query1 = "update EmpLevel set "+updatecolumnEmpLevel+"='"+updateInCellEmpLevel+"' where "+columnEmpLevel+"='"+valueInCellEmpLevel+"'";
						     Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     String query = "select * from EmpLevel";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("LevelNo");
						        String b = rs.getString("Lowsalary");
						        String c = rs.getString("Highsalary");

						        String[] columnNames = {"LevelNo","Lowsalary", "Highsalary"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c });
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 418, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							 query = "delete from EmpLevel where "+columnEmpLevel+"='"+valueInCellEmpLevel+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     String query = "select * from EmpLevel";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("LevelNo");
						        String b = rs.getString("Lowsalary");
						        String c = rs.getString("Highsalary");

						        String[] columnNames = {"LevelNo","Lowsalary", "Highsalary"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b, c });
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 418, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from EmpLevel";

			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("LevelNo");
			        String b = rs.getString("Lowsalary");
			        String c = rs.getString("Highsalary");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"LevelNo","Lowsalary", "Highsalary"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a, b, c });
			        table_1.setModel(model);		        
			      }
			      //st.close();
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }
			}
		});
		btnEmplevel_1.setBounds(30, 136, 121, 25);
		panel_3.add(btnEmplevel_1);
		
		JButton btnEmployee_1 = new JButton("Employee");
		btnEmployee_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Employee");
				internalFrame.setBounds(189, 30, 979, 481);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_35 = new JTextField();
				textField_35.setBounds(257, 421, 116, 22);
				internalFrame.getContentPane().add(textField_35);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellEmployee = (String)table_1.getValueAt(row,0);
				            columnEmployee=(String)table_1.getColumnName(0);
				        }
				    }
				});
				table_1.setBounds(12, 13, 26, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 926, 400);
				internalFrame.getContentPane().add(scrollPane);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnEmployee=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellEmployee = textField_35.getText();
							 String query1 = "update Employee set "+updatecolumnEmployee+"='"+updateInCellEmployee+"' where "+columnEmployee+"='"+valueInCellEmployee+"'";
						     Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     query = "select * from Employee";
						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("EmployeeId");
						        String b = rs.getString("Lname");
						        String c = rs.getString("Fname");
						        String d = rs.getString("PositionId");
						        String ee = rs.getString("QualId");
						        String f = rs.getString("DeptId");
						        String g = rs.getString("Salary");
						        String h = rs.getString("Comission");
						        String i = rs.getString("HireDate");
						        String j = rs.getString("BirthDate");

						        String[] columnNames = {"EmployeeId","Lname", "Fname", "PositionId","QualId","DeptId","Salary","Comission","HireDate","BirthDate"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a,b,c,d,ee,f,g,h,i,j});
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 418, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							String query = "delete from Employee where "+columnEmployee+"='"+valueInCellEmployee+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     query = "select * from Employee";
						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("EmployeeId");
						        String b = rs.getString("Lname");
						        String c = rs.getString("Fname");
						        String d = rs.getString("PositionId");
						        String ee = rs.getString("QualId");
						        String f = rs.getString("DeptId");
						        String g = rs.getString("Salary");
						        String h = rs.getString("Comission");
						        String i = rs.getString("HireDate");
						        String j = rs.getString("BirthDate");

						        String[] columnNames = {"EmployeeId","Lname", "Fname", "PositionId","QualId","DeptId","Salary","Comission","HireDate","BirthDate"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a,b,c,d,ee,f,g,h,i,j});
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 418, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from Employee";
			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("EmployeeId");
			        String b = rs.getString("Lname");
			        String c = rs.getString("Fname");
			        String d = rs.getString("PositionId");
			        String ee = rs.getString("QualId");
			        String f = rs.getString("DeptId");
			        String g = rs.getString("Salary");
			        String h = rs.getString("Comission");
			        String i = rs.getString("HireDate");
			        String j = rs.getString("BirthDate");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"EmployeeId","Lname", "Fname", "PositionId","QualId","DeptId","Salary","Comission","HireDate","BirthDate"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a,b,c,d,ee,f,g,h,i,j});
			        table_1.setModel(model);		        
			      }
			      //st.close();
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }
			}
		});
		btnEmployee_1.setBounds(30, 377, 121, 25);
		panel_3.add(btnEmployee_1);
		
		JButton btnPosition_1 = new JButton("Position");
		btnPosition_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Position");
				internalFrame.setBounds(196, 30, 701, 482);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_36 = new JTextField();
				textField_36.setBounds(257, 421, 116, 22);
				internalFrame.getContentPane().add(textField_36);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellPosition = (String)table_1.getValueAt(row, 0);
				            columnPosition=(String)table_1.getColumnName(0);
				        }
				    }
				});
				table_1.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(scrollPane);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnPosition=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellPosition = textField_36.getText();
							 String query1 = "update Position set "+updatecolumnPosition+"='"+updateInCellPosition+"' where "+columnPosition+"='"+valueInCellPosition+"'";
						     Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     query = "select * from Position";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("PositionId");
						        String b = rs.getString("PosDesc");

						        String[] columnNames = {"PositionId","PosDesc"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b });
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 418, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							String query = "delete from Position where "+columnPosition+"='"+valueInCellPosition+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     query = "select * from Position";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("PositionId");
						        String b = rs.getString("PosDesc");

						        String[] columnNames = {"PositionId","PosDesc"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b });
						        table_1.setModel(model);		        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 418, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from Position";

			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("PositionId");
			        String b = rs.getString("PosDesc");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"PositionId","PosDesc"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a, b });
			        table_1.setModel(model);		        
			      }
			      //st.close();
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }
			}
		});
		btnPosition_1.setBounds(30, 216, 121, 25);
		panel_3.add(btnPosition_1);
		
		JButton btnQualification_1 = new JButton("Qualification");
		btnQualification_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JInternalFrame internalFrame = new JInternalFrame("Qualification");
				internalFrame.setBounds(196, 30, 701, 482);
				panel_3.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
				internalFrame.setBackground(new Color(205 ,193, 197));
				
				textField_37 = new JTextField();
				textField_37.setBounds(257, 421, 116, 22);
				internalFrame.getContentPane().add(textField_37);
				
				table_1 = new JTable();
				table_1.addMouseListener(new MouseAdapter() {
					//getting value in particular cell
					@Override
					public void mousePressed(final MouseEvent e) {
				        if (e.getClickCount() == 1) {
				            table_1= (JTable)e.getSource();
				            final int row = table_1.getSelectedRow();
				            valueInCellQualification = (String)table_1.getValueAt(row,0);
				            columnQualification=(String)table_1.getColumnName(0);
				        }
				    }
				});
				table_1.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(table_1);
				
				JScrollPane scrollPane = new JScrollPane(table_1);
				scrollPane.setBounds(12, 13, 626, 400);
				internalFrame.getContentPane().add(scrollPane);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				table_1.addFocusListener(new FocusAdapter(){

					@Override
					public void focusLost(FocusEvent e1) {
						table_1= (JTable)e1.getSource();
			            final int column1 = table_1.getSelectedColumn();
			            updatecolumnQualification=(String)table_1.getColumnName(column1);
					}	
				});
				
				JButton btnUpdButton = new JButton("Update");
				btnUpdButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//Update operation
						try
						{
							 updateInCellQualification = textField_37.getText();
							 String query1 = "update Qualification set "+updatecolumnQualification+"='"+updateInCellQualification+"' where "+columnQualification+"='"+valueInCellQualification+"'";
						     System.out.println(query1);
							 Statement st1 = conn.createStatement();
						     st1.executeQuery(query1);
						     query = "select * from Qualification";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("QualId");
						        String b = rs.getString("QualDesc");

						        String[] columnNames = {"QualId","QualDesc"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b});
						        table_1.setModel(model);			        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						      JOptionPane.showMessageDialog(null,"Updated","Success",JOptionPane.INFORMATION_MESSAGE);
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnUpdButton.setBounds(157, 418, 97, 25);
				internalFrame.getContentPane().add(btnUpdButton);
				
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						model.setRowCount(0);
						//delete operation
						try
						{
							String query = "delete from Qualification where "+columnQualification+"='"+valueInCellQualification+"'";
						     Statement st = conn.createStatement();
						     st.executeQuery(query);
						     query = "select * from Qualification";

						      try{
						      PreparedStatement ps=conn.prepareStatement(query);
						      rs =ps.executeQuery(query);
						      while (rs.next())
						      {
						        String a = rs.getString("QualId");
						        String b = rs.getString("QualDesc");

						        String[] columnNames = {"QualId","QualDesc"};
						        model.setColumnIdentifiers(columnNames);
						       
						        model.addRow(new Object[]{ a, b});
						        table_1.setModel(model);			        
						      }
						      //st.close();
						      }catch (Exception e6)
						      {
						    	  if(conn==null)
										JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
						      }
						}catch(Exception e8)
						{
							JOptionPane.showMessageDialog(null,e8.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(47, 418, 97, 25);
				internalFrame.getContentPane().add(btnNewButton);
				internalFrame.setClosable(true);
				internalFrame.setVisible(true);
				
				String query = "select * from Qualification";

			      try{
			      PreparedStatement ps=conn.prepareStatement(query);
			      rs =ps.executeQuery(query);
			      while (rs.next())
			      {
			        String a = rs.getString("QualId");
			        String b = rs.getString("QualDesc");

			        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			        String[] columnNames = {"QualId","QualDesc"};
			        model.setColumnIdentifiers(columnNames);
			       
			        model.addRow(new Object[]{ a, b});
			        table_1.setModel(model);			        
			      }
			      //st.close();
			      }catch (Exception e6)
			      {
			    	  if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
			      }
			}
		});
		btnQualification_1.setBounds(30, 300, 121, 25);
		panel_3.add(btnQualification_1);				
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("    Drop    ", null, panel_4, null);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(216 ,191 ,216));
		
		JButton btnDepartment_2 = new JButton("Department");
		btnDepartment_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try{
					query = "drop table Department";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table Department dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e)
				{
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDepartment_2.setBounds(513, 76, 152, 25);
		panel_4.add(btnDepartment_2);
		
		JButton btnDependent_2 = new JButton("Dependent");
		btnDependent_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "drop table Dependent";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table Dependent dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e1)
			    {
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDependent_2.setBounds(513, 449, 152, 25);
		panel_4.add(btnDependent_2);
		
		JButton btnEmplevel_2 = new JButton("EmpLevel");
		btnEmplevel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "drop table EmpLevel";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table EmpLevel dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e2)
			    {
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e2.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnEmplevel_2.setBounds(513, 148, 152, 25);
		panel_4.add(btnEmplevel_2);
		
		JButton btnEmployee_2 = new JButton("Employee");
		btnEmployee_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "drop table Employee";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table Employee dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e3)
			    {
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e3.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEmployee_2.setBounds(513, 371, 152, 25);
		panel_4.add(btnEmployee_2);
		
		JButton btnPosition_2 = new JButton("Position");
		btnPosition_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "drop table Position";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table Position dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e4)
			    {
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e4.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		btnPosition_2.setBounds(513, 223, 152, 25);
		panel_4.add(btnPosition_2);
		
		JButton btnQualification_2 = new JButton("Qualification");
		btnQualification_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try{
					query = "drop table Qualification";
				    st = conn.createStatement();
				    st.executeQuery(query);
				    JOptionPane.showMessageDialog(null,"Table Qualification dropped","Success",JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e5)
			    {
				      if(conn==null)
							JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				      else
				    	  JOptionPane.showMessageDialog(null,e5.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnQualification_2.setBounds(513, 295, 152, 25);
		panel_4.add(btnQualification_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Query", null, panel_5, null);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(216 ,191 ,216));
		
		JLabel lblTableName = new JLabel("Table name:");
		lblTableName.setBounds(42, 54, 95, 25);
		panel_5.add(lblTableName);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setBounds(150, 54, 124, 25);
		panel_5.add(comboBox1);
		comboBox1.addItem("Department");
		comboBox1.addItem("Dependent");
		comboBox1.addItem("EmpLevel");
		comboBox1.addItem("Employee");
		comboBox1.addItem("Position");
		comboBox1.addItem("Qualification");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				tablename=(String) comboBox1.getSelectedItem();
				
				JInternalFrame layeredPane = new JInternalFrame();
				layeredPane.setBounds(336, 13, 790, 557);
				layeredPane.setBackground(new Color(205 ,193, 197));
				panel_5.add(layeredPane);
				layeredPane.getContentPane().setLayout(null);
				layeredPane.setVisible(true);
				layeredPane.setClosable(true);
				
				JComboBox comboBox = new JComboBox();
				comboBox.setBounds(12, 42, 132, 22);
				layeredPane.getContentPane().add(comboBox);
				
				if(conn==null)
					JOptionPane.showMessageDialog(null,"Not Connected to DB","Error",JOptionPane.ERROR_MESSAGE);
				if(tablename.equalsIgnoreCase("Department")||tablename.equalsIgnoreCase("Dependent")||tablename.equalsIgnoreCase("EmpLevel")||tablename.equalsIgnoreCase("Employee")||tablename.equalsIgnoreCase("Position")||tablename.equalsIgnoreCase("Qualification"))
				{																			
					if(tablename.equalsIgnoreCase("Department"))
					{
						comboBox.addItem("DeptID");
						comboBox.addItem("DeptName");
						comboBox.addItem("Location");
						comboBox.addItem("ManagementID");
					}
					else if(tablename.equalsIgnoreCase("EmpLevel"))
					{
						comboBox.addItem("LevelNo");
						comboBox.addItem("Lowsalary");
						comboBox.addItem("Highsalary");
					}
					else if(tablename.equalsIgnoreCase("Position"))
					{
						comboBox.addItem("PositionID");
						comboBox.addItem("PosDesc");
					}
					else if(tablename.equalsIgnoreCase("Qualification"))
					{
						comboBox.addItem("QualID");
						comboBox.addItem("QualDesc");
					}
					else if(tablename.equalsIgnoreCase("Employee"))
					{
						comboBox.addItem("EmployeeID");
						comboBox.addItem("Lname");
						comboBox.addItem("Fname");
						comboBox.addItem("PositionID");
						comboBox.addItem("QualID");
						comboBox.addItem("DeptID");
						comboBox.addItem("Salary");
						comboBox.addItem("Comission");
						comboBox.addItem("HireDate");
						comboBox.addItem("BirthDate");
					}
					else if(tablename.equalsIgnoreCase("Dependent"))
					{
						comboBox.addItem("EmployeeID");
						comboBox.addItem("DependentID");
						comboBox.addItem("DependentDOB");
						comboBox.addItem("Relation");
					}		
				}    
				else
					JOptionPane.showMessageDialog(null,"Invalid Tablename","Error",JOptionPane.ERROR_MESSAGE);
				
				JButton btnSubmit_1 = new JButton("Submit");
				btnSubmit_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						table.removeAll();
						String item=(String) comboBox.getSelectedItem();
						try {
						String query = "select "+item+" from "+tablename+"";
					    PreparedStatement ps=conn.prepareStatement(query);
					      rs =ps.executeQuery(query);
					      while (rs.next())
					      {
					        String a = rs.getString(item);
					        
					        String[] columnNames = {item};
					        model.setColumnIdentifiers(columnNames);
					       
					        model.addRow(new Object[]{a});
					        table.setModel(model);
					      }
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnSubmit_1.setBounds(22, 77, 97, 25);
				layeredPane.getContentPane().add(btnSubmit_1);
				
				textField_28 = new JTextField();
				textField_28.setBounds(166, 42, 116, 22);
				layeredPane.getContentPane().add(textField_28);
				textField_28.setColumns(10);
				
				JButton btnSubmit_2 = new JButton("Submit");
				btnSubmit_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						String item=(String) comboBox.getSelectedItem();
						String id=textField_28.getText();
						try {
							String query1 = "select * from "+tablename+" where "+item+"='"+id+"'";
						    PreparedStatement ps=conn.prepareStatement(query1);
						    rs =ps.executeQuery(query1);
						      if(tablename.equalsIgnoreCase("Department"))
								{
						    	  	while (rs.next())
						    	  	{
						    	  		String a = rs.getString("DeptId");
						    	  		String b = rs.getString("DeptName");
						    	  		String c = rs.getString("Location");
						    	  		String d = rs.getString("ManagementId");

						    	  		String[] columnNames = {"DeptId","DeptName", "Location", "ManagementId"};
						    	  		model.setColumnIdentifiers(columnNames);
							       
						    	  		model.addRow(new Object[]{ a, b, c, d });
						    	  		table.setModel(model);
						    	  	}
								}	
								else if(tablename.equalsIgnoreCase("EmpLevel"))
								{
									while (rs.next())
									{
										String a = rs.getString("LevelNo");
										String b = rs.getString("Lowsalary");
										String c = rs.getString("Highsalary");

										String[] columnNames = {"LevelNo","Lowsalary", "Highsalary"};
										model.setColumnIdentifiers(columnNames);
								       
										model.addRow(new Object[]{ a, b, c });
										table.setModel(model);		        
									}
								}
								else if(tablename.equalsIgnoreCase("Position"))
								{
									while (rs.next())
								    {
								        String a = rs.getString("PositionId");
								        String b = rs.getString("PosDesc");

								        String[] columnNames = {"PositionId","PosDesc"};
								        model.setColumnIdentifiers(columnNames);
								       
								        model.addRow(new Object[]{ a, b });
								        table.setModel(model);		        
								    }
								}
								else if(tablename.equalsIgnoreCase("Qualification"))
								{
									while (rs.next())
								    {
								        String a = rs.getString("QualId");
								        String b = rs.getString("QualDesc");

								        String[] columnNames = {"QualId","QualDesc"};
								        model.setColumnIdentifiers(columnNames);
								       
								        model.addRow(new Object[]{ a, b});
								        table.setModel(model);			        
								    }
								}
								else if(tablename.equalsIgnoreCase("Employee"))
								{
									while (rs.next())
								    {
								        String a = rs.getString("EmployeeId");
								        String b = rs.getString("Lname");
								        String c = rs.getString("Fname");
								        String d = rs.getString("PositionId");
								        String ee = rs.getString("QualId");
								        String f = rs.getString("DeptId");
								        String g = rs.getString("Salary");
								        String h = rs.getString("Comission");
								        String i = rs.getString("HireDate");
								        String j = rs.getString("BirthDate");

								        String[] columnNames = {"EmployeeId","Lname", "Fname", "PositionId","QualId","DeptId","Salary","Comission","HireDate","BirthDate"};
								        model.setColumnIdentifiers(columnNames);
								       
								        model.addRow(new Object[]{ a,b,c,d,ee,f,g,h,i,j});
								        table.setModel(model);		        
								    }
								}
								else if(tablename.equalsIgnoreCase("Dependent"))
								{
									while (rs.next())
								    {
								        String a = rs.getString("EmployeeId");
								        String b = rs.getString("DependentId");
								        String c = rs.getString("DependentDOB");
								        String d = rs.getString("Relation");

								        String[] columnNames = {"EmployeeId","DependentId", "DependentDOB", "Relation"};
								        model.setColumnIdentifiers(columnNames);
								       
								        model.addRow(new Object[]{ a, b, c, d });
								        table.setModel(model);
								        
								    }
								}		
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
							}
					}
				});
				btnSubmit_2.setBounds(176, 77, 97, 25);
				layeredPane.getContentPane().add(btnSubmit_2);
				
				JLabel lblColumnName = new JLabel("Column Name");
				lblColumnName.setBounds(12, 13, 97, 16);
				layeredPane.getContentPane().add(lblColumnName);
				
				JLabel lblId = new JLabel("ID:");
				lblId.setBounds(167, 13, 56, 16);
				layeredPane.getContentPane().add(lblId);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(12, 111, 750, 397);
				layeredPane.getContentPane().add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);	
			}
		});
		btnSubmit.setBounds(149, 95, 97, 25);
		panel_5.add(btnSubmit);	
	}
}
