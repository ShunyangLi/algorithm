
def minSubArrayLen(nums, target):
    index = 0
    res = 0
    min_len = 99999999

    for i in range(0, len(nums)):
        res += nums[i]

        while res >= target:
            print('i: ', i)
            print('index: ', index)
            length = i - index + 1
            min_len = min(length, min_len)
            res -= nums[index]
            index += 1

    return min_len if min_len != 99999999 else 0


def bf(nums, target):
    length = 9999

    for i in range(0, len(nums)):
        res = nums[i]
        if res >= target:
            length = 1
            continue
        for j in range(i + 1, len(nums)):
            res += nums[j]

            if res >= target:
                length = min(length, j - i + 1)
                break
    return length if length != 9999 else 0


if __name__ == '__main__':
    num = minSubArrayLen([2,3,1,2,4,3], 7)
    print(num)
