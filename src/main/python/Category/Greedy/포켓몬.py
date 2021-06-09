
def solution (nums):
    return len(nums)/2 if len(set(nums)) >= len(nums)/2 else len(set(nums))
nums = [3,1,2,3]
print(solution(nums))

