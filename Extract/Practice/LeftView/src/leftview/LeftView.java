/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftview;

import java.util.Scanner;

class Node {

    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LeftView {

    static int max = 0;

    static void levelOrder(Node root, int level) {
        //Write your code here

        if (root == null) {
            return;
        }

        if (max < level) {
            System.out.println(root.data);
            max = level;
        }

        levelOrder(root.left, level + 1);
        levelOrder(root.right, level + 1);

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the length of binary tree");
        System.out.println("Note:- First Element is the  root of binary tree");
        int T = sc.nextInt();

        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        levelOrder(root, 1);
    }
}
