def square_of_sum(num):
    return square(sum(range(1, num + 1)))


def square(num):
    return num ** 2


def sum_of_squares(num):
    return sum([square(n) for n in range(1, num + 1)])


def difference(num):
    return square_of_sum(num) - sum_of_squares(num)
