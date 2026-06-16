class Solution:
    def isValid(self, s: str) -> bool:
        openToClose = {"]":"[", "}":"{", ")":"("}
        stack = []

        for c in s:
            if c in openToClose:
                if stack and stack[-1] == openToClose[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)
        if not stack:
            return True
        else:
            return False 
    

