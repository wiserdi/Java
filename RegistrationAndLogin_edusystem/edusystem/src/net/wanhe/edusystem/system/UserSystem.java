package net.wanhe.edusystem.system;

import net.wanhe.edusystem.controller.UserController;

public class UserSystem {

    private UserController userController = new UserController();

    /*
     * 控制登陆注册的系统运行流程
     */
    public void run(){
        boolean flag = true;
        while(flag){
            //展示菜单
            int chooise = userController.printMenu();
            //根据用户输入的选项执行对应的功能
            switch(chooise){
                case 1:
                    //登录功能
                    //true  登陆成功  flag = false;
                    //false 登录失败  flag = true
                    flag = !userController.login();
                    break;
                case 2:
                    //注册功能
                    userController.regist();
                    break;
                default:
                    System.out.println("请选择正确的选项");
            }
        }
    }
}
