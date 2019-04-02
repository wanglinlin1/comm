package pro3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

public class PTest {

	public static void main(String[] args) {

		
	 try {
		 Connection con = null;// 创建一个数据库连接
		//1.加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 //2.获取连接对象
		 String url="jdbc:oracle:thin:@WIN1DOHMS6LJG6:1521:ORCL";
		 String user="wll";
		 String password="wll";
		 try {
			con=DriverManager.getConnection(url,user,password);
		//3.设置补全参数
			String sql="{call  PRO3_OUT(?,?)}";
			//3.1设置输出参数
			CallableStatement call=con.prepareCall(sql);
			call.setInt(1, 7);
			//3.2注册输出参数
			call.registerOutParameter(2, OracleTypes.DOUBLE);
	   //4.执行存储过程
			call.execute();
			//5.获取输出参数
			double sar=call.getDouble(2);
			System.out.println(sar);
			call.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
	}
     
//3.设置补全sql参数
//4.执行存储过程
//5.获取输出参数
//6.释放资源

	}

}
