package d11.BigDecimal;

import java.math.BigDecimal;

public class BDecimal {

    public static void main(String[] args) {

        // big decimal represents decimal numbers with arbitrary precision
        double[] arrayOfAny = {1.2232132132, 12.00000000001};

        //let convert to big decimal
        var bigDecimal = new BigDecimal(arrayOfAny[0]);
        System.out.println(bigDecimal.unscaledValue());
        System.out.println(bigDecimal.scale());

        System.out.println(BigDecimal.valueOf(arrayOfAny[1]).unscaledValue());
        System.out.println(BigDecimal.valueOf(arrayOfAny[1]).scale());
        // here the value has change 
    }
}
