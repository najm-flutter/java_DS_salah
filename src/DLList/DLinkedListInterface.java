package DLList;

public interface DLinkedListInterface {

    void addFirst(DNode n);

    void deleteFirst();

    void deleteLast();

    void addLast(DNode m);

    void addAfter(DNode mn, String id);

    void display();

    void addBefor(DNode node, String name);

    void addAt(DNode n, int pos);

    void deleteAt(int pos);

    void deleteAfter(String name);

    void deleteBefore(String name);

}
