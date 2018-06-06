/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
*/


public int calculate(String s) {
    Deque<Integer> stack = new LinkedList<>();
    int sum = 0;
    int cur = 0;
    int sign = 1;
    for(int i = 0; i < s.length(); i++){
    	if(Character.isDigit(s.charAt(i))){
    		cur *= 10;
    		cur += s.charAt(i) - '0';
    	}
    	else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
    		sum += sign * cur;
    		sign = s.charAt(i) == '+' ? 1 : -1;
    		cur = 0;
    	}
    	else if(s.charAt(i) == '('){
    		stack.offerFirst(sum);
    		stack.offerFirst(sign);
    		sum = 0;
    		sign = 1;
    	}
    	else if(s.charAt(i) == ')'){
    		sum += (cur * sign);
            sum *= stack.pollFirst();
            sum += stack.pollFirst();
    		cur = 0;
    	}
    }
    if(cur != 0){
    	sum += cur * sign;
    }

    return sum;
}