word = input()
word = word.upper()
list = []
for i in range(0, 201):
    list.append(0)

for i in word:
    list[ord(i)] += 1

if list.count(max(list)) > 1:
    print('?')
else:
    print(chr(list.index(max(list))))
