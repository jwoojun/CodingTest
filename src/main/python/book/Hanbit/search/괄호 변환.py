def balanced_bracket(p):
    count = 0
    for i in range(len(p)):
        if p[i] == "(":
            count += 1

        else:
            count -= 1

        if count == 0:
            return i


def proper_bracket(p):
    answer = ""
    count = 0
    for i in p:
        if i == "(":
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


def solution(p):
    if len(p) == 0:
        return ""

    index = balanced_bracket(p)
    u = p[:index + 1]
    v = p[index + 1:]

    if proper_bracket(u):
        return u + solution(v)

    else:
        t = "("
        t += solution(v)
        t += ")"
        u = list(u[1:-1])
        for i in range(len(u)):
            if u[i] == "(":
                u[i] = ")"
            elif u[i] == ")":
                u[i] = "("

        t += "".join(u)

        return t
print(solution(")("))