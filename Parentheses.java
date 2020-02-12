
import java.util.Scanner;

public class Parentheses {
    static class stack{

        int top=-1;
        char[] items = new char[20];

        void push(char x)
        {
            if (top == 19)
            {
                System.out.println("Stack full");
            }
            else
            {
                items[++top] = x;
            }
        }

        char pop()
        {
            if (top == -1)
            {
                System.out.println("Underflow error");
                return '\0';
            }
            else
            {
                char element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty()
        {
            return top == -1;
        }
    static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '<' && character2 == '>')
            return true;
        else return character1 == '(' && character2 == ')';
    }
    static boolean ParenthesesBalanced(char[] exp)
    {
        stack st=new stack();
        for (char c : exp) {
            if (c == '(' || c == '<')
                st.push(c);
            if (c == ')' || c == '>') {


                if (st.isEmpty()) {
                    return false;
                } else if (!isMatchingPair(st.pop(), c)) {
                    return false;
                }
            }

        }

        return st.isEmpty();
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] exp = new char[input.length()];

        for(int i=0;i  < input.length(); i++){
            exp[i]=input.charAt(i);
        }
        if (ParenthesesBalanced(exp))
            System.out.println("True");
        else
            System.out.println("False");
    }

}}