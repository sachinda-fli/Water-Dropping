package com.company;

public class waterDropping2 {

    public static void main(String[] args) {
	// write your code here

            // write your code here
            int[][] input = new int[][]{
                    {0,0,0,0,0,0,0},
                    {1,0,0,0,0,0,0},
                    {0,0,1,1,1,0,0},
                    {0,0,0,0,0,0,0},
                    {1,1,1,0,0,1,0},
                    {0,0,0,0,0,0,1},
                    {0,0,0,0,0,0,0}
            };

            pourWater(input, 2);
        }

        public static void pourWater(int array[][], int y){
            int result[] = new int[7];
            util(array, 0, y, 100, result);

            for (int bucket : result){
                System.out.println(bucket + " , ");
            }
        }

        public static void util(int array[][], int x, int y, int precentage, int result[]){
            if (array.length -1 == x){
                result[y] = precentage;
                return;
            }

            if (array[x][y] == 0){
                util(array, x + 1, y, precentage, result);
            }

            if (array[x + 1][y] == 1){
                int temp;
                if (y + 1 < array[x].length) {
                    temp = y;
                    while (temp < array[x].length && array[x + 1][temp] == 1) {
                        temp++;
                        if (temp > array[x].length)
                            return;

                    }
                    util(array, x + 1, temp, precentage / 2, result);
                }
                if (y - 1 > - 1) {
                    temp = y;
                    while (temp > -1 && array[x + 1][temp] == 1) {
                        temp--;
                        if (temp < 0)
                            return;
                    }
                    util(array, x + 1, temp, precentage / 2, result);
                }
            }
    }
}
