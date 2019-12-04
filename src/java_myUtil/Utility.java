package java_myUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	public static boolean isIOCopy(String fromFile, String toFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		boolean isSuccess = false;

		try {
			fis = new FileInputStream(fromFile);
			fos = new FileOutputStream(toFile);

			byte[] readBytes = new byte[1024 * 8]; 
			int readByteCount = 0;

			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
			
			isSuccess = true;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		
		
		return isSuccess;
		
	}
	
	public static String getDate(String pattern) {
		return new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
	}
	
	
	
}
