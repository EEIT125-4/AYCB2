package tool;

import java.io.File;

public  class Common {
	
	
	public void changeEnv(String env) {
		
		if(env.equals("Kevin")) {
			
			
		}
		
		
	}
	

	public static String UPLOAD_PATH="C:/iii/Java/JavaWebWorkspace/ProjectTest/WebContent/upload";
	//public static String uPLOAD_DIR="C:/iii/Java/JavaWebWorkspace/ProjectTest/WebContent/upload";
			
	public static boolean deleteFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			if (file.isFile()) {// 如果是一個標準檔案
				file.delete();
			} else {
				// 如果是一整個資料夾,把資料夾下所有的文件刪除,此案例雖然用不到,但之後可以做為其他專案參考
				File fileLists[] = file.listFiles();
				for (File f : fileLists) {
					f.delete();
				}
			}
		}
		return !file.exists();// 不知道有沒有可能碰到,刪不掉的情形
	}

}
