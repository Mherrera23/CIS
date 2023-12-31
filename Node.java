package groupLab4;
import java.util.LinkedList;

/**
 * 
 * @author Mohammed Asgar
 * @author Brandon Evangelista
 * @author Manuel Herrera
 *
 */
class Node {
	//Store Product data here and prev and next links
	//Include two Node constructors, one default and one with linked nodes
	//If Product class does not have getter and setter methods, be sure to include them
	   public Product data;
	   public Node nextNode;
	   public Node prevNode;

	   public Node(Product initialData) {
	      data = initialData;
	      nextNode = null;
	      prevNode = null;
	   }

}

class CustomLinkedList {
	Node head;

	Node tail;
	
	
	public CustomLinkedList() {
        head = null;
        tail = null;
    }

	
	// Method to insert a new node at the end
	public void append(Product data) {
		
		Node newNode = new Node(data);
        newNode.nextNode = null;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
	}

	
	
	// Method to delete a node with specific data
	public void delete(Product data) {
	    Node current = head;
	    Node previous = null;

	    while (current != null) {
	    	
	        if (current.data == data) {
	        	
	            if (previous == null) {
	                // If the matching node is the head, update head
	                head = current.nextNode;
	            } else {
	                // Otherwise, update the previous node's nextNode
	                previous.nextNode = current.nextNode;
	            }

	            // If the matching node is the tail, update tail
	            if (current == tail) {
	                tail = previous;
	            }

	            // Delete the current node
	            current = null;
	            return;
	        }

	        // Move to the next node
	        previous = current;
	        current = current.nextNode;
	    }
	}

		


	// Getter for the head node
    public Node getHead() {
        return head;
    }

    
    // Setter for the head node
    public void setHead(Node head) {
        this.head = head;
    }

    
    // Getter for the tail node
    public Node getTail() {
        return tail;
    }

    
    // Setter for the tail node
    public void setTail(Node tail) {
        this.tail = tail;
    }

    
    
 // Method to print the list
    public static void printList(LinkedList<Product> products, String sortLabel) {
    	
        if (products == null || products.isEmpty()) {
        	
            System.out.println("No products to display.");
            return;
        }

  //      System.out.println(sortLabel);
        
        for (Product product : products) {
            System.out.printf("%-12s | %.1f | $%.2f%n", product.productName, product.productRating, product.price);
        }
    }


	
	

	// Method to sort the list using Insertion Sort
	/**
	 * Performs insertion sort on a LinkedList of Product objects.
	 *
	 * @param list      The LinkedList to be sorted.
	 * @param parameter The field by which the LinkedList will be sorted.
	 */
	public static void insertionSort(LinkedList<Product> list, String parameter) {
		int n = list.size();
		for (int i = 1; i < n; ++i) {
			Product key = list.get(i);
			int j = i - 1;

			// Move elements of list[0..i-1], that are greater than key.productName
			// in alphabetical order for "Name" parameter, to one position ahead
			// of their current position
			while (j >= 0 && compareProducts(list.get(j), key, parameter) > 0) {
				list.set(j + 1, list.get(j));
				j = j - 1;
			}
			list.set(j + 1, key);
		}
	}




	// Method to sort the list using Merge Sort
	public static void mergeSort(LinkedList<Product> list, String parameter) {
		if (list.size() > 1) {
			int mid = list.size() / 2;

			LinkedList<Product> left = new LinkedList<>(list.subList(0, mid));
			LinkedList<Product> right = new LinkedList<>(list.subList(mid, list.size()));

			mergeSort(left, parameter);
			mergeSort(right, parameter);

			int i = 0, j = 0, k = 0;

			while (i < left.size() && j < right.size()) {
				if (compareProducts(left.get(i), right.get(j), parameter) <= 0) {
					list.set(k++, left.get(i++));
				} else {
					list.set(k++, right.get(j++));
				}
			}
			while (i < left.size()) {
				list.set(k++, left.get(i++));
			}

			while (j < right.size()) {
				list.set(k++, right.get(j++));
			}
		}
	}




	// Helper method to compare products based on the specified parameter
	private static int compareProducts(Product product1, Product product2, String parameter) {

		if (parameter.equalsIgnoreCase("Name")) {
			return product1.productName.compareTo(product2.productName);

		}
		else if (parameter.equalsIgnoreCase("Rating")) {
			return Float.compare(product1.productRating, product2.productRating);

		}
		else if (parameter.equalsIgnoreCase("Price")) {
			return Double.compare(product1.price, product2.price);

		} 
		else {
			return 0; // Default behavior if parameter is not recognized

		}

	}


}