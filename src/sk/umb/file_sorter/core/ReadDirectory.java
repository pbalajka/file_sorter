package sk.umb.file_sorter.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadDirectory {
	private static ReadDirectory singleton;

	private ReadDirectory() {
	};

	public static ReadDirectory getInstance() {
		if (singleton == null)
			singleton = new ReadDirectory();

		return singleton;
	}

	public File[] getSubFile(final String path) throws MyFileException {
		File file = new File(path);

		if (!file.exists())
			throw new MyFileException("File don't exist");

		String[] subFile = file.list();

		if (subFile.length == 0)
			throw new MyFileException("File is empty");

		List<String> noHidenFile = new ArrayList<>();

		for (int i = 0; i < subFile.length; i++) {
			String tempPath = path + subFile[i];
			File tempFile = new File(tempPath);
			if (tempFile.isHidden()) {
				System.out.println("Hidem file: " + tempPath);
				continue;
			}

			if (tempFile.isDirectory()) {
				System.out.println("Directory: " + tempPath);
				continue;
			}
			noHidenFile.add(subFile[i]);
		}

		File[] noHiden = new File[noHidenFile.size()];
		for (int i = 0; i < noHiden.length; i++) {
			noHiden[i] = new File(path + noHidenFile.get(i));
		}

		return noHiden;
	}

	public String[] getPostfix(final File[] files) {
		List<String> postfix = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(".")) {
				if (!postfix.contains(files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1))) {
					postfix.add(files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1));
				}
			} else {
				System.out.println("Name: " + files[i].getName() + "postfix: have not postfix.");
			}
		}

		return postfix.toArray(new String[postfix.size()]);
	}
}