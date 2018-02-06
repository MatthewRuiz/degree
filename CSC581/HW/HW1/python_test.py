from python_code import *
import unittest

class TestMethods(unittest.TestCase):

    def test_two_max(self):
        self.assertEqual(two_max(3,4), 4)
        self.assertEqual(two_max(-1,3), 3)

    def test_three_max(self):
        self.assertEqual(three_max(1,2,2), 2)
        self.assertEqual(three_max(-5,-10,-15), -5)

    def test_startswithvowel(self):
        self.assertTrue(startswithvowel("a"))
        self.assertTrue(startswithvowel("U"))
        self.assertFalse(startswithvowel("s"))

    def test_multiply(self):
        self.assertEqual(multiply([1,2,3,4]), 24)
        self.assertEqual(multiply([-1,3.5]), -3.5)

    def test_is_palindrome(self):
        self.assertTrue(is_palindrome("radar"))
        self.assertFalse(is_palindrome("radars"))

    def test_odd_list(self):
        self.assertEqual(odd_list([1,2,3,4,5]), [1,3,5])

    def test_is_sorted(self):
        self.assertTrue(is_sorted([1,2,2]))
        self.assertFalse(is_sorted(['b','a']))
        self.assertFalse(is_sorted([1,2,1]))
        self.assertTrue(is_sorted([-5,2,3]))
        

    def test_remove_spaces(self):
        self.assertEqual(remove_spaces({'philadelphia eagles':24, 'newengland':7}),
                        {'philadelphiaeagles':24, 'newengland':7})
        self.assertEqual(remove_spaces({' philadelphia    eagles ':24, ' new e   ngla nd  ':7}),
                        {'philadelphiaeagles':24, 'newengland':7})

    def test_ends_in_vowel(self):
        self.assertEqual(ends_in_vowel(['apple','bear','bingo']), ['apple','bingo'])

    def test_is_anagram(self):
        self.assertTrue(is_anagram("school master", "theclassroom"))
        self.assertFalse(is_anagram("school", "classroom"))
        self.assertTrue(is_anagram("roast beef", "eat for BSE"))

    def test_is_pangram(self):
        self.assertTrue(is_pangram("The Quick 3brown fox jumps over the lazy dog"))
        self.assertFalse(is_pangram("the quick brown fox jumps over the lazy fox"))

    def test_char_freq(self):
        self.assertEqual(char_freq('to be or not to be'),
                         {'t':3, 'o':4, ' ':5, 'b':2, 'e':2, 'r':1, 'n':1})

    def test_encode(self):
        self.assertEqual(encode("To be or not to be, That is the question"), "Gb or be abg gb or, Gung vf gur dhrfgvba")

    def test_decode(self):
        self.assertEqual(decode("Gb or be abg gb or, Gung vf gur dhrfgvba"), "To be or not to be, That is the question")

    def test_word_length(self):
        self.assertEqual(word_length(["the", "quick", "brown", "fox"]), [3, 5, 5, 3])

    def test_filter_long_words(self):
        self.assertEqual(filter_long_words(["the", "quick", "brown", "fox"], 4), ["QUICK", "BROWN"])        

if __name__ == '__main__':
    unittest.main(verbosity=2)


