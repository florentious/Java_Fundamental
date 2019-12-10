package java_20191210;

import java.util.ArrayList;

import java_20191210.dao.DeptDao;
import java_20191210.dto.DeptDto;

public class DeptDemo {
	public static void main(String[] args) {
		DeptDao d = DeptDao.getInstance();
		
		//System.out.println(d.insert(new DeptDto(70,"ANAYSIS","CICAGO")));		// insert
		//System.out.println(d.update(new DeptDto(70,"ANAYSIS","LA")));			// update
		//System.out.println(d.delete(70));										// delete
		
		ArrayList<DeptDto> list = d.select();									// select all
		for (DeptDto dto : list) {
			System.out.printf("deptno : %3d, dname : %10s, loc : %s%n",dto.getNo(), dto.getName(), dto.getLoc());
		}
		
		
		DeptDto dto = d.select(70); 
		if(dto == null) {
			System.out.println("Don't have Data");
		}else {
			System.out.printf("deptno : %3d, dname : %10s, loc : %s%n",dto.getNo(), dto.getName(), dto.getLoc());
		}
		
		
	}
}
