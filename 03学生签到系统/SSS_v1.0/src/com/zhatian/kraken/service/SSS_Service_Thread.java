package com.zhatian.kraken.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;

import org.dom4j.DocumentException;

import com.zhatian.Tinner.dao.AdminDao;
import com.zhatian.Tinner.dao.StudentDao;
import com.zhatian.Tinner.entity.Sign;
import com.zhatian.Tinner.entity.SignDate;
import com.zhatian.Tinner.entity.Student;
import com.zhatian.kraken.util.KrakenRecord;

/**
 * 
 * 逻辑线程
 * 
 * @author ask-kraken
 * @version 1.0
 */
public class SSS_Service_Thread implements Runnable {
	private Socket socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public SSS_Service_Thread(Socket socket) {
		this.socket = socket;
		//System.out.println(socket.hashCode());
		try {
			// 获取输入管道
			objectInputStream = new ObjectInputStream(this.socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void destroy() throws Exception {
		this.objectInputStream.close();
		this.objectOutputStream.close();
		this.socket.close();
	}

	@Override
	public void run() {
		try {
			int statusCode = objectInputStream.readInt();
			KrakenRecord.log("statusCode = "+statusCode + "\t");
			switch (statusCode) {
			case 0:
				this.stuRegister();
				break;
			case 1:
				this.stuLogin();
				break;
			case 2:
				this.stuModification();
				break;
			case 3:
				this.stuSignIn();
				break;
			case 4:
				this.stuSignOut();
				break;
			case 5:
				this.stuLog();
				break;
			case 6:
				this.stuShowLog();
				break;
			case 7:
				this.stuFindStrById();
				break;
			case 11:
				this.adminLogin();
				break;
			case 12:
				this.adminAddStudent();
				break;
			case 13:
				this.adminFindStrById();
				break;
			case 14:
				this.adminFindStrByUsername();
				break;
			case 15:
				this.adminChangeStudent();
				break;
			case 16:
				this.adminDeleteStudent();
				break;
			case 17:
				this.adminFindSignListByTimeAndClass();
				break;
			case 18:
				this.adminFindAllSignByStudentId();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 学生注册-0
	 * Input
	 * 	String username;
	 * 	String password;
	 * 	String name;
	 *  String sex;
	 *  String age;
	 *  String classroom;
	 * Output
	 * 	boolean result
	 */
	public void stuRegister() {
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuRegister");
				String username = objectInputStream.readUTF();
				String password = objectInputStream.readUTF();
				String name = objectInputStream.readUTF();
				String sex = objectInputStream.readUTF();
				String age = objectInputStream.readUTF();
				String classroom = objectInputStream.readUTF();	
				boolean result = StudentDao.stuRegist(username, password, name, sex, age, classroom);
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 学生登录-1
	 * Input
	 * 	String username;
	 * 	String password;
	 * Output
	 * 	Student student
	 */
	public void stuLogin() {
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuLogin");
				String username = objectInputStream.readUTF();
				String password = objectInputStream.readUTF();
				
				Student student = StudentDao.getStuByNameAndPwd(username, password);
						//new Student(1, "123", "123", "测试", "男", "12", "403");
				objectOutputStream.writeObject(student);
				objectOutputStream.flush();
				
				this.destroy();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 学生修改信息-2
	 * Input
	 * 	Student student
	 * Output
	 * 	boolean result
	 */
	public void stuModification() {
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuModification");
				Student student = (Student) objectInputStream.readObject();	
				boolean result = StudentDao.stuMotify(student.getStudent_Id(), student.getStudent_Password(), student.getStudent_Name(),student.getStudent_Sex(), student.getStudent_Age(), student.getStudent_Classroom());
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 学生签到-3
	 * Input
	 * 	String student_Id;
	 * 	Date studentDate;
	 * Output
	 * 	boolean result
	 */
	public void stuSignIn(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuSignIn");
				Student student = (Student) objectInputStream.readObject();
				Date studentDate = (Date) objectInputStream.readObject();
				boolean result = StudentDao.stuSignIn(student.getStudent_Id(),studentDate);
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 学生签退-4
	 * Input
	 * 	String student_Id;
	 * 	Date studentDate;
	 * Output
	 * 	boolean result
	 */
	public void stuSignOut(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuSignOut");
				Student student = (Student) objectInputStream.readObject();
				Date studentDate = (Date) objectInputStream.readObject();
				boolean result = StudentDao.stuSignOut(student.getStudent_Id(),studentDate);
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 学生日志-5
	 * Input
	 * 	String student_Id;
	 * 	String student_Log;
	 * Output
	 * 	boolean result
	 */
	public void stuLog(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuLog");
				Student student = (Student) objectInputStream.readObject();
				String student_Log = objectInputStream.readUTF();
				KrakenRecord.log(student.getStudent_Id()+student_Log);
				boolean result = StudentDao.stuLog(student.getStudent_Id(), student_Log);
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 学生查找指定日期日志-6 
	 */
	public void stuShowLog(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuShowLog");
				Student student = (Student) objectInputStream.readObject();
				String dateTime = objectInputStream.readUTF();
				Sign result = StudentDao.findSignByData(student, dateTime);
						//new Sign(1, 1, new Date(), new Date(), "测试日志", new Date());
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员通过Id查找学生-7
	 */
	public void stuFindStrById(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:stuFindStrById");
				int stuId = objectInputStream.readInt();
				Student result = AdminDao.getStudentById(stuId);
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员登录-11
	 */
	public void adminLogin(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminLogin");
				String username = objectInputStream.readUTF();
				String password = objectInputStream.readUTF();
				boolean result = false;
				if(username.equals("admin")&&password.equals("123456")){
					result = true;
				}
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员添加学生-12
	 */
	public void adminAddStudent(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminAddStudent");
				Student student = (Student) objectInputStream.readObject();
				boolean result = AdminDao.addStu(student.getStudent_Username(), student.getStudent_Password(),
						student.getStudent_Name(), student.getStudent_Sex(), student.getStudent_Age(),
						student.getStudent_Classroom());
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员通过Id查找学生-13
	 */
	public void adminFindStrById(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminFindStrById");
				int stuId = objectInputStream.readInt();
				Student result = AdminDao.getStudentById(stuId);
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员通过username查找学生-14
	 */
	public void adminFindStrByUsername(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminFindStrByUsername");
				String username = objectInputStream.readUTF();
				Student result = AdminDao.getStudentByUsername(username);
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员修改学生信息-15
	 */
	public void adminChangeStudent(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminChangeStudent");
				Student student = (Student) objectInputStream.readObject();
				boolean result = AdminDao.stuMotify(student.getStudent_Id(), student.getStudent_Password(),student.getStudent_Name(),
						student.getStudent_Sex(), student.getStudent_Age(), student.getStudent_Classroom());
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员删除学生信息-16
	 */
	public void adminDeleteStudent(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminDeleteStudent");
				Student student = (Student) objectInputStream.readObject();
				boolean result = AdminDao.deleteStu(student.getStudent_Id());
				objectOutputStream.writeBoolean(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员通过日期和班级查找学生签到信息-17
	 */
	public void adminFindSignListByTimeAndClass(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminFindSignListByTimeAndClass");
				String time = objectInputStream.readUTF();
				String classroom = objectInputStream.readUTF();
				List<SignDate> result = AdminDao.getSignListHistory(time, classroom);
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 管理员查找指定学生历史日志-18
	 */
	public void adminFindAllSignByStudentId(){
		synchronized ("server") {
			try {
				KrakenRecord.log("SSS_Service_Thread:adminFindAllSignByStudentId");
				Student student = (Student) objectInputStream.readObject();
				List<Sign> result = AdminDao.getSignListByStudentId(student);
				objectOutputStream.writeObject(result);
				objectOutputStream.flush();
				
				this.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
