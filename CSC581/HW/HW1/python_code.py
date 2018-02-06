# Matthew Ruiz

from functools import reduce
import string


def two_max(x,y):
    return x if (x > y) else y

def three_max(x,y,z):
    if (x > y):
        return x if (x > z) else z
    else:
        return y if (y > z) else z
    
def startswithvowel(x):
	if x.upper() in ('A', 'E', 'I', 'O', 'U'):
		return True
	
	return False

def multiply(params):
    return reduce(lambda x,y: x * y, params)

def is_palindrome(s):
    lengthMinusOne = len(s) - 1
    for x in range(0,len(s)):
        if (x > (lengthMinusOne - x)):
            return True
        if (s[x] != s[lengthMinusOne - x]):
            return False
        
def odd_list(nums):
    new_list = []
    for x in nums:
        if ((x % 2) != 0):
            new_list.append(x)
            
    return new_list  

def is_sorted(nums):
    return reduce(lambda x,y: x < y, nums)

def remove_spaces(data):
    for x in data:
        data[x.replace(' ','')] = data.pop(x)
        
    return data

def ends_in_vowel(s):
    new_list = []
    for x in s:
        if x[-1:] in ('a', 'e', 'i', 'o', 'u'):
            new_list.append(x)
            
    return new_list

def is_anagram(s1,s2):
    s = s2.lower()
    for x in s1:
        if x == ' ':
            continue
        if x.lower() in s:
            s.replace(x,"",1)
        else:
            return False
        
    return True

def is_pangram(s):
    s1 = s.lower()
    new_list = string.ascii_lowercase
    for x in new_list:
        if x not in s1:
            return False
    return True

def char_freq(s):
    freq = {}
    for x in s:
        if x in freq:
            freq[x] += 1
        else:
            freq[x] = 1
    return freq

key = {'a':'n', 'b':'o', 'c':'p', 'd':'q', 'e':'r', 'f':'s', 'g':'t', 'h':'u', 
       'i':'v', 'j':'w', 'k':'x', 'l':'y', 'm':'z', 'n':'a', 'o':'b', 'p':'c', 
       'q':'d', 'r':'e', 's':'f', 't':'g', 'u':'h', 'v':'i', 'w':'j', 'x':'k',
       'y':'l', 'z':'m', 'A':'N', 'B':'O', 'C':'P', 'D':'Q', 'E':'R', 'F':'S', 
       'G':'T', 'H':'U', 'I':'V', 'J':'W', 'K':'X', 'L':'Y', 'M':'Z', 'N':'A', 
       'O':'B', 'P':'C', 'Q':'D', 'R':'E', 'S':'F', 'T':'G', 'U':'H', 'V':'I', 
       'W':'J', 'X':'K', 'Y':'L', 'Z':'M'} 

def encode(s): 
    sen = list(s)
   
    for x in range(0,len(s)):
        if(sen[x] != ' ' and sen[x] != ','):
            sen[x] = key.get(sen[x],"") 
        
    return "".join(sen)

def decode(s):
    sen = list(s)
   
    for x in range(0,len(s)):
        if(sen[x] != ' ' and sen[x] != ','):
            sen[x] = key.get(sen[x],"") 
        
    return "".join(sen)    

def word_length(s):
    return [len(x) for x in s]

def filter_long_words(s,n):
    return [x.upper() for x in s if len(x) > n]
        
        
        
            
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    