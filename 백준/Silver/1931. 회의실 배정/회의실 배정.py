import sys

N = int(sys.stdin.readline())
m_time = []
for i in range(N):
    m_time.append(list(map(int, sys.stdin.readline().split())))

m_time.sort(key=lambda x: (x[1], x[0]))
last_end = 0
m_cnt = 0

for start, end in m_time:
    if start >= last_end:
        m_cnt += 1
        last_end = end

print(m_cnt)