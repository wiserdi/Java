package net.wanhe.edusystem.system;

import net.wanhe.edusystem.controller.StuController;

/*
 * 描述学生系统
 */
public class StuSystem {

    private StuController stuController = new StuController();

    public void run() {
        boolean flag = true;
        while(flag){
            int chooise = stuController.printMenu();
            switch(chooise){
                case 1:
                    stuController.findAllStus();
                    break;
                case 2:
                    stuController.addStu();
                    break;
                case 3:
                    stuController.delStu();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }
    }
}
