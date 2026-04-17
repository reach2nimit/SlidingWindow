class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> st = new ArrayDeque();

        for(String comp : components){
            if(comp.equals("") || comp.equals("."))
                continue;
            
            if(comp.equals("..")){
                if(!st.isEmpty())
                    st.pollLast();
            }
            else{
                st.offerLast(comp);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            
            sb.append("/");
            sb.append(st.pollFirst());
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}