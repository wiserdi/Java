package net.wanhe.edusystem.service;

import net.wanhe.edusystem.dao.UserDao;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.User;

import java.util.Scanner;

public class UserService {

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
    private Scanner sc = new Scanner(System.in);
    private UserDao userDao = new UserDao();


    public void userLogin(User user) throws UserException {
        //处理业务逻辑
        //1.判断账号是否正确
        //将账号给Dao 获取该账号的信息
        User u = userDao.findByLoinName(user.getLoginName());
        if (u == null){
            throw new UserException("账号不存在，请先创建账号");
        }
        //2.判断密码是否一致
        String secret = user.getPassword();
        if ( !secret.equals(u.getPassword())){
            throw new UserException("登录失败");
        }
    }

    public void userRegister(User user,   String secret_2) throws UserException{
        //处理业务逻辑
        //1.判断账号是否已被使用
        User u = userDao.findByLoinName(user.getLoginName());
        if (user.getLoginName() == null){
            throw new UserException("请输入账号");
        }
        if (u != null){
            throw new UserException("该账号已被使用");
        }

//        //2.判断密码是否符合要求
//        if (user.getPassword().length() < 8){
//            throw new UserException("创建失败,密码长度必须大于8");
//        }

        //3.重复输入密码判断密码是否一致
        if (!user.getPassword().equals(secret_2)){
            throw new UserException("密码不一致,请重新创建");
        }

        //4.添加账号信息给 Dao
        userDao.insertuser(user);

    }
}
