import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ButtonAction extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;

	//protected static DrawPanel dp;
	
	protected JSlider slider1;
	protected JSlider slider2;
	
	protected Inw1 inw1;
	protected Inw2 inw2;
	protected Parser parser;
	protected Automat automat;
	
	protected SelectFile selectFile;
	
	protected JTextField field1;
	protected JTextField field2;
	protected JTextField field3;
	protected JTextField field4;
	
	protected JButton button;
	
	protected JLabel area1;
	protected JLabel area2;
	protected JLabel area3;
	protected JLabel area4;
	
	protected JPanel jPanelSubNorth1;
	protected JPanel jPanelSubNorth2;
	
	public ButtonAction() {
		super();
		parser  = new Parser();
		slider1 = new JSlider(JSlider.HORIZONTAL,0,1000,  0); //direction , min , max , current
		slider2 = new JSlider(JSlider.HORIZONTAL,0,1000,500); //direction , min , max , current
		//dp      = new DrawPanel(800,600);
	}
	
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
		System.out.println("DEBUG : repaint");
	}

	@Override
	public void stateChanged(ChangeEvent e1) {
		JSlider source = (JSlider)e1.getSource();
		if(slider1 == source) {
			DrawPanel.spaceBetweenNode = source.getValue();
		} else if (slider2 == source) {
			DrawPanel.verticalPosition = source.getValue();
		}
		MainWindow.getDp().repaint();
	}

}
