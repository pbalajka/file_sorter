package sk.umb.file_sorter.core;

import java.io.File;
public class SortFile {
	private static SortFile instance = null;
	
	private SortFile() {}
	
	public static SortFile getInstance() {
		if(instance == null)
			instance = new SortFile();
		
		return instance;
	}

	public void sortFile(final File[] files, final Directory...  directories) {
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().contains(".")) {
				for(int j = 0; j < directories.length; j++) {
					if(!directories[j].containsPostfix(this.getSubfix(files[i]))) 
						continue;
					
					directories[j].addFile(files[i]);
					break;	
				}
			} else {
				System.out.println("Name: " + files[i].getName() + " have not postfix.");
			}
		}
	}
	
	private String getSubfix(final File file) {
		return file.getName().substring(file.getName().lastIndexOf(".") + 1);
	}
}