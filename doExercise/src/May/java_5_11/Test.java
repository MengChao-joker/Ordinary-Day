package java_5_11;


import com.sun.javafx.runtime.eula.Eula;

enum DemoEnum{

    MBY,
    ZJL,
    XS,

}
public class Test {
    public static void main(String[] args) {
        DemoEnum[] demoEnum = DemoEnum.values();
        for(Enum e:demoEnum){
            System.out.println(e);
        }

    }

 /*   //stackOverFlowError
    private static void doSome() {
        doSome();
    }
    public static void main(String[] args) {
        doSome();
    }
    */
}
