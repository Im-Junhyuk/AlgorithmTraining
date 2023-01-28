import sys


def make_seq():
    next_input = 1
    for i in range(n):
        num = int(sys.stdin.readline())

        if len(stack) == 0:
            for i in range(next_input, num+1):
                stack.append(i)
                result.append('+')
            del stack[-1]
            result.append('-')
            next_input = num + 1

        elif stack[-1] == num:
            del stack[-1]
            result.append('-')

        elif stack[-1] < num:
            if num not in stack:
                for i in range(next_input, num + 1):
                    stack.append(i)
                    result.append('+')
                next_input = num + 1
            del stack[-1]
            result.append('-')

        elif stack[-1] > num:
            print('NO')
            return 0

    return 1


n = int(sys.stdin.readline())
stack = []
result = []
# input_list = [x for x in range(1, n + 1)]
if make_seq() == 1:
    print('\n'.join(result))



