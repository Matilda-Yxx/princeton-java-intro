public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int curMaxRepeats = 0;
        int curPos = 0;
        String codon;
        int curRepeats = 0;
        while (curPos < dna.length() - 2) {
            // scans for CAG. if caught, will scan for consecutive CAGs
            codon = dna.substring(curPos, curPos+3);
            if (codon.equals("CAG")) {
                curPos += 3;
                curRepeats ++;
                if(curRepeats > curMaxRepeats) curMaxRepeats = curRepeats;
            } else { 
                // if NOT caught, continue scanning
                curPos ++;
                curRepeats = 0;
            }
        }
        // System.out.println(curMaxRepeats);
        return curMaxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        return s.replace("\t", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) return "not human";
        else if (maxRepeats < 36) return "normal";
        else if (maxRepeats < 40) return "high risk";
        else if (maxRepeats < 181) return "Huntington’s";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String input = new In(args[0]).readAll();
        input = removeWhitespace(input);
        int count = maxRepeats(input);
        System.out.println("max repeats = " + count);
        System.out.println(diagnose(count));
    }
}