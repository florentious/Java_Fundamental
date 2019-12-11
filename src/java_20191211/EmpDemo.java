package java_20191211;

import java_20191211.dao.EmpDao;
import java_20191211.dto.EmpDto;

public class EmpDemo {
	public static void main(String[] args) {
		
		/*
		try {
			EmpDao dao = (EmpDao) Class.forName("java_20191211.dao.EmpDao").newInstance();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		EmpDao dao = EmpDao.getInstance();
		
		//dao.insert(new EmpDto(9001,"name","job",7839,null,4998,0,20));
		//dao.update(new EmpDto(9000,"nameUpdated2","jobUpdated2",7839,null,4500,150,20));
		//dao.delete(9001);
		/*
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		list = dao.select(0, 10);
		
		for (EmpDto dto : list) {
			System.out.printf("%d, %s, %s, %d, %s, %d, %d, %d%n",
					dto.getNo(),dto.getName(),dto.getJob(), dto.getMgr(), dto.getHireDate(), dto.getSal(), dto.getComm(), dto.getDeptNo());
		}
		*/

		EmpDto dto = dao.select(9000);
		if(dto != null) {
			System.out.printf("%d, %s, %s, %d, %s, %d, %d, %d%n",
					dto.getNo(),dto.getName(),dto.getJob(), dto.getMgr(), dto.getHireDate(), dto.getSal(), dto.getComm(), dto.getDeptNo());
			
		} else {
			System.out.println("Not Exist employer");
		}
		
		
	}
}
