package net.wanhe.edusystem.service;


import net.wanhe.edusystem.dao.StuDao;
import net.wanhe.edusystem.exception.StuException;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.Student;

/**
 *
 * 模拟业务员
 * 处理业务逻辑
 */
public class StuService {

    private StuDao stuDao = new StuDao();

    /**
     * 处理添加学生的业务逻辑
     */
    public void addStu(Student stu) throws StuException {
        //保护系统学生数组不越界(处理业务逻辑)
//        if (num < 1 || num > 20){
//            System.out.println("请输入正确的学号(1~20)");
//            return;
//        }
        //1.将学号给Dao 获取该学号对应的信息
        Student s =stuDao.findByNum(stu.getNum());
        //2.判断学号是否已被使用
        if (s != null){
            throw new StuException("该学号已被使用");
        }
        //3.添加学生信息
        stuDao.addStu(stu);
    }


    /**
     * 处理删除学生的业务逻辑
     */
    public  void delStu(int num){
//        if (num < 1 || num > 20){
//            System.out.println("请输入正确的学号（1-20）");
//            return;
//        }
        //删除学生信息
        stuDao.delStu(num);
    }

    /**
     * 查询所有学生信息
     */
    public Student[] findAllStus(){
        Student[] stus = stuDao.findAllStus();
        return stus;
    }


    /*

    修改学生信息
     */
    public void update(Student stu){
        stuDao.update(stu);
    }

}
