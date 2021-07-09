from collections import deque

def hasSingleCycle(array):
    visited = [False] * len(array)
    d = deque(array)
    current = 0
    pointer = 0
    for i in range(len(array)):
        if pointer > 0 and current == 0:
            return False
        visited[current] = True
        current = calculate(current, array)

    for i in visited:
        if current != 0 or i == False:
            return False

    return True


def calculate(current, array):
    jump = array[current]
    nextPointer = (current + jump) % len(array)
    return nextPointer if nextPointer >= 0 else nextPointer + len(array)
