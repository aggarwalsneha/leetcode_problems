class Solution {
    public static String[] map={ "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String>ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return ans;
        generate(new char[digits.length()],digits,0);
        return ans;
    }
    
    public void generate(char[] curr,String dig,int ind)
    {
        if(ind>=dig.length())
        {
            ans.add(String.valueOf(curr));
            return;
        }
        String letters=map[dig.charAt(ind)-'0'];
        for(int i=0;i<letters.length();i++){
            curr[ind]=letters.charAt(i);
            generate(curr,dig,ind+1);
        }
    }
}