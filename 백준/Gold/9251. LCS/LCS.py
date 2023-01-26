str1 = input()
str2 = input()

len1 = len(str1)
len2 = len(str2)
if len1 > len2:
    str1, str2 = str2, str1
    len1, len2 = len2, len1

arr = [[0 for col in range(len2 + 1)] for row in range(len1 + 1)]
for i in range(1, len1 + 1):
    for j in range(1, len2 + 1):
        if max(arr[i - 1][j], arr[i][j - 1]) >= min(i, j):
            arr[i][j] = max(arr[i - 1][j], arr[i][j - 1])
        elif str1[i-1] == str2[j-1]:
                arr[i][j] = arr[i-1][j-1] + 1
        else:
            arr[i][j] = max(arr[i - 1][j], arr[i][j - 1])

print(arr[len1][len2])
#print(arr)