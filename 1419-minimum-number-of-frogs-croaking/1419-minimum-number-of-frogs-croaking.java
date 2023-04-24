class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count=new int[4];
        int frogs=0,max=0;
        for(int i=0;i<croakOfFrogs.length();i++){
            char ch=croakOfFrogs.charAt(i);
            switch(ch){
                case 'c':
                    count[0]++;
                    frogs++;
                    max=Math.max(max,frogs);
                    break;
                case 'r':
                    if(count[0]==0)
                        return -1;
                    count[0]--;
                    count[1]++;
                    break;
                case 'o':
                    if(count[1]==0)
                        return -1;
                    count[1]--;
                    count[2]++;
                    break;
                case 'a':
                    if(count[2]==0)
                        return -1;
                    count[2]--;
                    count[3]++;
                    break;
                case 'k':
                    if(count[3]==0)
                        return -1;
                    count[3]--;
                    frogs--;
                    break;
            }
        }
        return frogs==0 ? max:-1;
    }
}