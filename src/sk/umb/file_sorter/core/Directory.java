package sk.umb.file_sorter.core;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {
	private final String path;
	private final String nameDirectory;
	private List<String> postfix;
	private List<File> files;
	private boolean isEmpty = true;
	
	public Directory(final String nameDirectory, final String path){
		this.nameDirectory = nameDirectory;
		this.path = path;
		this.postfix = new ArrayList<String>();
		this.files = new ArrayList<File>();
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
	
	public void addFile(final File file) {
		this.isEmpty = false;
		this.files.add(file);
	}
	
	public List<File> getFile() {
		return this.files;
	}
	
	public boolean isEmpty() {
		return this.isEmpty;
	}
	
	public String getPath() {
		return this.path + this.nameDirectory + "/";
	}
 }
