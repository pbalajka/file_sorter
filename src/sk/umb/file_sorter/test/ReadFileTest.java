package sk.umb.file_sorter.test;

import java.io.File;

import sk.umb.file_sorter.core.MyFileException;
import sk.umb.file_sorter.core.ReadDirectory;

public class ReadFileTest {

	public static void main(String[] args) {
		File[] files;
		try {
			files = ReadDirectory.getInstance().getSubFile(Variable.PATH);

			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().contains("."))
					System.out.println("Name: " + files[i].getName() + " ,postfix: " + files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1));
				else
					System.out.println("Name: " + files[i].getName() + "postfix: have not postfix.");
			}
		} catch (MyFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}