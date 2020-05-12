"""
Name: test.py
Author: lsy
Time: 2020/4/2
"""

class LinkList():
    def __init__(self, value, next):
        self.value = value
        self.next = next


def add_num(l1, l2):
    """
    :param l1: link list 1
    :param l2: link list 2
    :return: a new list about the sum
    """

    # 先把数据结果提取出来
    data1, data2 = [], []

    while l1 is not None:
        if str(l1.value).isdigit() and len(str(l1.value)) == 1:
            data1.append(l1.value)
        l1 = l1.next

    while l2 is not None:
        data2.append(l2.value)
        l2 = l2.next

    data1.reverse()
    data2.reverse()

    # 然后拼接两个字符串，得到相对应的int 结果
    num1 = int("".join([str(x) for x in data1]))
    num2 = int("".join([str(x) for x in data2]))

    sum_Value = num1 + num2
    sum_Value = str(sum_Value)

    # 得到一个相对应的结果
    sum_Value = sum_Value.split('')
    # 逆序
    sum_Value.reverse()

    if len(sum_Value) is None:
        return None

    head = LinkList(sum_Value[0], None)
    temp = head
    for i in range(1, len(sum_Value)):
        node = LinkList(sum_Value[i], None)
        temp.next = node
        temp = node

    return head


if __name__ == '__main__':
    pass