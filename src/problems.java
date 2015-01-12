package auto.testcases;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by qilianghong on 14-12-17.
 */

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 
 hashmap
 */
enum TestType{
    First("first"),
    Second("Second"),
    Third("third");

    private final String des;
    private TestType(String des){
        this.des = des;
    }
    public String getDes(){
        return des;
    }
}

class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        }

public class problems {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
    
    private void printList(ListNode root){
        while(root != null){
            System.out.print(root.val);
            if(root.next != null){
                System.out.print("->");
            }
            root=root.next;
        }
        
    }
    private void printGrid(int[][] grid){

        int m = grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println("");
        }

    }
    /**
     * Find the contiguous subarray within an array (containing at least one number)
     * which has the largest product.

     For example, given the array [2,3,-2,4],
     the contiguous subarray [2,3] has the largest product = 6.
     */
    public int maxProduct(int[] A) {
        int len = A.length;
        int max = 0;
        int[][] grid = new int[len][len];
        for(int i=0;i<len ;i++){
            for(int j=i; j<len;j++){
                grid[i][j] = Integer.MIN_VALUE;
            }
        }
        max = Integer.MIN_VALUE;
        for(int i=0;i<len ;i++){
            for(int j=i; j<len;j++){
                if(i==j){
                    grid[i][j] = A[i];
                }else{
                    grid[i][j] = grid[i][j-1]*A[j];
                    if(max < grid[i][j]){
                        max = grid[i][j];
                    }
                }
            }
        }

        return max;
    }
    @Test
    public void testMaxProduct(){
        int[] A = {2,3,-5,4};

        int ret = maxProduct(A);

        System.out.println(ret);
    }
    /**
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

     Note: You can only move either down or right at any point in time.

     p[i][j] = min(p[i-1][j],p[i][j-1])
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] paths = new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                paths[i][j] = Integer.MAX_VALUE;
            }
        paths[0][0] = grid[0][0];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(i == 0 && j==0){
                    paths[i][j] = grid[0][0];
                }else{
                    if(i>0 && j==0) {
                        paths[i][j] = paths[i - 1][j] + grid[i][j];
                    }else if(i==0 && j>0){
                        paths[i][j] = paths[i][j-1] + grid[i][j];
                    }else if(i >0 && j>0){
                        paths[i][j] = Math.min(paths[i - 1][j] + grid[i][j], paths[i][j - 1] + grid[i][j]);
                    }
                }

            }
        return paths[m-1>0?m-1:0][n-1>0?n-1:0];
    }
    @Test
    public void testMinPathSum(){
        int[][] grid =
                {
                        {1,2,3},
                        {4,5,6},
                        {1,2,3},
                        {5,10,7}
                };

        int ret = minPathSum(grid);

        System.out.println(ret);
    }
    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

     For example,
     Given n = 3, there are a total of 5 unique BST's.

     1         3     3      2      1
     \       /     /      / \      \
     3     2     1      1   3      2
     /     /       \                 \
     2     1         2                 3
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return 0;
    }

    @Test
    public void testNumTrees(){

    }
    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.

     For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,

     return 1->4->3->2->5->NULL.

     Note:
     Given m, n satisfy the following condition:
     1 ≤ m ≤ n ≤ length of list.*
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode ptr1,ptr2,tmp,prev;
        int count=n-m;
        
        ptr1 = head;
        ptr2 = head;
        m--;
        n--;
        prev = null;
        while(m-- >0){
            if(m==0){
                prev = ptr1;
            }
            ptr1 = ptr1.next;
        }
        if(prev == null){
            prev = ptr1;
        }
        while(n-->0){
            ptr2 = ptr2.next;
        }

        if(ptr1 != head) {
            prev.next = ptr2;
        }else{
            head = ptr2;
        }
        tmp = ptr1;
        while(count-->0){
            
            ListNode t = tmp.next;
            tmp.next = ptr2.next;
            ptr2.next = tmp;
            tmp = t;
        }
        return head;
    }
    @Test
    public void testreverseBetween(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        
        ListNode t = reverseBetween(l1,1,5);
        
        printList(t);
        
    }
    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).

     Assume a BST is defined as follows:

     The left subtree of a node contains only nodes with keys less than the node's key.
     The right subtree of a node contains only nodes with keys greater than the node's key.
     Both the left and right subtrees must also be binary search trees.*
     */
    private boolean isValidBst(TreeNode root,TreeNode parent,boolean isLess){
        if(root == null){
            return true;
        }
        if(root.left != null){
            if(root.left.val >= root.val){
                return false;
            }
            if(parent != null){
                if(isLess) {
                    if (root.left.val >= parent.val) {
                        return false;
                    }
                }else {
                    if (root.left.val <= parent.val) {
                        return false;
                    }
                    
                }
                
            }
            if(!isValidBst(root.left, root, true)){
                return false;
            }
        }
        if(root.right != null){
            if(root.right.val <= root.val){
                return false;
            }
            if(parent != null){
                if(isLess) {
                    if (root.right.val >= parent.val) {
                        return false;
                    }
                }else {
                    if (root.right.val <= parent.val) {
                        return false;
                    }
                }
            }
            if(!isValidBst(root.right, root, false)){
                return false;
            }
        }
        return true;
    }
    private boolean checkValidBst(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
            
        }
        
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        
        return checkValidBst(root.left,min,root.val) && checkValidBst(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return checkValidBst(root,null,null);
    }
    @Test
    public void testIsValidBST(){
        TreeNode r = new TreeNode(3);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(8);
        
        
        r.left = t1;
        r.right = t2;
        t1.left = t3;
        t1.right = t4;
        System.out.println(isValidBST(r));
    }
    /**
     * Given a singly linked list where elements are sorted in ascending order, 
     * convert it to a height balanced BST.
     */
    public TreeNode sortedListToBST(ListNode head) {
        
        
        
        return null;
    }
    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
     Given the below binary tree and sum = 22,
     5
     / \
     4   8
     /   / \
     11  13  4
     /  \    / \
     7    2  5   1
     return
     [
     [5,4,11,2],
     [5,8,4,5]
     ]*
     */
    public void dfs(TreeNode root,int sum,List<Integer> ls){
        if(root == null){
            return;
        }
        ls.add(root.val);
        if(root.left == null && root.right == null){
            if(sum - root.val == 0){
                lss.add(new ArrayList<Integer>(ls));
            }
        }
        if(root.left != null){
            dfs(root.left,sum-root.val,ls);
            ls.remove(ls.size()-1);
        }
        if(root.right != null){
            dfs(root.right,sum- root.val,ls);
            ls.remove(ls.size()-1);
        }
    }
    List<List<Integer>> lss = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,new ArrayList<Integer>());
        
        return lss;
    }
    /**
     * Given a binary tree

     struct TreeLinkNode {
     TreeLinkNode *left;
     TreeLinkNode *right;
     TreeLinkNode *next;
     }
     Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Note:

     You may only use constant extra space.
     You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
     For example,
     Given the following perfect binary tree,
     1
     /  \
     2    3
     / \  / \
     4  5  6  7
     After calling your function, the tree should look like:
     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \  / \
     4->5->6->7 -> NULL*
     */
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> children = new ArrayList<>();
        if(root != null){
            children.add(root);
        }
        while(children.size()>0){
            TreeLinkNode pre = null;
            TreeLinkNode tmpNode = null;
            List<TreeLinkNode> tmpNodes = new ArrayList<>();
            for(int i=0;i<children.size();i++) {
                tmpNode = children.get(i);
                if(pre != null){
                    pre.next = tmpNode;
                }
                pre = tmpNode;
                
                if(tmpNode.left != null){
                    tmpNodes.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    tmpNodes.add(tmpNode.right);
                }
            }
            if(tmpNode != null){
                tmpNode.next = null;
            }
            children = tmpNodes;
        }
    }
    /**
     * shit*
     * @param head
     * @return
     */
    public ListNode deleteAllDuplicates(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        ListNode newNode = null;
        boolean isDup = false;
        while(tmp != null){
            if(prev == null){
                prev = tmp;
                newNode = tmp;
            }else {
                if(tmp.val == newNode.val){
                    isDup = true;
                }else{
                    if(isDup){
                        if(prev == newNode){
                            if(head == prev){
                                head = tmp;
                            }
                            prev = tmp;
                            newNode =tmp;
                        }else{
                            newNode =tmp;
                        }
                    }else{
                        if(newNode != prev){
                            prev.next =  newNode;
                            prev = newNode;
                        }
                        prev.next = null;
                        newNode = tmp;
                    }
                    isDup = false;
                }
            }
            tmp = tmp.next;
        }
        if(!isDup && prev !=null){
            if(prev.val != newNode.val)
                prev.next = newNode;
        }else if(isDup){
            if(prev.val == newNode.val){
                if(prev ==head){
                    head =null;
                }
            }
        }
        return head;
    }
    @Test
    public void testDelAllDup(){
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        
//        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        
        
        ListNode ret = deleteAllDuplicates(head);
        
        while(ret != null){
            System.out.print(ret.val);

            ret = ret.next;
            if(ret != null){
                System.out.print("->");
                
            }
        }
    }
/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X*
 */
class Node {
    int x;
    int y;
    char val;
    public Node(int m,int n){
        this.x = m;
        this.y = n;
    }
}
    boolean isSurrounded(char[][] board, int x,int y){
        if(y >0){
           if(board[x][y-1] =='O'){
               isSurrounded(board,x,y-1);
           }
            if(board[x][y+1] == 'O'){
               
               
           }
            
        }
        if(x >0){
            
            
        }
        
        return false;
    }
public void solve(char[][] board) {
    int len = (int) Math.pow(board.length, 2);
    for(int i=0;i<len;i++)
    for(int j=0;j<len;j++){
        if(board[i][j] == 'O'){
            Node node = new Node(i,j);
            isSurrounded(board,i,j);
        }
    }
}
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]
     * @param s
     * @return
     */
    private boolean isPalindromeString(String s){
        if(s == null){
            return false;
        }
        int p1,p2;
        p1 = 0;
        p2 = s.length() -1;
        
        while(p1<p2){
            if(s.charAt(p1++) != s.charAt(p2--)){
                return false;
            }
        }
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> lss = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String s1 = s.substring(0,i);
            if(!isPalindromeString(s1)){
                continue;
            }
            for(int j=i;j<s.length();j++){
                String t = s.substring(0);
                
            }
        }
        return null;
    }

    class BSTIterator {
        private TreeNode r;
        private Stack<TreeNode> s;
        public void traveTree(TreeNode root){
            if(root == null){
                return;
            }
            s.push(root);
            if(root.left != null){
                traveTree(root.left);
            }
        }
        public BSTIterator(TreeNode root) {
            r = root;
            s = new Stack<>();
            traveTree(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !s.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode smallestNode = s.pop();
            if(smallestNode.right != null){
                traveTree(smallestNode.right);
            }
            return smallestNode.val;
        }
    }
    @Test
    public void testBST(){
        TreeNode root = null;
        BSTIterator itr = new BSTIterator(root);
        while(itr.hasNext()){
            itr.next();
        }
        
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode itr = head;
        while(itr != null){
            if(pre == null){
                pre =head;
            }else{
                if(pre.val != itr.val){
                    pre.next = itr;
                    pre = itr;
                }
            }
            itr = itr.next;
            pre.next = null;
        }
        return head;
    }
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> ls = new ArrayList<>();
        ls.add(root);
        while(ls.size() >0){
            List<TreeNode> tmp = new ArrayList<>();
            for(int i=0;i<ls.size()/2;i++){
                TreeNode t1 = ls.get(i);
                TreeNode t2 = ls.get(ls.size()-1-i);
                if((t1 == null && t2 != null) || (t1 != null && t2 == null)){
                    return false;
                } else if(t1 !=null && t2!=null && t1.val != t2.val){
                    return false;
                }
            }
            for(TreeNode t : ls){
                if(t == null){
                    continue;
                }
                tmp.add(t.left);
                tmp.add(t.right);
            }
            ls = tmp;
        }
        return true;
    }
    @Test
    public void testSymmTree(){
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        
        boolean ret = isSymmetric(root);
        
        System.out.println(ret);
        
    }
    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.

     The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * @param A
     * @param elem
     * @return
     */
    public int removeElement2(int[] A, int elem){
        
        int p1;
        p1=0;
        int count=0;
        for(int i=0;i<A.length;i++){
         if(A[i] != elem){
             A[p1++] = A[i];
             count++;
         }
            
        }
        return count;
    }
    public int removeElement(int[] A, int elem) {
        int[] t = new int[A.length];
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i] != elem){
                t[count++] = A[i];
                
            }
            
        }
        for(int i=0;i<count;i++){
            A[i] = t[i];
        }
        return count;
    }
    /**
     * *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int[] newNum = new int[digits.length+1];
        int over=0;
        int count=0;
        for(int i=digits.length -1; i>=0;i--){
            int tmp = digits[i];
            if(i == digits.length -1){
                tmp++;
                
            }
            tmp =tmp +over;
            if(tmp >9){
                over = 1;
                tmp = tmp%10;
            }else{
                over =0;
            }
            newNum[count++] = tmp;
        }
        if(over == 1){
            newNum[count++] =1;
        }
        int[] ret = new int[count];
        for(int i=0;i<count;i++){
            ret[i] = newNum[count - i -1];
        }
        return ret;
    }
    @Test
    public void testPlusOne(){
        int[] t = {1,9,8};
        int[] ret = plusOne(t);
        System.out.println(ret);
    }
    public int romanToInt(String s) {
        int pre = -1;
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int num = 0;
            if(c == 'I'){
                num =1;
            }else if(c =='V'){
                num=5;
                
            }else if(c=='X'){
                num =10;
                
            }else if(c=='L'){
                num=50;
                
            }else if(c=='C'){
                num=100;
                
            }else if(c=='D'){
                num=500;
                
            }else if(c=='M'){
                num=1000;
                
            }
            if(pre ==-1){
                sum =sum+num;
            }else {
                if(pre < num){
                    sum =sum+num - pre - pre;
                }else{
                    sum+= num;
                }
            }
            pre = num;
        }
        
        
        return sum;
    }
    
    @Test
    public void testRomanToInt(){
        String s = "IVVV";
        
        int ret = romanToInt(s);
        
        System.out.println(ret);
        
    }
    /**
     * Given two sorted integer arrays A and B, merge B into A as one sorted array.

     Note:
     You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
     The number of elements initialized in A and B are m and n respectively.*
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int[] tmp = new int[m];
        for(int i=0;i<m;i++){
            tmp[i] = A[i];
        }
        int p1,p2;
        p1=p2=0;
        int count =0;
        while(p1<m || p2 <n){
            if(p1>=m){
                A[count++]=B[p2++];
            }else if(p2>=n){
                A[count++]=tmp[p1++];
                
            }else{
                if(tmp[p1]<B[p2]){
                    A[count++]=tmp[p1++];
                    
                }else{
                    A[count++] = B[p2++];
                    
                }
                
            }
        }
    }
    
    public List<List<Integer>> generate(int numRows) {
        int[] ls = new int[numRows+1];
        List<List<Integer>> lss = new ArrayList<>();
        if(numRows == 0){
            return lss;
        }
        
        for(int i=0;i<numRows;i++){
            int pre=0,post=0;
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    ls[j]=1;
                    pre = ls[j];
                }else{
                    post = ls[j];
                    ls[j] = pre+post;
                    pre = post;
                }
            }
            for(int j=0;j<=i;j++){
                l.add(ls[j]);
            }
            lss.add(l);
        }
        return lss;
    }
    /**
     * Given an index k, return the kth row of the Pascal's triangle.

     For example, given k = 3,
     Return [1,3,3,1].

     Note:
     Could you optimize your algorithm to use only O(k) extra space?
     * @param rowIndex
     * @return
     */
    public List<List<Integer>> getRow(int rowIndex) {
        int[] ls = new int[rowIndex];

        List<List<Integer>> lss = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            int pre=0,post=0;
            List<Integer> l = new ArrayList<>();
          for(int j=0;j<=i;j++){
              if(j==0 || j==i){
                  ls[j]=1;
                  pre = ls[j];
              }else{
                  post = ls[j];
                  ls[j] = pre+post;
                  pre = post;
              }
          }
            for(int j=0;j<=i;j++){
                l.add(ls[j]);
            }
            lss.add(l);
        }
        return lss;
    }
    @Test
    public void testPascalTrangle(){
//        int index = 4;
//        List<Integer> ls = getRow(index);
//
//        System.out.println(ls.size());
    }
    public boolean isValidSudoku(char[][] board) {
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        Map<Integer, Character> map = new HashMap<>();
        for(int i=0;i<9;i++) {
            map.clear();
            for (int j = 0; j < 9; j++) {
                if (map.containsValue(board[i][j]))
                    return false;
                map.put(i, board[i][j]);
            }
            for (int j = 0; j < 9; j++) {
                if (map.containsValue(board[j][i]))
                    return false;
                map.put(i, board[i][j]);
            }
        }
        return false;
    }
    public boolean isPalindromex(String s) {
        int p1,p2;
        boolean ret = true;
        p1 = 0;
        p2 = s.length()-1;
        if(s.isEmpty()){
            return true;
        }
        while(p1 <p2){
            if(!Character.isAlphabetic(s.charAt(p1)) && !Character.isDigit(s.charAt(p1))){
                p1++;
            }else if(!Character.isAlphabetic(s.charAt(p2)) && !Character.isDigit(s.charAt(p2))){
                p2--;
            }else{
                if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))){
                    ret = false;
                    break;
                }else{
                    p1++;
                    p2--;
                }
            }
        }
        return ret;
    }
    @Test
    public void testParlindrom(){
        String s = "a.";
        boolean ret =isPalindromex(s);
        System.out.println(ret);
        
    }
    public String longestCommonPrefix(String[] strs) {
        char c;
        boolean isContinue = true;
        StringBuilder str = new StringBuilder();
        if(strs.length <1){
            return "";
        }
        for(int i=0;i<strs[0].length();i++) {
            c = strs[0].charAt(i);
            for (String s : strs) {
                if(s.length() <=i || s.charAt(i) != c){
                    isContinue = false;
                    break;
                }
            }
            if(!isContinue){
                break;
            }
            str.append(c);
        }
        return str.toString();
    }
    public int lengthOfLastWord(String s) {
        int count =0;
        for(int i= s.length()-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                if(count == 0)
                continue;
                else
                    break;
            }
            if(s.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }
    public boolean isPalindrome(int x) {

        int tmp = x;
        int ret = 0;
        while(tmp !=0 ){
            ret = ret*10 + tmp%10;
            tmp = tmp/10;
        }
        
        if(ret == x){
            return true;
        }else{
            return false;
        }

    }
    @Test
    public void testPalindromNumber(){
        int x = -2147447412;
        int i = -125;
        int j= i%10;
        boolean ret = isPalindrome(x);
        
        System.out.println(ret);
    }

    /**
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

     Do not allocate extra space for another array, you must do this in place with constant memory.

     For example,
     Given input array A = [1,1,2],

     Your function should return length = 2, and A is now [1,2].*
     */
    public int removeDuplicates(int[] A) {
        int count=0;
        int tmp=0;
        for(int i=0;i<A.length;i++){
            if(i==0){
                tmp = A[0];
                count++;
            }else if(tmp != A[i]){
                tmp = A[i];
                A[count++]=A[i];
            }
        }
        return count;
    }
    @Test
    public void testRemoveDuplicates(){
        int[] a = {1,1,2};
        
        int ret = removeDuplicates(a);
        
        System.out.println(ret);
        
    }
    /**
     * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
     * * (ie, from left to right, level by level from leaf to root).

     For example:
     Given binary tree {3,9,20,#,#,15,7},
     3
     / \
     9  20
     /  \
     15   7
     return its bottom-up level order traversal as:
     [
     [15,7],
     [9,20],
     [3]
     ]
     */
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if(root == null){
            return ls;
        }
        nodes.add(root);
        while(nodes.size() >0){
            List<TreeNode> tmp = new ArrayList<>();
            List<Integer> num = new ArrayList<>(nodes.size());
            for(TreeNode n : nodes){
                num.add(n.val);
                if(n.left != null){
                    tmp.add(n.left);
                }
                if(n.right != null){
                    tmp.add(n.right);
                }
            }
            nodes = tmp;
            ls.add(num);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int i= ls.size() -1; i>=0;i--){
            ret.add(ls.get(i));
        }
        return ret;
    }
    @Test
    public void testLevelOrderBottom(){
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.left.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        
        List<List<Integer>> ls = levelOrderBottom(root);
        
        System.out.println(ls.size()+"");
    }
    /**
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

     If the fractional part is repeating, enclose the repeating part in parentheses.

     For example,

     Given numerator = 1, denominator = 2, return "0.5".
     Given numerator = 2, denominator = 1, return "2".
     Given numerator = 2, denominator = 3, return "0.(6)".
     Credits:
     Special thanks to @Shangrila for adding this problem and creating all test cases.
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        
        return null;
    }
    
    @Test
    public void testFraction(){
        int numerator = 1;
        int denominator = 2;
        
        String s = fractionToDecimal(numerator,denominator);
        System.out.println(s);
    }
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     Credits:
     Special thanks to @ifanchu for adding this problem and creating all test cases.
     * @param n
     * @return
     * 整数转换成26计数
     */
    public String convertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        int mod = 0;
        int tmp = n;
        while(tmp>0){
            tmp--;
            mod = (tmp)%26;
            tmp = tmp/26;
            
            ret.append((char)(mod + 'A'));
            
        }
        return ret.reverse().toString();
    }
    
    
    public int titleToNumber(String s) {
        int sum =0;
        for(int i= 0; i< s.length();i++){
            char c = s.charAt(i);
            sum=sum*26+(c-'A'+1);
        }
        return sum;
    }


    @Test
    public void testConvertTitle(){

        int n = 26*26+1;
        String s = convertToTitle(n);

        System.out.println(s);

        int sum = titleToNumber(s);

        System.out.println(""+sum);

    }

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

     You may assume that the array is non-empty and the majority element always exist in the array.

     Credits:
     Special thanks to @ts for adding this problem and creating all test cases.
      * @param num
     * @return
     *
     * 1.排序
     * 2.计数排序
     * 3.快排
     */
    public int majorityElement(int[] num) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        int value=0;
        for(int i=0;i<num.length;i++){
            int count = 0;
            if(map.containsKey(num[i])){
                count = map.get(num[i]);
                map.put(num[i],++count);
            }else{
                map.put(num[i],++count);
            }
            if(count > max){
                max = count;
                value = num[i];
            }
        }
        return value;
    }
    @Test
    public void testMajortyElement(){
        int[] num={1,1,1,1,1,2,3,4,5,6,7,8,9,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};

        int ret = majorityElement(num);

        System.out.println(ret);
    }
    /**
     * Implement wildcard pattern matching with support for '?' and '*'.

     '?' Matches any single character.
     '*' Matches any sequence of characters (including the empty sequence).

     The matching should cover the entire input string (not partial).

     The function prototype should be:
     bool isMatch(const char *s, const char *p)

     Some examples:
     isMatch("aa","a") → false
     isMatch("aa","aa") → true
     isMatch("aaa","aa") → false
     isMatch("aa", "*") → true
     isMatch("aa", "a*") → true
     isMatch("ab", "?*") → true
     isMatch("aab", "c*a*b") → false
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {


        return true;
    }
    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     1, 11, 21, 1211, 111221, ...

     1 is read off as "one 1" or 11.
     11 is read off as "two 1s" or 21.
     21 is read off as "one 2, then one 1" or 1211.
     Given an integer n, generate the nth sequence.

     Note: The sequence of integers will be represented as a string.

     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String s = "1";
        for(int i=0;i<n;i++){
            StringBuilder t = new StringBuilder();
            if(i ==0 ){
                t.append("1");
            }else{
                int len = s.length();
                for(int j=0;j<len;j++){
                    char c = s.charAt(j);
                    int count =1;
                    while(j+1<len && s.charAt(j+1) ==c){
                        count++;
                        j++;
                    }
                    t.append(count);
                    t.append(c);
                }
            }
            s = t.toString();
        }
        return s;
    }
    @Test
    public void testCountAndSay(){
        String s = countAndSay(6);
        
        System.out.println(s);
    }
    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

     Note:
     Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
     The solution set must not contain duplicate triplets.
     For example, given array S = {-1 0 1 2 -1 -4},

     A solution set is:
     (-1, 0, 1)
     (-1, -1, 2)
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum(int[] num) {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> ret = new LinkedList<>();
        if(num.length <3){
            return null;
        }
        for(int i=0;i<num.length-2;i++)
            for(int j=i+1;j<num.length-1;j++)
                for(int k=j+1;k<num.length;k++){
                    if(num[i]+num[j]+num[k] == 0){
                        System.out.println(i+"+"+j+"+"+k);
                        Set<Integer> tmp = new HashSet<>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[k]);

                        if(!list.contains(tmp)) {
                            list.add(tmp);
                            List<Integer> ilist = new ArrayList<>();
                            ilist.add(num[i]);
                            ilist.add(num[j]);
                            ilist.add(num[k]);
                            ret.add(ilist);
                        }
                    }
                }

        return ret;
    }

    /**
     * @param num
     * @return
     */
    public List<List<Integer>> threeSum2(int[] num) {
        List<List<Integer>> ret = new ArrayList<>();
        if(num.length <3){
            return ret;
        }
        Arrays.sort(num);//O(nlgn)

        for(int i=0;i<num.length;i++) {//n*n-1=O(n^2)
            if(i>0 && num[i] == num[i-1]){
                continue;
            }
            for (int j = i + 1, k = num.length - 1; j < k; ) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    //remove duplicated arrays
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[j]);
                    tmp.add(num[k]);
                    ret.add(tmp);
                    j++;
                    while (j < k && num[j] == num[j - 1])
                        j++;
                } else if (sum < 0) {
                    j++;
                    while (j < k && num[j] == num[j - 1])
                        j++;
                } else if (sum > 0) {
                    k--;
                    while (j < k && num[k] == num[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ret;
    }
    @Test
    public void testThreeSum(){
        int[] num ={0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14};
//       int[] num ={-1,0,1,2,-1,-4};
//        int[] num={0,0,0,0};
        List<List<Integer>> ls = threeSum2(num);
        System.out.println(ls.size());
    }
    /**
     * Compare two version numbers version1 and version2.
     If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 13.37
     Credits:
     Special thanks to @ts for adding this problem and creating all test cases.
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        Queue<Integer> s1 = new LinkedBlockingQueue<>();
        Queue<Integer> s2 = new LinkedBlockingQueue<>();
        for(String s : version1.split("\\.")){
            s1.offer(Integer.valueOf(s));
        }
        for(String s : version2.split("\\.")){
            s2.offer(Integer.valueOf(s));
        }
        int ret = 0;
        while(s1.size()>0 || s2.size()>0){
            if(s1.size()==0 ){
                if(s2.poll() >0){
                    ret = -1;
                }
            }else if(s2.size() ==0){
                if(s1.poll() >0){
                    ret = 1;
                }
            }else{
                int tmp1 = s1.poll();
                int tmp2 = s2.poll();

                if(tmp1 > tmp2){
                    ret = 1;
                }else if(tmp1 < tmp2){
                    ret = -1;
                }else {
                    ret = 0;
                }
            }
            if(ret != 0){
                return ret;
            }

        }

        return ret;
    }

        public boolean exist(char[][] board, String word) {

        return false;
    }
    public int longestConsecutive(int[] num) {
        if(num.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer e : num){
            set.add(e);
        }
        int max = 1;
        for(Integer e : num){
            int left = e -1;
            int right = e+1;
            int count =1;

            while(set.contains(left)){
                count++;
                set.remove(left);
                left--;
            }
            while(set.contains(right)){
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    @Test
    public void testcompareVersion(){
        String s1 = "1.0";
        String s2 = "1";

        int ret = compareVersion(s1,s2);

        System.out.println(ret);
    }
    @Test
    public void testLCS(){
        TestType t = TestType.First;

        for(TestType v :TestType.values()){
            System.out.println(v.getDes());
        }
        switch(t){
            case First:
                System.out.println(t.getDes());
                break;
            case Second:
                System.out.println(t.getDes());
                break;
            case Third:
            default:
                System.out.println("default :" +t.getDes());
        }
    }

}
