package Save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Shape {

	File file = new File("C:\\ShapeFall\\save\\Shape.txt");
	
	String defaultShape = "square";
	
	String content;
	
	public Shape(){
		content = defaultShape;
		writeToFile();
	}
	
	public Shape(int s){
		if(s == 1){
			content = "square";
		}
		else if(s == 2){
			content = "circle";
		}
		else{
			content = defaultShape;
			System.out.println("ERROR: Shape is different than the 2 preselected choices.");
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
			
			System.out.println("Current Shape: " + content);
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
