class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxCount = 0
        current = 0
        #nums=[1,1,0,1,1,1]
        for num in nums:
            if num == 1:
                current += 1
            else:
                maxCount = max(maxCount, current)
                current = 0
            maxCount = max(maxCount, current)
        return maxCount
        