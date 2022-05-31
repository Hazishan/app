package src.exercise.app.algebra;

import src.exercise.app.algebra.Rational;

/***
 * extends Rational
 * Important when retionals are compared --> correct output
 */
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
                Y = this.getN() * ((Rational) o).getD() - this.getD() * ((Rational) o).getN();
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