import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AddAutomateFilesWindow extends JFrame implements ActionListener, ChangeListener {
	
	private static final long serialVersionUID = 1L;
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	
	private SelectFile selectedFile;
	
	String filePathWord;
	String filePathM1;
	String filePathM2;
	String filePathAlphabet;
	
	public AddAutomateFilesWindow() {
		super();
		build();
	}
	
	private void build(){

		/* initialization window */
		setTitle("Add automate files");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		
		this.setResizable(false);

		JPanel jPanelMain = new JPanel();
		
		jPanelMain.setLayout(new GridLayout(6,1));
		
		JPanel jPanel0 = new JPanel();
		JPanel jPanel1 = new JPanel();
		JPanel jPanel2 = new JPanel();
		JPanel jPanel3 = new JPanel();
		JPanel jPanel4 = new JPanel();
		JPanel jPanel5 = new JPanel();
		
		jPanelMain.add(jPanel0);
		jPanelMain.add(jPanel1);
		jPanelMain.add(jPanel2);
		jPanelMain.add(jPanel3);
		jPanelMain.add(jPanel4);
		jPanelMain.add(jPanel5);
		
		button1 = new JButton("Select");
		button2 = new JButton("Select");
		button3 = new JButton("Select");
		button4 = new JButton("Select");
		button5 = new JButton("Finish");
		button6 = new JButton("Cancel");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		/* Add JPanel 0 */
		final JLabel area0 = new JLabel("", JLabel.LEFT);
		area0.setPreferredSize(new Dimension(400,25));
		area0.setText("Please select files :");
		jPanel0.add(area0);
		
		/* Add JPanel 1 */
		JLabel area1 = new JLabel("Word :", JLabel.RIGHT);
		area1.setPreferredSize(new Dimension(70,25));
		final JTextField field1 = new JTextField(20);
		jPanel1.add(area1);
		jPanel1.add(field1);
		
		button1.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  selectedFile = new SelectFile ();
		    	  field1.setText(selectedFile.getSelectedFile().toString());
		      }   
		});
	    jPanel1.add(button1);
		
		/* Add JPanel 2 */
		JLabel area2 = new JLabel("M1 :", JLabel.RIGHT);
		area2.setPreferredSize(new Dimension(70,25));
		final JTextField field2 = new JTextField(20);
		jPanel2.add(area2);
		jPanel2.add(field2);
		
		button2.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  selectedFile = new SelectFile ();
		    	  field2.setText(selectedFile.getSelectedFile().toString());
		      }   
		});
		jPanel2.add(button2);
		
		/* Add JPanel 3 */
		JLabel area3 = new JLabel("M2 :", JLabel.RIGHT);
		area3.setPreferredSize(new Dimension(70,25));
		final JTextField field3 = new JTextField(20);
		jPanel3.add(area3);
		jPanel3.add(field3);
		
		button3.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  selectedFile = new SelectFile ();
		    	  field3.setText(selectedFile.getSelectedFile().toString());
		      }   
		});
		jPanel3.add(button3);
		
		/* Add JPanel 4 */
		JLabel area4 = new JLabel("Alphabet :", JLabel.RIGHT);
		area4.setPreferredSize(new Dimension(70,25));
		final JTextField field4 = new JTextField(20);
		jPanel4.add(area4);
		jPanel4.add(field4);
		
		button4.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  selectedFile = new SelectFile ();
		    	  field4.setText(selectedFile.getSelectedFile().toString());
		      }   
		});
		jPanel4.add(button4);
		
		/* Add JPanel 5 */
		JLabel area5 = new JLabel("", JLabel.RIGHT);
		area5.setPreferredSize(new Dimension(225,30));
		jPanel5.add(area5);
	
		button5.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  filePathWord = field1.getText();
		    	  filePathM1 = field2.getText();
		    	  filePathM2 = field3.getText();
		    	  filePathAlphabet = field4.getText();
		    	  
		    	  if(filePathWord.isEmpty() || filePathM1.isEmpty() || filePathM2.isEmpty() || filePathAlphabet.isEmpty()){
		    		  System.out.println("DEBUG : Error selection of files");
		    		  area0.setForeground(Color.red);
		    		  area0.setText("You must fill in all of the fields !");
		    	  }
		    	  else { 
		    		  System.out.println("DEBUG : selection of files OK");
		    		  
		    		  /* 
		    		   *  si les 4 chemins pour les fichiers sont remplis, il faut récupère leur contenu et vérifier leur validité
		    		   *  
		    		   */
		    		  
		    		  // TODO TODO TODO
		    		  
		    		  dispose();
		    	  }	  
		      }   
		});
		jPanel5.add(button5);
		
		
		jPanel5.add(button6);

		add(jPanelMain);
		
		pack();
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//selectedFile = new SelectFile ();
	}
}
