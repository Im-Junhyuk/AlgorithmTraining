def div(A, B, C):
    if B == 1:
        return A % C
    if B % 2 == 0:
        return div(A, B//2, C) ** 2 % C
    else:
        return A * (div(A, B//2, C) ** 2) % C


A, B, C = map(int, input().split())
print(div(A, B, C))
