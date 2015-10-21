package sk.umb.file_sorter.test;

import java.io.File;
import java.io.IOException;

public class CreateTestData {

	public static void main(String[] args) {
		System.out.println("User: " + Variable.USER_NAME);
		System.out.println("Operating system: " + Variable.OPERATING_SYSTEM);
		System.out.println("Path: " + Variable.PATH);

		File file = new File(Variable.PATH);
		if (!file.exists()) {
			if (!file.mkdir()) {
				System.out.println("Error: Can't create directory: " + file.getName());
				System.exit(1);
			}
		} else
			System.out.println("Directory exists");

		for (int i = 0; i < Variable.TEST_DIRECTORY_NAMES.length; i++) {
			File temp = new File(Variable.PATH + Variable.TEST_DIRECTORY_NAMES[i]);
			if (!temp.mkdir()) {
				System.out.println("Error: Can't create directory: " + temp.getName());
			}
		}

		for (int i = 0; i < Variable.TEST_FILE_NAMES.length; i++) {
			try {
				File temp = new File(Variable.PATH + Variable.TEST_FILE_NAMES[i]);
				if (!temp.exists())
					temp.createNewFile();
				else
					System.out.println("File is exist: " + temp.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}