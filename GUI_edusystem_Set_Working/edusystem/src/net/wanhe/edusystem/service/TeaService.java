package net.wanhe.edusystem.service;

import net.wanhe.edusystem.dao.TeaDao;
import net.wanhe.edusystem.exception.TeaException;
import net.wanhe.edusystem.exception.UserException;
import net.wanhe.edusystem.pojo.Teacher;

public class TeaService {
    private TeaDao teaDao = new TeaDao();

    //处理添加教师的业务逻辑
    public void addTeas( Teacher tea)throws TeaException {

        //将工号给Dao,获取该学号对应的信息
        Teacher t = teaDao.findByNum(tea.getNum());
        if (t != null){
            throw new TeaException("该工号已被使用");
        }
        teaDao.addTea(tea);
    }

    //处理删除老师的业务逻辑
    public void delTeas(int num) {
        teaDao.delTea(num);
    }
    //查询所有老师信息
    public Teacher[] findAllTeas() {
        Teacher[] teas = teaDao.findAllTeas();
        return teas;
    }

    public void update(Teacher tea){
        teaDao.update(tea);
    }
}
