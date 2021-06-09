class MinMaxStack:
    # 초기화.
    def __init__(self):
        self.minMaxStack = []
        self.stack = []

    # 원본 데이터의 변동없이 가장 위의 값을 가지고 오는 것.
    def peek(self):
        return self.stack[len(self.stack) - 1]


    # 원본 데이터의 가장 오른쪽 값을 빼는 것.
    def pop(self):
        self.minMaxStack.pop()
        return self.stack.pop()


    # 원본 데이터에 데이터를 추가하는 것.
    def push(self, number):
        newMinMax = {"min": number, "max": number}
        if len(self.minMaxStack):
            lastMinMax = self.minMaxStack[len(self.minMaxStack) - 1]
            newMinMax["min"] = min(lastMinMax["min"], number)
            newMinMax["max"] = max(lastMinMax["max"], number)

        self.minMaxStack.append(newMinMax)
        self.stack.append(number)


    # 가장 최소값을 return.
    def getMin(self):
        return self.minMaxStack[len(self.minMaxStack) - 1]["min"]


    # 가장 최댓값을 return.
    def getMax(self):
        return self.minMaxStack[len(self.minMaxStack) - 1]["max"]


# 출처 : https://www.algoexpert.io/questions/Min%20Max%20Stack%20Construction