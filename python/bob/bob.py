import re


def hey(phrase):
    phrase = phrase.strip()
    if phrase.isupper():
        return 'Whoa, chill out!'
    elif re.match('.+\?$', phrase):
        return 'Sure.'
    elif phrase == "" or phrase.isspace():
        return 'Fine. Be that way!'
    else:
        return'Whatever.'
