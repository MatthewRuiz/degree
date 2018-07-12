from start import *
import unittest

class TestMethods(unittest.TestCase):

    def test_tokens(self):
        s = 'The dog went home.'
        self.assertEqual(tokens(s), ['the', 'dog', 'went', 'home'])

    def test_edits0(self):
        self.assertEqual(edits0('word'), 'word')

    # def test_edits2(self):
    #     self.assertEqual(edits2)


if __name__ == '__main__':
    unittest.main(verbosity=2)