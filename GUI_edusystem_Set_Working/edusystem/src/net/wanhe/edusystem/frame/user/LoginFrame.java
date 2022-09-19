package net.wanhe.edusystem.frame.user;

import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.frame.Menu;
import net.wanhe.edusystem.pojo.User;
import net.wanhe.edusystem.service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
    private UserService userService = new UserService();

    /**
     * 该构造方法指定了当前窗口对象的信息
     */
    public LoginFrame() {
        //设置当前窗口的标题
        setTitle("登录");
        //设置关闭该窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口弹出的位置距离屏幕左边的距离
        //设置窗口弹出的位置距离屏幕上边的距离
        //设置窗口的长度
        //设置窗口的高度
        setBounds(500,250,500,350);

        //创建面板对象
        contentPane = new JPanel();
        //设置该面板的边框尺寸
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        //将一个JPanel对象设置到当前窗口中
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //创建一个文本框对象
        textField = new JTextField();
        //设置文本框中的文字样式
        textField.setFont(new Font("楷体",Font.PLAIN,15));
        //设置文本框在面板中的位置和大小
        textField.setBounds(176,58,250,35);
        //设置文本框对象添加到面板对象中
        contentPane.add(textField);
        textField.setColumns(10);


        passwordField = new JPasswordField();
        passwordField.setFont(new Font("楷体",Font.PLAIN,15));
        passwordField.setBounds(176,128,250,35);
        contentPane.add(passwordField);


        JLabel label = new JLabel("账号：");
        label.setFont(new Font("楷体 ",Font.PLAIN,20));
        label.setBounds(100,52,120,43);
        contentPane.add(label);

        JLabel label_1 = new JLabel("密码：");
        label_1.setFont(new Font("楷体 ",Font.PLAIN,20));
        label_1.setBounds(100,122,120,43);
        contentPane.add(label_1);


        JButton btnNewButton = new JButton("登录");
        //给当前按钮对象绑定 点击事件
        //指定 点击该对像需要做的事情
        btnNewButton.addActionListener(new ActionListener(){
            //指定需要做的事情
            public void actionPerformed(ActionEvent e){
                String loginName = textField.getText();
                String password = passwordField.getText();
                User user  = new User(loginName,password);
                try {
                    userService.userLogin(user);
                    dispose();
                    net.wanhe.edusystem.frame.Menu menu = new Menu();
                    menu.setVisible(true);
                } catch (UserException ex) {
                    JOptionPane.showMessageDialog(contentPane,ex.getMessage());
                }
            }
        });
        btnNewButton.setFont(new Font("楷体",Font.PLAIN,25));
        btnNewButton.setBounds(62,230,137,35);
        contentPane.add(btnNewButton);



        JButton Button  = new JButton("注册");
        //指定用户点击当前按钮时我们需要做的事情
        Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //关闭当前窗口
                dispose();
                //打开注册窗口
                RegistFrame frame = new RegistFrame();
                frame.setVisible(true);
            }
        });
        Button.setFont(new Font("楷体",Font.PLAIN,25));
        Button.setBounds(289,230,137,35);
        contentPane.add(Button);
    }


}
