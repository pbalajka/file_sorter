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

	public String[] getSubFile(final String path) {
		String[] subFile = new File(path).list();
		;
		List<String> noHidenFile = new ArrayList<>();

		for (int i = 0; i < subFile.length; i++) {
			String tempPath = path + subFile[i];

			if (new File(tempPath).isHidden()) {
				System.out.println("Hidem file: " + tempPath);
			} else {
				System.out.println("Add no hiden file: " + tempPath);
				noHidenFile.add(subFile[i]);
			}
		}

		String[] noHiden = new String[noHidenFile.size()];
		for (int i = 0; i < noHiden.length; i++) {
			noHiden[i] = noHidenFile.get(i);
		}

		return noHiden;
	}
}