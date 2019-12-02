package java_20191202;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	public static void main(String[] args) {
		File f1 = new File("c:\\dev\\io\\2019\\12");
		boolean isSuccess = f1.mkdirs();
		System.out.println(isSuccess);
		
		File f2 = new File(f1,"jdk-11.0.3_windows-x64_bin.exe")	;
		long fileSize = f2.length()/1024;								//file size 구하기 위해선 length, 사이즈가 커서 long type임
		System.out.println(fileSize);
		long lastModified = f2.lastModified();
		
		Calendar c = Calendar.getInstance();				// getInstance() method 에는 new GregorianCalendar라는 subClass가 있음
		c.setTimeInMillis(lastModified);
		
		//System.out.println("lastModified : " + lastModified);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
		
		System.out.printf("year : %d, month : %d, day : %d\n",year,month,day);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E요일");
		String date = sdf.format(c.getTime());
		System.out.println(date);
		
		
		File f3 = new File("c:\\dev\\workspace\\Java_Fundamental");
		// list() : c:\\ 위치에 있는 모든 파일과디렉토리를 String[] 배열로 반환한다.
		String[] list = f3.list();
		
		for (String temp : list) {
			File f4 = new File(f3,temp);
			if(f4.isDirectory()) {
				System.out.println("directory : " + temp);
				
			}else if(f4.isFile()) {
				System.out.println("file : " + temp);
				
			}else {
				System.out.println("? : " + temp);
			}
		}
		
		
		File f5 = new File(f1,"jdk.exe");
		f2.renameTo(f5);
		
		File f6 = new File(f1,"FileDemo.txt");
		try {
			System.out.println(f6.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Name : " + f6.getName());
		System.out.println("Path : " + f6.getPath());
		System.out.println("Parent : " + f6.getParent());
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(f6.getParent());
		sb.append("\\");
		sb.append(System.currentTimeMillis());
		String extension = f6.getName().substring(f6.getName().lastIndexOf("."));
		sb.append(extension);
		
		
		
		//f6.renameTo(new File(sb.toString()));
		File f7 = new File(f6.getParent(), System.currentTimeMillis()+f6.getName().substring(f6.getName().lastIndexOf(".")));
		f6.renameTo(f7);
		
		//f6.delete();
		
		//삭제 안됨, 새로운 객체 만들어서 그 객체가 삭제되게 해야함
		
		
		System.out.println();
		
	}
	
}
