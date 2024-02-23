package database;
import java.io.Console;

public class LL {
        public node head=null;
        private int size;
        class node {
        int ID1;
        int ID2;
        node next;

        node(int ID1,int ID2){
            this.ID1=ID1;
            this.ID2=ID2;
            next=null;
        }
    }

    public int getSize() {
        return size;
    }


    public node insert(int data1, int data2){
            node new_node=new node(data1,data2);

            if(head==null){
                head=new_node;
            }
            else{
                node temp=head;
                while(temp.next!=null){
                    temp=temp.next;

                }
                temp.next=new_node;
            }
            return head;
    }
    public void print(){
            int count=1;
            if(head==null){
                System.out.println("List Is Empty");
            }
            else{
                node temp=head;

                while (temp!=null){
//                    System.out.println("Count "+count+" Data1: "+temp.ID1+" Data2: "+temp.ID2);
                    System.out.printf("%-7s%-11s%-10s%n",count,temp.ID1,temp.ID2);
                    temp=temp.next;
                    count++;
                }
            }
    }

    public void delete(int data1,int data2){
        if (head==null){
            System.out.println("Does Not Exist");
        }
        else {
            if(head.ID1==data1&&head.ID2==data2){
                head=head.next;

            }
            else {
                node temp = head;
                while ((temp.next.ID1 != data1 && temp.next.ID2 != data2)) {
                    System.out.println(temp.ID1);
                    if(temp.next==null){
                        break;
                    }
                    temp = temp.next;

                }
                if (temp.next.ID1 == data1 && temp.next.ID2 == data2) {
                    //Last Node Case
                    if (temp.next.next == null) {
                        temp.next = null;
                    }
                    //First Node Case
                    else if (temp == head) {
                        head = head.next;
                    }
                    //Middle Node Case
                    else {
                        temp.next = temp.next.next;
                    }
                }
                // Not Found
                else {
                    System.out.println("Does Not Exist");
                }
            }
        }
    }



}
