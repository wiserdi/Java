package edusystem.src.net.wanhe.edusystem.pojo;

/**
 * 用于描述学生对象
 * 实体类
 */
public class Student {

    public String name;

    public int age;

    public String phone;

    public String address;

    public Student() {
    }

    public Student(String name, int age, String phone, String address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }
}
