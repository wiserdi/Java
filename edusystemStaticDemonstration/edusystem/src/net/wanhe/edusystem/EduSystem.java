package net.wanhe.edusystem;

import java.util.Scanner;

/*
 * 用来描述教育系统
 */
public class EduSystem {

    Scanner sc = new Scanner(System.in);

    StuSystem stuSystem = new StuSystem();

    TeaSystem teaSystem = new TeaSystem();

    /*
     * 运行教育管理系统
     */
    public void run(){

        boolean flag = true;
        while(flag){
            int chooise = printMenu();
            switch (chooise){
                case 1:
                    stuSystem.run();
                    break;
                case 2:
                    teaSystem.run();
                    break;
                case 3:
                    System.out.println("谢谢您的使用");
                    flag = false;
                    break;
                default:
                    System.out.println("请选择正确的选项");
            }
        }
    }

    /*
     * 展示当前系统菜单的方法
     */
    public int printMenu(){
        System.out.println("---教育管理系统---");
        System.out.println("1、学生管理");
        System.out.println("2、教师管理");
        System.out.println("3、退出系统");
        System.out.println("请选择:");
        return sc.nextInt();
    }


}
