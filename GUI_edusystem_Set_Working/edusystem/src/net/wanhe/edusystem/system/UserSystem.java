package net.wanhe.edusystem.system;

import net.wanhe.edusystem.controller.UserController;


public class UserSystem {

    private UserController userController = new UserController();
    //private boolean flag =true;


    //展示登录注册的菜单
    //1.登录
    //2.注册
    //请选择：
    //注册（成功/失败）  +  登录失败  继续展示当前菜单
    //只有登录成功 展示管理菜单
    //注册  账号 + 密码 + 重复密码  （判断两次密码是否一致）（账号不能重复）
    //登录  账号 + 密码 （判断账号是否正确）  （判断密码是否一致）
    //User loginName passWord Userontroller UserService UserDao


    //运行登录注册系统
    public void run(){
        boolean flag = true;
        while(flag){
            //展示菜单 并拿到用户选项
            int choice = userController.printMenu();
            switch (choice){
                case 1:
                    //登录功能
                    //true  登陆成功 flag = false
                    //true  登陆失败 flag = true
                    //flag = !userController.userLogin();
                    flag = userController.userLogin();
                    break;
                case 2:
                    //注册功能
                    userController.userRegister();
                    break;
                default:
                    System.out.println("请输入正确数字");
            }
        }

    }
}
