import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public AboutWindow(){
		super();
		build();
	}

	private void build(){

		setTitle("About");
		setSize(400,200);
		setLocationRelativeTo(null);
		setResizable(true);
		
		this.setResizable(false);
		
		JLabel area0 = new JLabel("", JLabel.CENTER);
		area0.setPreferredSize(new Dimension(250,25));
		area0.setText("Aix Marseille Université© 2014");
		this.add(area0);

		setVisible(true);
	}
}
