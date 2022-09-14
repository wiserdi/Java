package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.User;

import java.util.Arrays;

public class UserDao {

    private static User[] users = new User[5];

    private static int index = 0;

    /*
     * 根据用户名获取用户信息
     */
    public User findByLoginName(String loginName){
        for(int i = 0;i < index;i++){
            if(users[i].getLoginName().equals(loginName)){
                return users[i];
            }
        }
        return null;
    }

    /*
     * 添加用户
     */
    public void insert(User user) {
        if(users.length == index){
            users = Arrays.copyOf(users,users.length + 5);
        }
        users[index++] = user;
    }
}
