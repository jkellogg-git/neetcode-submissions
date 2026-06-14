class Solution:
    def calPoints(self, operations: List[str]) -> int:
        sum = 0
        stack = []
        for i in range(len(operations)):
            if operations[i] == "+":
                num = int(stack[len(stack)-2] + stack[len(stack) -1])
                stack.append(num)
                sum += num
            elif operations[i] == "D":
                num = stack[len(stack)-1] * 2
                stack.append(num)
                sum += num
            elif operations[i] == "C":
                sum -= stack[len(stack) - 1]
                stack.pop()
            else:
                stack.append(int(operations[i]))
                sum += int(operations[i])
        return sum
                    
        