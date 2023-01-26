num_of_case = int(input())

for i in range(num_of_case):
    scores = list(map(int,input().split()))
    num_of_student = scores.pop(0)
    avg_score = sum(scores)/num_of_student
    better_than_avg = 0
    for k in scores:
        if k > avg_score:
            better_than_avg += 1
    rate = better_than_avg/num_of_student*100
    print('{:.3f}%'.format(rate))