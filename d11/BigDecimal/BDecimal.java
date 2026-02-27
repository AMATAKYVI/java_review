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

        double value = 2.2302032030;
        BigDecimal scaledValue = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(scaledValue);

        BigDecimal policyPayout = new BigDecimal("1_000_000");
        System.out.println();
    }
}
