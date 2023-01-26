import sys


def what_num(num):
    num_found = 0
    i = 1
    while True:
        i_copy = i
        count6 = 0
        while i_copy > 0:
            if i_copy % 10 == 6:
                count6 += 1
                if count6 == 3:
                    num_found += 1
                    # print(i)
                    if num_found == num:
                        return i
            else:
                count6 = 0
            i_copy = i_copy // 10
        i += 1


num = int(sys.stdin.readline())
print(what_num(num))