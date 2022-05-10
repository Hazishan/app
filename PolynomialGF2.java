import java.util.Arrays;

public class PolynomialGF2 {

    final boolean[] ZERO = null;
    final boolean[] ONE = {true};
    private int n;
    private boolean[] gf2 = new boolean[n];

    ///default constructor
    public PolynomialGF2() {
        gf2 = ONE;
    }
    ///constructor with boolean array, which gets trimmed
    public PolynomialGF2(boolean[] bitVal){
        gf2 = trim(bitVal);
    }
    ///support constructor --> int to boolean array
    public PolynomialGF2(int intInput){
        gf2 = intBool(intInput);
    }

    public String toArray(){
        return Arrays.toString(gf2);
    }



    public boolean isZero(){
        return gf2 == ZERO;
    }

    public boolean isOne(){
        return gf2 == ONE;
    }

    public PolynomialGF2 add(PolynomialGF2 input){
        int solution = this.hashCode()+input.hashCode();
        PolynomialGF2 tmp = new PolynomialGF2(intBool(solution));

        return tmp;
    }


    public PolynomialGF2 times(PolynomialGF2 input){
        int solution = this.hashCode()*input.hashCode();
        return new PolynomialGF2(intBool(solution));
    }

    //probably wrong but the modulo works :)
    public PolynomialGF2 mod(PolynomialGF2 input){
        int solution = this.hashCode()%input.hashCode();
        return new PolynomialGF2(intBool(solution));
    }

    /// bool to string (polynom style)
    public String toString(){
        String[] keys = {"1","x","x^2","x^3","x^4"};
        String poly = "";
        int runner = 0;         ///runner=0 means keys=1, runner=1 means keys=2 etc., keys safed in string
        for(int i =gf2.length-1;i>=0;i--){
            if(gf2[i]){
                poly+= " + " + keys[runner];

            }
            runner+=1;
        }
        return poly;
    }

    //boolean positions determine the factor of x, sum of factors = degree of polynom
    private int getdegree(){
        int accum = 0;
        for(int i =0; i<=gf2.length-1; i++){
            if(gf2[i]){accum+= gf2.length-i-1;}
        }
        return accum;
    }

    private boolean[] trim(boolean[] bitVal){
        if(bitVal.length==1 & !bitVal[0]){return ZERO;} ///in case of Zero bool
        if(!bitVal[0]){     ///if first bool is false, make new boolean array (len-1) and copy everything except first position
            boolean[] returnBitVal = new boolean[bitVal.length-1];
            for( int i =1; i < bitVal.length;i++){
                returnBitVal[i-1] = bitVal[i];
            }

            return trim(returnBitVal);      //recursion, try again till first bool != false
        }

        else {return bitVal;}
    }


    /// support method for int to bool translation
    private boolean[] intBool(int input){
        String inputBinary = Integer.toBinaryString(input);

        boolean[] returnbool = new boolean[inputBinary.length()];   //array where every element is false
        for(int i =0;i<=inputBinary.length()-1;i++){
            if(inputBinary.charAt(i) == '1'){returnbool[i] = true;}         ///if 1 --> true in array
        }
        return returnbool;
    }

    /// from boolean list to binary String
    private String getBinaryString(){
        String h = "";
        for (int i = 0; i<= gf2.length-1;i++) {
            if(gf2[i]){h+=1;}
            else h+=0;
        }
        return h;
    }


    public boolean equals(PolynomialGF2 o) {
        if (this == o) return true; ///if they are equal
        if (o == null || getClass() != o.getClass()) return false;  ///if one polynom=0 both have too
        return Arrays.equals(gf2, ((PolynomialGF2) o).gf2);
    }


    protected Object clone() {
        boolean[] gf2_copy = new boolean[gf2.length];
        for (int i =0; i<= gf2.length-1;i++){
            gf2_copy[i] = gf2[i];
        }
        return gf2_copy;
    }



    /// makes unique integer from Binary

    public int hashCode() {
        String binaryString = getBinaryString();
        return Integer.parseInt(binaryString,2);
    }

    public static void main(String[] args) {
        PolynomialGF2 poly_mod = new PolynomialGF2(new boolean[] {true,false,true,true});
        PolynomialGF2 base = new PolynomialGF2();
        PolynomialGF2 base2 = new PolynomialGF2(13);


        /// beim testen ist nets sinnvolles rausgekommen, mod funktioniert net wie gedacht ):

        for(int i = 0; i<7; i++){
            PolynomialGF2 poly = base.mod(poly_mod);
            System.out.println(Integer.toString(i)+" |    "+poly.hashCode()+" | "+poly.toString());

        }
    }
}