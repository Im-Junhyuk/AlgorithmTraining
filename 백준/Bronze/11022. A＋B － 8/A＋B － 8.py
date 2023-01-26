case_num = int(input())

for i in range(1, case_num +1):
    input1, input2 = map(int, input().split())
    print('Case #' + str(i) + ':', input1, '+', input2 , '=', input1 + input2)