package src.exercise.app.algebra;

import src.exercise.app.algebra.Rational;

public class CompRational extends Rational implements Comparable<CompRational> {
    /***
     *
     * @param num
     * @param denum
     */
    public CompRational(long num, long denum) {
        super(num, denum);
    }


    /***
     *
     * @param o object of any Type
     * @return =0 means same, -1 = smaller, 1 = larger
     */
    @Override
    public int compareTo(CompRational o) {
        try {
            if (o != null) {
                /***
                 * because both numbers are devided by their gdc,
                 * we can compare ad-bc
                 */
                long Y;
                Rational otherO = (Rational) o;
                Y = this.getN() * otherO.getD() - this.getD() * otherO.getN();
                if (Y > 1) {
                    return 1;
                } else if (Y == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(o == null){
            throw new IllegalArgumentException("Objects are incomparable");
        }
        return -2;
    }
}