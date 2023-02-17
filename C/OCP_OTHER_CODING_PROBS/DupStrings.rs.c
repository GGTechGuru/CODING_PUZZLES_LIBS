// Find duplicated Strings (words) in an array of words. Print the words that recur,
// as well as the total number of times a word recurs at least once.

#include <stdio.h>
#include <ctypes.h>

typedef struct {
    char*	key;
    int		value;
} KeyVal;

KeyVal* contains_key(char* word, KeyVal** kv_list) {
    KeyVal** iter;

    iter = kv_list;

    while (*iter != (KeyVal *)NULL) {
        this_kv = *iter;

        if (!strcmp(word, this_kv->key))
            return this_kv;
    }

    return (KeyVal*)NULL;
}

void dup_info(char ** wl) {
            
    KeyVal word_occurs[];
    KeyVal* this_kv = NULL;

    int index = 0;
    
    char *this_word = (char *)NULL;

    char **iter = (char **)NULL;

    for (iter=wl; (this_word=*iter) != (char *)NULL; iter++) {

        int count = 0;

        if ((this_kv=contains_key(this_word)) != (KeyVal *)NULL) {
            count = this_kv->value;
        }
        else {
            *this_kv = (KeyVal)malloc(sizeof(KeyVal));
            append to list
        }

        count += 1;
        this_kv->value = count;

    }

    int repeats = 0;
    for (index=0; (this_kv = word_occurs[index]) != NULL; index++) {

        char* this_word = this_kv->key;
        int count= this_kv->value;

        if (count > 1) {

            printf("%s : %d\n", this_word, count);

            repeats += 1;
        }
    }

    printf( "Total words with 2+ occurences: %d\n", repeats );

}


//////////////////////////////////////////////////////////////////////////////////////

int main() {

    char* test_words[] = { "delhi", "bombay", "delhi", "dodballapur", "bombay", "calcutta", "bombay" };

    dup_info(test_words);
}
