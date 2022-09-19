package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.Student;
import net.wanhe.edusystem.pojo.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 模拟数据管理员
 * 管理数据
 */
public class StuDao {
//    static int index = 0;
//    private static Student[] stus = new Student[2];
    private static ArrayList<Student> stus = new ArrayList<Student>();

    /**
     * 根据学号获得对应学生信息
     */
    public Student findByNum(int num) {
        for (int i = 0; i < stus.size(); i++) {
            if (stus.get(i).getNum() == num) {
                return stus.get(i);
            }
        }
        return null;
    }

    /**
     * 添加学生
     */
    public void addStu(Student stu) {
        stus.add(stu);
        //当存放的数据和数组的容量相同时 进行扩容 的操作
//        if (stus.size() == stus.length) {
////            //创建一个新的数组
////            Student[] newArray = new Student[stus.length+2];
////            //将旧数组stus中的数据存放到新数组newArray中
////            for (int i = 0;i < stus.length;i++){
////                newArray[i] = stus[i];
////            }
////            //将新数组的地址赋给 stus
////            stus = newArray;
////            System.err.println("扩容成功");
//            stus = Arrays.copyOf(stus, stus.length + 5);
//        }
//        //将对象存进数组
//        stus[index++] = stu;
    }

    /**
     * 删除学生
     */
    public void delStu(int num) {
        //找到需要删除的下标
        for (int i = 0; i < stus.size(); i++) {
            if (stus.get(i).getNum() == num) {
                stus.remove(i);
            }
        }
    }

    /**
     * 查询所有学生的信息
     */
    public Student[] findAllStus() {
        Student[] objects = new Student[stus.size()];
        for (int i = 0;i<stus.size();i++){
            objects[i] =stus.get(i);
        }
        return objects;
    }

    /*
    修改学生信息
     */
    public void update(Student stu){
        for (int i = 0;i<stus.size();i++){
            if (stus.get(i).getNum() == stu.getNum()){
                stus.set(i,stu);
            }
        }
    }
}
