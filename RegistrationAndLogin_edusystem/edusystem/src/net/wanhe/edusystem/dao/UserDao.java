package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.User;

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
            User[] newArray = new User[users.length + 5];
            for(int i = 0;i < users.length;i++){
                newArray[i] = users[i];
            }
            users = newArray;
        }
        users[index++] = user;
    }
}
