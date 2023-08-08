/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm2_p5;

import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Myqueue mq = new Myqueue(); 
        Mystack ms = new Mystack();
        while(true){
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("");
                System.out.println("============ Menu ============");
                System.out.println("Enter 1: Send messages"); 
                System.out.println("Enter 2: Handle messages");
                System.out.println("Enter 3: Messages received");
                System.out.println("Enter 4: Exit the program");
                System.out.println("==============================");
                System.out.println("Please enter your choice:");
                int t = sc.nextInt();
                switch(t) {
                    case 1:
                        System.out.println("You selected send messages!");
                        System.out.println("To exit this function, type 'exit'!");
                        String message = "";
                        do{
                            System.out.println("Please enter your message:");
                            sc = new Scanner(System.in);
                            message = sc.nextLine();
                            if (message.length()> 250) {
                                System.out.println(
                                "Message must be <= 250 characters,send failed");
                            }
                            if (message.length() <= 250 
                            && !("exit").equals(message)){
                                mq.enQueue(new Node(message));
                            }
                        } while (!("exit").equals(message));
                        break;  
                    case 2:
                        System.out.println("You selected handle messages!");
                        if (mq.isEmpty()){
                            System.out.println("No messages to handele!");
                        }
                        while (!mq.isEmpty()) {
                            Node m = mq.deQueue();
                            ms.push(m);
                            if(mq.isEmpty()){
                                System.out.println("All messages handeled!");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Messages received:");
                        if (ms.isEmpty()){
                            System.out.println("No messages received!");
                        }
                        while(!ms.isEmpty()){
                            System.out.println(ms.pop().getData());
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;                    
                    default:
                        System.out.println("Invalid selection!");
                        break;                    
                }
            }
            catch(Exception e){
                System.out.println("Invalid selection!");
            }
        }
    }
}
