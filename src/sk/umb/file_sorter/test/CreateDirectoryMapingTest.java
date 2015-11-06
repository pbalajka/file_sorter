package sk.umb.file_sorter.test;

import java.io.File;
import sk.umb.file_sorter.core.Directory;
import sk.umb.file_sorter.core.SortFile;
import sk.umb.file_sorter.core.MyFileException;
import sk.umb.file_sorter.core.ReadDirectory;

public class CreateDirectoryMapingTest {

	public static void main(String[] args) {
		/*CreateTestData.main(new String[] { "CreateTestData, Test" });*/

		Directory documents = new Directory(Variable.DOCUMENTS, Variable.PATH);
		documents.addPostfix("pdf", "odt", "xlsx");
		Directory videos = new Directory(Variable.VIDEOS, Variable.PATH);
		videos.addPostfix("mkv", "tft", "mkv", "srt", "mp4");
		Directory musics = new Directory(Variable.MUSICS, Variable.PATH);
		musics.addPostfix("mp3", "waw");
		Directory pictures = new Directory(Variable.Picture, Variable.PATH);
		pictures.addPostfix("jpg", "JPG", "png");
		Directory archives = new Directory("Archivy", Variable.PATH);
		archives.addPostfix("zip", "rar");
		
		File[] files = null;
		try {
			files = ReadDirectory.getInstance().getSubFile(Variable.PATH);
		} catch (MyFileException e) {
			System.exit(1);
			e.printStackTrace();
		}

		System.out.println("--------------------------------------");
		System.out.println("Sorting");

		SortFile.getInstance().sortFile(files, documents, videos, musics, pictures, archives);
		SortFile.getInstance().moveSortFile(documents, videos, musics, pictures, archives);
		SortFile.getInstance().printFile(documents, videos, musics, pictures, archives);
	}	
}
