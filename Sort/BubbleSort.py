"""
Name: BubbleSort.py
Author: lsy
Time: 2020/4/2
冒泡排序法
"""


def bubble_sort(num_list):
    """
    交换法排序，时间复杂度高
    :param num_list:
    :return:
    """
    for i in range(0, len(num_list)):
        for j in range(0, len(num_list)):
            if num_list[j] > num_list[i]:
                temp = num_list[j]
                num_list[j] = num_list[i]
                num_list[i] = temp

    return num_list


def merge(left, right):
    i, j = 0, 0
    result = []
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result += left[i:]
    result += right[j:]
    return result


def merge_sort(lists):
    if len(lists) <= 1:
       return lists
    num = len(lists) / 2
    left = merge_sort(lists[:num])
    right = merge_sort(lists[num:])
    return merge(left, right)

if __name__ == '__main__':
    print(bubble_sort([3, 6, 9, 1, 2]))
