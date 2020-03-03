
def roman(numbers):
    """
    convert roman to number
    :param numbers: romans number
    :return:
    """
    data = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    res = []
    for num in numbers:
        res.append(data[num])

    sum = 0
    for i in range(0, len(res)):
        if i >= 1:
            if res[i] > res[i-1]:
                sum += int(res[i])
                sum -= 2 * int(res[i-1])
            else:
                sum += int(res[i])
        else:
            sum += int(res[i])

    return sum


if __name__ == '__main__':
    print(roman('II'))  # 2
    print(roman('IV'))  # 4
    print(roman('IX'))  # 9
    print(roman('XIX'))  # 19
    print(roman('XX'))  # 20
    print(roman('MDCCLXXVI'))  # 1776
    print(roman('MMXIX'))  # 2019