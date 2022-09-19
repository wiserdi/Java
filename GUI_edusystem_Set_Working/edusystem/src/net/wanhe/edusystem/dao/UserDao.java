package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.User;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDao {

//    static int index = 0;
//
//    private static User[] users = new User[20];

    private static ArrayList<User> users = new ArrayList<User>();

    //通过输入的账号寻找对应的账号密码
    public User findByLoinName(String num){
        for (int i = 0 ;i<users.size();i++){
            if (num.equals(users.get(i).getLoginName())){
                return users.get(i);
            }
        }
        return null;
    }

    public void insertuser(User user){
        users.add(user);
        //如果存放数据数量等于数组容量 进行扩容操作
//        if (users.size() ==users.length){
////            //定义一个新的数组
////            User[] newArray = new User[users.length+2];
////            //通过循环存放转移数组里的对象
////            for (int i = 0; i< users.length;i++){
////                newArray[i] = users[i];
////            }
////            //将新数组的地址赋给旧数组
////            users = newArray;
////            System.out.println("扩容成功");
//            users = Arrays.copyOf(users,users.length+5);
//        }
//
//        //将对象user存放到数组中
//        users[index++] = user;
    }

}
