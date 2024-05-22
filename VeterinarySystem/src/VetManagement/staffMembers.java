package VetManagement;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.io.*;
public class staffMembers extends JPanel implements ActionListener{
	private DefaultTableModel model;
	private JButton addButton;
	private JTable table;
	private JButton deleteMem;
	private String name;
	private String designation;
	private String address;
	private String email;
	private String contact;
	
 staffMembers() {
	
 	JPanel tablePanel = new JPanel();   
 	tablePanel.setBounds(15, 80, 696, 472);
 	tablePanel.setLayout(new BorderLayout());
 	String[] coloumns = {"Name","Designation","Address" , "Email Address","Contact Number"}; // THIS LINE IS MAGIINITIALIZE TAYO PARA SA COLOUMN NUNG JTABLE NA GAGAMITIN.PARANG HEADER ETO NUNG TABLE NATEN
 	
	model = new DefaultTableModel(new Object[0][],coloumns) {  //DEFAULT TABLE MODEL. ITO YUNG MAGSESERVE AS DATAHANDLER NG JTABLE.WHAT DO I MEAN BY THAT? - NEED NATEN IPASA YUNG JTABLE NATEN SA JMODEL PARA MAS MANIPULATE NATEN YUNG DATA WITHIN THE JTABLE.MAKAKAREMOVE AND ADD TAYO NG DATA IF GAGAMIT TAYO NG TABLE MODEL.
		public boolean isCellEditable(int row , int coloumn){  //THEN DITO IS NAG OVERRIDE TAYO NG METHOD WHICH IS THE CELLEDITABLE.NAGRERECEIVE LANG NG BOOLEAN YUNG CELL EDITABLE KAYA NAGRETURN TAYO NG FALSE.FALSE BECAUSE WE DONT WANT NA MAACCESS NG USER YUNG KADA CELLS NG JTABLE.TRY NYO ILAGAY TO PARA MAS MAINTINDIHAN NYO YUNG CODE."return row == 1" which will make the row 1 uneditable.
			return false;
		}
	};
	
	
	loadData(model); //loadData method. icacall naten to dito para magshow agad sa JTable naten yung data na nasa text file.   PS.Textfile is dun tayo nag sstore ng data naten para kahit iclose yung system is nandun parin yung mga data na ininput ng user.
	setLayout(null);
	table = new JTable(model);  // eto na yung JTable naten.dito magshoshow lahat ng data na nasa tableModel naten.
	
	
	JScrollPane scrollPane = new JScrollPane(table);    // gumamit tayo ng scrollpane dito para kapag di na kasya sa table yung data is magkakaroon ng scroll bar sa gilid nung table
	tablePanel.add(scrollPane, BorderLayout.CENTER);  // kapag pala ipinasa naten yung table naten sa scrollpane is dapat scrollpane yung iaadd naten sa panel para may scroll panel yung JTable naten kase if table lang ipapasa naten is di sya magkakaroon ng scroll bar when it is needed. 
	
	
	JLabel staffLabel = new JLabel("STAFF MEMBERS");    //title lang toh ng panel
	staffLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	staffLabel.setBounds(25, 28, 142, 45);
	
	addButton = new JButton("ADD");          //initialize naten dito yung add button
	addButton.setBounds(516, 50, 89, 23);
	addButton.addActionListener(this);      //nag add tayo ng action listener dito para magkafunction yung add button
	
	

	deleteMem = new JButton("DELETE");   
	deleteMem.setBounds(615, 50, 89, 23);
	deleteMem.addActionListener(this);
	
	add(addButton);            //ADD THE COMPONENTS TO THE PANEL
	add(tablePanel);
	add(staffLabel);
	add(deleteMem);
	
	
	

	

}

@Override
public void actionPerformed(ActionEvent e) {          //SO THIS IS THE LOGIC NA PARA DUN SA ADD BUTTON AND DELETE BUTTON       
	 JButton click = (JButton)e.getSource();       // KUKUNIN NG LINE NA TOH YUNG MGA BUTTONS NATEN. ANG BUTTONS ATA NATEN IS DELETE AND ADD. FOR EXAMPLE "IF(CLICK == ADDBUTTON))", ANG IBIG SABIHIN NETO IS ONCE NA PRINESS NATEN YUNG SPECIFIC BUTTON IS MAY LOGIC TAYONG GAGAWIN
	 JTextField nameField;             
	 JTextField designationField;  
	 JTextField addressField;
	 JTextField emailField;
	 JTextField contactField;
	 JFrame frame = new JFrame();
	
	if(click == addButton) {              //ONCE NA PININDOT NATEN YUNG ADD BUTTON IS MAY BAGONG FRAME NA MAGPROPROMPT SA SCREEN WHICH IS PARA SA DATA NUNG STAFF MEMBERS.91-147 IS SINESET LANG NATEN YUNG MGA JTEXTFIELD PARA SA NAME,DESIGNATION,ADDRESS,EMAIL AT CONTACT NUMBER NG STAFF MEMBERS
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setBounds(100, 100, 442, 542);
	frame.setTitle("INFORMATION");	
	frame.setLocationRelativeTo(null);
	setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 428, 505);
	frame.getContentPane().add(panel);
	panel.setLayout(null);
	
	JLabel nameLabel = new JLabel("Name");
	nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	nameLabel.setBackground(new Color(240, 240, 240));
	nameLabel.setBounds(10, 76, 45, 29);
	
	
	nameField = new JTextField();
	nameField.setBounds(95, 79, 292, 27);
	
	
	
	JLabel designationLabel = new JLabel("Designation");
	designationLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	designationLabel.setBounds(10, 133, 80, 29);
	
	
	designationField = new JTextField();
	designationField.setBounds(95, 136, 292, 27);
	
	
	JLabel Address = new JLabel("Address");
	Address.setFont(new Font("Tahoma", Font.PLAIN, 15));
	Address.setBounds(10, 194, 80, 29);
	
	
	addressField = new JTextField();
	addressField.setBounds(95, 196, 292, 27);
	
	
	JLabel emailLabel = new JLabel("Email");
	emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	emailLabel.setBounds(15, 253, 80, 29);

	
	emailField = new JTextField();
	emailField.setBounds(95, 255, 292, 27);
	
	contactField = new JTextField();
	contactField.setBounds(95, 319, 292, 27);
	JLabel contactLabel = new JLabel("Contact");
	contactLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	contactLabel.setBounds(15, 316, 80, 29);
	
	
	JButton addMembers = new JButton("ADD");
	
	addMembers.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			name = nameField.getText();         //DITO IS SSTORE NATEN YUNG DATA FROM JTEXTFIELD PARA MAIPASA NATEN SA MODEL NG TABLE. AS WHAT I SAID EARLIER YUNG TABLE MODEL YUNG MAGMAMANIPULATE NG DATA NG JTABLE.
            designation = designationField.getText();
            address = addressField.getText();
            email = emailField.getText();
            contact = contactField.getText();
            
            saveData(name , designation , address , email, contact);  // CACALL NATEN YUNG METHOD NA RESPONSIBLE PARA SA PAGSAVE NG DATA SA TEXTFILE.THE PARAMETERS IS NAME,DESIGNATION,ADDRESS,EMAIL AT CONTACT NUMBER.NEED NATEN IPASA MGA TOH MAMAYA SA METHOD PARA MAILAGAY YUNG PER DATA SA FILE.
            model.addRow(new Object[]{name , designation , address , email, contact});  //WHAT IS OBJECT? OBJECT IS A CLASS IN JAVA NA KAYANG MAKAPAGHOLD NG DIFFERENT DATA TYPES AND OBJECTS WHICH IS BUTTONS AND ETC. SO IN THIS LINE WE ARE ADDING A ROW IN THE TABLE MODEL WHICH IS YUNG MGA DATA NA ININPUT NG USER.ACTUALLY PEDE PA NATEN LAGYAN NG BUTTONS YUNG ROWS NG TABLE EH BUT MASYADONG TEDIOUS NA PROCEDURE NON.        
			//WHY NEW OBJECT ? YUNG TABLE MODEL KASE IS NAG AACCEPT LANG SIYA NG OBJECT ARRAY KAYA KAILANGAN NATING GAWING OBJECT YUNG STRINGS AND OTHER DATA.DINESIGN NG JAVA SWING YUN KASE HINDI LANG NAMAN IISANG DATA TYPE YUNG LAMAN NG KADA CELLS NG JTABLE.
            
            frame.dispose();		
		}
	});
    
	
	
	addMembers.setBounds(175, 370, 89, 23);
	addMembers.setBackground(Color.WHITE);
	panel.add(emailLabel);
	panel.add(addMembers);
	panel.add(emailField);
	panel.add(Address);
	panel.add(designationField);
	panel.add(addressField);
	panel.add(designationLabel);
	panel.add(nameField);
	panel.add(nameLabel);
	panel.add(contactField);
	panel.add(contactLabel);
    frame.setVisible(true);
	} 
	
	
	if (click == deleteMem) {
		deleteRow(model);             // WILL DELETE THE SELECTED ROW 
	}

}
   

//THIS WILL SAVE THE DATAS
   
public void deleteRow(DefaultTableModel model) {
	   int selected = table.getSelectedRow();
	   if(selected != -1) {
		   model.removeRow(selected);
		   rewriteData(model);
	   }
	   saveData(name , designation , address , email, contact);
}



   public void saveData(String name , String designation , String Address , String email,String contact) {
	   try {
	   BufferedWriter writer = new BufferedWriter(new FileWriter("staff.txt" , true));  //BUFFEREDWRITER THIS WILL WRITE THE DATA IN OUR TEXT FILE, KAYA PINASA NATEN YUNG NAMES AND ETC KANINA KASE ILALAGAY NATEN SYA SA TEXT FILE.
	   writer.write(name);          //WRITER IS YUNG BUFFERED WRITER NA DINECLARE NATEN. THIS LINE IS SIMPLY WRITING THE NAME IN THE TEXT FILE.THEN MAG NEWNEW LINE SYA ONCE NA NAIWRITE NA.
	   writer.newLine();
	   writer.write(designation);
	   writer.newLine();
	   writer.write(Address);
	   writer.newLine();
	   writer.write(email);
	   writer.newLine();
	   writer.write(contact);
	   writer.newLine();
	   
	   writer.close();       // TAKE NOTE NA NEED LAGI MAISARA YUNG WRITER PARA MAIWASAN YUNG MEMORY LEAKS.
	   }
	   
	   catch(IOException e) {
		  e.printStackTrace(); // IPRIPRINT NETO YUNG ERROR ONCE NA MAY MAG OCCUR SA TRY BLOCK NATEN.
	   }
	   
	   }
 
   
   public void loadData(DefaultTableModel model) {  //THIS WILL LOAD ALL THE DATA IN THE JTABLE
	  try {
	  BufferedReader reader = new BufferedReader(new FileReader("staff.txt")); //BUFFERED READER NAMAN IS ICHECHECK NIYA YUNG MGA DATA SA TEXT FILE PARA MAIPASA SA JTABLE.
	  String line; // ETO YUNG MAGCHECHECK NG BAWAT LINE DUN SA TEXT FILE
	  while((line = reader.readLine()) != null) {    //HANGGANG MAY NAREREAD NA TEXT YUNG LINE NATEN HINDI SYA MAG SSTOP.NULL KASE YUNG DULO NG BAWAT TEXT FILE KAYA ONCE NA NASA DULO NA SIYA AUTOMATIC NA SIYANG MAGSSTOP SA PAGREAD.
		  if(!line.trim().isEmpty()) { //IF THE LINE IS NOT EMPTY IEEXECUTE NYA YUNG CODE BELOW.TRIM() IS A METHOD IN JAVA NA TATANGALIN NYA YUNG SPACES SA START AND END NG STRING.THEN ONCE NA NATANGGAL NA YUNG SPACES IS ICHECHECH NYA NAMAN KUNG EMPTY NA YUNG STRING.
		  //FOR EXAMPLE IF THE LINE IS " " OR "    " OR " " OR "     " IS CONSIDERED AS EMPTY.
		  //MAG RURUN LANG YUNG CODE BELOW HANGGANG HINDI EMPTY YUNG STRING.
			  
		  String name = line;    // INILAGAY KO YUNG LINE SA NAME KASE SA NAME MASSTORE YUNG UNANG MAREREAD NA TEXT NUNG LINE. PABABA LANG NG PABABA YUNG PAGREAD NUNG LINE THEN ONCE NA MAKARATING NA SA END IS IAADD NA SYA SA TABLE THEN CONTINUE ULIT YUNG PAGREAD NG LINE HANGGANG SA DULO NG TEXT FILE.
		  String designation = reader.readLine();
		  String address = reader.readLine();
		  String email = reader.readLine();
		  String contact = reader.readLine();
		  model.addRow(new Object[] { name , designation , address ,email, contact}); 
          
	  }
	  }
	  reader.close();    // NEED DIN SIYA ICLOSE KATULAD NUNG SA WRITER PARA MAIWASAN YUNG MEMORY LEAKS.	
	  }
	  catch(IOException e){
	  e.printStackTrace();	  
	  }
  }

// Method to rewrite data in a file using data from a DefaultTableModel
public void rewriteData(DefaultTableModel model) {   

    // Try block to catch any IOExceptions
    try {

        // Create a BufferedWriter to write to a file named "staff.txt"
        // The second parameter 'false' means the file will be overwritten, not appended to
        BufferedWriter writer = new BufferedWriter(new FileWriter("staff.txt", false));

        // Loop through each row in the model
        for (int i = 0; i < model.getRowCount(); i++) {

            // Write the value at column 0 of the current row to the file
            writer.write(model.getValueAt(i, 0).toString());

            // Write a new line to the file
            writer.newLine();

            // Write the value at column 1 of the current row to the file
            writer.write(model.getValueAt(i, 1).toString());

            // Write a new line to the file
            writer.newLine();

            // Write the value at column 2 of the current row to the file
            writer.write(model.getValueAt(i, 2).toString());

            // Write a new line to the file
            writer.newLine();

            // Write the value at column 3 of the current row to the file
            writer.write(model.getValueAt(i, 3).toString());

            // Write a new line to the file
            writer.newLine();

            // Write the value at column 4 of the current row to the file
            writer.write(model.getValueAt(i, 4).toString());

            // Write a new line to the file
            writer.newLine();
        }

        // Close the BufferedWriter to free up system resources
        writer.close();

    // Catch block to handle any IOExceptions
    } catch(IOException e) {

        // Print the stack trace for the IOException to the console
        e.printStackTrace(); 
    }
}
}


