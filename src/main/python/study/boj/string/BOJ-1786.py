def kmp(s,p) :
    j = 0
    count = 0
    pos = []
    for i in range(len(s)) :
        while j > 0 and s[i] != p[j] :
            j = table[j-1]

        if s[i] == p[j] :
            j += 1
            if j == len(p) :
                count += 1
                pos.append(i-len(p)+2)
                j = table[j-1]

    return count, poss

