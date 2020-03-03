"""
Will talk about how to use decorator
"""
import time


def count_time(func):
    """
    run the function without args
    :param func: the function
    :return:
    """
    def wrapper():
        start_time = time.time()
        res = func()
        end_time = time.time()
        print("The progress cost: {:4}".format(end_time-start_time))
        return res
    return wrapper


def count_time_args(func):
    """
    run the function with args
    :param func:
    :return:
    """
    def wrapper(*args):
        start_time = time.time()
        res = func(*args)
        end_time = time.time()
        print("The progress cost: {:4}".format(end_time - start_time))
        return res
    return wrapper


def is_prime(num):
    """
    determine whether exist a prime number
    :param num:
    :return:
    """
    if num < 2:
        return False

    for i in range(2, num):
        if num % i == 0:
            return True


@count_time
def count_prime():
    """
    count how many prime numbers
    :return:
    """
    nums = []
    for i in range(2, 10000):
        if is_prime(i):
            nums.append(i)
    return nums


@count_time_args
def count_prime_args(num):
    """
    using decorator with args
    :param num:
    :return:
    """
    nums = []
    for i in range(2, num):
        if is_prime(i):
            nums.append(i)
    return nums


if __name__ == '__main__':
    data = count_prime()
    print(data)
    data = count_prime_args(10000)
    print(data)
