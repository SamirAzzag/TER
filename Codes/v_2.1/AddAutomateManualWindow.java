import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
	
	private Inw1 inw1;
	private Inw1 inw2;
	
	private JButton buttonOk;
	private Parser parser;
	private Automat automat;
	
	private JLabel area1;
	private JLabel area2;
	private JLabel area3;
	private JLabel area4;

	public AddAutomateManualWindow(){
		super();
		build();
		parser = new Parser();
	}

	private void build(){

		/* initialization window */
		setTitle("Add automate manual");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		
		this.setResizable(false);
		
		area1  = new JLabel("Word :", JLabel.RIGHT);
		area1.setPreferredSize(new Dimension(70,25));
		field1 = new JTextField(20);
		
		area2  = new JLabel("M1 :", JLabel.RIGHT);
		area2.setPreferredSize(new Dimension(70,25));
		field2 = new JTextField(20);
		
		area3  = new JLabel("M2 :", JLabel.RIGHT);
		area3.setPreferredSize(new Dimension(70,25));
		field3 = new JTextField(20);
		
		area4  = new JLabel("Alphabet :", JLabel.RIGHT);
		area4.setPreferredSize(new Dimension(70,25));
		field4 = new JTextField(20);
		
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(this);

		 
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
		
		
		/* JPanel 0 */
		JLabel area0 = new JLabel("", JLabel.LEFT);
		area0.setPreferredSize(new Dimension(400,25));
		area0.setText("Please enter your data :");
		
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
		jPanel5.add(buttonOk);

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
	
	/* ActionEvent */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Execute when button is pressed
		String w  = field1.getText();
		String s  = field2.getText();
		String s2 = field3.getText();
		String a  = field4.getText();
		List<Character> alphabet = parser.parseAlphabet(a);
		List<CircleShape> word = parser.parseCircles(w);
		List<ArcShape> asAbove = parser.parseArcs(s, false, word);
		automat = new Automat(alphabet,word);

		if(!parser.checkSymbols(w, alphabet))
			return;
		
		if(!s2.isEmpty()) {
			List<ArcShape> asBelow = parser.parseArcs(s2, true, word);
			inw2 = new Inw2(w, asAbove, asBelow);
			if(inw2.isMatching()) {
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, asBelow, word));
			} else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		} else  {
			inw1 = new Inw1();
			inw1.setWord(w);
			inw1.setMatching(asAbove);
			inw1.setAlphabet(a);
			if (inw1.isMatching()){
				MainWindow.getDp().setComponentShape(parser.generateGraphicsComponent(asAbove, null, word));
			} else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		}
		MainWindow.getDp().repaint();
		dispose();
	}

	@Override
	public void stateChanged(ChangeEvent e1) {
		// TODO Auto-generated method stub
	}

}
