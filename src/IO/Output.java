/*
 * Deal with output file, create output file line by line.
 */

package IO;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	
	public Output(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
		getBufferedWriter();
	}
	 
	private void getBufferedWriter() {
		bufferedWriter = new BufferedWriter(fileWriter);
	}
	
	
    // Always close files when finish
	private void closeBufferedWriter() throws IOException {
        bufferedWriter.close();

	}
	
	public void putLine(String line) throws IOException {
		bufferedWriter.write(line);
		bufferedWriter.newLine();
	}
	
	public void finish() throws IOException {
		closeBufferedWriter();
	}
}
