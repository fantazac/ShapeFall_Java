package Save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Colors {

	File file = new File("C:\\ShapeFall\\save\\Colors.txt");
	
	String defaultDiff = "1\n2\n3\n4\n5";
	
	String content;
	
	public Colors(){
		content = defaultDiff;
		System.out.println("Colors set back to default");
		writeToFile();
	}
	
	public Colors(int a, int b, int c, int d, int e){
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
 
			System.out.println("Colors saved");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
