def encode(ch, num):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    alphabet = alphabet.upper() if ch.isupper() else alphabet
    try:
        index = (alphabet.index(ch) + num) % len(alphabet)
    except:
        return ch

    return alphabet[index]


def rotate(text, num):
    return ''.join([encode(ch, num) for ch in text])
