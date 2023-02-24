import sys
sys.setrecursionlimit(10**9)

# make prerorder list
preorder = []
while 1:
    try:
        preorder.append(int(sys.stdin.readline()))
    except:
        break

# make postorder list
postorder = []


def make_postorder(start, end):
    if start > end:
        return

    root = preorder[start]
    left = start + 1
    right = end + 1  # default

    for i in range(left, end + 1):
        if preorder[i] > root:
            right = i
            break

    make_postorder(left, right - 1)
    make_postorder(right, end)
    postorder.append(root)


make_postorder(0, len(preorder) - 1)
for i in postorder:
    print(i)