package sk.umb.file_sorter.test;

import java.io.File;

import sk.umb.file_sorter.core.MyFileException;
import sk.umb.file_sorter.core.ReadDirectory;

public class ReadFileTest {

	public static void main(String[] args) {
		File[] files;
		try {
			files = ReadDirectory.getInstance().getSubFile(Variable.PATH);
			String[] postfix = ReadDirectory.getInstance().getPostfix(files);
			
			for(int i = 0; i < postfix.length; i++) {
				System.out.println(postfix[i]);
			}
		} catch (MyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}