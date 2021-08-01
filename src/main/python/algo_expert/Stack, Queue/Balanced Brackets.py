def balancedBrackets(string) :
    startBrackets = "([{"
    endBrackets =")]}"
    setBrackets = {")":"(", "]":"[", "}":"{"}

    answer = []
    for char in string :
        if char in startBrackets :
            answer.append(char)

        elif char in endBrackets :
            if len(answer) == 0 :
                return False

            if answer[-1] == setBrackets[char] :
                answer.pop()

            else :
                return False

    return len(answer) == 0