N = int(input().strip())

paint_price = []
for i in range(N):
    list_input = list(map(int, input().strip().split()))
    paint_price.append(list_input)
    
price_R = paint_price[0][0]
price_G = paint_price[0][1]
price_B = paint_price[0][2]

for i in range(1,N):
    total_price_R = min(price_G, price_B) + paint_price[i][0]
    total_price_G = min(price_R, price_B) + paint_price[i][1]
    total_price_B = min(price_R, price_G) + paint_price[i][2]
    price_R = total_price_R
    price_G = total_price_G
    price_B = total_price_B
    
print(min(total_price_R, total_price_G, total_price_B))