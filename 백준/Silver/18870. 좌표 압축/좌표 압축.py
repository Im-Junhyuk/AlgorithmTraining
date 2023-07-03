# 입력 받기
input_num = int(input())
input_list = list(map(int, input().split()))

# 중복 제거
input_set = set(input_list)

# 정렬하기
sorted_list = sorted(list(input_set))

# dict 생성
order_dict = dict()

# 번호 메기기
for order, value in enumerate(sorted_list):
    order_dict[value] = order

# 출력
for i in input_list:
    print(order_dict[i], end=" ")


