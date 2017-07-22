def is_isogram(str):
    replace = ['-', ' ']
    filtered_str = str.lower().translate({ord(x): '' for x in replace})
    set_ = set([c for c in filtered_str])
    return len(set_) == len(filtered_str)
