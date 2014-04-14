import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends ButtonAction {

	private static final long serialVersionUID = 1L;
	
	/* variables for the menu */
	private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu("File");
    private JMenu menuEdit = new JMenu("Edit");
    private JMenu menuHelp = new JMenu("Help");
    private JMenuItem menuItemOpen = new JMenuItem("Open");
    private JMenuItem menuItemClose = new JMenuItem("Close");
    private JMenuItem menuItemAddAutomateFile = new JMenuItem("Add automate files");
    private JMenuItem menuItemAddAutomateManual = new JMenuItem("Add automate manual");
    private JMenuItem menuItemAbout = new JMenuItem("About");
    
    private static DrawPanel dp = new DrawPanel(800,600);

	public MainWindow(){
		super();
		build();
	}

	private void build(){

		/* init */
		setTitle("TER");
		setSize(800,400);
		setLocationRelativeTo(null); /* center position */
		setResizable(true);
		
		//inw1   = new Inw1();
		//inw2   = new Inw2();
		
		/* Menu Top */
		menuItemOpen.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		selectFile = new SelectFile ();
		      }   
		});
	    this.menuFile.add(menuItemOpen);
	    
	    menuItemClose.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		System.exit(0);
		      }   
		});
	    this.menuFile.add(menuItemClose);
	    
	    menuItemAddAutomateFile.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		new AddAutomateFilesWindow();
		      }   
		});
	    this.menuEdit.add(menuItemAddAutomateFile);
	    
	    menuItemAddAutomateManual.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  new AddAutomateManualWindow();
		      }   
		});
	    this.menuEdit.add(menuItemAddAutomateManual);
	    
	    menuItemAbout.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  new AboutWindow();
		      }   
		});
	    this.menuHelp.add(menuItemAbout);
	    
	    this.menuBar.add(menuFile);
	    this.menuBar.add(menuEdit);
	    this.menuBar.add(menuHelp);
	    this.setJMenuBar(menuBar);
		
		/* slider */
		slider1.setName("spaceBetweenNode");
		slider1.setMajorTickSpacing(100);
		slider1.setMinorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.setPaintTicks(true);
		slider1.setPaintTrack(true);
		slider1.setPreferredSize(new Dimension(330,50));
		slider1.addChangeListener(this);

		slider2.setName("verticalPosition");
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		slider2.setPaintTrack(true);
		slider2.setPreferredSize(new Dimension(330,50));
		slider2.addChangeListener(this);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());

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
	
	public static DrawPanel getDp () {
		return dp;
	}

}
