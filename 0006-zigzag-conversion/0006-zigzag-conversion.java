class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int n=s.length();
        int sec=(int)Math.ceil(n/(2*numRows-2.0));
        int col=sec*(numRows-1);
        char[][]matrix=new char[numRows][col];
            for(char[]row:matrix)
                Arrays.fill(row,' ');
        
        int currRow=0,currCol=0;
        int currInd=0;
        while(currInd<n)
        {
            while(currRow<numRows && currInd<n)
            {
                matrix[currRow++][currCol]=s.charAt(currInd++);
            }
            currRow-=2;
            currCol++;
            while(currRow>0 && currCol<col && currInd<n)
            {
                matrix[currRow--][currCol++]=s.charAt(currInd++);
            }
        }
        StringBuilder ans=new StringBuilder();
        for(char[]row:matrix)
        {
            for(char ch:row)
            {
                if(ch!=' ')
                    ans.append(ch);
            }
        }
        return ans.toString();
    }
}                                                                                       