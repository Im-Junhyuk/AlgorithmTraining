N, K = map(int, input().split())

temp = list(map(int, input().split()))
temp_sum = []
temp_sum.append(sum(temp[:K]))

# len(temp_sum) = len(temp) - K + 1
# former sum - fir element + new element
for i in range(len(temp) - K):
    temp_sum.append(temp_sum[i] - temp[i] + temp[i + K])

print(max(temp_sum))
#print(temp_sum)