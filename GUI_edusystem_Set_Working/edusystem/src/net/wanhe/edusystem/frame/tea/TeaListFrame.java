package net.wanhe.edusystem.frame.tea;

import net.wanhe.edusystem.frame.Menu;
import net.wanhe.edusystem.frame.stu.StuUpdateFrame;
import net.wanhe.edusystem.frame.stu.TeaUpdateFrame;
import net.wanhe.edusystem.frame.tea.TeaAddFrame;
import net.wanhe.edusystem.pojo.Student;
import net.wanhe.edusystem.pojo.Teacher;
import net.wanhe.edusystem.service.TeaService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * 展示教师信息的窗口
 */
public class TeaListFrame extends JFrame {

    private JPanel contentPane;

    private JTable table;

    private TeaService teaService = new TeaService();


    //    public static void main(String[] args) {
//        StuListFrame stuListFrame = new StuListFrame();
//        stuListFrame.setVisible(true);
//    }
    /*
     * 该构造方法指定了当前窗口对象的信息
     */
    public TeaListFrame() {
        //设置当前窗口的标题
        setTitle("教师管理-列表");
        //设置关闭该窗口时退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口弹出的位置距离屏幕左边的距离
        //设置窗口弹出的位置距离屏幕上边的距离
        //设置窗口的长度
        //设置窗口的高度
        setBounds(200, 100, 1200, 750);

        //创建面板对象
        contentPane = new JPanel();
        //设置该面板的边框尺寸
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        //将一个JPanel对象设置到当前窗口中
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("添加老师");
        //给当前按钮对象绑定 点击事件
        //指定 点击该对象需要做的事情
        btnNewButton.addActionListener(new ActionListener() {
            //指定需要做的事情
            public void actionPerformed(ActionEvent e) {
                dispose();
                TeaAddFrame frame = new TeaAddFrame();
                frame.setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 25));
        btnNewButton.setBounds(960, 100, 190, 35);
        contentPane.add(btnNewButton);


        JButton button_2 = new JButton("修改信息");
        //指定用户点击当前按钮时我们需要做的事情
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取用户选中的行
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(contentPane,"请选中需要修改的行");
                    return;
                }
                //获取当前这一行的学生信息
                int num = (int)table.getValueAt(row,0);
                String name = (String)table.getValueAt(row,1);
                int age = (int)table.getValueAt(row,2);
                String phone = (String)table.getValueAt(row,3);
                String address = (String)table.getValueAt(row,4);

                Teacher tea = new Teacher(num,name,age,phone,address);

                dispose();
                //通过构造方法将学生信息传递给修改窗口
                TeaUpdateFrame teaUpdateFrame = new TeaUpdateFrame(tea);
                teaUpdateFrame.setVisible(true);
                teaService.update(tea);


            }
        });
        button_2.setFont(new Font("楷体", Font.PLAIN, 25));
        button_2.setBounds(960, 300, 190, 35);
        contentPane.add(button_2);


        JButton button = new JButton("删除老师");
        //指定用户点击当前按钮时我们需要做的事情
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //获取用户在表格中选中的行
                int row = table.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(contentPane,"请选中需要删除的行");
                    return;
                }
                int chooise = JOptionPane.showConfirmDialog(contentPane, "您确定要删除嘛?");
                if(chooise == 0){
                    //获取用户选中的行中的第一列的值
                    int num = (int) table.getValueAt(row, 0);
                    teaService.delTeas(num);
                    //重新初始化表格中的信息
                    initTable();
                }
            }
        });
        button.setFont(new Font("楷体", Font.PLAIN, 25));
        button.setBounds(960, 200, 190, 35);
        contentPane.add(button);

        JButton button_1 = new JButton("返回上一级");
        //指定用户点击当前按钮时我们需要做的事情
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                net.wanhe.edusystem.frame.Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        button_1.setFont(new Font("楷体", Font.PLAIN, 25));
        button_1.setBounds(960, 500, 190, 35);
        contentPane.add(button_1);

        //创建一个滚动条面板
        JScrollPane scrollPane = new JScrollPane();
        //设置滚动条面板尺寸和位置 1200 750
        scrollPane.setBounds(14, 14, 916, 650);
        //将滚动条对象存放到面板中
        contentPane.add(scrollPane);

        //创建表格对象
        //创建一个表格对象
        table = new JTable();
        //设置表格样式
        table.setRowHeight(40);//设置行高
        //设置表格中的字体样式
        table.setFont(new Font("楷体", Font.PLAIN, 24));
        //设置表头
        JTableHeader header = table.getTableHeader();//从表格中获取表头对象
        header.setPreferredSize(new Dimension(1,40));//设置表头高度
        header.setBackground(Color.PINK);//设置表头的背景色
        header.setFont(new Font("楷体", Font.PLAIN, 26));
        //将表格对象存放到滚动面板中
        scrollPane.setViewportView(table);

        //初始化表格中的内容
        initTable();
    }

    /*
     * 初始化表格中的数据
     */
    public void initTable() {
        //定义表格的表头
        String[] heads = {"工号","姓名","年龄","手机号","地址"};
        //定义每一行的数据
//        Object[][] datas = {
//                {1,"张三",18,"1234567","江苏南京"},
//                {2,"李四",18,"1234567","江苏南京"},
//                {3,"王五",18,"1234567","江苏南京"},
//                {4,"赵六",18,"1234567","江苏南京"}
//        };
        Teacher[] teas = teaService.findAllTeas();
        Object[][] datas = new Object[teas.length][5];
        for(int i = 0;i < datas.length;i++){
            datas[i][0] = teas[i].getNum();
            datas[i][1] = teas[i].getName();
            datas[i][2] = teas[i].getAge();
            datas[i][3] = teas[i].getPhone();
            datas[i][4] = teas[i].getAddress();
        }
        //定义一个表格模型
        DefaultTableModel model = new DefaultTableModel(datas,heads);
        //将模型设置到表格中
        table.setModel(model);
    }

}
