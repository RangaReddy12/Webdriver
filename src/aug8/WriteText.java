package aug8;

import java.io.*;

public class WriteText {

	public static void main(String[] args) throws Throwable {
		//create a file
		File f = new File("D://Sample.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Iam learning java");
		bw.newLine();
		bw.write("Iam learning selenium");
		bw.newLine();
		bw.write("Ia learning testing");
		bw.flush();
		bw.close();

	}

}
