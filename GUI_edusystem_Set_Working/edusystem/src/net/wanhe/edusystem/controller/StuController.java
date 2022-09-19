package net.wanhe.edusystem.controller;

import net.wanhe.edusystem.exception.StuException;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.service.StuService;
import net.wanhe.edusystem.pojo.Student;

import java.util.Scanner;

/**
 * 模拟销售
 * 获取用户数据
 * 展示用户结果
 */
public class StuController {

    private Scanner sc = new Scanner(System.in) ;

    private StuService stuService = new StuService();

    //展示当前系统菜单的方法
    public int printMenu(){
        System.out.println("--学生管理系统--");
        System.out.println("1.查询信息");
        System.out.println("2.添加信息");
        System.out.println("3.删除信息");
        System.out.println("4.返回上级");
        return sc.nextInt();
    }

    /**
     * 添加学生
     */
     public void addStu(){
            System.out.println("请输入学号");
            int num = sc.nextInt();
            System.out.println("请输入姓名");
            String name = sc.next();
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            System.out.println("请输入电话");
            String phone = sc.next();
            System.out.println("请输入地址");
            String address = sc.next();

            //将获取到的用户数据封装成学生对象
            Student stu = new Student(num,name,age,phone,address);
            //将数据交给servie,由service继续完成
            try{
                stuService.addStu(stu);
                System.out.println("添加成功");
            } catch (StuException e) {
                System.out.println(e.getMessage());
            }
     }


    //删除学生
    public void delStu(){
        System.out.println("请输入正确学号");
        int num = sc.nextInt();
        stuService.delStu(num);
        System.out.println("删除成功");
    }


    //查询信息
    public void showStus(){
        Student[] stus = stuService.findAllStus();
        for (int i = 0; i < stus.length; i++){
            if (stus[i] != null){
                System.out.println("学号" + stus[i].getNum()
                        +"  姓名："+ stus[i].getName()
                        +"  年龄："+ stus[i].getAge()
                        +"  手机号："+ stus[i].getPhone()
                        +"  地址："+ stus[i].getAddress()
                );
            }
        }
    }
}