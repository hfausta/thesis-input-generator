import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class FileReader {
	
	private HashMap<String, ArrayList<String>> accessions;
	private String file;
	
	public FileReader(String file) throws IOException {
		this.file = file;
		accessions = new HashMap<String, ArrayList<String>>();
		readFile();
	}
	
	public void readFile() throws IOException {
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(dis));
		String currentLine;
		
		while((currentLine = br.readLine()) != null) {
			String[] lineSplit = currentLine.split(",");
			if(accessions.containsKey(lineSplit[0])) {
				accessions.get(lineSplit[0]).add(currentLine);
			} else {
				ArrayList<String> parts = new ArrayList<String>();
				parts.add(currentLine);
				accessions.put(lineSplit[0], parts);
			}
		}
	}

	public HashMap<String, ArrayList<String>> getAccessions() {
		return accessions;
	}

	public void setAccessions(HashMap<String, ArrayList<String>> accessions) {
		this.accessions = accessions;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
}
