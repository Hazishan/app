package uebung02.algebra;

import java.util.Objects;

public class Rational extends BasisFraction{

    private long num;
    private long denom;

    public Rational(){};

    public Rational(long numerator, long denominator){
        long gcdDivider = gcd(numerator, denominator);
        num = numerator / gcdDivider;
        denom = denominator / gcdDivider;
        if (num < 0) {
            num = num * -1;
            denom = -denom;
        }
    }

    @Override
    protected void setND(long numerator, long denominator) {
        long gcdDivider = gcd(numerator, denominator);
        num = numerator / gcdDivider;
        denom = denominator / gcdDivider;
        if (num < 0) {
            num = num * -1;
            denom = -denom;
        }
    }

    @Override
    public long getN() {
        return num;
    }

    @Override
    public long getD() {
        return denom;
    }

    /// euclidean algorithm
    private long gcd(long num1, long num2) {
        while (num2 != 0) {
            long temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    @Override
    public String toString() {
        return getN()+"/"+getD();
    }

    @Override
    public Fractional reciprocal() {
        return new Rational(denom, num);
    }

    @Override
    public Fractional negation() {
        return new Rational(-num,denom);
    }

    @Override
    public Rational clone(){
        return new Rational(num,denom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return num == rational.num && denom == rational.denom;
    }


    @Override
    public int hashCode() {
        return Objects.hash(num, denom);
    }
}



