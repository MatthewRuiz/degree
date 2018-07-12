from main import Main
import time
import re
import nltk
import string
import csv
#nltk.download('words')
from nltk.corpus import words
# nltk.download('wordnet')

alphabet = 'abcdefghijklmnopqrstuvwxyz'
# m = Main()
charx_xy_path = 'matrices\chars_xy.txt'
addmatrix_path = 'matrices/addmatrix.txt'
delmatrix_path = 'matrices/delmatrix.txt'
revmatrix_path = 'matrices/revmatrix.txt'
submatrix_path = 'matrices/submatrix.txt'
c_xy = [[0 for x in range(27)] for y in range(27)]

def get_matrix_from_file(path):
    with open(path, 'r') as matrix_reader:
        rows = matrix_reader.readlines()
        matrix = []
        for row in rows:
            row_of_counts = row[:-1].split(',')
            matrix.append(row_of_counts)

        return matrix
    
def load_csv():
    text = ''
    with open(r'{}'.format('articles1.csv'),
              encoding='ascii',
              errors='ignore') as csv_data_file:
        csv_reader = csv.reader(csv_data_file)

        for row in csv_reader:
            text += row[0].lower()
            
        return text

t = load_csv()
# 26 x 26 matrix containing the number of times xy appeared
chars_xy = get_matrix_from_file(charx_xy_path)
addmatrix = get_matrix_from_file(addmatrix_path)
delmatrix = get_matrix_from_file(delmatrix_path)
revmatrix = get_matrix_from_file(revmatrix_path)
submatrix = get_matrix_from_file(submatrix_path)

def start():
    start_time = time.time()

    # Main instance

    # print(m.get_chars_xy_matrix())
    # print(m.get_char_frequency('a'))

    # print(m.WORDS[:100])
    # print(m.correct('therre'))
    w = 'place'

#    print(known(edits1('the')))
#    print(correct('thz'))
    for x in range(len(t)):
        if t[x] is ' ':
            f_l = 26
        else:
            f_l = string.ascii_lowercase.index(t[x].lower())
        
        if t[x+1] is ' ':
            s_l = 26
        else:
            s_l = string.ascii_lowercase.index(t[x+1].lower())
            
        c_xy[f_l][s_l] += 1
        
    print(c_xy)
        
#    pairs = splits('acress')
#    print(pairs)
#    print(custom_deletes(pairs))
    print(time.time() - start_time)
    
def correct(word):
    "Find the best spelling correction for this word."
    # Prefer edit distance 0, then 1, then 2; otherwise default to word itself.
    candidates = (known(edits0(word)) or 
                  known(edits1(word)) or 
                  known(edits2(word)) or 
                  [word])
    
    return candidates

def tokens(text):
    "List all the word tokens (consecutive letters) in a text. Normalize to lowercase."
    return re.findall('[a-z]+', text.lower())

def known(tokens):
    "Return the subset of words that are actually in the dictionary."
    return {word for word in tokens if word in words.words()}

def edits0(word):
    "Return all strings that are zero edits away from word (i.e., just word itself)."
    return {word}

def edits2(word):
    "Return all strings that are two edits away from this word."
    return {e2 for e1 in edits1(word) for e2 in edits1(e1)}

def edits1(word):
    "Return all strings that are one edit away from this word."
    pairs = splits(word)
    word_deletes = deletes(pairs)
    word_transposes = transposes(pairs)
    word_replaces = replaces(pairs)
    word_inserts = inserts(pairs)
                           
    return set(word_deletes + word_transposes + word_replaces + word_inserts)

def deletes(pairs):
    return [(a + b[1:], counter) for counter, (a,b) in enumerate(pairs) if b]

def custom_deletes(pairs):
    for counter, (a, b) in enumerate(pairs):
        if counter < len(pairs) - 1:
            if len(a) > 0:
                x = string.ascii_lowercase.index(a[-1].lower())
            else:
                x = 26  
                
            y = string.ascii_lowercase.index(b[0].lower())
            
            print(x,y)
            count = 0
            for s in chars_xy[y]:
                count += int(s)
                
            print(delmatrix[x][y])
    #        print(count)
            prob = float(int(delmatrix[x][y]) / count)
            
            print(prob)
        

def transposes(pairs):
    return [a + b[1] + b[0] + b[2:] for (a, b) in pairs if len(b) > 1]

def replaces(pairs):
    return [a + c + b[1:] for (a, b) in pairs for c in alphabet if b]

def inserts(pairs):
    return [a + c + b for (a, b) in pairs for c in alphabet]
    
def splits(word):
    "Return a list of all possible (first, rest) pairs that comprise word."
    return [(word[:i], word[i:])
            for i in range(len(word) + 1)]
     
if __name__ == '__main__':
    start()