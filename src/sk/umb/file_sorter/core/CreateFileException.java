package sk.umb.file_sorter.core;

public class CreateFileException extends Exception {
	private static final long serialVersionUID = 1663508798505403273L;
	
	public CreateFileException(){}
	
	public CreateFileException(final String message) {
		super(message);
	}
}