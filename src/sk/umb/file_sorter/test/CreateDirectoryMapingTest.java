package sk.umb.file_sorter.test;

import java.io.File;

import sk.umb.file_sorter.core.DirectoryMaping;
import sk.umb.file_sorter.core.MyFileException;
import sk.umb.file_sorter.core.ReadDirectory;

public class CreateDirectoryMapingTest {

	public static void main(String[] args) {
		CreateTestData.main(new String[] { "CreateTestData, Test" });

		DirectoryMaping documents = new DirectoryMaping(Variable.DOCUMENTS);
		documents.addPostfix("pdf", "odt");
		DirectoryMaping videos = new DirectoryMaping(Variable.VIDEOS);
		videos.addPostfix("mkv", "tft");
		DirectoryMaping musics = new DirectoryMaping(Variable.MUSICS);
		musics.addPostfix("mp3");
		DirectoryMaping picture = new DirectoryMaping(Variable.Picture);
		musics.addPostfix("jpg", "JPG", "png");
		DirectoryMaping[] directoryMaps = new DirectoryMaping[] { documents, videos, musics, picture };

		File[] files = null;
		try {
			files = ReadDirectory.getInstance().getSubFile(Variable.PATH);
		} catch (MyFileException e) {
			System.exit(1);
			e.printStackTrace();
		}

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			System.out.println("Main trehad don't sleep");
		}

		System.out.println("Create contain directory");
		String[] postfix = ReadDirectory.getInstance().getPostfix(files);
		for (int i = 0; i < directoryMaps.length; i++) {
			File newFile = new File(Variable.PATH + directoryMaps[i].getName());
			if (newFile.exists())
				continue;

			for (int j = 0; j < postfix.length; j++) {
				if (directoryMaps[i].containsPostfix(postfix[j])) {
					if (!newFile.mkdir()) {
						System.out.println("Error: Can't create directory: " + newFile.getName());
					}
					break;
				}
			}

		}
		System.out.println("Test success finish");

	}
}
