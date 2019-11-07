

import java.util.Scanner;

public class tetromino {
	static int n, m;
	static int maxx;
	static int map[][];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = s.nextInt();
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (i + 3 < n)// |
				{
					int temp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
					if (temp > maxx)
						maxx = temp;
				}
				if (j + 3 < m)// ㅡ
				{
					int temp = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 1 < m))// ㅁ
				{
					int temp = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// L
				{
					int temp = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// ___ㅣ
				{
					int temp = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// 7
				{
					int temp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// ㅣ---^
				{
					int temp = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// _ㅣ
				{
					int temp = map[i + 2][j] + map[i + 2][j + 1] + map[i + 1][j + 1] + map[i][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// ㄱ
				{
					int temp = map[i][j] + map[i + 1][j + 2] + map[i][j + 1] + map[i][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// ㅣ-^
				{
					int temp = map[i + 2][j] + map[i + 1][j] + map[i][j] + map[i][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// |___
				{
					int temp = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// ㄴㄱ
				{
					int temp = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// _|-^
				{
					int temp = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// -^|_
				{
					int temp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// 번개
				{
					int temp = map[i][j + 1] + map[i + 2][j] + map[i + 1][j] + map[i + 1][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// ㅜ
				{
					int temp = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// ㅏ
				{
					int temp = map[i + 1][j + 1] + map[i][j] + map[i + 1][j] + map[i + 2][j];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 2 < n) && (j + 1 < m))// ㅓ
				{
					int temp = map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
					if (temp > maxx)
						maxx = temp;
				}
				if ((i + 1 < n) && (j + 2 < m))// ㅗ
				{
					int temp = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
					if (temp > maxx)
						maxx = temp;
				}
			}
		System.out.println(maxx);

	}
}
