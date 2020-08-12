package com.xx.designpattern.CreativePattern.Prototype;

import java.io.*;

/**
 * 原型模式
 * 浅拷贝：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 * 深拷贝：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 *
 * @author xiaoxinga
 * @date 2020/06/05 14:40
 * @since
 */
public class Man implements Cloneable, Serializable {
    private String name;
    private int age;
    private Man friend;

    public Man() {
    }

    public Man(String name, int age, Man man) {
        this.name = name;
        this.age = age;
        this.friend = man;
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

    public Man getFriend() {
        return friend;
    }

    public void setFriend(Man friend) {
        this.friend = friend;
    }


    // 浅拷贝
    public Man clone() {
        Man proto = null;
        try {
            proto = (Man) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return proto;
    }

    // 深拷贝
    public Man deepClone() throws IOException, ClassNotFoundException {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Man) ois.readObject();
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friend=" + friend +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Man man = new Man();
        man.setName("Bob");
        man.setAge(15);
        Man friend = new Man("Jeck", 12, null);
        man.setFriend(friend);
        Man manClone = man.clone();
        Man manDeepClone = man.deepClone();
        System.out.println("manClone:" + manClone.toString());
        System.out.println("manDeepClone:" + manDeepClone.toString());
        man.setName("Lily");
        man.setAge(18);
        friend.setName("Jack");
        System.out.println("manClone:" + manClone.toString());
        System.out.println("manDeepClone:" + manDeepClone.toString());
    }
}
