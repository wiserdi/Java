package net.wanhe.edusystem.pojo;
/**
 * 用于描述学生对象
 * 实体类
 */
public class Student {
    private int num;
    private String name;
    private int age;
    private String phone;
    private String address;

    public Student() {
    }

    public Student(int num,String name, int age, String phone, String address) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
