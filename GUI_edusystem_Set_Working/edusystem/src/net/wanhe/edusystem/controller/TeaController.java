package net.wanhe.edusystem.controller;

import net.wanhe.edusystem.exception.TeaException;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.Teacher;
import net.wanhe.edusystem.service.TeaService;

import javax.swing.*;
import java.util.Scanner;

/**
 *  模拟销售
 *  获取用户数据
 *  获取用户结果
 */
public class TeaController {
    private Scanner sc = new Scanner(System.in);
    private TeaService teaService = new TeaService();
    public TeaController() {
    }

    //展示当前系统菜单的方法
    public int printMenu(){
        System.out.println("--教师管理系统--");
        System.out.println("1.查询信息");
        System.out.println("2.添加信息");
        System.out.println("3.删除信息");
        System.out.println("4.返回上级");
        return sc.nextInt();
    }

    //添加信息
    public void addTeas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入工号");
        int num = sc.nextInt();
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入手机");
        String phone = sc.next();
        System.out.println("请输入地址");
        String address = sc.next();


        //将得到的用户信息封装成对象
        Teacher tea = new Teacher(num,name,age,phone,address);
        //将service交给Service,由service继续完成

        try{
            teaService.addTeas(tea);
            System.out.println("添加成功");
        }catch (TeaException e){
            System.out.println(e.getMessage());
        }
    }

    //删除信息
    public void delTeas(){

        System.out.println("请输入工号：");
        int num =sc.nextInt();
        teaService.delTeas(num);
        System.out.println("删除成功");

    }


    //查询信息
    public void showTeas(){

        Teacher[] teas = teaService.findAllTeas();
         for (int i = 0;i <teas.length;i++){
             if (teas[i] != null){
                System.out.println("工号" + teas[i].getNum()
                        +"  姓名"+teas[i].getName()
                        +"  年龄"+teas[i].getAge()
                        +"  手机号码"+teas[i].getPhone()
                        +"  地址"+teas[i].getAddress()
                );
             }
         }
    }




}
