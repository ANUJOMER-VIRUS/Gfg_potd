class Potd2004{
    static int lev;
    static boolean f;
    static int ans;
    static void dfs(Node root, int home, int k){
        if(root == null)    return;
        if(root.data == home){
            f = true;
            lev = 0;
            ans = home;
            lev++;
            dfs(root.left, home, k);
            lev--;
            lev++;
            dfs(root.right, home, k);
            lev--;
        }else{
            if(!f){
                dfs(root.left, home, k);
                if(f){
                    lev++;
                    lev++;
                    dfs(root.right, home, k);
                    lev--;
                    if(f && lev<=k)
                        ans += root.data;
                }else{
                    dfs(root.right, home, k);
                    if(f){
                        lev++;
                        if(lev<=k){
                            lev++;
                            dfs(root.left, home, k);
                            lev--;
                            ans += root.data;
                        }
                    }
                }
            }else{
                lev++;
                dfs(root.left, home, k);
                lev--;
                lev++;
                dfs(root.right, home, k);
                lev--;
                if(f && lev<=k)
                    ans += root.data;
            }
        }
    }
    static int ladoos(Node root, int home, int k){
        // Your code goes here
        ans = 0;
        f = false;
        dfs(root, home, k);
        return ans;
    }
}