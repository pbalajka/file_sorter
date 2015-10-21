package sk.umb.file_sorter.core;

import java.io.File;

public class CreateFile {
	private static CreateFile singleton_instance;

	private CreateFile() {

	}

	public static CreateFile getInstance() {
		if (singleton_instance == null)
			singleton_instance = new CreateFile();

		return singleton_instance;
	}

	public File createFile(final String path) throws Exception {
		File file = new File(path);;

		if (!file.exists())
			file.mkdirs();
		else {
			throw new CreateFileException("File is not create, because is exist");
		}

		return file;
	}
}