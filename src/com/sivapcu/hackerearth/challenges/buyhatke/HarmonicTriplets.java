package com.sivapcu.hackerearth.challenges.buyhatke;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HarmonicTriplets {
	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		int numOfTestCases = fr.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < numOfTestCases; i++) {
			int n = fr.nextInt();
			int q = fr.nextInt();
			Item[] arr = new Item[n];
			for (int j = 0; j < n; j++) {
				arr[j] = new Item(fr.nextInt(), j);
			}

			Arrays.sort(arr);

			for (int j = 0; j < q; j++) {
				int pivot = fr.nextInt() - 1;
				if (pivot <= 0 || pivot >= n - 1) {
					pw.println(0);
					continue;
				}

				for (int k = 0; k < n; k++) {
					if (arr[k].index == pivot) {
						int sortedArrayPivot = k;
						int left = -1;
						int right = -1;
						boolean rightFound = false;
						boolean leftFound = false;
						Item pivotItem = arr[sortedArrayPivot];
						for (int r = sortedArrayPivot + 1; r < n && arr[r].value == pivotItem.value; r++) {
							if (leftFound && rightFound) {
								break;
							}
							if (arr[r].index > pivotItem.index) {
								rightFound = true;
								right = arr[r].value;
							} else {
								leftFound = true;
								left = arr[r].value;
							}
						}

						for (int l = sortedArrayPivot - 1; l >= 0 && arr[l].value <= pivotItem.value; l--) {
							if (leftFound && rightFound) {
								break;
							}
							if (!leftFound && arr[l].index < pivotItem.index) {
								left = arr[l].value;
								leftFound = true;
							} else if (!rightFound && arr[l].index > pivotItem.index) {
								right = arr[l].value;
								rightFound = true;
							}
						}

						if (left == -1 || right == -1) {
							pw.println(0);
						} else {
							pw.println(left * right * arr[k].value);
						}
						break;
					}
				}
			}
		}
		pw.flush();

	}

	static class FastReader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public FastReader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public FastReader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}

class Item implements Comparable<Item> {
	public Item(int value, int index) {
		this.value = value;
		this.index = index;
	}

	int value;
	int index;

	@Override
	public int compareTo(Item o) {
		return this.value == o.value ? 0 : this.value > o.value ? 1 : -1;
	}

	@Override
	public String toString() {
		return "Item [value=" + value + ", index=" + index + "]";
	}
}
