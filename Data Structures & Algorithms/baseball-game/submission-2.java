class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int sum = stack.peek() + top;
                score += sum;
                stack.push(top);
                stack.push(sum);
            } else if (op.equals("C")) {
                int top = stack.pop();
                score -= top;
            } else if (op.equals("D")) {
                int top = stack.peek();
                int sum = top * 2;
                stack.push(sum);
                score += sum;
            } else {
                stack.push(Integer.parseInt(op));
                score += Integer.parseInt(op);
            }
        }
        return score;
    }
}