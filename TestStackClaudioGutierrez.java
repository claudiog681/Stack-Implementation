// Class:		Data structures Section 03
// Term:		Spring 2022
// Name:		Claudio Gutierrez
// Program Number:	Assignment 3
// IDE: 		Intelli J java13jdk

package Assignment3;


import java.util.Scanner;

public class TestStackClaudioGutierrez {
    public static void main(String[] args){
        MyStackClaudioGutierrez stack= new MyStackClaudioGutierrez();
        Scanner input= new Scanner(System.in);


        int menu= 0;//variable to declare state in menu
        do{//main loop for menu and program
            System.out.println("-----Main Menu-----\n" +//print menu options
                                "0 - Exit Program\n" +
                                "1 - Push\n" +
                                "2 - Pop\n" +
                                "3 - Peek (TOP)\n" +
                                "4 - Size\n" +
                                "5 - Is Empty\n" +
                                "6 - Print Stack\n" +
                                "Choose Menu:");
            menu= input.nextInt();//take user input
            if (menu>6)//out of bounds exception
                new Exception("out of bounds");

            switch(menu){//switch statments to select operation
                case 0://exit program
                    break;
                case 1://push user defined element into stack
                    System.out.println("Enter string to push");
                    input.nextLine();
                    String push= input.nextLine();
                    stack.push(push);
                    break;
                case 2://print popped element
                    System.out.println(stack.pop());
                    break;
                case 3://peek stack
                    System.out.println(stack.peek());
                    break;
                case 4://print stack size
                    System.out.println("Stack Size:" + stack.size());
                    break;
                case 5://declare if stack is empty
                    System.out.println("Is Stack Empty: " + stack.isEmpty());
                    break;
                case 6://print entire stack
                    System.out.println(stack.toString());
            }
        }while(menu!=0);

        System.out.println("Program ended");
    }



}
