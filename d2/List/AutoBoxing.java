package d2.List;

public class AutoBoxing {

    public static void main(String[] args) {
        int a = 1;
        Integer b = a;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("Type of a: " + Integer.valueOf(a).getClass().getSimpleName());
        System.out.println("Type of b: " + b.getClass().getSimpleName());

    }
}
