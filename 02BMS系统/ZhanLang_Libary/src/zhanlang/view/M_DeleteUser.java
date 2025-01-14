package zhanlang.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zhanlang.DAO.ManagerDAO;
import zhanlang.DAO.Imple.ManagerDAOImple;
import zhanlang.entity.Book;
import zhanlang.entity.User;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class M_DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField deleteUser1;

	/**
	 * Create the frame.
	 */
	public M_DeleteUser(){
		setTitle("删除用户");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblid = new JLabel("请输入用户的ID ：");
		lblid.setFont(new Font("楷体", Font.BOLD, 13));
		lblid.setBounds(44, 82, 125, 24);
		contentPane.add(lblid);

		
		deleteUser1 = new JTextField();
		deleteUser1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		deleteUser1.setBounds(184, 83, 164, 21);
		contentPane.add(deleteUser1);
		deleteUser1.setColumns(10);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(M_DeleteUser.class.getResource("/picture/text/删除.jpg")));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取输入框内容
				String userName =deleteUser1.getText();
				String command=new String("deleteUser");
				User user=new User();
				user.setUserName(userName);
				JOptionPane.showConfirmDialog(null, "确认要删除吗？");
				ManagerDAO manager=new ManagerDAOImple();
				Object object=manager.deleteUser(command, user);
				if((boolean)object==true){
					JOptionPane.showMessageDialog(null, "用户删除成功！");
				//处理完上一次提交的操作申请，应当将输入框置空
				deleteUser1.setText("");	
				}else{
					JOptionPane.showMessageDialog(null, "用户删除失败，请重试！");
				}
			}
		});
		button_4.setBackground(new Color(211, 211, 211));
		button_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		button_4.setBounds(87, 146, 93, 23);
		contentPane.add(button_4);
		

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(M_DeleteUser.class.getResource("/picture/text/返回.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.mDeleteUserFrame.dispose();
			}
		});
		button.setBackground(new Color(211, 211, 211));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		button.setBounds(208, 146, 93, 23);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(M_DeleteUser.class.getResource("/picture/text/添加图书背景.jpg")));
		label.setBounds(0, 0, 384, 262);
		contentPane.add(label);
	}
}
