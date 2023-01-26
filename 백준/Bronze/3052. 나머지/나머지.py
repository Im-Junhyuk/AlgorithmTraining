list = []
for i in range(10):
    result = int(input()) % 42
    if result not in list:
        list.append(result)

print(len(list))