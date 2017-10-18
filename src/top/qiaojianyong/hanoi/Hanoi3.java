package top.qiaojianyong.hanoi;

import java.util.HashMap;
import java.util.LinkedList;

public class Hanoi3 {

	static HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
	static int num = 4;
	static int count = 0;
	static {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> list3 = new LinkedList<>();

		for (int i = 1; i <= num; i++)
			list1.add(i);
		map.put(1, list1);
		map.put(2, list2);
		map.put(3, list3);
	}

	public static void main(String[] args) {
		for (int i = 0; i < num; i++) {
			System.out.print("          ");
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 2 * num - 1; k++) {
					int size = map.get(j).size();
					int stars = 0;
					if (num - i <= size) {
						stars = map.get(j).get(size + i - num);
						stars = 2 * stars - 1;
					}
					int spaces = (2 * num - 1 - stars) / 2;
					if (k <= spaces || k >= spaces + stars)
						System.out.print(" ");
					else
						System.out.print("█");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		hanoi(num, 1, 3);
		//结束
		for (Integer i : map.get(3))
			System.out.println("          " + i);
		System.out.println("\n                    " + "总步数 " + count);
	}

	private static void hanoi(Integer n, int from, int to) {
		//		System.out.println(from + "-->" + to + "  " + n);
		int t = from + to;
		switch (t) {
		case 4:
			t = 2;
			break;
		case 3:
			t = 3;
			break;
		case 5:
			t = 1;
			break;
		}
		if (n == 1) {
			map.get(to).addFirst(map.get(from).removeFirst());
			System.out.println("          " + from + " _" + n + "_ -->" + to);
			count++;
			for (int i = 0; i < num; i++) {
				System.out.print("          ");
				for (int j = 1; j <= 3; j++) {
					for (int k = 1; k <= 2 * num - 1; k++) {
						int size = map.get(j).size();
						int stars = 0;
						if (num - i <= size) {
							stars = map.get(j).get(size + i - num);
							stars = 2 * stars - 1;
						}
						int spaces = (2 * num - 1 - stars) / 2;
						if (k <= spaces || k >= spaces + stars)
							System.out.print(" ");
						else
							System.out.print("█");
					}
					System.out.print(" ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		//第一步 先将n-1层挪到t盘上,缓冲
		hanoi(n - 1, from, t);
		//第二步 将最底层的碟子移到目标盘上
		map.get(to).addFirst(map.get(from).removeFirst());
		System.out.println("          " + from + " _" + n + "_ -->" + to);
		count++;
		for (int i = 0; i < num; i++) {
			System.out.print("          ");
			for (int j = 1; j <= 3; j++) {
				for (int k = 1; k <= 2 * num - 1; k++) {
					int size = map.get(j).size();
					int stars = 0;
					if (num - i <= size) {
						stars = map.get(j).get(size + i - num);
						stars = 2 * stars - 1;
					}
					int spaces = (2 * num - 1 - stars) / 2;
					if (k <= spaces || k >= spaces + stars)
						System.out.print(" ");
					else
						System.out.print("█");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
		//最后一步,将t盘上的碟子移到目标盘上
		hanoi(n - 1, t, to);
	}
}
