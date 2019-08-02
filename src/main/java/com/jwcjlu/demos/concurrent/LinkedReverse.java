package com.jwcjlu.demos.concurrent;

import lombok.ToString;

/**
 * Created by jwcjlu on 2019/5/28.
 */
public class LinkedReverse {
    public static void main(String[] args) {
        Node n1=new Node(null ,1);
        Node n2=new Node(n1 ,2);
        Node n3=new Node(n2 ,3);
        Node n4=new Node(n3 ,4);
        Node d=reverse(n4);
        System.out.println(n1);
        System.out.println(d);

    }
    public static Node reverse(Node head){
        Node pr,p;
        p=head.next;
        head.next=null;
        while(p!=null){
            pr=p.next;
            p.next=head;
            head=p;
            p=pr;

        }

        return head;
    }











 /*   public static Node reverse(Node head){
        Node pr,p;
        p=head.next;
        head.next=null;
        while(p!=null){
            pr=p.next;
            p.next=head;
            head=p;
            p=pr;
        }
        return head;
    }*/


}
@ToString
class Node{
    Node next;
    int value;
    public Node(Node next,int value){
        this.next=next;
        this.value=value;
    }
}