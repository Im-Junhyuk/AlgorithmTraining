str1 = input()
bomb = input()
bomb_len = len(bomb)

stack = []

for i in str1:
    stack.append(i)
    if i == bomb[-1]:
        if len(stack) >= bomb_len:
            last = ''.join(stack[-bomb_len:])
            if last == bomb:
                for j in range(bomb_len):
                    stack.pop()


if len(stack) == 0:
    print('FRULA')
else:
    print(''.join(stack))