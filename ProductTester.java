package groupLab4;
import java.util.LinkedList;


/**
* 
* @author Mohammed Asgar
* @author Brandon Evangelista
* @author Manuel Herrera
*/
public class ProductTester {

	public static void main(String[] args) {

		LinkedList<Product> products = new LinkedList<>();

		products.add(new Product(1, "Laptop", 4.5f, 700.00));
		products.add(new Product(2, "Phone", 3.8f, 300.00));
		products.add(new Product(3, "TV", 4.7f, 400.00));
		products.add(new Product(4, "Camera", 3.9f, 500.00));
		products.add(new Product(5, "Headphones", 4.2f, 50.00));


		System.out.println("INSERTION SORT:");
		System.out.println("\nSorting by Name: (alphabetical)");
		CustomLinkedList.insertionSort(products, "Name");
		CustomLinkedList.printList(products, "Name");

		System.out.println("\nSorting by Rating: (lowest)");
		CustomLinkedList.insertionSort(products, "Rating");
		CustomLinkedList.printList(products, "Rating");

		System.out.println("\nSorting by Price: (lowest)");
		CustomLinkedList.insertionSort(products, "Price");
		CustomLinkedList.printList(products, "Price");


		System.out.println("\n\n\nMERGE SORT:");
		System.out.println("\nSorting by Name: (alphabetical)");
		CustomLinkedList.mergeSort(products, "Name");
		CustomLinkedList.printList(products, "Name");

		System.out.println("\nSorting by Rating: (lowest)");
		CustomLinkedList.mergeSort(products, "Rating");
		CustomLinkedList.printList(products, "Rating");

		System.out.println("\nSorting by Price: (lowest)");
		CustomLinkedList.mergeSort(products, "Price");
		CustomLinkedList.printList(products, "Price");

	}


}