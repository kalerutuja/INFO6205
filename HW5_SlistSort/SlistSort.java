import java.nio.file.FileStore;

import javafx.scene.Node;

/**
 * File Name: SlistSort.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */
/*
 * To compile you require: IntUtil.java RandomInt.java Slist2.java
 * SlistSort.java
 */

public class SlistSort {
    private Slist2 s;
    private int[] work;
    private boolean show;
    private static IntUtil u = new IntUtil();
    // You cannot add any variables to this class

    SlistSort(Slist2 s, String method, int[] work, boolean show) {
        this.s = s;
        this.work = work;
        this.show = show;
        if (method == "merge_sort") {
            merge_sort();
        } else if (method == "quick_sort") {
            quick_sort();
        }
    }

    private void increment_numCompare(int x) {
        work[0] = work[0] + x;
    }

    private void increment_numSwap(int x) {
        work[1] = work[1] + x;
    }

    private void increment_Recursion(int x) {
        work[2] = work[2] + x;
    }

    /************************************************************
     * WRITE YOUR CODE BELOW
     * YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS AND PRIVATE CLASS
     *************************************************************/
    private void merge_sort() {
        if (show) {
            s.Pln("Before sort s = ");
        }
        s.first = mergeSort(s.first);
        // WRITE CODE BELOW
        // YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS
        if (show) {
            s.Pln("Before sort s = ");
        }

    }

    private Node2 mergeSort(Node2 n) {
        Node2 nodes = n;
        if ((n != null) && (n.next != null)) {
            if (show) {
                s.Pln("before partition =", n);
            }
            increment_Recursion(1);
            Node2 middle = getmiddleElement(n);
            if (show) {
                s.Pln("after partition =", n);
                s.Pln("after partition =", middle);
            }
            Node2 p1 = mergeSort(n);
            Node2 p2 = mergeSort(middle);
            nodes = merge(p1, p2);
            if (show) {
                s.Pln("after merge =", nodes);
            }
        }
        return nodes;
    }

    private Node2 getmiddleElement(Node2 a) {
        Node2 slow = a;
        Node2 fast = a.next;
        u.myassert(a != null);
        u.myassert(a.next != null);
        while (fast != null) {
            increment_numCompare(1);
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        Node2 t = slow.next;
        slow.next = null;
        return t;
    }

    private Node2 merge(Node2 a, Node2 b) {
        Node2 fast = null;
        Node2 last = null;
        while (a != null && b != null) {
            Node2 toAdd = a.next;
            Node2 toLow = b.next;
            increment_numCompare(1);
            increment_numSwap(1);
            if (a.d > b.d) {
                if (fast == null) {
                    fast = b;
                } else {
                    last.next = b;
                }
                last = b;
                b.next = null;
                b = toLow;
            } else {
                if (fast == null) {
                    fast = a;
                } else {
                    last.next = a;
                }
                last = a;
                a.next = null;
                a = toAdd;
            }
        }
        if ((a != null || b != null)) {
            Node2 laterHalf = a;
            if (a == null) {
                laterHalf = b;
            }
            u.myassert(laterHalf != null);
            u.myassert(last != null);
            last.next = laterHalf;
        }
        return fast;
    }

    // ----------------------------------------------------
    // _____________________________________________________
    private void quick_sort() {
        if (show) {
            s.Pln("Before sort s = ");
        }
        // WRITE CODE BELOW
        // YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS
        s.first = quickSort(s.first);
        if (show) {
            s.Pln("after sort s =");
        }
    }

    private Node2 quickSort(Node2 start) {

        if ((start != null) && (start.next != null)) {
            increment_Recursion(1);
            node d = partition(start);
            Node2 pivotstart = d.d[node.highRoot];
            u.myassert(pivotstart != null);
            Node2 leftstart = quickSort(d.d[node.lowRoot]);
            Node2 rightstart = quickSort(d.d[node.middleRoot]);
            Node2 merge = QuickSort(leftstart, pivotstart, rightstart);
            if (show) {
                s.Pln("after merge", merge);
            }
            return merge;
        }
        return start;
    }
    
    private node partition(Node2 start) {

        Node2 pivot = findPivot(start);
        int pivotValue = pivot.d;
        node d = new node();
        u.myassert(start != null);
        u.myassert(start.next != null);
        while (start != null) {
            int x = start.d - pivotValue;
            increment_numCompare(1);
            d.isAlreadySorted(x, start);
            Node2 os = start;
            start = start.next;
            os.next = null;
        }
        u.myassert(d.d[node.highRoot] != null);
        u.myassert(d.d[node.highList].next == null);
        increment_numSwap(1);
        if (d.d[node.lowRoot] != null) {
            u.myassert(d.d[node.lowList].next == null);
        } else {
            u.myassert(d.d[node.lowList] == null);
        }
        if (d.d[node.middleRoot] != null) {
            u.myassert(d.d[node.middleList].next == null);
        } else {
            u.myassert(d.d[node.middleList] == null);
        }
        return d;
    }


    private Node2 findPivot(Node2 a) {
        Node2 s = a;
        Node2 f = a.next;
        while (f != null) {
            increment_numCompare(1);
            f = f.next;
            if (f != null) {
                f = f.next;
                s = s.next;
            }
        }
        return s;
    }

    private Node2 lastPivot(Node2 c, int[] steps) {
        steps[0] = 0;
        Node2 last = null;
        while (c != null) {
            last = c;
            steps[0]++;
            c = c.next;
        }
        return last;
    }

    private class node {
        static final int nodes = 6;
        static final int lowRoot = 0;
        static final int lowList = 1;
        static final int highRoot = 2;
        static final int highList = 3;
        static final int middleRoot = 4;
        static final int middleList = 5;
        private Node2[] d;

        node() {
            d = new Node2[nodes];
            for (int i = 0; i < nodes; i++) {
                d[i] = null;
            }
        }

    public void isAlreadySorted(int x, Node2 p) {
            int start = highRoot;
            int end = highList;
            if (x < 0) {
                start = lowRoot;
                end = lowList;
            } else if (x > 0) {
                start = middleRoot;
                end = middleList;
            }
            if (d[start] == null) {
                d[start] = p;
            } else {
                d[end].next = p;
            }
            d[end] = p;
        }
    }

    private Node2 QuickSort(Node2 left, Node2 middle, Node2 right) {
        u.myassert(middle != null);
        int[] work = { 0 };
        Node2 s = left;
        if (left == null) {
            s = middle;
        } else {
            Node2 leftlast = lastPivot(left, work);
            increment_numSwap(work[0]);
            leftlast.next = middle;
        }
        Node2 middlelast = lastPivot(middle, work);
        increment_numSwap(work[0]);
        if (right == null) {
            return s;
        } else {
            middlelast.next = right;
            Node2 rightlast = lastPivot(right, work);
            increment_numSwap(work[0]);
            u.myassert(rightlast.next == null);
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println("SlistSort STARTS");

        System.out.println("SlistSort ENDS");
    }

}
