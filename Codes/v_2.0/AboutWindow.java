import javax.swing.JFrame;

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
		
		// TODO
		
		setVisible(true);
	}
}
