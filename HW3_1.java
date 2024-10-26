
public class HW3_1 {

    private int numerator;
    private int denominator;

    public HW3_1(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("分母不能為0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private void normalize() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public boolean isWhole() {
        return denominator == 1;
    }

    public boolean isDecimal() {
        return denominator != 1;
    }

    public boolean equals(int numerator, int denominator) {
        HW3_1 r = new HW3_1(numerator, denominator);
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    public boolean equals(HW3_1 r) {
        return this.numerator == r.numerator && this.denominator == r.denominator;
    }

    public static HW3_1 parseRational(char[] numChars, char[] denomChars) {
        int num = Integer.parseInt(new String(numChars));
        int denom = Integer.parseInt(new String(denomChars));
        return new HW3_1(num, denom);
    }

    public static HW3_1 parseRational(String rationalStr) {
        String[] parts = rationalStr.split("/");
        int num = Integer.parseInt(parts[0]);
        int denom = Integer.parseInt(parts[1]);
        return new HW3_1(num, denom);
    }

    public static void main(String[] args) {
        HW3_1 r1 = new HW3_1(4, 8);
        System.out.println("分子: " + r1.getNumerator());
        System.out.println("分母: " + r1.getDenominator());

        System.out.println("是否為整數: " + r1.isWhole());

        HW3_1 r2 = HW3_1.parseRational(new char[]{'3'}, new char[]{'6'});
        System.out.println("r2 的分子: " + r2.getNumerator());
        System.out.println("r2 的分母: " + r2.getDenominator());

        HW3_1 r3 = HW3_1.parseRational("10/20");
        System.out.println("r3 的分子: " + r3.getNumerator());
        System.out.println("r3 的分母: " + r3.getDenominator());

    }
}
