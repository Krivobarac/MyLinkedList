package myLinkedList;
public interface ILinkedList<T> {
	boolean add(T value);
	public boolean addAt(T value, int index);
	public boolean updateAt(T value, int index);
	public boolean deleteAt(int index);
	public void showAll();
	public T getAt(int index);
}
