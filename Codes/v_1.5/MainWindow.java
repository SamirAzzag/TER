import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame implements ActionListener, ChangeListener{

	private static final long serialVersionUID = 1L;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;

	private JSlider slider1;
	private JSlider slider2;
	private JButton button;
	private DrawPanel dp;
	private Inw1 inw1;
	private Inw2 inw2;
	private Parser parser;
	private Automat automat;

	public MainWindow(){
		super();
		build();
	}

	private void build(){

		/* init */
		setTitle("TER");
		setSize(800,600);
		setLocationRelativeTo(null); /* center position */
		setResizable(true);
		JLabel area1 = new JLabel("Word :", JLabel.RIGHT);
		field1 = new JTextField(20);
		JLabel area2 = new JLabel("M1 :", JLabel.RIGHT);
		field2 = new JTextField(20);
		JLabel area3 = new JLabel("M2 :", JLabel.RIGHT);
		field3 = new JTextField(20);
		JLabel area4 = new JLabel("Alphabet :", JLabel.RIGHT);
		field4 = new JTextField(20);
		button = new JButton("Ok");
		//inw1   = new Inw1();
		//inw2   = new Inw2();
		dp     = new DrawPanel(1600,600);  /* draw panel */
		parser = new Parser();

		button.addActionListener(this);

		/* slider */
		slider1 = new JSlider(JSlider.HORIZONTAL,0,1000,0);//direction , min , max , current
		slider1.setName("spaceBetweenNode");
		slider1.setMajorTickSpacing(100);
		slider1.setMinorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.setPaintTicks(true);
		slider1.setPaintTrack(true);
		//slider1.setAutoscrolls(true);
		slider1.setPreferredSize(new Dimension(330,50));
		slider1.addChangeListener(this);

		slider2 = new JSlider(JSlider.HORIZONTAL,0,1000,500);//direction , min , max , current
		slider2.setName("verticalPosition");
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		slider2.setPaintTrack(true);
		//slider2.setAutoscrolls(true);
		slider2.setPreferredSize(new Dimension(330,50));
		slider2.addChangeListener(this);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		JPanel jPanelNorth = new JPanel();
		jPanelNorth.setLayout(new BorderLayout());
		JPanel jPanelSubNorth1 = new JPanel();
		JPanel jPanelSubNorth2 = new JPanel();
		jPanelSubNorth2.add(area4);
		jPanelSubNorth2.add(field4);
		jPanelSubNorth1.add(area1);
		jPanelSubNorth1.add(field1);
		jPanelSubNorth1.add(area2);
		jPanelSubNorth1.add(field2);
		jPanelSubNorth1.add(area3);
		jPanelSubNorth1.add(field3);
		jPanelSubNorth2.add(button);
		jPanelNorth.add(jPanelSubNorth1, BorderLayout.NORTH);
		jPanelNorth.add(jPanelSubNorth2, BorderLayout.SOUTH);
		jPanel.add(jPanelNorth, BorderLayout.NORTH);
		jPanel.add(dp, BorderLayout.CENTER);
		JPanel jPanelSouth = new JPanel();
		jPanelSouth.add(slider1);
		jPanelSouth.add(slider2);
		jPanel.add(jPanelSouth, BorderLayout.SOUTH);
		add(jPanel);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		//Execute when button is pressed
		String w = field1.getText();
		String s  = field2.getText();
		String s2 = field3.getText();
		String a = field4.getText();
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
				dp.setComponentShape(parser.generateGraphicsComponent(asAbove, asBelow, word));
			} else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		} else  {
			inw1 = new Inw1();
			inw1.setWord(w);
			inw1.setMatching(asAbove);
			inw1.setAlphabet(a);
			if (inw1.isMatching()){
				dp.setComponentShape(parser.generateGraphicsComponent(asAbove, null, word));
			} else {
				System.out.println("Les conditions ne sont pas respectees par le matching propose.");
			}
		}
		dp.repaint();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if(slider1 == source) {
			DrawPanel.spaceBetweenNode = source.getValue();
		} else if (slider2 == source) {
			DrawPanel.verticalPosition = source.getValue();
		}
		dp.repaint();
	}
}

