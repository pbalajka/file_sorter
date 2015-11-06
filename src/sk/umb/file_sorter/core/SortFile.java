package sk.umb.file_sorter.core;

import java.io.File;

public class SortFile {
	private static SortFile instance = null;

	private SortFile() {
	}

	public static SortFile getInstance() {
		if (instance == null)
			instance = new SortFile();

		return instance;
	}

	public void sortFile(final File[] files, final Directory... directories) {

		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(".")) {
				for (int j = 0; j < directories.length; j++) {
					if (!directories[j].containsPostfix(this.getSubfix(files[i])))
						continue;

					directories[j].addFile(files[i]);
				}
			} else {
				System.out.println("Name: " + files[i].getName() + " have not postfix");
			}
		}
	}

	private String getSubfix(final File file) {
		return file.getName().substring(file.getName().lastIndexOf(".") + 1);
	}

	public void moveSortFile(final Directory... dir) {
		for (Directory tempDir : dir) {
			if(this.isEmpty(tempDir))
				continue;
			
			if(!this.createDirectory(tempDir))
				continue;
			
			for (File file : tempDir.getFile()) {
				if(!file.renameTo(new File(tempDir.getPath() + file.getName()))) {
					System.out.println(file.getName() + " move not success");
					continue;
				}
			}
		}
	}

	private boolean createDirectory(final Directory dir) {
		File file = new File(dir.getPath());

		if (file.exists())
			return true;
		if (file.mkdirs())
			return true;

		System.out.println(dir.getName() + " is not create");
		return false;
	}
	
	private boolean isEmpty(final Directory dir) {
		if(dir.isEmpty()) {
			System.out.println(dir.getName() + " is Empty, no create");
		} else {
			System.out.println(dir.getName() + " is create");
		}
		return dir.isEmpty();
	}
	
	public  void printFile(final Directory... dir) {
		for(Directory temp: dir) {
		System.out.println("Name directory: " + temp.getName());
		for (File fileTemp : temp.getFile()) {
			System.out.println(fileTemp.getName());
		}
		System.out.println(" ");
		}
	}
}