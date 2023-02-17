// Find duplicated strings (words) in an array of words. Print the words that recur, as well as the total
// number of times a word recurs at least once.

#include <iostream>
#include <array>
#include <list>
#include <map>
#include <string>

using namespace std;

class DupStrings {

    public:

        static void dupInfo(list<string> wl) {
            
            map<string, int> wordOccurs;

            for (const string& thisWord: wl)
                    wordOccurs[thisWord]++;

            int repeats = 0;
            for (map<string, int>::iterator iter = wordOccurs.begin(); iter != wordOccurs.end();
                                                                       iter++ ) {

                string thisWord = iter->first;
                int count = iter->second;

                if (count > 1) {

                    printf("%s : %d\n", thisWord.c_str(), count);

                    repeats += 1;
                }
            }

            printf( "Total words with 2+ occurences: %d\n", repeats );

        }

};

//////////////////////////////////////////////////////////////////////////////////////

int main(int argc, char ** args) {

        list<string> testWords{ "delhi", "bombay", "delhi", "dodballapur", "bombay",
                                  "calcutta", "bombay"};

        DupStrings::dupInfo(testWords);

}
