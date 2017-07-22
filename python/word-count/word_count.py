import re


def word_count(phrase):
    words = filter(None, re.sub('[^a-z0-9 ]', ' ', phrase.lower()).split(' '))
    dct = {}
    for word in words:
        if word in dct:
            dct[word] += 1
        else:
            dct[word] = 1
    return dct
