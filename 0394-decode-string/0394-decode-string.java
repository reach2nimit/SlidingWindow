class Solution {
    public String decodeString(String s) {

        Deque<Integer> countStack = new ArrayDeque();
        Deque<StringBuilder> stringStack = new ArrayDeque();

        StringBuilder current = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch))
                k = k * 10 + (ch - '0');
            else if(ch == '['){
                countStack.push(k);
                stringStack.push(current);
                k = 0;
                current = new StringBuilder();
            }
            else if(ch == ']'){
                StringBuilder previous = stringStack.pop();
                int times = countStack.pop();

                for(int i = 0 ; i < times; i++)
                    previous.append(current);
                
                current = previous;
            }
            else
                current.append(ch);
        }
        return current.toString();
    }
}