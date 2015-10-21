package sk.umb.file_sorter.test;

import sk.umb.file_sorter.core.CreateFile;

public class CreateFolderTest {

	public static void main(String[] args) {
		System.out.println("User: " + Variable.USER_NAME);
		System.out.println("Operating system: " + Variable.OPERATING_SYSTEM);
		System.out.println("Path: " + Variable.PATH);
		
		String[] files = Variable.FILE_NAMES;
		for (int i = 0; i < files.length; i++) {
			String tempPath = Variable.PATH + files[i];
			System.out.println(tempPath);
			try {
				CreateFile.getInstance().createFile(tempPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}