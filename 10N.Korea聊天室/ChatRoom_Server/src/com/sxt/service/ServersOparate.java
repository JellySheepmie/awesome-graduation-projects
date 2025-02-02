package com.sxt.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import com.sxt.dao.Parse;
import com.sxt.server.swing.MyCellRenderer;
import com.sxt.server.swing.MyListModel;
import com.sxt.vo.TransMsg;
import com.sxt.vo.Users;
/**
 * 服务器功能实现类
 * @author gabriel
 *
 */
public class ServersOparate {
	//登录
	public static TransMsg checkUser(TransMsg buff){
		return new TransMsg("login", Parse.checkout((Users) buff.getMsg()));
	}
	//注册
	public static TransMsg registerUser(TransMsg buff){
		Users users=(Users) buff.getMsg();
		if(Parse.addUser(users)){
			return new TransMsg("regist", users);
		}else return new TransMsg("regist", null);
		
	}
	//管理员操作：查看全部用户  返回所有用户
	public static TransMsg adminShowAllUsers(){
		return new TransMsg("Admin-ShowAllUsers", Parse.getUser());
	}
	//添加在线好友
	public  static List<Users> addOnlineUsers(List<Users> list,Users users){
		
		for(Users u:list){
			if(u.getName().equals(users.getName()))
				return list;
		}
		list.add(users);
		return list;
	}
	//删除用户
	public static TransMsg delUser(TransMsg buff){
		Users users=(Users) buff.getMsg();
		if(Parse.searchUser(users)!=null){
			Parse.deleteUsers(users);
			return new TransMsg("Admin-DeleteUsers", new Users("true", "true", "true", 0));
		}
		return new TransMsg("Admin-DeleteUsers", new Users("false", "false", "false", 0));
	}
	//管理员返回查找用户
	public static TransMsg AdminCheckUser(TransMsg buff){
		return new TransMsg("Admin-FindUser", Parse.searchUser((Users) buff.getMsg()));
	}
//管理员修改用户操作实现
	public static TransMsg AdminModifyUser(TransMsg buff){
		boolean b=Parse.changeUsers((Users)buff.getMsg());
		if (b) {
			return new TransMsg("Admin-ModifyUser", new Users(null, "true", null, 0));
		}
		return new TransMsg("Admin-ModifyUser", new Users(null, "false", null, 0));
	}
	//添加到服务器在线用户
	public static void addToServerOnlineUser(JList jList,List list){
		MyCellRenderer cellRenderer=new MyCellRenderer((ArrayList<Users>) list);
		MyListModel model=new MyListModel((ArrayList<Users>) list);
		jList.setCellRenderer(cellRenderer);
		jList.setModel(model);
		
	}
}
