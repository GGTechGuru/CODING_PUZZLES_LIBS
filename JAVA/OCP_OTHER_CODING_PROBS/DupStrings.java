import java.util.*;

// Find duplicated strings (words) in an array of words. Print the words that recur, as well as the total
// number of times a word recurs at least once.

class DupStrings {

    public static void dupInfo( String[] wl ) {

        HashMap<String, Integer> wordOccurs = new HashMap<String, Integer>();

        
        for (int index=0; index < wl.length; index++ ) {

            String thisWord = wl[index];

            if ( wordOccurs.containsKey( thisWord )) {

                int count = wordOccurs.get(thisWord);

                wordOccurs.put(thisWord, count + 1);
            }
            else {
                wordOccurs.put(thisWord, 1);
            }
        }


        int repeats = 0;

        for (String word: wordOccurs.keySet()) {

            int count = wordOccurs.get(word);

            if (count > 1) {

                System.out.format("%s : %d\n", word, count);

                repeats += 1;
            }
        }

        System.out.format( "Total words with 2+ occurences: %d\n", repeats );
         
    }

    //////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        String[] testWords1 = new String[]{ "delhi", "bombay", "delhi", "dodballapur", "bombay",
                                            "calcutta", "bombay"};

        DupStrings.dupInfo(testWords1);

    }
}
