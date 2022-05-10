package uebung02.algebra;

public abstract class BasisFraction implements Fractional {

    /// sets numerator and dominator: n/d
    protected abstract void setND(long numerator, long denominator);


    @Override
    public void add(Fractional operand) {
        setND(this.getN()* operand.getD()+ operand.getN()*this.getD(),
                this.getD()*operand.getD());
    }

    @Override
    public void sub(Fractional operand) {
        this.add(operand.negation());
    }

    @Override
    public void mul(Fractional operand) {
        setND(this.getN()* operand.getN(),this.getD()*operand.getD());
    }

    @Override
    public void div(Fractional operand) {
        operand = operand.reciprocal();
        this.mul(operand);
    }
    public abstract Fractional negation();

    public abstract Fractional reciprocal();

}
