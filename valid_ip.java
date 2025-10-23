import java.util.StringTokenizer;

class GfG {

    static boolean isValid(String s){
        int n = s.length();

        if (n < 7)
            return false;

        // Using StringTokenizer to 
        // separate all the strings
        // from '.' and push back into
        // vector like for example -
        StringTokenizer st = new StringTokenizer(s, ".");
        int count = 0;
        while (st.hasMoreTokens()) {
            String substr = st.nextToken();
            count++;

            // If the substring size 
            // is greater than 1 and
            // the first character is
            // '0', return false
            if (substr.length() > 1
                && substr.charAt(0) == '0')
                return false;

            for (int j = 0; j < substr.length(); j++) {
                if (!Character.isDigit(substr.charAt(j)))
                    return false;
            }

            // Check if the number is greater than 255
            if (Integer.parseInt(substr) > 255)
                return false;
        }

        if (count != 4)
            return false;

        return true;
    }

    public static void main(String[] args){
        String s = "128.0.0.1";

        System.out.println(isValid(s) ? "true": "false");
    }
}
