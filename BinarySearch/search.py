"""
Name: search.py
Author: lsy
Time: 2020/4/1
"""


def binary_search(num_list, x):
    num_list = sorted(num_list)
    left, right = 0, len(num_list)

    while left < right:
        mid = int((left + right) / 2)
        if num_list[mid] < x:
            left = mid + 1
        elif num_list[mid] > x:
            right = mid
        else:
            return mid
    return None


if __name__ == '__main__':
    print(binary_search([1,3,2,4,6,9,10,12], 6))
