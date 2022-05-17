package src.exercise.app.algebra;

/**
 * Interface for simple arithmetic operations
 */
public interface Fractional {
    /**
     * get numerator
      */
    long getN();
    /**
     * get denominator
     */
    long getD();
    /**
     * add object by operand
     */
    void add(Fractional operand);
    /**
     * subtract object by operand
     */
    void sub(Fractional operand);
    /**
     * multiply object by operand
     */
    void mul(Fractional operand);
    /**
     * divide object by operand
     */
    void div(Fractional operand);
    /**
     * new additive inverse object
     */
    Fractional negation ();
    /**
     * new multiplicative inverse object
     */
    Fractional reciprocal ();
}
