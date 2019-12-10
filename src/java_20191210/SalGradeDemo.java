package java_20191210;

import java.util.ArrayList;

import java_20191210.dao.SalGradeDao;
import java_20191210.dto.SalGradeDto;

public class SalGradeDemo {

	public static void main(String[] args) {
		SalGradeDao dao = SalGradeDao.getInstance();
		
		ArrayList<SalGradeDto> list = dao.select();									// select all
		for (SalGradeDto dto : list) {
			System.out.printf("grade : %d, losal : %4d, hisal : %d%n",dto.getGrade(),dto.getLosal(),dto.getHisal());
		}
		
	}
}
