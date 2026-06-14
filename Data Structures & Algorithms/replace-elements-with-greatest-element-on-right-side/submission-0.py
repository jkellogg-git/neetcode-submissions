class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        maxVal = -1
        right = len(arr) - 1
        for num in arr:
            tempIndex = arr[right]
            arr[right] = maxVal
            maxVal = max(tempIndex, maxVal)
            right -= 1
        return arr
        