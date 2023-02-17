// StringLib.java

import java.util.ArrayList;
import java.util.HashMap;

class CharStack {

    private ArrayList<Character> stack = null;

    public CharStack() {
        this.stack = new ArrayList<Character>();
    }

    public Character push(Character c) {
        this.stack.add(c);
        return c;
    }

    public Character peek() {
        int end_index = stack.size() - 1;

        if (end_index < 0) return null;
        
        Character c = this.stack.get(end_index);
        return c;
    }

    public Character pop() {
        int end_index = stack.size() - 1;
        Character c = this.stack.get(end_index);
        this.stack.remove(end_index);
        return c;
    }
        
}


class StringLib {

    public StringLib() {
        this.r2lHm = new HashMap<Character, Character>();

        this.r2lHm.put(')', '(');
        this.r2lHm.put(']', '[');
        this.r2lHm.put('}', '{');

    }

    String	lBracks = "([{";
    String	rBracks = ")]}";
    HashMap<Character, Character> r2lHm = null;

    CharStack cStack = new CharStack();

    Boolean matchedBrackets(String s) {

        int index = 0;

        while (index < s.length()) {

            char c = s.charAt(index);

            if (lBracks.indexOf(c) >= 0) {
                cStack.push(c);
            }
            else if (rBracks.indexOf(c) >= 0) {
                char lc = this.r2lHm.get(c);

                if (cStack.peek() == null) return false;

                if (cStack.peek() == lc) {
                    cStack.pop();
                }

                else return false;
            }

            index++;
        }

        return (cStack.peek() == null);

    }

    ////////////////////////////////

    Boolean isPalindrome(String s) {
        int index = 0;
        int findex = s.length() - 1;

        System.out.format("Final index of %s is %d\n", s, findex);

        while (index < findex) {
            if (s.charAt(index) != s.charAt(findex))
                return false;
            else { index++; findex--; }
        }

        return true;
    }

    private void handleArgs(String[] args) {

        String funct = (args[0]).toLowerCase();

        switch (funct) {

            case "ispalindrome":
                if (args.length != 2) {
                    System.err.format("%s requires a second argument.\n",
                                      args[0]);
                    System.exit(2);
                }
                else {
                    String arg = args[1];
                    Boolean ip = isPalindrome(arg);
                    System.out.format("%s: %s a palindrome.\n", arg,
                                  (ip ? "is" : "is not") );
                }
                break;

            case "matchedbrackets":
                if (args.length != 2) {
                    System.err.format("%s requires a second argument.\n",
                                      args[0]);
                    System.exit(2);
                }
                else {
                    String arg = args[1];
                    Boolean mb = matchedBrackets(arg);
                    System.out.format("%s: %s have matched brackets.\n", arg,
                                  (mb ? "does" : "does not") );

                }

                break;

            default:
                break;
        }

    }

    ///////////////////////////////////////////////

    public static void main( String[] args ) {

        System.out.println("Size of args list is " + args.length + "\n" );

        if (args.length < 1) {
            System.err.println("Requires at least one argument.\n");
            System.exit(1);
        }

        StringLib s = new StringLib();

        s.handleArgs(args);

    }
}
