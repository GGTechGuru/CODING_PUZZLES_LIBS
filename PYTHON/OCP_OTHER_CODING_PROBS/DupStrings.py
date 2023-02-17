# Find duplicated strings (words) in an array of words. Print the words that recur, as well as the total
# number of times a word recurs at least once.

class DupStrings:

    def dupInfo( wl ):

        wordOccurs = {}

        index=0
        while index < len(wl):

            thisWord = wl[index];

            if thisWord in wordOccurs.keys():

                count = wordOccurs[thisWord]

                wordOccurs[thisWord] = count + 1
            
            else:

                wordOccurs[thisWord] = 1

            index += 1


        repeats = 0

        for word in wordOccurs.keys():

            count = wordOccurs[word]

            if count > 1:

                print( "%s : %d\n" % ( word, count) )

                repeats += 1

        print( "Total words with 2+ occurences: %d\n" % ( repeats ) )
         

#########################################################################################

testWords1 = ["delhi", "bombay", "delhi", "dodballapur", "bombay", "calcutta", "bombay" ]

DupStrings.dupInfo(testWords1)

