// Find duplicated strings (words) in an array of words. Print the words that recur, as well as the total
// number of times a word recurs at least once.

class DupStrings {

    static dupInfo( wl ) {

        const wordOccurs = new Map();
        const wordSet = new Set();

        for (let index=0; index < wl.length; index++ ) {

            var thisWord = wl[index];

            if (wordOccurs[thisWord] != undefined) {

                var wcount = wordOccurs[thisWord];

                wordOccurs[thisWord] = (wcount + 1);
            }
            else {
                wordOccurs[thisWord] = 1;
            }

            wordSet.add(thisWord);
        }
        const wordAry = Array.from(wordSet);

        var repeats = 0;
        for (let index=0; index < wordAry.length; index++ ) {

            var word = wordAry[index];
            var occurs = wordOccurs[word];
            if (occurs > 1) {
                console.log(word);
                repeats += 1;
            }
        }
        console.log("Total words with 2+ occurences:" + repeats);
        console.log(wordOccurs);
         
    }
}

//////////////////////////////////////////////////////////////////////////

testWords1 = [ "delhi", "bombay", "delhi", "dodballapur", "bombay", "calcutta", "bombay"];

DupStrings.dupInfo(testWords1);
