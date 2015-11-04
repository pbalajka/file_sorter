package sk.umb.file_sorter.core;


import java.util.ArrayList;
import java.util.List;

public class DirectoryMaping {
	private final String nameDirectory;
	private List<String> postfix;
	
	public DirectoryMaping(final String nameDirectory){
		this.nameDirectory = nameDirectory;
		this.postfix = new ArrayList<String>();
	}
	
	public String getName() {
		return this.nameDirectory;
	}
	
	public List<String> getPostfix() {
		return this.postfix;
	}
	
	public void addPostfix(final String... postfix) {
		for(int i = 0; i < postfix.length; i++) {
			this.postfix.add(postfix[i]);
		}
		
	}
	
	public boolean deletePostfix(final String postfix) {
		if(this.postfix.contains(postfix)) {
			this.postfix.remove(postfix);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsPostfix(final String postfix) {
		if(this.postfix.contains(postfix)) {
			return true;
		} else {
			return false;
		}
	}
}
