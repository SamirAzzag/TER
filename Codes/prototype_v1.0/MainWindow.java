import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame implements ActionListener, ChangeListener{

	private static final long serialVersionUID = 1L;
	private JTextField field1;
	private JTextField field2;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JButton button;
	private DrawPanel dp;
	private Inw1 inw1;

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
		field1 = new JTextField(40);
		field2 = new JTextField(40);
		button = new JButton("Ok");
		inw1   = new Inw1();
		dp     = new DrawPanel(1600,600);  /* draw panel */

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
		slider2.setName("nodeDiameter");
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		slider2.setPaintTrack(true);
		//slider2.setAutoscrolls(true);
		slider2.setPreferredSize(new Dimension(330,50));
		slider2.addChangeListener(this);

		slider3 = new JSlider(JSlider.HORIZONTAL,0,1000,500);//direction , min , max , current
		slider3.setName("verticalPosition");
		slider3.setMajorTickSpacing(100);
		slider3.setMinorTickSpacing(25);
		slider3.setPaintLabels(true);
		slider3.setPaintTicks(true);
		slider3.setPaintTrack(true);
		//slider3.setAutoscrolls(true);
		slider3.setPreferredSize(new Dimension(330,50));
		slider3.addChangeListener(this);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		JPanel jPanelNorth = new JPanel();
		jPanelNorth.add(field1);
		jPanelNorth.add(field2);
		jPanelNorth.add(button);
		jPanel.add(jPanelNorth, BorderLayout.NORTH);
		jPanel.add(dp, BorderLayout.CENTER);
		JPanel jPanelSouth = new JPanel();
		jPanelSouth.add(slider1);
		jPanelSouth.add(slider2);
		jPanelSouth.add(slider3);
		jPanel.add(jPanelSouth, BorderLayout.SOUTH);
		add(jPanel);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) {
		//Execute when button is pressed
		String s = field2.getText();
		Parser parser = new Parser(s);
		inw1.setWord(field1.getText());
		inw1.setMatching(parser.parseArcs());
		inw1.isMatching();
		dp.setComponentShape(inw1.generateGraphicsComponent());
		dp.repaint();
		System.out.println(field1.getText() +  "   " + s);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if(slider1 == source) {  
			DrawPanel.spaceBetweenNode = source.getValue();
		} else if (slider2 == source) {
			DrawPanel.nodeDiameter = source.getValue();
		} else if (slider3 == source) {
			DrawPanel.verticalPosition = source.getValue();
		}
		dp.repaint();
	}
}

