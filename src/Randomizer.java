import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


public class Randomizer {
	
	private HashMap<String, ArrayList<String>> accessions;
	
	public Randomizer(HashMap<String, ArrayList<String>> accessions) {
		this.accessions = accessions;
	}
	
	public ArrayList<String> generateRandom() {
		ArrayList<String> randomList = new ArrayList<String>();
		ArrayList<String> keys = new ArrayList<String>();
		for(Entry<String, ArrayList<String>> entry : accessions.entrySet()) {
			keys.add(entry.getKey());
		}
		Collections.shuffle(keys);
		int end = accessions.keySet().size()/10;
		System.out.println(end);
		
		for(int i=0;i<end;i++) {
			for(String s : accessions.get(keys.get(i))) {
				randomList.add(s);
			}
		}
		Collections.sort(randomList);
		
		return randomList;
	}
	
	public void generateOutputFile(ArrayList<String> randomList) throws IOException {
		String path = "output";
		String fileName = "";
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		int last = 1;
		
		if(listOfFiles.length > 0) {
			for (int i=0;i<listOfFiles.length;i++) {
				if(listOfFiles[i].isFile()) {
					fileName = listOfFiles[i].getName();
					String[] fileNameSplit = fileName.split("-");
					if(last < Integer.parseInt(fileNameSplit[1])) {
						last = Integer.parseInt(fileNameSplit[1]);
					}
				}
			}
			last++;
		}
	
		FileWriter fw = new FileWriter("output/adbannotation-" + last);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(String s : randomList) {
			bw.write(s + "\n");
		}
		
		bw.close();
	}

	public HashMap<String, ArrayList<String>> getAccessions() {
		return accessions;
	}

	public void setAccessions(HashMap<String, ArrayList<String>> accessions) {
		this.accessions = accessions;
	}
	
}
