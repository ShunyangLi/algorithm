# -*- coding:utf-8 -*-

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 返回ListNode
    def ReverseList(self, pHead):
        temp = pHead
        last = None
        curr = pHead
        while temp is not None:
            if temp.next is None:
                pHead = temp
            temp = temp.next
            curr.next = last
            last = curr
            curr = temp
        return pHead


if __name__ == '__main__':
    n1 = ListNode(1)
    n2 = ListNode(2)
    # n3 = ListNode(3)
    n2.next = n1

    node = Solution().ReverseList(n2)
    while node is not None:
        print(node.val)
        node = node.next
