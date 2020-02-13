package myLinkedList;

public class App {

	public static void main(String[] args) {
		MyLinkedList<Integer> lista = new MyLinkedList<>();
		lista.add(5);
		lista.add(3);
		lista.add(8);
		
		lista.showAll();
		System.out.println("********************");
		lista.addAt(9,3);
		lista.showAll();
		
		System.out.println("********************");
		boolean x = lista.addAt(11, 2);
		lista.showAll();
		System.out.println("********************");
		System.out.println(x);
		System.out.println("********************");
		System.out.println(lista.getAt(4));
		System.out.println("********************");
		
		lista.updateAt(22, 3);
		lista.showAll();
		System.out.println("********************");
		lista.deleteAt(5);
		lista.showAll();

	}

}
