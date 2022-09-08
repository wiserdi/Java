package edusystem.src.net.wanhe.edusystem.dao;

import edusystem.src.net.wanhe.edusystem.pojo.Student;

/**
 * 模拟数据管理员
 * 管理数据
 */
public class StuDao {

    static Student[] stus = new Student[20];

    /*
     * 根据学号获取对应的学生信息
     */
    public Student findByNum(int num){
        return stus[num - 1];

    }

    /*
     * 添加学生
     */
    public void addStu(int num, Student stu) {
        stus[num - 1] = stu;
    }

    /*
     * 删除学生
     */
    public void delStu(int num) {
        stus[num - 1] = null;
    }

    /*
     * 查询所有的学生信息
     */
    public Student[] findAllStus() {
        return stus;
    }
}
