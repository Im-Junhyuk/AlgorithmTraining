exp = input()
no_sub_exp = exp.split('-')
for i in range(0,len(no_sub_exp)):
    no_op_exp = no_sub_exp[i].split('+')
    no_sub_exp[i] = sum(map(int, no_op_exp))

#print(no_sub_exp)
result = no_sub_exp[0]
for i in range(1, len(no_sub_exp)):
    result -= no_sub_exp[i]

print(result)