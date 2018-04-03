package preparation.chapter7;

public class Ex13 {
    public static void main(String[] args) {
        String s = "nt-quang";
        String t = "sieu kaka nt-quang";
        System.out.println(findFirst(t,s));
    }

    public static int findFirst(String t, String s){
        if(s.length() > t.length()) return -1;// s can not be a substring of t
        long base = 26; // because we have 26 characters in alphabet. This base is similar to decimal base
        long powerS = 1; // we use it to exclude the first character in each substring.
        // Hash numbers. How to represent hash number:
        // if one string is {A, B, C}
        // => hash = base ^ 2 * code of `A` + base ^ 1 * code of `B` + base ^ 0 * code of `C`
        long thash = 0; // hash number for a substring of t.
        long shash = 0; // hash number for s.
        for(int i=0; i<s.length(); i++){
            powerS = i > 0 ? base * powerS : 1;
            thash = thash * base + t.charAt(i);
            shash = shash * base + s.charAt(i);
        }
        // Compare thash to shash.
        // Walking through each character in t.
        // Initial step with i = s.length()
        // In each step, if we have thash equal to shash,
        // we should check next condition (t.substring(i-s.length(), i) equal to s)
        // if yes, return i
        // otherwise, keep moving on.
        for(int i=s.length(); i<t.length(); i++){
            if(thash == shash && t.substring(i-s.length(), i).equals(s)){
                return i-s.length();
            } else {
                // re-calculate thash
                thash -= powerS * t.charAt(i - s.length()); // exclude the first character
                thash = thash * base + t.charAt(i); // append next character
            }
        }

        // Check the last substring of t
        if(thash == shash && t.substring(t.length() - s.length()).equals(s)){
            return t.length() - s.length();
        }
        return -1;

    }
}
