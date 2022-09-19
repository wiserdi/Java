package net.wanhe.edusystem.system;

import java.util.Scanner;

/**
 * 用来描述教育系统
 */
public class EduSystem {

    //存储数据的容器   应当只有一个 ，放在while循环之外
    //在此处EduSystem对象只被创建了一次
    private StuSystem stuSystem = new StuSystem();
    private TeaSystem teaSystem = new TeaSystem();
    private UserSystem userSystem = new UserSystem();
    private Scanner sc = new Scanner(System.in);

        //运行教育管理系统
        public void run(){
        //运行用户登陆注册系统
        userSystem.run();

        boolean flag = true;
//        存储数据的容器   应当只有一个 ，放在while循环之外
//        在此处run()只被运行了一次
//        StuSystem stuSystem = new StuSystem();
//        TeaSystem teaSystem = new TeaSystem();
        while (flag){
            int choice = printMenu();
            switch (choice){
                case 1://进入学生管理系统
                    stuSystem.run();
                    break;
                case 2://进入教育管理系统
                    teaSystem.run();
                    break;
                case 3://退出系统
                    flag = false;
                    System.out.println("感谢使用");
                    break;
                default://提示错误
                    System.out.println("请输入正确的代码");
                    break;
            }
        }
    }
    //展示当前系统菜单的方法
    public int printMenu(){
        System.out.println("--教育管理系统--");
        System.out.println("1.学生管理系统");
        System.out.println("2.教师管理系统");
        System.out.println("3.退出系统");
        return sc.nextInt();
    }

}
