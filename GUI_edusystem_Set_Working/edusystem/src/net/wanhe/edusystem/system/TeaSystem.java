package net.wanhe.edusystem.system;

import net.wanhe.edusystem.controller.TeaController;

public class TeaSystem {

//    static Teacher[] teas = new Teacher[20];
//    Scanner sc = new Scanner(System.in);
    private TeaController controller = new TeaController();

    //运行教师管理系统
    public void run(){
        boolean flag = true;
        while (flag){
            int choice = controller.printMenu();
            switch (choice){
                case 1://查询信息
                    controller.showTeas();
                    break;
                case 2://添加信息
                    controller.addTeas();
                    break;
                case 3://删除信息
                    controller.delTeas();
                    break;
                case 4://返回上级
                    flag = false;
                    break;
                default://提示出错
                    System.out.println("请输入正确的代码");
                    break;
            }
        }
    }
}
