# -*- coding:utf-8 -*-


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def find_mid(head):
    """
    找到该list中间的元素
    :param head: the head of list
    :return:
    """
    slow = head
    fast = head

    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next

    return slow


def find_mid_recursion(node, index):
    """
    find the mid by recursion
    :param node:
    :param index:
    :return:
    """
    global mid
    if node.next is not None:
        find_mid_recursion(node.next, index+1)
    else:
        mid = int(index / 2)

    if mid == index:
        return node

    return None


def check_cycle(node):
    """
    check whether exist cycle in the linklist
    :param node:
    :return:
    """
    slow = node
    fast = node

    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next

        if slow == fast:
            return True

    return False


def reverse_recursion(curr, next):
    """
    reverse the link list by recursion
    :param curr:
    :param next:
    :return:
    """
    if next is None:
        return
    reverse_recursion(next, next.next)
    next.next = curr
    curr.next = None


def reverse(node):
    """
    reverse the link list without recursion
    :param node:
    :return:
    """
    curr = node
    next = node.next
    curr.next = None

    while next is not None:
        temp = next.next
        next.next = curr

        curr = next
        next = temp


def find_diff(node):
    """
    in a sort link list, remove the duplicate value
    :param node:
    :return:
    """
    curr = node
    record = None

    while curr.next is not None:
        next_node = curr.next
        if curr.val == next_node.val and record is None:
            record = curr
        elif curr.val != next_node.val and record is not None:
            record.next = next_node
            record = None

        curr = curr.next


def sum_list(l1, l2):
    """
    add two link list together
    将链表代表的数字进行相加即可，注意首位代表的是个位。3->1->5 代表513，5->9->2 代表295，最终计算结果为 8->0->8， 808。
    :param l1:
    :param l2:
    :return:
    """
    over_ten = False
    s = ListNode(0)
    head = s

    while l1 is not None or l1 is not None:
        v1 = l1.val if l1 is not None else 0
        v2 = l2.val if l2 is not None else 0

        sum_value = v1 + v2
        sum_value = sum_value + 1 if over_ten else sum_value

        if sum_value >= 10:
            over_ten = True
            sum_value = sum_value % 10

        s.val = sum_value

        l1 = l1.next if l1 is not None else None
        l2 = l2.next if l2 is not None else None

        if l1 is None and l2 is None:
            break
        else:
            s.next = ListNode(0)
            s = s.next

    return head


def merge_two_list(l):
    """
    split to two list
    :param l:
    :return:
    """
    odd = ListNode(0)
    even = ListNode(0)

    odd_head = odd
    even_head = even

    index = 1
    while l is not None:
        if index % 2 != 0:
            odd.val = l.val
            odd.next = ListNode(None)
            odd = odd.next
        else:
            even.val = l.val
            even.next = ListNode(None)
            even = even.next

        l = l.next

    odd = None
    even = None

    reverse_recursion(odd_head, odd_head.next)
    reverse_recursion(even_head, even_head.next)

    # merge them together


def delete_n_element(l, n):
    """
    删除倒数n的element
    :param l:
    :param n:
    :return:
    """
    index = 0
    curr = l
    corr = l

    while curr is not None:
        if index >= n + 1:
            corr = corr.next
        curr = curr.next
        index += 1

    print(corr.val)





if __name__ == '__main__':
    n0 = ListNode(3)
    n1 = ListNode(1)
    n2 = ListNode(5)
    # n3 = ListNode(3)

    n0.next = n1
    n1.next = n2
    n2.next = None

    n3 = ListNode(5)
    n4 = ListNode(9)
    n5 = ListNode(2)

    n3.next = n4
    n4.next = n5
    n5.next = None

    delete_n_element(n0, 1)

    # print(head.val, head.next.val, head.next.next.val)
