def hansu(N):
    num_of_hansu = 0
    for i in range(1,N + 1):
        if i < 100:
            num_of_hansu += 1
        else:
            third = i %10
            i = i//10
            sec = i %10
            i = i//10
            first = i
            if 2 * sec == first + third:
                num_of_hansu += 1
    return num_of_hansu
                
N = int(input())
print(hansu(N))