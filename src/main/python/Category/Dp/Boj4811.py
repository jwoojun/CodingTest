lst = [1]
for i in range(int(input())) :
    lst.append(lst[i]*3-1)

lst.append(0)
print(lst)
