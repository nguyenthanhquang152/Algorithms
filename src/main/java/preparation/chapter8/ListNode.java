package preparation.chapter8;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;
    public ListNode(){
    }
    public ListNode(T data, ListNode<T> next){
        this.data = data;
        this.next = next;
    }

    public static void printNode(ListNode<?> node){
        System.out.print("[ ");
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static int length(ListNode<?> node){
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}
