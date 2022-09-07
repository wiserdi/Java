package net.wanhe.edusystem;

import java.util.Scanner;

/*
 * 描述学生系统
 */
public class StuSystem {

    Scanner sc = new Scanner(System.in);

    static String[] stus = new String[20];

    public void run() {
        boolean flag = true;
        while(flag){
            int chooise = printMenu();
            switch(chooise){
                case 1:
                    findAllStus();
                    break;
                case 2:
                    addStu();
                    break;
                case 3:
                    delStu();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }

    public int printMenu(){
        System.out.println("--学生管理--");
        System.out.println("1.查看学生信息");
        System.out.println("2.添加学生");
        System.out.println("3.删除学生");
        System.out.println("4.返回上一级");
        System.out.println("请选择:");
        return sc.nextInt();
    }

    /*
     * 展示所有学生的信息
     */
    public void findAllStus(){
        for(int i = 0;i < stus.length;i++){
            if(stus[i] != null){
                System.out.println("学号:" + (i+1) + "  姓名:" + stus[i]);
            }
        }
    }

    /*
     * 添加学生
     */
    public void addStu(){
        System.out.println("请输入学号:");
        int num = sc.nextInt();
        System.out.println("请输入姓名:");
        String name = sc.next();
        if(num < 1 || num > stus.length){
            System.out.println("请输入正确的学号（1-20)");
            return;
        }
        if(stus[num - 1] != null){
            System.out.println("该学号以使用");
            return;
        }
        stus[num - 1] = name;
        System.out.println("添加成功");
    }

    /*
     * 删除学生
     */
    public void delStu(){
        System.out.println("请输入学号:");
        int num = sc.nextInt();
        if(num < 1 || num > stus.length){
            System.out.println("请输入正确的学号（1-20)");
            return;
        }
        stus[num - 1] = null;
        System.out.println("删除成功");
    }

}
