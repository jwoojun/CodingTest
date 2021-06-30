


def convert_2(arr):
    result = 0
    for a in arr:
        result |= (1 << a)
    return result

print(convert_2([1,2,3]))