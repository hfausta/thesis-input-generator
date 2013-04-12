import java.io.IOException;

public class InputGenerator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String input = "/home/henry/thesis/RandomInput/resultset.csv";
		FileReader fr = new FileReader(input);
		Randomizer randomizer = new Randomizer(fr.getAccessions());
		
		int i = 0;
		while(i<30) {
			randomizer.generateOutputFile(randomizer.generateRandom());
			i++;
		}
	}

}
