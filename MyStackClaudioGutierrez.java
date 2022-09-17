// Class:		Data structures Section 03
// Term:		Spring 2022
// Name:		Claudio Gutierrez
// Program Number:	Assignment 3
// IDE: 		Intelli J java13jdk
package Assignment3;


public class MyStackClaudioGutierrez<T> {
    //linked list to implement stack
    Node head;
    Node tail;
    int size;

    public class Node {//create node class
        T data;
        Node link;

        Node() {//no arg Node constructor
        }

        Node(T element) {//generic input constructor
            data = element;
            link = null;
        }
    }

    public MyStackClaudioGutierrez() {//linked list to be used as stack constructor
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {//returns ture if list is empty and false if not
        if(size==0)
            return true;
        else
            return false;
    }

    public int size() {//returns size
        return size;
    }

    public T peek() throws RuntimeException {//returns the element that is on top of the stack throws exception of stack is empty
        if (size <= 0)//if empty throw runtime exception
            throw new RuntimeException("No elements in this stack");
        else if (size == 1)//if stack has 1 element return head as top element
            return head.data;
        else//if stack has more than one element return tail as top element
            return tail.data;
    }

    public T pop() {//return top element then remove the top element
        if (size <= 0)//if the stack is empty throw runtime exception
            throw new RuntimeException("No elements in this stack");
        else if (size == 1) {//if stack has 1 element
            Node top = head;//temporary node that holds the top element
            head= tail= null;//point head node to tail and make both null
            size--;//reduce stack size
            return top.data;//return top element
        }
            else{//if stack has more than 1 element
                Node temp = head;//temporary node
                for (int i = 1; i < size - 1; i++) {//traverse stack to get node that points to tail
                    temp = temp.link;
                }
                Node top = tail;//temporary node that holds top element
                temp.link = null;//delete pointer to tail
                tail = temp;//initialize new tail
                size--;//reduce stack size
                return top.data;//return top element
            }
        }



    public void push(T element) {//add new element to top of stack
        Node newNode= new Node(element);//node with element
        if(size<=0){//if stack is empty
            newNode.link= head;//new node pointer to head
            head=newNode;//new node is head node or top of stack
            tail=newNode;
            size++;//increase size

        }
        else{//if node has 1 or more elements
            tail.link=newNode;//tail pointer points to new node
            tail=newNode;//new node is now the tail and top of stack
            size++;//increase size
        }

    }

    @Override
    public String toString() {//To string method to print whole stack
        String str = "[";
        MyStackClaudioGutierrez.Node temp = head;

        while(temp != null) {//while current node is not empty
            str = str + temp.data;
            if(temp != tail) {
                str = str + ", ";
            }
            temp = temp.link;
        }
        return str = str + "]";

    }


}
