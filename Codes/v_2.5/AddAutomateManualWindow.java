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

public class AddAutomateManualWindow extends JFrame implements ActionListener, ChangeListener  {

	private static final long serialVersionUID = 1L;
	
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;
	private JTextField field5;
	
	private JButton buttonOk;
	private Generator generator;
	
	private JLabel area1;
	private JLabel area2;
	private JLabel area3;
	private JLabel area4;
	private JLabel area5;

	public AddAutomateManualWindow(Generator g){
		super();
		build();
		generator = g;
	}

	private void build(){

		/* initialization window */
		setTitle("Add automate manual");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		
		this.setResizable(false); // interdit le redimensionnement
		
		/* Ligne 0 */
		JLabel area0 = new JLabel("", JLabel.LEFT);
		area0.setPreferredSize(new Dimension(400,25));
		area0.setText("Please enter your data :");
		
		/* Ligne 1 */
		area1  = new JLabel("Word :", JLabel.RIGHT);
		area1.setPreferredSize(new Dimension(70,25));
		field1 = new JTextField(20);
		
		/* Ligne 2 */
		area2  = new JLabel("M1 :", JLabel.RIGHT);
		area2.setPreferredSize(new Dimension(70,25));
		field2 = new JTextField(20);
		
		/* Ligne 3 */
		area3  = new JLabel("M2 :", JLabel.RIGHT);
		area3.setPreferredSize(new Dimension(70,25));
		field3 = new JTextField(20);
		
		/* Ligne 4 */
		area4  = new JLabel("Alphabet :", JLabel.RIGHT);
		area4.setPreferredSize(new Dimension(70,25));
		field4 = new JTextField(20);
		
		/* Ligne 5 */
		area5  = new JLabel("Transitions :", JLabel.RIGHT);
		area5.setPreferredSize(new Dimension(70,25));
		field5 = new JTextField(20);
		
		/* Ligne 6 */
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(this);

		 
		// On ajoute un GridLayout de 7 lignes et 1 colonne sur le JPanel Principal
		// dans chaque ligne on ajoute un JPanel numeroté de 0 à 6
		
		JPanel jPanelMain = new JPanel(); // JPanel Principal
		
		jPanelMain.setLayout(new GridLayout(7,1)); // 7 Lignes et 1 Colonne
		
		JPanel jPanel0 = new JPanel(); // Ligne 0
		JPanel jPanel1 = new JPanel(); // Ligne 1
		JPanel jPanel2 = new JPanel(); // Ligne 2
		JPanel jPanel3 = new JPanel(); // Ligne 3
		JPanel jPanel4 = new JPanel(); // Ligne 4
		JPanel jPanel5 = new JPanel(); // Ligne 5
		JPanel jPanel6 = new JPanel(); // Ligne 6
		
		
		/* On ajoute les JPanel dans le GridLayout de jPanelMain */
		jPanelMain.add(jPanel0);
		jPanelMain.add(jPanel1);
		jPanelMain.add(jPanel2);
		jPanelMain.add(jPanel3);
		jPanelMain.add(jPanel4);
		jPanelMain.add(jPanel5);
		jPanelMain.add(jPanel6);

		
		/* Add items in JPanel */
		jPanel0.add(area0);
		jPanel1.add(area1);
		jPanel1.add(field1);
		jPanel2.add(area2);
		jPanel2.add(field2);
		jPanel3.add(area3);
		jPanel3.add(field3);
		jPanel4.add(area4);
		jPanel4.add(field4);
		jPanel5.add(area5);
		jPanel5.add(field5);
		jPanel6.add(buttonOk);

		/* On ajoute jPanelMain dans la fenêtre */
		add(jPanelMain);

		pack();
		setVisible(true);
	}
	
	/* Getters and Setters */
	public JTextField getField1 (){
		return field1;
	}
	
	public JTextField getField2 (){
		return field2;
	}
	
	public JTextField getField3 (){
		return field3;
	}
	
	public JTextField getField4 (){
		return field4;
	}
	
	/* Action du bouton OK */
	@Override
	public void actionPerformed(ActionEvent e) {

		String w  = field1.getText();
		String s1  = field2.getText();
		String s2 = field3.getText();
		String a  = field4.getText();
		
		generator.generateWord(w, s1, s2, a);
		generator.generateAutomat(null, null, null, null, null);
		//generator.startAutomat();
		
		dispose(); // Window closing
	}
	
	/* Rien à définir */
	@Override
	public void stateChanged(ChangeEvent e1) {
		// TODO Auto-generated method stub
	}

}
