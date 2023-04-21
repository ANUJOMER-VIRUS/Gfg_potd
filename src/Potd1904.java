public class Potd1904 {
    boolean wifiRange(int N, String S, int X)
    {
    int st=0;
    while (st<N && S.charAt(st)!='1'){
        st++;
    }
    if(st==N||st>X){
        return false;
    }
    int last=st;
        for (int i = st; i <N ; i++) {
            if(i-last+1>2*(X+1)){
                return false;
            }
            if(S.charAt(i)=='1'){
                last=i;
            }
        }
        if(N-last>X+1){
            return false;
        }

        return true;
    }
}
