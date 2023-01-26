num_of_subject = int(input())

scores = list(map(int,input().split()))

max_score = max(scores)

avg_score = sum(scores)/ num_of_subject
avg_score = avg_score / max_score * 100
print(avg_score)