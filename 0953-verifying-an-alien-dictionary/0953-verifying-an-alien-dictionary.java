class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr=new int[26];
        for(int i=0;i<order.length();i++)
        {
            arr[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                if(j>=words[i+1].length())
                    return false;
                if(words[i].charAt(j)!=words[i+1].charAt(j))
                {
                    int curr=words[i].charAt(j)-'a';
                    int next=words[i+1].charAt(j)-'a';
                    if(arr[curr]>arr[next])
                        return false;
                    else
                        break;
                }
            }
        }
        return true;
    }
}