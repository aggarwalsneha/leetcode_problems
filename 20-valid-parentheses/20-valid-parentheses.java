class Solution {
    public boolean isValid(String s) {
        Stack stack1 = new Stack();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack1.push(s.charAt(i));
            else
            {
                if(stack1.isEmpty())
                    return false;
            else if(stack1.peek()==map.get(s.charAt(i)))
                    stack1.pop();
            else
                return false;
                    
            }
           }
        if(stack1.isEmpty())
                return true;
        return false;
    }
}