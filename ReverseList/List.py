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



if __name__ == '__main__':
    n0 = ListNode(0)
    n1 = ListNode(1)
    n2 = ListNode(1)
    # n3 = ListNode(3)
    n2.next = n1
    n1.next = n0
    # n3.next = n2

    find_diff(n2)
    print(n2, n1, n0)
    print(n2.val, n2.next, n2.next.val)

