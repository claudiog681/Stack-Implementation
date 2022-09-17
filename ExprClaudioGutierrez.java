// Class:		Data structures Section 03
// Term:		Spring 2022
// Name:		Claudio Gutierrez
// Program Number:	Assignment 3
// IDE: 		Intelli J java13jdk
package Assignment3;

import java.util.Scanner;

public class ExprClaudioGutierrez {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String menu= "";

        do {
            System.out.println("Enter an infix:");//Ask for user input
            String infix= input.nextLine();

            String post= infixToPostfix(infix);//Use input to convert to postfix
            System.out.println("Postfix Expression: " + post);//print postfix expression

            System.out.println("Result Value: " + postfixEval(post));//calculate post fix result and print

            System.out.println("Would you like to continue: (Y/N)");//ask to continue program
            menu= input.nextLine();
        }while(menu.contains("y"));
        System.out.println("Program ended");
    }

    public static String infixToPostfix(String infix){

        String result = "";// create string to hold result


        MyStackClaudioGutierrez<Character> stack = new MyStackClaudioGutierrez();// Create stack to Character class

        for (int i = 0; i<infix.length(); i++) {//traverse expression
            char oper = infix.charAt(i);


            if (Character.isDigit(oper))//check for operand, if so add it to the output
                result += oper;


            else if (oper == '(')//push ( into the stack
                stack.push(oper);


            else if (oper == ')') {//pop until ( is checked
                while (stack.isEmpty()== false && stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            }
            else{//if an there is an operator
                while (stack.isEmpty()== false && order(oper) <= order(stack.peek())){

                    result += stack.pop();
                }
                stack.push(oper);
            }

        }


        while (stack.isEmpty()== false){//pop all remaining operators
            result += stack.pop();
        }
        return result;
    }

    public static double order(char ch) {//define the order of operations
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return 0;
    }
    static double postfixEval(String postfix)
    {

        MyStackClaudioGutierrez<Double> stack=new MyStackClaudioGutierrez<>();//create a stack


        for(int i=0;i<postfix.length();i++)//check all characters postfix
        {
            char oper=postfix.charAt(i);//get char at index


            if(Character.isDigit(oper))//chack for operand and push into stack
                stack.push((double) (oper - '0'));


            else//if operator pop top 2 elements from stack and calculate
            {
                double value1 = stack.pop();

                double value2 = stack.pop();

                switch(oper)
                {
                    case '+':
                        stack.push(value2+value1);
                        break;

                    case '-':
                        stack.push(value2- value1);
                        break;

                    case '/':
                        stack.push(value2/value1);
                        break;

                    case '*':
                        stack.push(value2*value1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
