class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public void printRational() {
        System.out.println(this.numerator + "/" + this.denominator);
    }
    public String toString() {
        return numerator + "/" + denominator;
    }

    public void negate() {
        this.numerator = -this.numerator;
    }
    public void invert() {
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
    }
    public double toDouble() {
        return (double) numerator / denominator;
    }
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public void reduce() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
    }
    public Rational add(Rational other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        Rational result = new Rational(newNumerator, newDenominator);
        result.reduce();
        return result;
    }
}

public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
        this.year = 2024;
        this.month = 4;
        this.day = 13;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static void main(String[] args) {
        Date birthday = new Date(1986, 9, 18);
        System.out.println("Birthdate: " + birthday.getMonth() + "/" + birthday.getDay() + "/" + birthday.getYear());

        Rational rationalNumber = new Rational(2, 3);
        System.out.print("Rational number: ");
        rationalNumber.printRational();


        System.out.println("Rational number (toString): " + rationalNumber.toString());

        rationalNumber.negate();
        System.out.print("Negated rational number: ");
        rationalNumber.printRational();

        rationalNumber.invert();
        System.out.print("Inverted rational number: ");
        rationalNumber.printRational();

        System.out.println("Rational number as double: " + rationalNumber.toDouble());

        Rational fractionToReduce = new Rational(6, 8);
        System.out.print("Fraction before reduction: ");
        fractionToReduce.printRational();
        fractionToReduce.reduce();
        System.out.print("Fraction after reduction: ");
        fractionToReduce.printRational();

        Rational rational1 = new Rational(1, 3);
        Rational rational2 = new Rational(1, 2);
        Rational sum = rational1.add(rational2);
        System.out.print("Sum of fractions: ");
        sum.printRational();
    }
}