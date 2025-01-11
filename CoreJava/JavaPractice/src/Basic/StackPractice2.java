package Basic;

class Stack2 {
    private int[] stack;
    private int topOfStack;

    Stack2(int size){
        stack = new int[size];
        topOfStack=-1;
    }

//    push an item onto the stack
    void push(int item){
        if(topOfStack==stack.length-1){
            System.out.println("Stack is full");
        } else {
            stack[++topOfStack] = item;
        }
    }

//    pop an item from the stack
    int pop(){
        if(topOfStack < 0){
            System.out.println("Stack underflow.");
            return 0;
        } else {
            return stack[topOfStack--];
        }
    }
}

public class StackPractice2 {
    public static void main(String[] args) {
        Stack2 mystack1 = new Stack2(5);
        Stack2 mystack2 = new Stack2(8);

//        push some numbers onto the stack
        for (int i=0;i<5;i++)
            mystack1.push(i);
        for (int j=0;j<8;j++)
            mystack2.push(j);

//        pop those numbers off the stack
        System.out.println("stack in mystack1.");
        for (int i=0;i<5;i++)
            System.out.println(mystack1.pop());

        System.out.println("stack in mystack2");
        for (int j=0;j<8;j++)
            System.out.println(mystack2.pop());
    }
}
