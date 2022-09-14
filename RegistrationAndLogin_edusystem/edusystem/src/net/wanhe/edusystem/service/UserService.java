package net.wanhe.edusystem.service;

import net.wanhe.edusystem.dao.UserDao;
import net.wanhe.edusystem.pojo.User;

public class UserService {

    private UserDao userDao = new UserDao();

    /*
     * 注册功能
     */
    public void regist(User user, String repassword) {
        if(!user.getPassword().equals(repassword)){
            System.out.println("两次密码不一致");
            return;
        }
        User u = userDao.findByLoginName(user.getLoginName());
        if(u != null){
            System.out.println("该账号已注册，请登录");
            return;
        }
        userDao.insert(user);
        System.out.println("注册成功");
    }

    /*
     * 登录功能
     */
    public boolean login(User user) {
        User u = userDao.findByLoginName(user.getLoginName());
        if(u == null){
            System.out.println("该账号不存在，请注册");
            return false;
        }
        if(!user.getPassword().equals(u.getPassword())){
            System.out.println("密码错误");
            return false;
        }
        return true;
    }
}
