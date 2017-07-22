import re


def is_pangram(_str):
    regex = re.compile('[a-z]')
    chars = [char for char in _str.lower() if regex.match(char)]
    return len(set(chars)) == 26
