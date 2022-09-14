package net.wanhe.edusystem.controller;

import net.wanhe.edusystem.pojo.User;
import net.wanhe.edusystem.service.UserService;

import java.util.Scanner;

public class UserController {

    private Scanner sc = new Scanner(System.in);

    private UserService userService = new UserService();

    /*
     * 展示登录注册的菜单
     */
    public int printMenu(){
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("请选择:");
        return sc.nextInt();
    }

    /*
     * 注册功能
     */
    public void regist() {
        System.out.println("请输入账号名:");
        String loginName = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        System.out.println("请确认密码:");
        String repassword = sc.next();
        //打包数据
        User user = new User(loginName,password);
        userService.regist(user,repassword);
    }

    /*
     * 登录功能
     */
    public boolean login() {
        System.out.println("请输入账号名:");
        String loginName = sc.next();
        System.out.println("请输入密码:");
        String password = sc.next();
        //打包数据
        User user = new User(loginName,password);
        return userService.login(user);
    }
}
