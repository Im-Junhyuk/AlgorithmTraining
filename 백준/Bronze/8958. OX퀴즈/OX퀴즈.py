num_of_string = int(input())
for i in range(num_of_string):
    string = input()
    num_of_O = 0
    score = 0
    for k in string:
        if k == 'O':
            num_of_O += 1
            score += num_of_O
        else:
            num_of_O = 0
    print(score)