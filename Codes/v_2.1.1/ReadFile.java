import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadFile {
	
	private String contentsFile;
	
	
	public ReadFile(String filePath) {
		
		contentsFile = "";

		try{
			InputStream ips = new FileInputStream(filePath); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			
			while ( (ligne = br.readLine()) != null)
				contentsFile += ligne; // Attention au saut de ligne !
			
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public String getContentsFile() {
		return this.contentsFile;
	}

}
