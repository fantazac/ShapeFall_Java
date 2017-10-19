package Save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Score {

	File file = new File("C:\\ShapeFall\\save\\Score.txt");
	
	String content;
	
	public Score(int a, int b, int c, int d, int e){
		content = a + "\n" + b + "\n" + c + "\n" + d + "\n" + e;
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
 
			System.out.println("Score saved");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
