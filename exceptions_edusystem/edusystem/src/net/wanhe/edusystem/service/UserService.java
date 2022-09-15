package net.wanhe.edusystem.service;

import net.wanhe.edusystem.dao.UserDao;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.User;

public class UserService {

    private UserDao userDao = new UserDao();

    /*
     * 注册功能
     */
    public void regist(User user, String repassword) throws UserException{
        if(!user.getPassword().equals(repassword)){
            throw new UserException("两次密码不一致");
        }
        User u = userDao.findByLoginName(user.getLoginName());
        if(u != null){
            throw new UserException("该账号已注册，请登录");
        }
        userDao.insert(user);
    }

    /*
     * 登录功能
     */
    public void login(User user) throws UserException {
        User u = userDao.findByLoginName(user.getLoginName());
        if(u == null){
            throw new UserException("该账号不存在，请注册");
        }
        if(!user.getPassword().equals(u.getPassword())){
            throw new UserException("密码错误");
        }
    }
}
