# 사각형 크기, 시작 좌표 rc, 받음, 재귀 함수
def d_c(n, this_r, this_c):
    global r, c, i

    # n == 0 이면 자기 자신 확인 후 return i
    if n == 0:

        # 현재 위치가 목표면 탈출
        if this_r == r and this_c == c:
            print(i)
            return
        i = i + 1
        return

    # 좌표에 더해줄 값
    j = 2 ** (n - 1)

    # 첫번째 사각형 호출
    if this_r <= r < this_r + j and this_c <= c < this_c + j:
        d_c(n - 1, this_r, this_c)
    else:
        i = i + j * j
        
    # 두번째 사각형 호출
    if this_r <= r < this_r + j and this_c + j <= c < this_c + j * 2:
        d_c(n - 1, this_r, this_c + j)
    else: 
        i = i + j * j
        
    # 세번째 사각형 호출
    if this_r + j <= r < this_r + j * 2 and this_c <= c < this_c + j:
        d_c(n - 1, this_r + j, this_c)
    else:
        i = i + j * j
        
    # 네번째 사각형 호출
    if this_r + j <= r < this_r + j * 2 and this_c + j <= c < this_c + j * 2:
        d_c(n - 1, this_r + j, this_c + j)
    else:
        i = i + j * j

# 조건 입력
n, r, c = map(int, list(input().strip().split()))
i = 0
# 첫번째 사각형 호출
d_c(n, 0, 0)
