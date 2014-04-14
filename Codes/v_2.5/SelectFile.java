import java.io.File;
import javax.swing.JFileChooser;

public class SelectFile {
	
	private JFileChooser choice = new JFileChooser();
	
    public SelectFile () {   
        // affichage
    	choice.showOpenDialog(null);
         
        // r�cup�ration du fichier s�lectionn�
        System.out.println("Selected File : " + choice.getSelectedFile());
    }
    
    public File getSelectedFile () {
    	return choice.getSelectedFile();
    }
}