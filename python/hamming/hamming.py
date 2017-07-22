def distance(dna1, dna2):
    if len(dna1) != len(dna2):
        raise ValueError('error')
    diff = 0
    for idx, ch in enumerate(dna1):
        if ch != dna2[idx]:
            diff += 1
    return diff
