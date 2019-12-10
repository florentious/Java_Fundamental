package hello;

import java_20191210.dto.DeptDto;

public class DaoIOExam {

	
	public static void main(String[] args) {
		DeptDaoExam d = DeptDaoExam.getInstance();
		
		System.out.println(d.insert(new DeptDto(70,"ANAYSIS","CICAGO")));
		
	}
}
