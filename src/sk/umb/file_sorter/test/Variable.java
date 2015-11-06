package sk.umb.file_sorter.test;

public class Variable {
	public static final String LINUX = "Linux";
	public static final String MAC = "Mac OS X";
	public static final String USER_NAME = System.getProperty("user.name");
	public static final String OPERATING_SYSTEM = System.getProperty("os.name");
	public static final String PATH = LINUX.equals(OPERATING_SYSTEM) || MAC.equals(OPERATING_SYSTEM) ? new String("/home/" + USER_NAME + "/test/") : "Windows";
	public static final String[] FILE_NAMES = {"je", "to", "super", "appka", "smile_emoticon" };
	public static final String[] TEST_FILE_NAMES = {"film.mp4", "titulky.tft", "dokument.pdf","hudba.waw","wtf.tft", "pavol.pdf", "istvan.pdf", "branko.mp3", "santa.odt", "za.ker.rak.mkv" , ".hidenFile", "chytak_bez_pripony", "palko.mp3" };
	public static final String[] TEST_DIRECTORY_NAMES = {"Santa", "Klaus", "Vianoce", ".hiden_direcotry"};
	public static final String DOCUMENTS = "Dokumenty";
	public static final String MUSICS = "Hudba";
	public static final String VIDEOS = "Filmy";
	public static final String Picture = "Obrazky";
}
