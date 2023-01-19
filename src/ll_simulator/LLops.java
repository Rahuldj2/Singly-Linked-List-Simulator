/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ll_simulator;

/**
 *
 * @author Rahul
 */

/*
THIS FILE HAS A CLASS WHICH CONTAINS CODE FOR DIFFERENT LINKED LIST OPERATIONS
*/

public class LLops {
    
    int dataFlag = 0;
    class Node {
        int data;
        Node next;
        
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    
//    public class ops {
    Node head;
        
    void push(int data)
    {
        Node newNode = new Node(data);
        if (head==null)
        {
            head = newNode;
            return;
        }

        Node temp = head;
        newNode.next = temp;
        head = newNode;   
    }
    
    void append(int data)
    {
        Node newNode = new Node(data);
        if (head==null)
        {
            head = newNode;
            return;
        }
        
        Node temp = head;
        while (temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    int countNodes()
    {
        if (head==null)
        {
            return 0;
        }
        int num = 0;
        Node temp = head;
        
        while (temp!=null)
        {
            num++;
            temp = temp.next;
        }
        return num;
    }
    
    
    boolean search(int data)
    {
        if (head==null)
        {
            return false;
        }
        Node temp = head;
        while (temp!=null)
        {
            if (temp.data == data)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    void delete(int pos)
    {
        if (head==null)
        {
            System.out.println("EMPTY LIST");
            return;
        }
        
        if (pos<=1)
        {
            //delete at beginning
            Node temp = head;
            temp = temp.next;
            head = temp;
        }
        else if (pos>=countNodes())
        {
            //delete at end
            Node temp = head;
            Node prev = temp;
            while (temp.next!=null)
            {
                prev = temp;
                temp = temp.next;
            }
            if (countNodes()==1)
            {
                head=null;
                return;
            }
            temp = null;
            prev.next = null;
            
        }
        else
        {
            int i=1;
            Node temp = head;
            while (i<pos-1 && temp.next != null)
            {
                i++;
                temp = temp.next;
            }
            //temp is at pos-1
            Node toDel = temp.next;
            
            temp.next = toDel.next;
        }
    }
    
    void deleteByData(int data)
    {
        if (head==null)
        {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        Node prev = null;
        while (temp!=null)
        {
            if (head.data==data)
            {
                dataFlag=1;
                head = head.next;
                break;
            }
            if (temp.data==data)
            {
                dataFlag=1;
                prev.next = temp.next;
                temp = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    void printList()
    {
        if (head==null)
        {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        while (temp != null)
        {
         System.out.print(temp.data+ " ");
         temp = temp.next;
        }
        System.out.println();
    }
}
