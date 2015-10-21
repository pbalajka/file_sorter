package sk.umb.file_sorter.core;

public class MyFileException extends Exception {
	private static final long serialVersionUID = 1663508798505403273L;
	
	public MyFileException(){}
	
	public MyFileException(final String message) {
		super(message);
	}
}