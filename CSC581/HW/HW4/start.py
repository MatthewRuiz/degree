from main import Main
import time
import re
import nltk
from nltk.corpus.reader import wordnet as wn
# nltk.download('wordnet')

alphabet = 'abcdefghijklmnopqrstuvwxyz'
# m = Main()

def start():
    start_time = time.time()

    # Main instance

    # print(m.get_chars_xy_matrix())
    # print(m.get_char_frequency('a'))

    # print(m.WORDS[:100])
    # print(m.correct('therre'))
    w = 'the'
    print(wn.all_synsets('the'))
    # print(edits1('the'))
    print(time.time() - start_time)

def tokens(text):
    "List all the word tokens (consecutive letters) in a text. Normalize to lowercase."
    return re.findall('[a-z]+', text.lower())

def known(words):
    "Return the subset of words that are actually in the dictionary."
    return {w for w in words if w in m.COUNTS}

def edits0(word):
    "Return all strings that are zero edits away from word (i.e., just word itself)."
    return word

def edits2(word):
    "Return all strings that are two edits away from this word."
    return {e2 for e1 in edits1(word) for e2 in edits1(e1)}

def edits1(word):
    "Return all strings that are one edit away from this word."
    pairs       = splits(word)
    deletes     = [a + b[1:]                for (a, b) in pairs if b]
    transposes  = [a + b[1] + b[0] + b[2:]  for (a, b) in pairs if len(b) > 1]
    replaces    = [a + c + b[1:]            for (a, b) in pairs for c in alphabet if b]
    inserts     = [a + c + b                for (a, b) in pairs for c in alphabet]
    return set(deletes + transposes + replaces + inserts)

def splits(word):
    "Return a list of all possible (first, rest) pairs that comprise word."
    return [(word[:i], word[i:])
            for i in range(len(word) + 1)]


if __name__ == '__main__':
    start()