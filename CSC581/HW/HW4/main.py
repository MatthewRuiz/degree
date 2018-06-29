import csv
import string
import re
import collections
import time
import sys
import logging

class Main:
    def __init__(self):
        self.charx_xy_path = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/matrices/chars_xy.txt'
        self.addmatrix_path = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/matrices/addmatrix.txt'
        self.delmatrix_path = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/matrices/delmatrix.txt'
        self.revmatrix_path = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/matrices/revmatrix.txt'
        self.submatrix_path = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/matrices/submatrix.txt'

        # 26 x 26 matrix containing the number of times xy appeared
        self.chars_xy = self.get_matrix_from_file(self.charx_xy_path)
        self.addmatrix = self.get_matrix_from_file(self.addmatrix_path)
        self.delmatrix = self.get_matrix_from_file(self.delmatrix_path)
        self.revmatrix = self.get_matrix_from_file(self.revmatrix_path)
        self.submatrix = self.get_matrix_from_file(self.submatrix_path)

        # Words in the articles1.csv file
        self.WORDS = self.tokens(self.load_csv())
        # Dictionary of {word : count} pairs
        self.COUNTS = collections.Counter(self.WORDS)

        self.alphabet = 'abcdefghijklmnopqrstuvwxyz'

        # csv.field_size_limit(sys.maxsize)

    def get_chars_xy_matrix(self):
        return self.chars_xy


    def get_char_frequency(self, char):
        if char is '#':
            row = 26
        else:
            row = string.ascii_lowercase.index(char.lower())
        frequency = 0
        for freq in self.chars_xy[row]:
            frequency += int(freq)
        return frequency

    def get_matrix_from_file(self, path):
        with open(path, 'r') as matrix_reader:
            rows = matrix_reader.readlines()
            matrix = []
            for row in rows:
                row_of_counts = row[:-1].split(',')
                matrix.append(row_of_counts)

            return matrix

    def load_csv(self):
        text = ''
        with open(r'{}'.format('/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/articles1.csv'),
                  encoding='ascii',
                  errors='ignore') as csv_data_file:
            csv_reader = csv.reader(csv_data_file)

            for row in csv_reader:
                text += row[0].lower()

        return text


    # The following six methods were taken from:
    # http://nbviewer.jupyter.org/url/norvig.com/ipython/How%20to%20Do%20Things%20with%20Words.ipynb

    def correct(self, word):
        "Find the best spelling correction for this word."
        # Prefer edit distance 0, then 1, then 2; otherwise default to word itself.
        candidates = (self.known(self.edits0(word)) or
                      self.known(self.edits1(word)) or
                      self.known(self.edits2(word)) or
                      [word])
        return max(candidates, key=self.COUNTS.get)

    def tokens(self, text):
        "List all the word tokens (consecutive letters) in a text. Normalize to lowercase."
        return re.findall('[a-z]+', text.lower())

    def known(self, words):
        "Return the subset of words that are actually in the dictionary."
        return {w for w in words if w in self.COUNTS}

    def edits0(self, word):
        "Return all strings that are zero edits away from word (i.e., just word itself)."
        return {word}

    def edits2(self, word):
        "Return all strings that are two edits away from this word."
        return {e2 for e1 in self.edits1(word) for e2 in self.edits1(e1)}

    def edits1(self, word):
        "Return all strings that are one edit away from this word."
        pairs       = self.splits(word)
        deletes     = [a + b[1:]                for (a, b) in pairs if b]
        transposes  = [a + b[1] + b[0] + b[2:]  for (a, b) in pairs if len(b) > 1]
        replaces    = [a + c + b[1:]            for (a, b) in pairs for c in self.alphabet if b]
        inserts     = [a + c + b                for (a, b) in pairs for c in self.alphabet]
        return set(deletes + transposes + replaces + inserts)

    def splits(self, word):
        "Return a list of all possible (first, rest) pairs that comprise word."
        return [(word[:i], word[i:])
                for i in range(len(word) + 1)]


# The following functions are used to create char[x] and char[x,y] matrices
##########################################################################################
#    def set_char_frequencies(self):
#        for row in self.load_csv():
#    
#            words = self.tokens(row)
#            self.WORDS.extend(words)
#    
#            for word in words:
#                self.store_xy_frequencies(word)


    #def store_xy_frequencies(self, word):
    #    for x in range(len(word) - 1):
    #        first_letter = word[x]
    #        second_letter = word[x + 1]
    #        row = string.ascii_lowercase.index(first_letter)
    #        column = string.ascii_lowercase.index(second_letter)
    #        self.chars_xy[row][column] += 1