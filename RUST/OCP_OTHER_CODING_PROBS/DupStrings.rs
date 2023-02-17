// Find duplicated Strings (words) in an array of words. Print the words that recur,
// as well as the total number of times a word recurs at least once.

use std::collections::HashMap;

fn dup_info(wl: Vec<&str>) {
            
    let mut word_occurs = HashMap::<&str, i32>::new();

    for this_word in wl.iter() {

        let mut count = 0;
        if word_occurs.contains_key(this_word) {
            count = word_occurs[this_word];
        }

        count += 1;
        word_occurs.insert(this_word, count);
    }

    let mut repeats = 0;

    for (this_word, count) in &word_occurs {

        if count > &1 {

            println!("{} : {}\n", this_word, count);

            repeats += 1;
        }
    }

    println!( "Total words with 2+ occurences: {}\n", repeats );

}


//////////////////////////////////////////////////////////////////////////////////////

fn main() {

    let test_words = vec![ "delhi", "bombay", "delhi", "dodballapur", "bombay", "calcutta", "bombay"];

    dup_info(test_words);
}
