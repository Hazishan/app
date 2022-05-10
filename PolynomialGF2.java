public class PolynomialGF2 {

    final boolean[] ZERO = null;
    final boolean[] ONE = {true};
    private int n;
    private boolean[] gf2 = new boolean[n];


    public PolynomialGF2() {
        gf2 = ONE;
    }

    public PolynomialGF2(boolean[] bitVal){
        gf2 = trim(bitVal);
    }

    public PolynomialGF2(int intInput){
        gf2 = intBool(intInput);
    }

    public boolean[] toArray(){
        return gf2;
    }

    private boolean[] trim(boolean[] bitVal){
        if(bitVal.length==1 & !bitVal[0]){return ZERO;}
        if(!bitVal[0]){
            boolean[] returnBitVal = new boolean[bitVal.length-1];
            for( int i =1; i < bitVal.length;i++){
                returnBitVal[i-1] = bitVal[i];
            }

            return trim(returnBitVal);
        }

        else {return bitVal;}
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

    public PolynomialGF2 mod(PolynomialGF2 input){
        int solution = this.hashCode()%input.hashCode();
        return new PolynomialGF2(intBool(solution));
    }

    public String toString(){
        String[] keys = {"1","x","x^2","x^3","x^4"};
        String poly = "";
        int runner = 0;
        for(int i =gf2.length-1;i>=0;i--){
            if(gf2[i]){
                poly+= " + " + keys[runner];

            }
            runner+=1;
        }
        return poly;
    }

    private boolean[] intBool(int input){

        String inputBinary = Integer.toBinaryString(input);

        boolean[] returnbool = new boolean[inputBinary.length()];
        for(int i =0;i<=inputBinary.length()-1;i++){
            if(inputBinary.charAt(i) == '1'){returnbool[i] = true;}


        }

        return returnbool;


    }

    @Override
    protected Object clone() {
        boolean[] gf2_copy = new boolean[gf2.length];
        for (int i =0; i<= gf2.length-1;i++){
            gf2_copy[i] = gf2[i];
        }
        return gf2_copy;
    }

    private String getBinaryString(){
        String h = "";
        for (int i = 0; i<= gf2.length-1;i++) {
            if(gf2[i]){h+=1;}
            else h+=0;
        }
        return h;
    }



    @Override
    public int hashCode() {
        String binaryString = getBinaryString();
        int intval = Integer.parseInt(binaryString,2);
        return intval;
    }

    public static void main(String[] args) {
        PolynomialGF2 poly_mod = new PolynomialGF2(new boolean[] {true,false,true,true});
        PolynomialGF2 base = new PolynomialGF2(2);

        System.out.println(Math.pow(2,3)%(Math.pow(2,3)+2+1));


        for(int i=1;i<=8;i++){
            PolynomialGF2 tmp = new PolynomialGF2((int) Math.pow(i,3));
            System.out.println(tmp.hashCode());
            PolynomialGF2 tmp_calc = tmp.mod(poly_mod);

            System.out.println(i-1 + "\t" + tmp_calc.hashCode()+ "\t"+tmp_calc.toString());

        }

    }
}