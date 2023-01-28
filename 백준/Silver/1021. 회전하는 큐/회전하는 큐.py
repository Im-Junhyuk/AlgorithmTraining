from collections import deque

N, M = map(int, input().split())
num = list(map(int, input().split()))
total_rotate_num = 0

dq_card = deque([])
for i in range(1, N + 1):
    dq_card.append(i)

for i in num:
    card_index = dq_card.index(i)
    if card_index > len(dq_card) // 2:
        # rotate right
        rotate_num = len(dq_card) - card_index
        dq_card.rotate(rotate_num)
        total_rotate_num += rotate_num
        dq_card.popleft()

    else:
        # rotate left
        rotate_num = card_index
        dq_card.rotate(-rotate_num)
        total_rotate_num += rotate_num
        dq_card.popleft()

print(total_rotate_num)
        
    