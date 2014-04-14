import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddAutomateManualWindow extends ButtonAction   {

	private static final long serialVersionUID = 1L;

	public AddAutomateManualWindow(){
		super();
		build();
	}

	private void build(){

		setTitle("Add automate manual");
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(true);
		
		area1  = new JLabel("Word :", JLabel.RIGHT);
		field1 = new JTextField(20);
		area2  = new JLabel("M1 :", JLabel.RIGHT);
		field2 = new JTextField(20);
		area3  = new JLabel("M2 :", JLabel.RIGHT);
		field3 = new JTextField(20);
		area4  = new JLabel("Alphabet :", JLabel.RIGHT);
		field4 = new JTextField(20);
		button = new JButton("Ok");
		
		button.addActionListener(this);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		JPanel jPanelNorth = new JPanel();
		jPanelNorth.setLayout(new BorderLayout());
		jPanelSubNorth1 = new JPanel();
		jPanelSubNorth2 = new JPanel();
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
		JPanel jPanelSouth = new JPanel();
		jPanel.add(jPanelSouth, BorderLayout.SOUTH);
		add(jPanel);
		
		
		pack();
		setVisible(true);
	}

}
