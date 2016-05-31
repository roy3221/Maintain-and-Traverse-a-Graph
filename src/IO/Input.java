/*
 * Deal with input file, scan input file line by line.
 */

package IO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Input {  
    private String line; // This will reference one line at a time
    private FileReader fileReader; // FileReader reads text files in the default encoding.
    private BufferedReader bufferedReader; // Always wrap FileReader in BufferedReader.
    private boolean finish; // finishing reading all lines or not?
    
    public Input(String fileName) throws FileNotFoundException {
    	this.line = null;
    	this.fileReader = new FileReader(fileName);
    	getBufferedReader();
    	finish = false;
    }
    
    // get each line of the input file.
    public String getLine() throws IOException {
    	 line = bufferedReader.readLine();
    	 if(line == null) {
    		 closeBufferedReader();
    		 finish = true;
    	 }
         return line;
    }
    
    private void getBufferedReader(){
    	bufferedReader = new BufferedReader(fileReader);
    }
    
    // Always close files when finish;
    private void closeBufferedReader() throws IOException {
        bufferedReader.close(); 
    }
    
    public boolean finish() {
    	return finish;
    }
    
}

