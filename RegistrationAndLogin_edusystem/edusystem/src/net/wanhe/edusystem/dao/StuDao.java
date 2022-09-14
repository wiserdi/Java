package net.wanhe.edusystem.dao;

import net.wanhe.edusystem.pojo.Student;

/**
 * 模拟数据管理员
 * 管理数据
 */
public class StuDao {

    private static Student[] stus = new Student[2];

    //记录了即将添加的数据的下标
    //记录了当前数组中存放的有效数据的数量
    static int index = 0;

    /*
     * 根据学号获取对应的学生信息
     */
    public Student findByNum(int num){
        for(int i = 0;i < index;i++){
            if(stus[i].getNum() == num){
                return stus[i];
            }
        }
        return null;
    }

    /*
     * 添加学生
     * 动态数组
     */
    public void addStu(Student stu) {
        //当存放的数据和数组的容量相同时 进行 扩容 的操作
        if(index == stus.length){
            //创建一个新的数组
            Student[] newArray = new Student[stus.length + 2];
            //将旧数组stus中的数据存放到新数组newArray中
            for(int i = 0;i < stus.length;i++){
                newArray[i] = stus[i];
            }
            //将新数组的地址赋值给stus
            stus = newArray;
            System.err.println("测试代码 数组扩容");
        }
        stus[index++] = stu;
    }

    /*
     * 删除学生
     */
    public void delStu(int num) {
        //找到需要删除的下标
        for(int i = 0;i < index;i++){
            if(stus[i].getNum() == num){
                //当前i的值就是要删除的下标
                //从i的值开始后面的数据都要向前移动
                for(int j = i;j < index - 1;j++){
                    stus[j] = stus[j+1];
                }
                stus[index - 1] = null;
                index--;
            }
        }
    }

    /*
     * 查询所有的学生信息
     */
    public Student[] findAllStus() {
        return stus;
    }
}
