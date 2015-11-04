package sk.umb.file_sorter.test;

import java.io.File;
import sk.umb.file_sorter.core.Directory;
import sk.umb.file_sorter.core.SortFile;
import sk.umb.file_sorter.core.MyFileException;
import sk.umb.file_sorter.core.ReadDirectory;

public class CreateDirectoryMapingTest {

	public static void main(String[] args) {
		CreateTestData.main(new String[] { "CreateTestData, Test" });

		Directory documents = new Directory(Variable.DOCUMENTS, Variable.PATH);
		documents.addPostfix("pdf", "odt");
		Directory videos = new Directory(Variable.VIDEOS, Variable.PATH);
		videos.addPostfix("mkv", "tft");
		Directory musics = new Directory(Variable.MUSICS, Variable.PATH);
		musics.addPostfix("mp3");
		Directory pictures = new Directory(Variable.Picture, Variable.PATH);
		musics.addPostfix("jpg", "JPG", "png");
		
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
			System.out.println("Main thretad don't sleep");
		}
		System.out.println("--------------------------------------");
		System.out.println("Sorting");

		SortFile.getInstance().sortFile(files, documents, videos, musics, pictures);

		CreateDirectoryMapingTest.execute(documents);
		CreateDirectoryMapingTest.execute(videos);
		CreateDirectoryMapingTest.execute(musics);
		CreateDirectoryMapingTest.execute(pictures);

	}

	private static void execute(final Directory dir) {
		if (dir.isEmpty()) {
			System.out.println("Name directory: " + dir.getName() + " is empty, do not create");
			return;
		}

		CreateDirectoryMapingTest.printFile(dir);
		CreateDirectoryMapingTest.createDirectory(dir);
	}

	private static void printFile(final Directory dir) {
		System.out.println("Name directory: " + dir.getName());
		for (File temp : dir.getFile()) {
			System.out.println(temp.getName());
		}
		System.out.println(" ");
	}

	private static boolean createDirectory(final Directory dir) {
		File file = new File(dir.getPath());

		if (file.exists())
			return true;
		if (file.mkdirs())
			return true;
		
		
		return false;
	}
}
