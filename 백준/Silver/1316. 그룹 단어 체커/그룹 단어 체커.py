num_of_word = int(input())
num_of_gword = 0
for i in range(num_of_word):
    word = input()
    alphabet_list = []
    current = None
    for k in word:
        if current is None:#first
            current = k
        elif k != current:#new alphabet input
            if k in alphabet_list:#already have k
                num_of_gword -=1
                break
            else:    #get k first time
                alphabet_list.append(current)
                current = k
#        elif k == current:#new have k
            
    num_of_gword += 1
print(num_of_gword)
            