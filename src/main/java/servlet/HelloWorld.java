package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class HelloWorld {
	// 引数ナシ
	public String sayHello1() {
		System.out.println("sayHello1()");
		return "Hello";
	}

	// 引数がString、戻り値がString
	public String sayHello(String input) {
		System.out.println("sayHello(input)");
		return "Hello " + input + " .";
	}

	// 引数がString[]
	public String[] sayHellos() {
		System.out.println("sayHellos()");
		return new String[] { "Hello World.", "hello world." };
	}

	public String uploadFile(InputStream inputStream, String filename) throws IOException{
		try {
			File file = new File("C:\\Eclipse", new File(filename).getName());
			Files.copy(inputStream, file.toPath());
		} catch (IOException e) {
		    e.printStackTrace();
		}

	    //Se sube el documento y se devuelve el resultado
	    return "success";

	}

	public String multiUploadFile(InputStream[] inputStreams, String[] filenames) throws IOException{
		try {
			for(int i=0; i<inputStreams.length; i++){
				File file = new File("C:\\Eclipse", new File(filenames[i]).getName());
				Files.copy(inputStreams[i], file.toPath());
			}
		} catch (IOException e) {
		    e.printStackTrace();
		}

	    //Se sube el documento y se devuelve el resultado
	    return "success";

	}
}