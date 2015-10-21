package sk.umb.file_sorter.test;

import sk.umb.file_sorter.core.ReadDirectory;

public class ReadFileTest {
	private static final String path = "/home/pavol/Downloads";
	
	public static void main(String[] args) {
		
		ReadDirectory.getInstance().getSubFile(path);
	}
}