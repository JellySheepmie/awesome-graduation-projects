package zhanlang.entity;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;

import zhanlang.service.operate.ServerListen;
/**
 * Service
 * 服务器入口类
 * @author lisi
 *
 */
public class Service {
	public static void main(String[] args) throws IOException {
		//输出流重定向
		PrintStream ps=System.out;
		Date date=new Date();
		PrintStream pfile=new PrintStream(new FileOutputStream(new File("日志_"+(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate()+".txt"),true));
		pfile.println();
		pfile.println("["+(date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds()+"]");
		pfile.println();
		PrintStream ps1=new PrintStream(new OutputStream() {
			
			@Override
			public void write(int b) throws IOException {
				// 写入指定的字节，忽略
			}
			@Override
			public void write(byte data[]) throws IOException{
		        // 追加一行字符串,显示在窗口上
				ServiceFrame.jta.append(new String(data));
				//同步到日志文件中
				pfile.print(new String(data));
		    }
			@Override
		    public void write(byte data[], int off, int len) throws IOException {
		        // 追加一行字符串中指定的部分，这个最重要
		    	ServiceFrame.jta.append(new String(data, off, len));
		    	//同步到日志文件中
		    	pfile.print(new String(data, off, len));
		        // 移动TextArea的光标到最后，实现自动滚动
		    	ServiceFrame.jta.setCaretPosition(ServiceFrame.jta.getText().length());
		    }
		});
		//System输出流重定向
		System.setOut(ps1);
		//System.setErr(ps1);
		//设置光标颜色
		ServiceFrame.jta.setCaretColor(new Color(255, 0, 0));
		//设置用于呈现禁用文本的当前颜色。设置颜色会触发一个 PropertyChange 事件 ("disabledTextColor")。 
		ServiceFrame.jta.setDisabledTextColor(new Color(0, 255, 0));
		//设置用于呈现选定文本的当前颜色。将颜色设置为 null 的方法与设置 Color.black 的方法相同。设置颜色会导致触发一个 PropertyChange 事件 ("selectedTextColor")。 
		ServiceFrame.jta.setSelectedTextColor(new Color(0, 0, 255));
		//设置用于呈现选定的当前颜色。将颜色设置为 null 的方法与设置 Color.white 的方法相同。设置颜色会导致一个 PropertyChange 事件 ("selectionColor")。 
		ServiceFrame.jta.setSelectionColor(Color.GRAY);
		//选中的文本的颜色
		ServiceFrame.jta.setSelectedTextColor(new Color(255, 0, 0));
		//选中的文本的背景
		ServiceFrame.jta.setSelectionColor(new Color(0, 0, 255));
		//设置文本框的背景颜色
		ServiceFrame.jta.setBackground(new Color(0, 0, 0));
		//字体颜色
		ServiceFrame.jta.setForeground(new Color(0, 255, 0));
		//字体样式
		ServiceFrame.jta.setFont(new Font("宋体", Font.BOLD, 16));//BOLD 粗体样式常量。ITALIC 斜体样式常量。PLAIN 普通样式常量。
		System.out.println("服务器启动成功！");
		//处理用户接入线程部分
		ServerListen sl=new ServerListen();
		Thread t=new Thread(sl);
		t.start();
		//处理服务器窗口
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}
}
