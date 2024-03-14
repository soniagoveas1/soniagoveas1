import java.util.Stack;

public class Parenthesization {
    /***
     * @param args tests to send to isReadable.
     */
    public static void main(String[] args) {
        //added additional text cases from lab spec
        String[] tests = {"(", "}", "({})", "", "([])", "()", "[](())", "[](([]))", ")(", "[}", "{[", "(([)]))"};
        for(int i = 0; i < tests.length; i++){
            System.out.println(tests[i]);
            boolean myBool = isReadable(tests[i]);
            if (myBool){
                System.out.println(" is readable");
            }
            else{
                System.out.println(" is NOT readable");
            }
        }
    }

     /**
      * @param s: inputted String which we will determine contains readable or unreadable parenthesis
      * @return if input is true or false
      * whether the parenthesis is readable or not readable (T or F)
      */
    public static boolean isReadable(String s) {
        
        //creating the stack which we will add the individual parts of the paranthesis to
        Stack<Character> testingStack = new Stack<>();
        
         //https://www.geeksforgeeks.org/java-string-tochararray-example/
         //toCharArray to be able to go through the list
         //iterates through each character of inputted String as chars
         for(char ch: s.toCharArray()){

            //checks for opening parentheses
            //if found, push to stack
            if(ch == '(' || ch == '[' || ch == '{'){
                testingStack.push(ch);

            //checks for closing parentheses
            //if found, check if stack is empty
            } else if (ch == ')' || ch == ']' || ch == '}') {

                //if stack is empty & there is a closing bracket
                //return false --> unreadable 
                if(testingStack.isEmpty()) {
                    return false;
                }
                
                //remove element from stack using pop
                char top = testingStack.pop();

                //check if closing parentheses is the top parentheses' match
                if((ch == ')' && top != '(' ) 
                    || (ch == ']' && top != '[') 
                    || (ch == '}' && top != '{')) {

                    //if they do not, return false 
                    return false;
                }
            }
        }

        //been through entire chars
        //if stack is empty, then all parentheses have a match
        return testingStack.isEmpty();
    }
}





