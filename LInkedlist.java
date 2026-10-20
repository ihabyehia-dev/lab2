
package person;

public class LInkedlist {
	Node head;
	Node tail;

	public boolean isempty() {
		boolean ok = false;
		if (head == null) {
			ok = true;
			return ok;
		}
		return ok;
	}

	void insertatfront(int v) {
		Node n = new Node(v);

		if (isempty() == true) {
			head = n;
			return;
		}
		n.next = head;
		head = n;
	}

	void insertatback(int v) {
		Node n = new Node(v);
		if (isempty() == true) {
			head = n;
			return;
		}
		tail.next = n;
	}

	void insertbefore(int key, int v) {
		Node n = new Node(v);
		Node current = head;
		Node prev = current;

		while (current.data != key && current != null) {
			prev = current;
			current = current.next;
		}
		n.next = current;
		n.prev = prev;
		current.prev = n;
		prev.next = n;
	}

	void deletefromfront() {
		if (head == null) {
			return;
		}
		head = head.next;
	}

	void deletefromback() {
		if (head == null) {
			return;
		}
		if (head == tail) {
			head = null;
			return;
		}
		tail.prev.next = null;
	}

	void deletebyvalue(int key) {
		Node current = head;
		Node prev = current;

		if (head == null) {
			return;
		}
		if (head.data == key) {
			head = head.next;
			return;
		}
		if (tail.data == key) {
			tail.prev.next = null;
			return;
		}
		while (current != null && current.data != key) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
		current.next.prev = prev;
	}

	public int searchrecursive(int key) {
		return searchrecursion(head, key, 0);
	}

	public int searchrecursion(Node n, int key, int index) {
		if (n == null) {
			return -1;
		}
		if (n.data == key) {
			return index;
		}
		return searchrecursion(n.next, key, index + 1);
	}

	void displayforward() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + ",");
			current = current.next;
		}
	}

	void displaybackward() {
		Node current = tail;

		while (current != null) {
			System.out.print(current.data + ",");
			current = current.prev;
		}
	}

	void reverse() {
		Node current = head;
		Node temp = null;

		while (current != null) {
			temp = current.next;
			current.next = current.prev;
			current.prev = temp;
			current = temp;
		}
		temp = head;
		head = tail;
		tail = temp;
	}

	static LInkedlist intersection(LInkedlist a, LInkedlist b) {
		LInkedlist result = new LInkedlist();
		Node currentA = a.head;
		while (currentA != null) {
			Node currentB = b.head;
			boolean found = false;

			while (currentB != null) {
				if (currentA.data == currentB.data) {
					found = true;
					break;
				}
				currentB = currentB.next;
			}
			if (found) {
				Node check = result.head;
				boolean alreadyAdded = false;
				while (check != null) {
					if (check.data == currentA.data) {
						alreadyAdded = true;
						break;
					}
					check = check.next;
				}
				if (!alreadyAdded) {
					result.insertatback(currentA.data);
				}
			}
			currentA = currentA.next;
		}

		return result;
	}
}
