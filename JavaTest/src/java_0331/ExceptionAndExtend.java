package java_0331;

public class ExceptionAndExtend {
    public static void main(String[] args) {
        B b = new B();
        int num = b.getValue();
        System.out.println(num);
    }

    static class A {
        protected int valueA;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.valueA = value;
        }

        public int getValue() {
            try {
                valueA++;
                return valueA;
            } finally {
                this.setValue(valueA);
                System.out.println(valueA);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}

