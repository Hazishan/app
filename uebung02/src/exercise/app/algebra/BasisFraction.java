package src.exercise.app.algebra;

/**
 * Implements Fractional, abstract class
 * @see Rational for extention
 */


public abstract class BasisFraction implements Fractional {

    /// sets numerator and dominator: n/d
    protected abstract void setND(long numerator, long denominator);


    /**
    Adds two uebung02.src.algebra_unbuilt.Fractional values --> pattern:
    pattern: a/b + c/d = a*d+b*c / b*d
     */
    public void add(Fractional operand) {
        setND(this.getN()* operand.getD()+ operand.getN()*this.getD(),
                this.getD()*operand.getD());
    }
    /**
    Subtracts two uebung02.src.algebra_unbuilt.Fractional values --> pattern:
    uses @see negation and @see add
     */
    @Override
    public void sub(Fractional operand) {
        this.add(operand.negation());
    }

        /**
    Multiplies two Fractions
    pattern: a/b * c/d --> a*c / b*d
     */
    @Override
    public void mul(Fractional operand) {
        setND(this.getN()* operand.getN(),this.getD()*operand.getD());
    }
    /**
    Divides two Fractions
    uses @see reciprocal and @see mul
     */
    @Override
    public void div(Fractional operand) {
        operand = operand.reciprocal();
        this.mul(operand);
    }
    public abstract Fractional negation();

    public abstract Fractional reciprocal();

}
