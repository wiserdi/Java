package net.wanhe.edusystem.frame;

import net.wanhe.edusystem.frame.stu.StuListFrame;
import net.wanhe.edusystem.frame.tea.TeaListFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JPanel contentPane;

    public Menu(){
        //设置当前窗口的标题
        setTitle("教育管理系统");
        //设置关闭该窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口弹出的位置距离屏幕左边的距离
        //设置窗口弹出的位置距离屏幕上边的距离
        //设置窗口的长度
        //设置窗口的高度
        setBounds(600, 150, 400, 600);

        //创建面板对象
        contentPane = new JPanel();
        //设置该面板的边框尺寸
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //将一个JPanel对象设置到当前窗口中
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("学生管理");
        //给当前按钮对象绑定 点击事件
        //指定 点击该对象需要做的事情
        btnNewButton.addActionListener(new ActionListener() {
            //指定需要做的事情
            public void actionPerformed(ActionEvent e) {
                dispose();
                StuListFrame frame = new StuListFrame();
                frame.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
        btnNewButton.setBounds(125, 100, 150, 35);
        contentPane.add(btnNewButton);

        JButton button = new JButton("教师管理");
        //指定用户点击当前按钮时我们需要做的事情
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TeaListFrame frame = new TeaListFrame();
                frame.setVisible(true);
            }
        });
        button.setFont(new Font("楷体", Font.PLAIN, 25));
        button.setBounds(125, 200, 150, 35);
        contentPane.add(button);

        JButton button_2 = new JButton("班级管理");
        //指定用户点击当前按钮时我们需要做的事情
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TeaListFrame frame = new TeaListFrame();
                frame.setVisible(true);
            }
        });
        button_2.setFont(new Font("楷体", Font.PLAIN, 25));
        button_2.setBounds(125, 300, 150, 35);
        contentPane.add(button_2);


        JButton button_1 = new JButton("退出系统");
        //指定用户点击当前按钮时我们需要做的事情
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button_1.setFont(new Font("楷体", Font.PLAIN, 25));
        button_1.setBounds(125, 400, 150, 35);
        contentPane.add(button_1);
    }

}
