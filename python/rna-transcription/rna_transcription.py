import re


def to_rna(_str):
    regex = re.compile('^[ACGT]+$')
    if regex.match(_str) is None:
        return ''
    return _str.translate({ord('G'): 'C', ord('C'): 'G',
                           ord('T'): 'A', ord('A'): 'U'})
