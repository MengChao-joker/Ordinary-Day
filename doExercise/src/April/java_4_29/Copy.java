package java_4_29;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Copy {

    public static class Singer implements Cloneable {
        private String name;
        private int age;

        public Singer(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

//        protected Object deepClone() throws CloneNotSupportedException {
//            Singer s =(Singer)super.clone();
//            s.setAge(s.getAge());
//            s.setName(s.getName());
//            return super.clone();
//        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Singer singer = new Singer("毛毛",26);
        Singer singer1 = (Singer) singer.clone();
        singer.setAge(28);
        singer.setName("jmc");
        singer1.setName("maobuyi");
        System.out.println(singer1.getAge());
        System.out.println(singer1.getName());
        System.out.println(singer.getName());
        System.out.println(singer.getAge());
        List<Integer> list = new ArrayList<>();
        Collections.shuffle(list);

    }

    public static void main1(String[] args) throws CloneNotSupportedException {

        //浅拷贝
        Singer singer = new Singer("毛毛",26);
        Singer singer1 = (Singer) singer.clone();
        singer.setAge(28);
        singer.setName("jmc");
        singer1.setName("maobuyi");
        System.out.println(singer1.getAge());
        System.out.println(singer1.getName());
        System.out.println(singer.getName());

//        //深拷贝
//        Singer singer2 = (Singer) singer.deepClone();
//        singer.setAge(28);
//        System.out.println(singer2.getAge());


    }
}
