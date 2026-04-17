class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Deque<String> st = new ArrayDeque();

        for(String comp : components){
            if(comp.equals("") || comp.equals("."))
                continue;
            
            if(comp.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(comp);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            StringBuilder temp = new StringBuilder(st.pop());
            sb.append(temp.reverse()).append("/");
        }

        return sb.length() == 0 ? "/" : sb.reverse().toString();
    }
}