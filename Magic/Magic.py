
def determine_miss_repeat(data, line):
    """
    determine whether repeat in the matrix
    :param data: matrix data
    :param line: how many lines
    :return: whether miss or repeat
    """

    # check miss
    if len(data) < line:
        return False

    all_numbers = []
    for i in range(0, line):
        if len(data[i]) < line:
            return False
        for j in data[i]:
            all_numbers.append(j)

    # check  repeat
    if len(set(all_numbers)) != (line ** 2):
        return False

    return True


def determine_sum(data, line):
    """
    determine whether the sum is same
    :param data:
    :param line:
    :return:
    """
    # we can make a flag sum firstly
    flag = sum([int(i) for i in data[0]])

    # 横向加和
    for i in range(0, line):
        temp = sum([int(i) for i in data[i]])
        if temp != flag:
            return False

    # 竖向加和
    index = 0
    for i in range(0, line):
        temp = 0
        while index < line:
            temp += int(data[i][index])
            index += 1
        index = 0
        if temp != flag:
            return False

    # the first element and the last element is special
    first_diagonal = sum([int(data[i][i]) for i in range(0, line)])

    # first_diagonal = 0
    # for i in range(0, line):
    #     first_diagonal += int(data[i][i])

    if first_diagonal != flag:
        return False

    # the last element diagonal sum
    last_diagonal = sum([int(data[i][i]) for i in range(line-1, -1, -1)])

    # last_diagonal = 0
    # for i in range(line-1, -1, -1):
    #     last_diagonal += int(data[i][i])

    if last_diagonal != flag:
        return False

    return True


def magic_matrix():
    data = []
    lines = input("")

    for i in range(0, int(lines)):
        line = input("")
        data.append(line.split())

    if determine_miss_repeat(data, int(lines)):
        if determine_sum(data, int(lines)):
            print("Magic square")
        else:
            print("Invalid data: inconsistent sums")

    else:
        print("Invalid data: missing or repeated number")


if __name__ == '__main__':
    magic_matrix()
