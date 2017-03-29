package com.afunx.algorithm.datastructure;

public class LinkedList<T> {

	private static class HeadNode<T> {
		public Node<T> first = null;
	}

	private static class Node<T> {
		public Node<T> prev = null;
		public Node<T> next = null;
		public T key = null;
	}

	private abstract static class LinkedListAbs<T> {

		public abstract void insert(Node<T> x);

		public abstract void delete(Node<T> x);

	}

	private static class HeadLinkedList<T> extends LinkedListAbs<T> {

		private HeadNode<T> headNode;

		private HeadLinkedList() {
			headNode = new HeadNode<>();
		}

		public static <T> Node<T> createNode(T t) {
			Node<T> node = new Node<T>();
			node.key = t;
			return node;
		}

		@Override
		public void insert(Node<T> x) {
			x.next = headNode.first;
			if (headNode.first != null) {
				headNode.first.prev = x;
			}
			headNode.first = x;
			x.prev = null;
		}

		@Override
		public void delete(Node<T> x) {
			if (x.prev == null) {
				headNode.first = x.next;
			} else {
				x.prev.next = x.next;
			}
			if (x.next != null) {
				x.next.prev = x.prev;
			}
		}

		@Override
		public String toString() {
			if (headNode == null) {
				return "headNode=null";
			} else if (headNode.first == null) {
				return "headNode.first=null";
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("next:");
				Node<T> first = headNode.first;
				Node<T> last = headNode.first;
				Node<T> current = first;
				while (current != null) {
					last = current;
					sb.append(current.key + ",");
					current = current.next;
				}
				sb.append("\n");

				sb.append("prev:");
				current = last;
				while (current != null) {
					sb.append(current.key + ",");
					current = current.prev;
				}
				return sb.toString();
			}
		}
	}

	private static class NonHeadLinkedList<T> extends LinkedListAbs<T> {

		private Node<T> nilNode;

		private NonHeadLinkedList() {
			nilNode = new Node<>();
			nilNode.next = nilNode;
			nilNode.prev = nilNode;
		}

		@Override
		public void insert(Node<T> x) {
			x.next = nilNode.next;
			nilNode.next.prev = x;
			x.prev = nilNode;
			nilNode.next = x;
		}

		@Override
		public void delete(Node<T> x) {
			x.prev.next = x.next;
			x.next.prev = x.prev;
		}

		@Override
		public String toString() {
			if (nilNode.next == nilNode) {
				return "nilNode=null";
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("next:");
				Node<T> next = nilNode.next;
				while (next != nilNode) {
					sb.append(next.key + ",");
					next = next.next;
				}
				sb.append("\n");
				sb.append("prev:");
				Node<T> prev = nilNode.prev;
				while (prev != nilNode) {
					sb.append(prev.key + ",");
					prev = prev.prev;
				}
				return sb.toString();
			}
		}

	}

	public static void main(String args[]) {
		HeadLinkedList<String> linkedList = new HeadLinkedList<>();
		Node<String> head5 = HeadLinkedList.createNode("5");
		Node<String> head4 = HeadLinkedList.createNode("4");
		Node<String> head3 = HeadLinkedList.createNode("3");
		Node<String> head2 = HeadLinkedList.createNode("2");
		Node<String> head1 = HeadLinkedList.createNode("1");
		linkedList.insert(head5);
		linkedList.insert(head4);
		linkedList.insert(head3);
		linkedList.insert(head2);
		linkedList.insert(head1);
		System.out.println(linkedList);
		System.out.println();
		linkedList.delete(head2);
		System.out.println(linkedList);
		System.out.println();
		linkedList.delete(head1);
		System.out.println(linkedList);
		System.out.println();

		NonHeadLinkedList<String> nonHeadLinkedList = new NonHeadLinkedList<>();
		head5 = HeadLinkedList.createNode("5");
		head4 = HeadLinkedList.createNode("4");
		head3 = HeadLinkedList.createNode("3");
		head2 = HeadLinkedList.createNode("2");
		head1 = HeadLinkedList.createNode("1");
		nonHeadLinkedList.insert(head5);
		nonHeadLinkedList.insert(head4);
		nonHeadLinkedList.insert(head3);
		nonHeadLinkedList.insert(head2);
		nonHeadLinkedList.insert(head1);
		System.out.println(nonHeadLinkedList);
		System.out.println();
		nonHeadLinkedList.delete(head2);
		System.out.println(nonHeadLinkedList);
		System.out.println();
		nonHeadLinkedList.delete(head1);
		System.out.println(nonHeadLinkedList);
		System.out.println();
	}
}
