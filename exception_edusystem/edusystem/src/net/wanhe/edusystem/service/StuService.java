package net.wanhe.edusystem.service;

import net.wanhe.edusystem.dao.StuDao;
import net.wanhe.edusystem.pojo.Student;

/**
 * 模拟业务员
 * 处理业务逻辑
 */
public class StuService {

    private StuDao stuDao = new StuDao();

    /*
     * 处理添加学生的业务逻辑
     */
    public void addStu(Student stu){
        //将学号给dao 获取该学号对应的信息
        Student s = stuDao.findByNum(stu.getNum());
        if(s != null){
            System.out.println("该学号以使用");
            return;
        }
        stuDao.addStu(stu);
        System.out.println("添加成功");
    }


    /*
     * 处理删除学生的业务逻辑
     */
    public void delStu(int num) {
        stuDao.delStu(num);
        System.out.println("删除成功");
    }

    /*
     * 查询所有的学生信息
     */
    public Student[] findAllStus() {
        Student[] stus = stuDao.findAllStus();
        return stus;
    }
}
