package net.wanhe.edusystem.frame.tea;

import net.wanhe.edusystem.exception.TeaException;
import net.wanhe.edusystem.pojo.Teacher;
import net.wanhe.edusystem.service.TeaService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeaAddFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    private TeaService teaService = new TeaService();

    //    public static void main(String[] args) {
//        StuAddFrame stuAddFrame = new StuAddFrame();
//        stuAddFrame.setVisible(true);
//    }
    /*
     * 该构造方法指定了当前窗口对象的信息
     */
    public TeaAddFrame() {
        //设置当前窗口的标题
        setTitle("教师管理-添加");
        //设置关闭该窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口弹出的位置距离屏幕左边的距离
        //设置窗口弹出的位置距离屏幕上边的距离
        //设置窗口的长度
        //设置窗口的高度
        setBounds(500, 250, 700, 600);

        //创建面板对象
        contentPane = new JPanel();
        //设置该面板的边框尺寸
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //将一个JPanel对象设置到当前窗口中
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //创建一个文本框对象
        textField = new JTextField();
        //设置文本框中的文字样式
        textField.setFont(new Font("楷体", Font.PLAIN, 20));
        //设置文本框在面板中的位置和大小
        textField.setBounds(276, 60, 250, 40);
        //将文本框对象添加到面板对象中
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("楷体", Font.PLAIN, 20));
        textField_1.setBounds(276, 130, 250, 40);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("楷体", Font.PLAIN, 20));
        textField_2.setBounds(276, 200, 250, 40);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("楷体", Font.PLAIN, 20));
        textField_3.setBounds(276, 270, 250, 40);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("楷体", Font.PLAIN, 20));
        textField_4.setBounds(276, 340, 250, 40);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel label = new JLabel("工号:");
        label.setFont(new Font("楷体", Font.PLAIN, 24));
        label.setBounds(142, 60, 120, 43);
        contentPane.add(label);

        JLabel label_1 = new JLabel("姓名:");
        label_1.setFont(new Font("楷体", Font.PLAIN, 24));
        label_1.setBounds(142, 130, 120, 43);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("年龄:");
        label_2.setFont(new Font("楷体", Font.PLAIN, 24));
        label_2.setBounds(142, 200, 120, 43);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("手机号:");
        label_3.setFont(new Font("楷体", Font.PLAIN, 24));
        label_3.setBounds(142, 270, 120, 43);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("地址:");
        label_4.setFont(new Font("楷体", Font.PLAIN, 24));
        label_4.setBounds(142, 340, 120, 43);
        contentPane.add(label_4);

        JButton btnNewButton = new JButton("确认");
        //给当前按钮对象绑定 点击事件
        //指定 点击该对象需要做的事情
        btnNewButton.addActionListener(new ActionListener() {
            //指定需要做的事情
            public void actionPerformed(ActionEvent e) {
                String num = textField.getText();
                String name = textField_1.getText();
                String age = textField_2.getText();
                String phone = textField_3.getText();
                String address = textField_4.getText();
                Teacher tea = new Teacher(Integer.parseInt(num),name,Integer.parseInt(age),phone,address);
                try {
                    teaService.addTeas(tea);
                    dispose();
                    TeaListFrame frame = new TeaListFrame();
                    frame.setVisible(true);
                } catch (TeaException ex) {
                    JOptionPane.showMessageDialog(contentPane,ex.getMessage());
                }

            }
        });
        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
        btnNewButton.setBounds(389, 430, 137, 35);
        contentPane.add(btnNewButton);

        JButton button = new JButton("取消");
        //指定用户点击当前按钮时我们需要做的事情
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                TeaListFrame frame = new TeaListFrame();
                frame.setVisible(true);

            }
        });
        button.setFont(new Font("楷体", Font.PLAIN, 25));
        button.setBounds(142, 430, 137, 35);
        contentPane.add(button);
    }

}
