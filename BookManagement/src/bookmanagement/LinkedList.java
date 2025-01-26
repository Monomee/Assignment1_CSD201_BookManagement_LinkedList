/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookmanagement;

import java.util.List;

/**
 *
 * @author PC
 */
public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void visit(Node p) {
        if (p != null) {
            if (p.bookInfo != null) {
                System.out.print(p.bookInfo);
            } else if (p.readerInfo != null) {
                System.out.print(p.readerInfo);
            } else if (p.lendingInfo != null) {
                System.out.print(p.lendingInfo);
            }
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
            System.out.println();
        }
    }

    int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return (count);
    }

    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return p;
            } else {
                i++;
                p = p.next;
            }
        }
        return (null);
    }

    int indexOf(Node q) {
        if (q == null) {
            return -1;
        }

        int index = 0;
        Node p = head;
        while (p != null) {
            if (p == q) {
                return index;
            } else {
                index++;
                p = p.next;
            }
        }
        return -1;
    }

    //Add
    void addFirst(Book x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    void addFirst(Reader x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    void addFirst(Lending x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

    void addLast(Book x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addLast(Reader x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void addLast(Lending x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void insertAfter(int k, Book x) {
        Node q = pos(k);
        if (q == null) {
            return;
        }
        if (tail == q) {
            addLast(x);
            return;
        }

        Node newNode = new Node(x, q.next);
        q.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    //Search
    Node searchBybCode(String xbCode) {
        Node p = head;
        while (p != null) {
            if (p.bookInfo.getbCode().equals(xbCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchInLeandingBybCode(String xbCode) {
        Node p = head;
        while (p != null) {
            if (p.lendingInfo.getbCode().equals(xbCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchByrCode(String xrCode) {
        Node p = head;
        while (p != null) {
            if (p.readerInfo.getrCode().equals(xrCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    Node searchInLendingByrCode(String xrCode) {
        Node p = head;
        while (p != null) {
            if (p.lendingInfo.getrCode().equals(xrCode)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }

    //Delete
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            head = head.next;
            if (head == null) {
                tail = null; 
            }
            return;
        }

        Node p = head;
        while (p != null && p.next != q) {
            p = p.next;
        }

        if (p != null) {
            p.next = q.next;
            if (p.next == null) {
                tail = p;  
            }
        }
    }

    void remove(int k) {
        Node p = pos(k);
        remove(p);
    }

    void removeBybCode(String xbCode) {
        Node p = searchBybCode(xbCode);
        remove(p);
    }

    void removeByrCode(String xrCode) {
        Node p = searchBybCode(xrCode);
        remove(p);
    }

    //Sort
    void sortBybCode() {
        Node pi, pj;
        Book temp;
        for (pi = head; pi != null; pi = pi.next) {
            for (pj = pi.next; pj != null; pj = pj.next) {
                if (pj.bookInfo.getbCode().compareTo(pi.bookInfo.getbCode()) < 0) {
                    temp = pi.bookInfo;
                    pi.bookInfo = pj.bookInfo;
                    pj.bookInfo = temp;
                }
            }
        }
    }
}
