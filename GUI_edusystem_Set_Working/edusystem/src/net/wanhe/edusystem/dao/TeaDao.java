package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.Student;
import net.wanhe.edusystem.pojo.Teacher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TeaDao {

//    private static Teacher[] teas = new Teacher[2];
//    static int index = 0;
    //static 是为了保证，每次执行该类，有且仅有一个数组
    private static ArrayList<Teacher> teas = new ArrayList<Teacher>();

    //根据工号获得对应信息
    public Teacher findByNum(int num){
        for (int i = 0;i< teas.size();i++){
            if(num == teas.get(i).getNum()){
                return teas.get(i);
            }
        }
        return null;
    }

    //添加老师
    public void addTea(Teacher tea){
        //当存放的数据数量和数组下标index一样是，需要对数组进行扩容
//        if (index == teas.length){
////            //创建一个新的数组
////            Teacher[] newArray = new Teacher[teas.length+2];
////            //将旧数组teas的值放到新数组去
////            for (int i = 0;i<index;i++){
////                newArray[i] =teas[i];
////            }
////            //将新数组地址赋值给teas
////            teas = newArray;
////            System.err.println("扩容成功");
//            teas = Arrays.copyOf(teas,teas.length+5);
//        }
//        teas[index++] = tea;
        teas.add(tea);
    }

    //删除老师
    public void delTea(int num){
        //找到需要删除的下标
        for (int i = 0; i <teas.size() ; i++){
            if (num == teas.get(i).getNum()){
                teas.remove(i);
            }
        }
    }

    // 查询所有学生的信息
    public Teacher[] findAllTeas(){
        Teacher[] objects = new Teacher[teas.size()] ;
        for (int i = 0 ; i< teas.size();i++){
            objects[i] = teas.get(i);
        }
        return objects;
    }

    public void update(Teacher tea){
        for (int i = 0; i < teas.size(); i++) {
            if (teas.get(i).getNum() == tea.getNum()){
                teas.set(i,tea);
            }
        }
    }

}
