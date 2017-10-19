package Save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Difficulty {

	File file = new File("C:\\ShapeFall\\save\\Difficulty.txt");
	
	String defaultDiff = "3";
	
	String content;
	
	public Difficulty(){
		content = defaultDiff;
		writeToFile();
	}
	
	public Difficulty(int diff){
		if(diff == 1){
			content = "1";
		}
		else if(diff == 2){
			content = "2";
		}
		else if(diff == 3){
			content = "3";
		}
		else{
			content = defaultDiff;
			System.out.println("ERROR: Difficulty is different than 1,2,3.");
		}
			
		writeToFile();
	}
	
	public void writeToFile(){
		try {
 
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Difficulty: " + content);
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
