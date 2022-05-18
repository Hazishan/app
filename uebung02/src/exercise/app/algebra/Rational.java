package src.exercise.app.algebra;

import java.util.Objects;

/**
 * Extends
 * {@link BasisFraction}
 *
 */

public class Rational extends BasisFraction {

    /**
     * nummerator
     */
    private long num;
    /**
     * denominator
     */
    private long denom;

    /** Standard Constructor
     */
    public Rational(){};

    /**
    /// parameterized Constructor
    needs
     {@link num} and
     {@link denom} to
    calculates the Greates common Divider --> {@link gcd}
    also sets format of Rational object
     */
    public Rational(long numerator, long denominator){
        setND(numerator, denominator);
    }

    @Override
    /**
    @see Rational
     */
    protected void setND(long numerator, long denominator) {
        long gcdDivider = gcd(numerator, denominator);
        num = numerator / gcdDivider;
        denom = denominator / gcdDivider;
        if (num < 0) {
            num = num * -1;
            denom = -denom;
        }
    }
    /**
    @return numerator
    */
    @Override
    public long getN() {
        return num;
    }
    /**
        @return Denominator
    */
    @Override
    public long getD() {
        return denom;
    }

    /**
    uses euclidean algorithm to get gcd
    {@link <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">Euclidean algorithm</a>}
     */
    private long gcd(long num1, long num2) {
        while (num2 != 0) {
            long temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    /**
    @return String
     */
    @Override
    public String toString() {
        if(getD()==1){return Integer.toString((int) getN());}
        return getN()+"/"+getD();
    }
    /**
    creates new Rational Object
    new Rational Object is "turned around"
     */
    @Override
    public Fractional reciprocal() {
        return new Rational(denom, num);
    }
    /**
    creates new Rational Object
    new Rational Object is negated
     */
    @Override
    public Fractional negation() {
        return new Rational(-num,denom);
    }
    /**
    clones Rational Object
     */
    @Override
    public Rational clone(){
        return new Rational(num,denom);
    }
    /**
    Tests object on equality
     */
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



