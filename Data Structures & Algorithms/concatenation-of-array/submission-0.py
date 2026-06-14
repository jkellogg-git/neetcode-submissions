class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        ans = []
        m = 0
        for i in range(len(nums) * 2):
            if i == (len(nums)):
                m = 0
            ans.append(nums[m])
            m += 1
        return ans 