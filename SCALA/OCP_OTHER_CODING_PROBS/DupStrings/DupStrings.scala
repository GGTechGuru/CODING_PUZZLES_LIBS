// Find duplicated strings (words) in an array of words. Print the words that recur, as well as the total
// number of times a word recurs at least once.

object DupStrings {

    def dupInfo(wl: Array[String]) {

        var wordOccurs:Map[String, Int] = Map()
        
        var index = 0

        for (index <- 0 to wl.length-1) {

            var thisWord = wl(index)

            var count = 0

            if ( wordOccurs.contains( thisWord )) {

                count = (wordOccurs.get(thisWord)).getOrElse(0)
            }

            count += 1

            wordOccurs += (thisWord -> count)
        }


        var repeats = 0

        for ( (word, count) <- wordOccurs) {

            if (count > 1) {

                println("%s : %d\n".format(word, count))

                repeats += 1;
            }
        }

        println( "Total words with 2+ occurences: %d\n".format(repeats ))
        println(wordOccurs)

         
    }

    //////////////////////////////////////////////////////////////////////////

    def main(args: Array[String]) {

        val testWords1 = Array("delhi", "bombay", "delhi", "dodballapur", "bombay", "calcutta", "bombay")

        dupInfo(testWords1)

    }
}
