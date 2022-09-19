package net.wanhe.edusystem.controller;

import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.User;
import net.wanhe.edusystem.service.UserService;

import java.util.Scanner;

public class UserController {
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

    private UserService userService = new UserService();

    private Scanner sc = new Scanner(System.in);

    //打印登录注册界面
    public int printMenu(){
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("请选择：");
        return sc.nextInt();
    }


    //登录功能
    public boolean userLogin(){
        System.out.println("请输入账户：");
        String LoginName = sc.next();
        //userService.numJudge(num);
        System.out.println("请输入密码");
        String password = sc.next();
        //userService.secJudge(secret);

        //将获取到的数据封装成对象
        User userlogin = new User(LoginName,password);
        try{
            userService.userLogin(userlogin);
            System.out.println("登陆成功");
            return false;
        }catch (UserException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    //注册功能
    public void userRegister(){
        System.out.println("请输入账户");
        String loginName = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        System.out.println("请再次输入密码");
        String repassword = sc.next();

        //将获取到的数据封装成对象
        User userregister = new User(loginName,password);
        try{
            userService.userRegister(userregister,repassword);
            System.out.println("注册成功");
        }catch (UserException e){
            //获取捕捉到的异常信息
            System.out.println(e.getMessage());
        }

    }


}
