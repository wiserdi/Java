package net.wanhe.edusystem.system;

import net.wanhe.edusystem.controller.StuController;

public class StuSystem {

//    static Student[] stus = new Student[20];
//    Scanner sc = new Scanner(System.in);

    private StuController controller = new StuController();

    //运行学生管理系统
    public void run(){
        boolean flag = true;
        while (flag){
            int choice = controller.printMenu();
            switch (choice){
                case 1://查询信息
                    controller.showStus();
                    break;
                case 2://添加信息
                    controller.addStu();
                    break;
                case 3://删除信息
                    controller.delStu();
                    break;
                case 4://返回上级
                    flag = false;
                    break;
                default://提示出错
                    System.out.println("请输入正确的代码");
                    break;
            }
        }
    }
}
