package sk.umb.file_sorter.test;

import sk.umb.file_sorter.core.CreateFile;

public class CreateFolderTest {
	private static final String LINUX = "Linux";
	private static final String MAC = "Mac OS X";

	public static void main(String[] args) {
		String userName = System.getProperty("user.name");
		System.out.println(userName);

		String operatingSystem = System.getProperty("os.name");
		System.out.println(operatingSystem);

		String path = null;
		if (LINUX.equals(operatingSystem) || MAC.equals(operatingSystem)) {
			path = new String("/home/" + userName + "/test/");
			System.out.println(path);
		} else {
			System.exit(0);
		}

		final String[] filesName = { "je", "to", "super", "appka", "smile_emoticon" };

		for (int i = 0; i < filesName.length; i++) {
			String tempPath = path + filesName[i];
			System.out.println(tempPath);
			try {
				CreateFile.getInstance().createFile(tempPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}