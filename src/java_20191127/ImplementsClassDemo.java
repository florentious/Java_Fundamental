package java_20191127;

import java.util.*;
import java.sql.*;

/** ( api dacumentation 주소-api 용)
 	this class is testing class
 
 */

public class ImplementsClassDemo {
	/**
	 이 메서드는 JVM이 호출해주는 메서드 입니다.
	 */
	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		InterA a = new ImplementClass();
		a.mA();
		a.mB();
		a.mC();
	}
}
