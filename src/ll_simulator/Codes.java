/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ll_simulator;

/**
 *
 * @author Rahul
 */
public class Codes {
    
     String javaPush = """
                    class Node {
                            int data;
                            Node next;
                            
                            Node(int data)
                            {
                                this.data = data;
                                this.next = null;
                            }
                        }
                       
                       
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
                      """;
    
    String CPush = """
    struct Node
    {
      int data;
      struct Node *next;
    };

    struct Node* push(struct Node* head, int data)
    {
        struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));
        new_node->data  = data;
        if (head==NULL)
        {
          head = new_Node;
          return head;
        }
        struct Node *temp = head;
        new_node->next = temp;
        head = new_Node;
        return head;
    }
                   """;
    
    String javaAppend = """
                         class Node {
                            int data;
                            Node next;
                            Node(int data)
                            {
                                this.data = data;
                                this.next = null;
                            }
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
                        """;
    
    String javaDelPos = """
                        class Node {
                                int data;
                                Node next;
                                
                                Node(int data)
                                {
                                    this.data = data;
                                    this.next = null;
                                }
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
                                    //delete in middle
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
                        """;
    String javaDelData = """
                         class Node {
                            int data;
                            Node next;

                            Node(int data)
                            {
                                this.data = data;
                                this.next = null;
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
                                    head = head.next;
                                    break;
                                }
                                if (temp.data==data)
                                {
                                    prev.next = temp.next;
                                    temp = null;
                                    break;
                                }
                                prev = temp;
                                temp = temp.next;
                            }
                        }
                         """;

    String javaSearch = """
                        class Node {
                                int data;
                                Node next;
                                
                                Node(int data)
                                {
                                    this.data = data;
                                    this.next = null;
                                }
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
                        """;
    
    String cAppend = """
                    struct Node
                    {
                      int data;
                      struct Node *next;
                    };

                    struct Node* append(struct Node* head, int data)
                    {
                        struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));
                        new_node->data  = data;
                        if (head==NULL)
                        {
                          head = new_Node;
                          return head;
                        }
                        struct Node *temp = head;
                        while (temp->next!=NULL)
                        {
                          temp = temp->next;
                        }
                        temp->next = new_Node;
                        return head;
                    }

                     """;
    String cDelPos = """
                    struct Node
                    {
                      int data;
                      struct Node *next;
                    };
                    struct Node *delete(struct Node *head, int pos) {
                      /*Deletes Node at position pos. pos>0.
                        If pos> list length then deletes last node.
                        If pos<1 deletes first node.
                      */
                      struct Node *prev, *temp;
                      if (head==NULL) return NULL;
                      else
                        if (pos<=1) {temp=head; head=head->next; free(temp);}
                        else {//pos>1
                        int i;
                        prev=head;
                        i=1;
                        while (i++<pos-1 && (prev->next)->next!=NULL) {
                          prev=prev->next;
                        }
                        temp=prev->next;//node to be deleted
                        prev->next=(prev->next)->next;//node removed from list
                        free(temp);//send memory back to store
                      }
                      return head;
                    }
                     """;
    
    String cDelData = """
                    struct Node
                    {
                      int data;
                      struct Node *next;
                    };
                     
                    struct Node *deleteByData(struct Node *head, int val) 
                    {
                      
                      struct Node *prev, *temp;
                      if (head==NULL)
                      {
                        return NULL;
                      }
                      prev = NULL;
                      temp = head;

                      while (temp!=null)
                      {
                        if (head.data==val)
                        {
                          head = head->next;
                          break;
                        }
                        if(temp->data==val)
                        {
                          prev->next=temp->next;
                          free(temp);
                          break;
                        }
                        prev = temp;
                        temp = temp->next;
                      }
                      return head;
                    }  
                      """;
    
    
    String cSearch = """
                    struct Node
                    {
                      int data;
                      struct Node *next;
                    };
                     
                    int search(int data)
                    {
                        if (head==NULL)
                        {
                            return 0;
                        }
                        struct Node* temp = head;
                        while (temp!=null)
                        {
                            if (temp=->data == data)
                            {
                                return 1;
                            }
                            temp = temp->ext;
                        }
                        return 0;
                    }
                     """;
}
