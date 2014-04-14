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
	private JButton button7;

	private SelectFile selectedFile;

	String filePathWord;
	String filePathM1;
	String filePathM2;
	String filePathAlphabet;

	ReadFile word;
	ReadFile m1;
	ReadFile m2;
	ReadFile alphabet;

	private Generator generator;

	public AddAutomateFilesWindow(Generator g) {
		super();
		build();
		generator = g;
	}

	private void build(){

		/* initialization window */
		setTitle("Add automate files");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);

		this.setResizable(false); // interdit le redimensionnement

		// On ajoute un GridLayout de 6 lignes et 1 colonne sur le JPanel Principal
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

		/* Creation des boutons */
		button1 = new JButton("Select");
		button2 = new JButton("Select");
		button3 = new JButton("Select");
		button4 = new JButton("Select");
		button5 = new JButton("Select");
		button6 = new JButton("Finish");
		button7 = new JButton("Cancel");

		/* Affectation des actions des boutons */
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);

		/** Ligne 0 - Texte **/
		final JLabel area0 = new JLabel("", JLabel.LEFT);
		area0.setPreferredSize(new Dimension(400,25));
		area0.setText("Please select files :");
		jPanel0.add(area0); // On ajoute le Texte à la ligne 0


		/** Ligne 1 - Select 1 **/
		JLabel area1 = new JLabel("Word :", JLabel.RIGHT);
		area1.setPreferredSize(new Dimension(80,25));
		final JTextField field1 = new JTextField(20);
		jPanel1.add(area1);
		jPanel1.add(field1);

		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				selectedFile = new SelectFile ();
				field1.setText(selectedFile.getSelectedFile().toString());
			}   
		});
		jPanel1.add(button1); // On ajoute le bouton à la ligne 1


		/** Ligne 2 - Select 2 **/
		JLabel area2 = new JLabel("M1 :", JLabel.RIGHT);
		area2.setPreferredSize(new Dimension(80,25));
		final JTextField field2 = new JTextField(20);
		jPanel2.add(area2);
		jPanel2.add(field2);

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				selectedFile = new SelectFile ();
				field2.setText(selectedFile.getSelectedFile().toString());
			}   
		});
		jPanel2.add(button2); // On ajoute le bouton à la ligne 2


		/** Ligne 3 - Select 3 **/
		JLabel area3 = new JLabel("M2 (optional) :", JLabel.RIGHT);
		area3.setPreferredSize(new Dimension(80,25));
		final JTextField field3 = new JTextField(20);
		jPanel3.add(area3);
		jPanel3.add(field3);

		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				selectedFile = new SelectFile ();
				field3.setText(selectedFile.getSelectedFile().toString());
			}   
		});
		jPanel3.add(button3); // On ajoute le bouton à la ligne 3


		/** Ligne 4 - Select 4 **/
		JLabel area4 = new JLabel("Alphabet :", JLabel.RIGHT);
		area4.setPreferredSize(new Dimension(80,25));
		final JTextField field4 = new JTextField(20);
		jPanel4.add(area4);
		jPanel4.add(field4);

		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				selectedFile = new SelectFile ();
				field4.setText(selectedFile.getSelectedFile().toString());
			}   
		});
		jPanel4.add(button4); // On ajoute le bouton à la ligne 4


		/** Ligne 5 - Select 5 **/
		JLabel area5 = new JLabel("Transitions :", JLabel.RIGHT);
		area5.setPreferredSize(new Dimension(80,25));
		final JTextField field5 = new JTextField(20);
		jPanel5.add(area5);
		jPanel5.add(field5);

		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				selectedFile = new SelectFile ();
				field5.setText(selectedFile.getSelectedFile().toString());
			}   
		});
		jPanel5.add(button5); // On ajoute le bouton à la ligne 4


		/** Ligne 6 - Bouton Finish **/
		JLabel area6 = new JLabel("", JLabel.RIGHT);
		area6.setPreferredSize(new Dimension(225,30));
		jPanel6.add(area6);

		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				filePathWord = field1.getText();
				filePathM1 = field2.getText();
				filePathM2 = field3.getText();
				filePathAlphabet = field4.getText();

				if(filePathWord.isEmpty() || filePathM1.isEmpty() || filePathAlphabet.isEmpty()){ //filePathM2.isEmpty() est optionnel
					System.out.println("DEBUG : Error selection of files");
					area0.setForeground(Color.red);
					area0.setText("You must fill in all of the fields !");
				} else { 
					System.out.println("DEBUG : selection of files OK");

					/* Lecture des fichiers */
					word     = new ReadFile(filePathWord);
					m1       = new ReadFile(filePathM1);
					alphabet = new ReadFile(filePathAlphabet);

					if(!filePathM2.isEmpty())
						m2 = new ReadFile(filePathM2);

					/* Recuperation du contenu des fichiers */
					String w  = word.getContentsFile();
					String s1  = m1.getContentsFile();
					String a  = alphabet.getContentsFile();
					String s2;

					if (!filePathM2.isEmpty()) {
						s2 = m2.getContentsFile();
					} else {
						s2 = new String();
					}

					generator.generateWord(w, s1, s2, a);
					generator.generateAutomat(null, null, null, null, null);
					//generator.startAutomat();

					dispose(); // Window closing
				}	  
			}   
		});
		jPanel6.add(button6); // On ajoute le bouton à la ligne 6


		/** Bouton Cancel **/
		button7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				filePathWord     = null;
				filePathM1       = null;
				filePathM2       = null;
				filePathAlphabet = null;
				dispose();
			}   
		});
		jPanel6.add(button7); // On ajoute le bouton à la ligne 6


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
