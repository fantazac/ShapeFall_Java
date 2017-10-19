package Save;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Interface.KeyInput;

public class Controls {
	
	protected String word;
	protected int line;
	
	File file = new File("C:\\ShapeFall\\save\\Controls.txt");
	
	String content;
	
	KeyInput ki;
	
	public Controls(KeyInput ki, int nbLine) throws IOException{
		this.ki = ki;
		this.line = nbLine;
		BufferedReader br = new BufferedReader(new FileReader("C:\\ShapeFall\\save\\Controls.txt"));
		for (int i = 0; i < line; i++) 
		{ 
			word = br.readLine();
			ki.addKey(word);
		}
		
		/*for (int i = line; i < line + 1; i++) 
		{
			word = br.readLine();
			
		}*/
		br.close();
	}
	
	public Controls(int c1, int c2, int c3, int c4, int c5, int cS, int cP, int cSP){
		content = Integer.toString(c1);
		content += "\n" + Integer.toString(c2);
		content += "\n" + Integer.toString(c3);
		content += "\n" + Integer.toString(c4);
		content += "\n" + Integer.toString(c5);
		content += "\n" + Integer.toString(cS);
		content += "\n" + Integer.toString(cP);
		content += "\n" + Integer.toString(cSP);
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
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
