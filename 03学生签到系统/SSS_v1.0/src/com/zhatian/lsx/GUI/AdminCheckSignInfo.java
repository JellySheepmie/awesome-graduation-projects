package com.zhatian.lsx.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.zhatian.Tinner.entity.SignDate;
import com.zhatian.kraken.control.AdminAction;

public class AdminCheckSignInfo extends JFrame implements ActionListener {

	/**
	 * 查看指定班级的指定日期的签到信息。
	 * 需要用户输入班级名称和日期，系统根据这两个条件检索之后，将信息显示在屏幕窗口的表格中
	 * 产生失败的原因是：用户输入班级不存在、用户输入的日期大于当前系统的日期
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton select;
	private JButton return1;
	private JButton downLoad;
	private JTextField clazzField;
	private JTextField dateField;
	private String clazz1 = null;

	private JPanel panel;
	private Vector<Vector<String>> rowData;
	private JTable table;
	private JScrollPane scrollPane;
	// 次变量为一个单独的数据流，是专门为查看班级签到的信息创建的。返回的集合当中存放的信息只有姓名、签到时间和签退时间
	// 设置为私有的全局变量是因为，在点击下载按钮之后，是需要或的这个集合的信息，而放在检索方法内部定义的话，就不能够访问到了
	// 放在外面每检索一次就会对这个signs赋一次值。所以能够保证下载的文件的我们想要的新的文件
	private List<SignDate> signs;
	// 这个是输出Excel文件的一个Excel文件
	private HSSFWorkbook wb;

	/***
	 * 管理员检查某个班级某一天的所有签到信息的功能 管理员在这个功能中可以通过输入日期和班级名称进行检索 系统会以界面的形式显示出来所有的签到信息
	 * 
	 * 唯一失败原因是：管理严输入的时间格式不符合要求，以及管理员输入的日期大于当前系统时间
	 */
	public AdminCheckSignInfo() {
		this.setLayout(null);
		this.setTitle("炸天学生签到系统_查看签到信息");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon liftIicon = new ImageIcon("resource\\admin_resouces\\ico1.jpg");
		// 将左上角图标换做自定义图标
		this.setIconImage(liftIicon.getImage());

		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);

		JLabel clazz = new JLabel("班级：");
		clazz.setFont(new Font("", Font.BOLD, 20));
		clazz.setBounds(12, 20, 63, 25);
		c.add(clazz);
		clazzField = new JTextField(20);
		clazzField.setBounds(72, 20, 45, 30);
		c.add(clazzField);

		JLabel date = new JLabel("日期：");
		date.setFont(new Font("", Font.BOLD, 20));
		date.setBounds(120, 20, 63, 25);
		c.add(date);
		dateField = new JTextField(30);
		dateField.setBounds(180, 20, 100, 30);
		c.add(dateField);

		select = new JButton("检索");
		select.setFont(new Font("", Font.PLAIN, 11));
		select.setBounds(285, 20, 60, 30);
		select.addActionListener(this);
		c.add(select);

		downLoad = new JButton("下载");
		downLoad.setFont(new Font("", Font.PLAIN, 11));
		downLoad.setBounds(355, 20, 60, 30);
		downLoad.addActionListener(this);
		c.add(downLoad);

		return1 = new JButton("返回");
		return1.setFont(new Font("", Font.PLAIN, 11));
		return1.setBounds(425, 20, 60, 30);
		return1.addActionListener(this);
		c.add(return1);

		// 设置盛放表格的容器面板
		JPanel p1 = new JPanel();
		p1.setBounds(0, 70, 500, 470 - 35);
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		c.add(p1);
		p1.setBackground(Color.red);
		p1.setLayout(null);

		// 设置表头
		Vector<String> columnNames = new Vector<>();
		columnNames.add("学生姓名");
		columnNames.add("签到时间");
		columnNames.add("签退时间");

		// 设置表格体,即每一行的数据加起来构成的，就是表格体。每一行的数据是下面定义的celldata。而这么多多的celldata
		// 会构成一个rowdata。即一个表格体。
		rowData = new Vector<>();
		// 初始化表格中的内容
		initTable();
		// 设置表格
		table = new JTable(rowData, columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 500, 470);
		p1.add(scrollPane);

		this.setVisible(true);
	}

	/**
	 * 监听器监听事件方法。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == select) {
			// 这是表格清除语句。将表格中的内容清除干净，不然就没有办法把新查询到的信息输出出来
			rowData.clear();
			// 获取查询所需信息，时间和班级。
			clazz1 = clazzField.getText().trim();
			String date1 = dateField.getText();
			// 定义一个正则表达式校验输入日期的正确性
			String regex = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// 扩大date的作用域，并初始化。在try catch快中可能无法对其进行初始化
			Date date = null;
			if (date1.matches(regex)) {
				// 如果匹配成功，将字符串转换为日期格式，进行下一步匹配
				try {
					date = format.parse(date1);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
				// 判断输入时间是否大于当前时间
				if (date.after(new Date())) {
					JOptionPane.showMessageDialog(panel, "对不起，输入日期大于当前日期，请重新输入！！");
					// 重置输入框
					clazzField.setText("");
					dateField.setText("");
					// 清空表中数据
					rowData.clear();
					// 初始化表格内容
					initTable();
					// 表格重绘
					table.repaint();
					// 布局容器重绘
					// scrollPane.updateUI();
					// //通知界面需要重绘
					// this.revalidate();
				} else {
					// 执行到这里，说明输入的日期格式是属于我们的要求的格式，且日期也合法，不在当前日期之后。
					// 调用服务器的查询方法
					signs = AdminAction.findAllSignByTimeAndClass(date1, clazz1);
					// 需要将传递过来的数据的格式进行转换。
					if (signs == null || signs.isEmpty() || signs.size() == 0) {
						JOptionPane.showMessageDialog(panel, "系统中并无此班级签到信息！");
						// 重置输入框
						clazzField.setText("");
						dateField.setText("");
						// 清空表中数据
						rowData.clear();
						// 初始化表格内容
						initTable();
						// 表格重绘
						table.repaint();
						// 布局容器重绘
						// scrollPane.updateUI();

					} else {
						// SimpleDateFormat format1 = new
						// SimpleDateFormat("HH:mm:ss");
						for (int i = 0; i < signs.size(); i++) {
							Vector<String> cellData = new Vector<>();
							// 这个地方可以直接向celldata中添加元素，因为对于签到时间和签退时间的判断和校验，已经在服务器那边的做好了
							// 返回给我的就是可以直接添加的
							cellData.add("" + (signs.get(i).getName()));
							cellData.add(signs.get(i).getInTime());
							cellData.add(signs.get(i).getOutTime());
							rowData.add(cellData);
						}
						// 刷新界面以显示数据
						// scrollPane.updateUI();
						table.repaint();// ;这个语句没有作用。得让这个放着表格的滚动框重绘
						// this.revalidate();
						// 该语句可没有。因为该语句是当现在的布局中，如果有组件被修改了，才调用这个，通知系统组件被修改，需要对组件重新布局
						// 而在我们的这个操作的里面是没有布局发生改变，只是表格里面的数据变了，所以就不用抵用此语句
					}
				}
			}

		} else if (e.getSource() == downLoad) {
			String path = "c:/";
			// 如果点击下载，先检验我们想要用的集合是不是空的
			if (signs == null || signs.isEmpty() || signs.size() == 0) {
				JOptionPane.showMessageDialog(panel, "无可下载文件，请重新检索！");
				clazzField.setText("");
				dateField.setText("");
			} else {

				// *************************保存路径选择***************************
				// 常见一个文件选择器
				JFileChooser c = new JFileChooser();
				// 设置选择属性.默认为JFileChooser.FILES_ONLY
				c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				// 下载文件时使用showSaveDialog(this) 显示“保存文件选择路径的显示框”
				c.showSaveDialog(this);
				// 从系统打开某个文件的时候，用showOpenDialog(this)，显示“打开文件的选择路径的显示框”
				// c.showOpenDialog(this);
				// **********************保存选择的路径到path**************************************
				// 此条语句是直接得到选择的结果。没有进行错误性的判断
				// String string = c.getSelectedFile().getPath();

				// 此条语句进行了错误性判断
				File file = c.getSelectedFile();
				if (file != null) {
					path = file.getPath();
				}
				// --------------------------进行下载Excel文件的操作----------------------------
				System.out.println(path);
				// 创建HSSFWorkbook对象
				wb = new HSSFWorkbook();
				// 创建HSSFSheet对象
				HSSFSheet sheet = wb.createSheet("签到表格");
				// 创建HSSFRow对象
				// 括号中的数字代表的是表中的第一个数据的出现位置的行位置
				// 注意第一行在这个括号中的参数应该是0
				HSSFRow row1 = sheet.createRow(0);
				HSSFCell cell1 = row1.createCell(0);
				// 设置单元格的值
				cell1.setCellValue(clazz1 + "班--级签到信息");
				// 将表头居中。
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
				// 表格和表头做好之后。现在开始做表格里边的内容
				// 做二级表头
				HSSFRow row2 = sheet.createRow(1);
				row2.createCell(0).setCellValue("学生姓名");
				row2.createCell(1).setCellValue("签到时间");
				row2.createCell(2).setCellValue("签退时间");
				// 将服务器传递过来的信息写入Excel文件当中
				for (int i = 0; i < signs.size(); i++) {
					// 因为想要利用循环中的i值来创建行。而表格的上面已经有了两行，所以这里我们就需要将i的值加2.
					HSSFRow row = sheet.createRow((i + 2));
					row.createCell(0).setCellValue(signs.get(i).getName());
					row.createCell(1).setCellValue(signs.get(i).getInTime());
					row.createCell(2).setCellValue(signs.get(i).getOutTime());
				}
			}
			// 输出Excel文件
			FileOutputStream output = null;
			// 因为出输出流是必须是写入一个文件的，而不是一个文件夹，所以这里的路径里面必须有文件的名字
			// 所以path1 = 从文件选择框得到的路径+“\\”+clazz1+"文件名.xls"
			String path1 = path + "\\" + clazz1 + "班级签到信息.xls";

			try {

				output = new FileOutputStream(path1);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				wb.write(output);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				output.flush();
				output.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(panel, "下载成功，请到指定路径查看文件");
			rowData.clear();
			initTable();
			table.repaint();
			clazzField.setText("");
			dateField.setText("");

		} else if (e.getSource() == return1) {
			new AdminLogicOpera();
			this.dispose();

		}

	}

	private void initTable() {
		for (int i = 0; i < 25; i++) {
			// 这个celldata是每一行中的所有列的信息
			Vector<String> cellData = new Vector<>();
			// 先将表格初始化出来，要不会很难看
			cellData.add("");
			cellData.add("");
			cellData.add("");

			rowData.add(cellData);
		}
	}

	public static void main(String[] args) {
		new AdminCheckSignInfo();
	}

}
