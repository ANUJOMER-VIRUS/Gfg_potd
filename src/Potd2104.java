public class Potd2104 {
    private boolean isPrefix(String s1,String s2){
        if(s1.length()>=s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                return false;
        }
        return true;
    }
    private boolean isSuffix(String s1,String s2){
        if(s1.length()>=s2.length())
            return false;
        for(int i=s1.length()-1;i>=0;i--){
            if(s1.charAt(i)!=s2.charAt(s2.length() - s1.length() + i))
                return false;
        }
        return true;
    }

    public int prefixSuffixString(String s1[],String s2[])
    {
        int cnt=0;
        for(int i=0; i<s2.length;i++) {
            for (String element: s1) {
                if(isSuffix(s2[i],element)||isPrefix(s2[i],element)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String s1[]={"cat", "catanddog", "lion"};
        String s2[]={"cat", "dog", "rat"};

System.out.println(new Potd2104().prefixSuffixString(s1,s2));
    }
}
