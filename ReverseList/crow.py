"""
Name: crow.py
Author: lsy
Time: 2020/5/3
"""

import sys

if __name__ == '__main__':
    lines = sys.stdin.readlines()
    nums, dis = lines[0].split(" ")
    del lines[0]

    if len(lines) != nums:
        print("Please enter enough crow")

    crows = {}

    for line in lines:
        line = line.replace('\n', "").split(" ")
        # 把x的坐标当做index，height当做身高
        crows[int(line[0])] = int(line[1])

    # then sort the dict
    crows = {k: crows[k] for k in sorted(crows)}
    position = [int(i) for i in crows]
    height = [int(crows[i]) for i in crows]

    index = 1
    total = 0
    record = []
    dis = int(dis)
    while index < len(position) - 1:
        p0 = position[index-1]
        p1 = position[index]
        p2 = position[index+1]

        h0 = height[index - 1]
        h1 = height[index]
        h2 = height[index+1]

        # 如果距离小于规定距离, 然后判断身高
        if abs(p0 - p1) < dis:
            if h1 <= 2*h0:
                total += 1
                record.append((p1, h1))
        elif abs(p2 - p1) < dis:
            if h2 <= 2*h1:
                total += 1
                record.append((p1, h1))
        index += 1

    print(total, record)
