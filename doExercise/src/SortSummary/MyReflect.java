package SortSummary;


import java.lang.reflect.Field;

class Cat{
    public String name;
    int age;
    String color;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void doSome(){
        System.out.println(this.name+"正在叫~");
    }
}
public class MyReflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //1.通过字符串来获取类对象
        Class catClass = Class.forName("SortSummary.Cat");

        //2.通过实例来获取，实例的getclass方法
        Cat cat = new Cat("小黑");
        Class catClass2 = cat.getClass();

        //3.通过类名来获取
        Class catClass3 = Cat.class;
//        System.out.println(catClass == catClass2);
//        System.out.println(catClass == catClass3);


        System.out.println(catClass.toString());
        System.out.println(catClass.getName());
        System.out.println(catClass.getFields()[0]);
    }
}
