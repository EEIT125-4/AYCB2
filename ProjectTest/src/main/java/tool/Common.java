package tool;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.Part;

import net.bytebuddy.asm.Advice.This;

public  class Common {
	
	
	public void changeEnv(String env) {
		
		if(env.equals("Kevin")) {
			
			
		}
		
		
	}
	
	
	public static String UPLOAD_PATH="C:/iii/Java/JavaWebWorkspace/ProjectTest/WebContent/upload";//UPLOAD_PATH="C:/AYCB/AYCB2/src/main/webapp/upload/
	public static String IMAGE_REAL_PATH="C:\\iii\\java\\src\\main\\webapp\\upload";//"C:\\AYCB\\AYCB2\\src\\main\\webapp\\upload"
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
	
	public static String saveImage(Part part) throws IOException {
		
		String filename = part.getSubmittedFileName();

		filename = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_"
				+ filename;

		File file = new File(Common.UPLOAD_PATH, filename);

		part.write(file.getAbsolutePath());// 寫入真實路徑

		System.out.printf("成功寫入圖片,路徑:%s\n", file.getAbsoluteFile());

		return "./upload/" + filename;
		
		
	}
	
	public static String getImgRealPath(String s) {
		
		String path = s.substring(s.lastIndexOf("/"));
		return  Common.IMAGE_REAL_PATH+ path;
	}

}
