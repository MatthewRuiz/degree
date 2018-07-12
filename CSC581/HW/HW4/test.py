import csv
import re
import time
import sys
import logging
import string

# csv.field_size_limit(sys.maxsize)
logging.basicConfig(filename='example.log', level=logging.DEBUG)
logging.debug('This message should go to the log file')
logging.info('So should this')
logging.warning('And this, too')


def load_csv(csv_file):
    text = ""
    with open(r'{}'.format(csv_file),
              encoding='ascii',
              errors='ignore') as csv_data_file:

        csv_reader = csv.reader(csv_data_file)

        for row in csv_reader:
                yield row[0].lower()


a = []
start_time = time.time()
n_count = 0
l = 0

# r = re.compile(r'\w+')
# for row in load_csv('articles1.csv'):
#     tokenized_string_as_list = r.findall(row)
#     n_count += len(tokenized_string_as_list)
#     l += 1
#
# print('lines: {} n_count: {}'.format(l,n_count))
# print(time.time() - start_time)


# Compute chars matrix and vector
################################################################################################

# Create 26 x 26 matrix; all set to 0
chars_xy = [[0 for x in range(26)] for y in range(26)]

s = 'The dog came home. I was happy!'

# Find all words in a sentence
all_words_compiled_regex = re.compile(r'\w+')
tokens = all_words_compiled_regex.findall(s)

# Store char xy sequence inside of matrix

# for x in range(len(w) - 1):
#     first_letter = w[x]
#     second_letter = w[x+1]
#     row = string.ascii_lowercase.index(first_letter)
#     column = string.ascii_lowercase.index(second_letter)
#     print(row, column)
#     chars_xy[row][column] += 1

# print(chars_xy)


# def compute_xy_frequencies(word):
#     for x in range(len(word) - 1):
#         first_letter = word[x]
#         second_letter = word[x + 1]
#         row = string.ascii_lowercase.index(first_letter)
#         column = string.ascii_lowercase.index(second_letter)
#         chars_xy[row][column] += 1
#
# for x in tokens:
#     compute_xy_frequencies(x.lower())
#
# print(chars_xy)

# with open('/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/chars_xy.txt', 'r') as c_matrix:
#     c = c_matrix.readlines()
#     c_xy = []
#     for row in c:
#         r = row[:-1].split(',')
#         c_xy.append(r)
#         # print(r)
#
#     print(c_xy[0][0])

def get_matrix_from_file(path):
    with open(path, 'r') as matrix_reader:
        rows = matrix_reader.readlines()
        matrix = []
        for row in rows:
            row_of_counts = row[:-1].split(',')
            matrix.append(row_of_counts)

        return matrix


p = '/Users/matthewruiz/Documents/GitHub/degree/CSC581/HW/HW4/addmatrix.txt'
print(get_matrix_from_file(p))

