import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String string="(a)()())()";
		RemoveInvalidParentheses testInvalidParentheses=new RemoveInvalidParentheses();
		System.out.println(testInvalidParentheses.removeInvalidParenthese(string));
		
	}
    public List<String> removeInvalidParenthese(String s){
     List<String> ansList=new ArrayList<>();
     if(s==null||s.length()==0){
    	 ansList.add("");
    	 return ansList;
     }
     //remove procceding ")"
    int i=0;
    for (int j = 0; j < s.length(); j++) {
		if(s.charAt(i)!='('){
			i++;
		}
		else {
			break;
		}
	}
    s=s.substring(0, i).replace(")", "")+((i == s.length())?"" : s.substring(i, s.length()));
    //remove trails"("
    int k=s.length()-1;
    for (int j = k; j>=0; j--) {
		if(s.charAt(k)!=')'){
			k--;
		}
		else {
			break;
		}
	}
    s=s.substring(k+1, s.length()).replace("(", "")+((k ==0)?"" : s.substring(0, k+1));
    Queue<String> queue=new LinkedList<>();
    Set<String> visited=new HashSet<>();
    queue.offer(s);
    visited.add(s);
    boolean found=false;
    while (!queue.isEmpty()) {
    	s=queue.poll();
    	if (isValid(s)) {
			ansList.add(s);
			found=true;
		}
    	if (found) {
			continue;
		}
		for (int j = 0; j < s.length(); j++) {
			if(s.charAt(j)!='('&&s.charAt(j)!=')'){
				continue;
			}
			String t=s.substring(0,j)+s.substring(j+1);
			if (!visited.contains(t)) {
				visited.add(t);
				queue.offer(t);
			}
		}
		
	}
    return ansList;
   
    		
}
 public Boolean isValid(String s){
	Stack<Character> stack=new Stack<>();
	for (char c : s.toCharArray()) {
		if (c=='(') {
			stack.push(c);
		}
		if (c==')') {
			if (!stack.isEmpty()) {
				stack.pop();
			}else {
				return false;
			}
		}
	}
	return stack.isEmpty();
		
	}
}
