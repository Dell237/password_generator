
public class Generator {
    Alphabet alphabet;
    boolean includeUpper;
    boolean includeLower ;
    boolean includeNum  ;
    boolean includeSym ;

    public Generator( Boolean includeUpper, Boolean includeLower, Boolean includeNum, Boolean includeSym) {
        this.includeUpper = includeUpper;
        this.includeLower = includeLower;
        this.includeNum = includeNum;
        this.includeSym = includeSym;
        alphabet = new Alphabet(includeUpper, includeLower ,includeNum ,includeSym);
    }

    public Password generatePassword (int length){
        final StringBuilder pw = new StringBuilder("");

        final  int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min  + 1;

        for (int i = 0; i < length; i++) {
            int index =(int) (Math.random() * range) + min;
            pw.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pw.toString());
    }


//    private void printUsefulInfo() {
//        System.out.println();
//        System.out.println("Use a minimum password length of 8 or more characters if permitted");
//        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
//        System.out.println("Generate passwords randomly where feasible");
//        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
//        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
//                "\nusernames, relative or pet names, romantic links (current or past) " +
//                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
//        System.out.println("Avoid using information that the user's colleagues and/or " +
//                "acquaintances might know to be associated with the user");
//        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
//    }


}
