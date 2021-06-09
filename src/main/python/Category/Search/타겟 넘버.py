def solution(numbers, target):
    count = 0
    def operator(numbers, target, index=0):
        if index < len(numbers):
            numbers[index] *= 1
            operator(numbers, target, index+1)
            numbers[index] *= -1
            operator(numbers, target, index+1)

        elif sum(numbers) == target:
            nonlocal count
            count += 1
            operator(numbers, target)

        return count