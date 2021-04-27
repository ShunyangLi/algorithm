
def isAnagram(s, t):
    data = {}

    for i in s:
        if i not in data:
            data[i] = 1
        else:
            data[i] += 1

    for i in t:
        if i not in data:
            return False
        else:
            if data[i] == 0:
                return False
            else:
                data[i] -= 1

    for key, val in data.items():
        if data[key] != 0:
            return False

    return True


if __name__ == '__main__':
    res = isAnagram("ab", "a")
    print(res)
