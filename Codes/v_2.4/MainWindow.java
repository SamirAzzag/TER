import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainWindow extends JFrame implements ActionListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	
	/* variables for the menu */
	private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile   = new JMenu("File");
    private JMenu menuEdit   = new JMenu("Edit");
    private JMenu menuHelp   = new JMenu("Help");
    private JMenuItem menuItemOpen  = new JMenuItem("Open");
    private JMenuItem menuItemClose = new JMenuItem("Close");
    private JMenuItem menuItemAddAutomateFile   = new JMenuItem("Files");
    private JMenu menuItemAddAutomate  = new JMenu("Add automate");
    private JMenuItem menuItemAddAutomateManual = new JMenuItem("Manual");
    private JMenuItem menuItemAbout = new JMenuItem("About");
    
    /* variables for the DrawPanel */
    private static DrawPanel dp = new DrawPanel(800,400);
    
    /* variables for the Sliders */
    private static JSlider slider1;
	private static JSlider slider2;
	
	SelectFile selectFile;

	public MainWindow(){
		super();
		build();
	}

	private void build(){

		/* initialization window */
		setTitle("TER");
		setSize(800,400);
		setLocationRelativeTo(null); /* center position */
		setResizable(true);
		
		//inw1   = new Inw1();
		//inw2   = new Inw2();
		
		/** Menu items **/
		/* Menu Open */
		menuItemOpen.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		selectFile = new SelectFile ();
		      }   
		});
	    this.menuFile.add(menuItemOpen);
	    
	    /* Menu Item Close */
	    menuItemClose.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		System.exit(0);
		      }   
		});
	    this.menuFile.add(menuItemClose);
	    
	    
	    this.menuEdit.add(menuItemAddAutomate);
	    
	    final Generator g = new Generator();
	    
	    /* Menu Item Add Automate File */
	    menuItemAddAutomateFile.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
	    		new AddAutomateFilesWindow(g);
		      }   
		});
	    this.menuItemAddAutomate.add(menuItemAddAutomateFile);
	    
	    /* Menu Item Add Automate Manual */
	    menuItemAddAutomateManual.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  new AddAutomateManualWindow(g);
		      }   
		});
	    this.menuItemAddAutomate.add(menuItemAddAutomateManual);
	    
	    /* Menu Item About */
	    menuItemAbout.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  new AboutWindow();
		      }   
		});
	    this.menuHelp.add(menuItemAbout);
	    
	    /* add item menu in odre */
	    this.menuBar.add(menuFile);
	    this.menuBar.add(menuEdit);
	    this.menuBar.add(menuHelp);
	    this.setJMenuBar(menuBar);
		
		/* sliders */
		slider1 = new JSlider(JSlider.HORIZONTAL,0,1000,  0); //direction , min , max , current
		slider2 = new JSlider(JSlider.HORIZONTAL,0,1000,500); //direction , min , max , current
	    
		/* slider 1 */
		slider1.setName("spaceBetweenNode");
		slider1.setMajorTickSpacing(100);
		slider1.setMinorTickSpacing(25);
		slider1.setPaintLabels(true);
		slider1.setPaintTicks(true);
		slider1.setPaintTrack(true);
		slider1.setPreferredSize(new Dimension(330,50));
		slider1.addChangeListener(this);
		
		/* slider 2 */
		slider2.setName("verticalPosition");
		slider2.setMajorTickSpacing(100);
		slider2.setMinorTickSpacing(25);
		slider2.setPaintLabels(true);
		slider2.setPaintTicks(true);
		slider2.setPaintTrack(true);
		slider2.setPreferredSize(new Dimension(330,50));
		slider2.addChangeListener(this);

		/* jPanel */
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(dp, BorderLayout.CENTER);
		JPanel jPanelSouth = new JPanel();
		jPanelSouth.add(slider1);
		jPanelSouth.add(slider2);
		jPanel.add(jPanelSouth, BorderLayout.SOUTH);
		add(jPanel);

		/* parameter window */
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* getters and setters */
	public static DrawPanel getDp () {
		return dp;
	}
	
	public static JSlider getSlider1 () {
		return slider1;
	}
	
	public static JSlider getSlider2 () {
		return slider2;
	}

	@Override
	public void stateChanged(ChangeEvent e1) {
		JSlider source = (JSlider)e1.getSource();
		if(MainWindow.getSlider1() == source) {
			DrawPanel.spaceBetweenNode = source.getValue();
		} else if (MainWindow.getSlider2() == source) {
			DrawPanel.verticalPosition = source.getValue();
		}
		MainWindow.getDp().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
