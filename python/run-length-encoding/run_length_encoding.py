import re


def repl(match):
    group = match.group()
    return str(len(group)) + group[0]


def encode(text):
    return re.sub(r'(.)\1{1,}', repl, text)


def displ(match):
    _, num, c = match
    return int(num) * c if num else c


def decode(text):
    matches = re.compile('((\d+)?(\D))').findall(text)
    lst = list(map(displ, matches))
    return "".join(lst)
