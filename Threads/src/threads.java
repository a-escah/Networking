import java.util.*;

public class threads {
	public threads() {}
			
	public static int[][] generateMatrix(){
		 int[][] matrix20 = new int[20][20];
		 Random random = new Random();
		 for (int i = 0; i < 20; i++) {
			   for (int j = 0; j < 20; j++) {
			    matrix20[i][j] = random.nextInt(100);
			   }
		 }
		 return matrix20;
	}
	
	public static void printmatrix(int[][] matrix) {
		for (int i = 0; i < 20; i++) {
			   for (int j = 0; j < 20; j++) {
			    System.out.print(matrix[i][j] + "  ");
			   }
			   System.out.println();
			  }
	}
	
	 public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		  int resultRows = matrix1.length;
		  int resultColumns = matrix2[0].length;
		  int[][] result = new int[resultRows][resultColumns];
		  int columns2 = matrix2[0].length;
		  for (int i = 0; i < resultRows; i++) {
		   for (int j = 0; j < columns2; j++) {
		    result[i][j] = 0;
		    for (int k = 0; k < resultColumns; k++) {
		     result[i][j] += matrix1[i][k] * matrix2[k][j];
		    }
		   }
		  }
		  return result;
		 }
	 
	public static int[][] mergeArrays(int A[], int B[],int C[], int D[]) {
		 int result[][] = new int [4][20];
		 for (int i = 0; i < 20; i++) {
				 result[0][i] = A[i];
				 result[1][i] = B[i];
				 result[2][i] = C[i];
				 result[3][i] = D[i];
		 }
		 return result;
	}
	
	public static int[][] mergeMatrix(int A[][], int B[][], int C[][], int D[][], int E[][]){
		int result[][] = new int[20][20];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 4; j++) {
				result[j][i] = A[j][i];
				result[j+4][i] = B[j][i];
				result[j+8][i] = C[j][i];
				result[j+12][i] = D[j][i];
				result[j+16][i] = E[j][i];
			}
		}
		return result;
	}
		
	public static void main(String[] args) 
	{
		int[][] matrix1 = threads.generateMatrix();
		int[][] matrix2 = threads.generateMatrix();

		System.out.println("\nMatrix 1:");
		threads.printmatrix(matrix1);
		System.out.println("\nMatrix 2:");
		threads.printmatrix(matrix2);
		System.out.println("\nNormal Multiplication result:");
		threads.printmatrix(multiply(matrix1,matrix2));
		
		int[] A1 = matrix1[0];
		int[] A2 = matrix1[1];
		int[] A3 = matrix1[2];
		int[] A4 = matrix1[3];
		int[][] matrix1_a = mergeArrays(A1,A2,A3,A4);
		int[][] mul1 = new int[4][20];
		
		int[] B1 = matrix1[4];
		int[] B2 = matrix1[5];
		int[] B3 = matrix1[6];
		int[] B4 = matrix1[7];
		int[][] matrix1_b = mergeArrays(B1,B2,B3,B4);
		int[][] mul2 = new int[4][20];
		
		int[] C1 = matrix1[8];
		int[] C2 = matrix1[9];
		int[] C3 = matrix1[10];
		int[] C4 = matrix1[11];
		int[][] matrix1_c = mergeArrays(C1,C2,C3,C4);
		int[][] mul3 = new int[4][20];
		
		int[] D1 = matrix1[12];
		int[] D2 = matrix1[13];
		int[] D3 = matrix1[14];
		int[] D4 = matrix1[15];
		int[][] matrix1_d = mergeArrays(D1,D2,D3,D4);
		int[][] mul4 = new int[4][20];
		
		int[] E1 = matrix1[16];
		int[] E2 = matrix1[17];
		int[] E3 = matrix1[18];
		int[] E4 = matrix1[19];
		int[][] matrix1_e = mergeArrays(E1,E2,E3,E4);
		int[][] mul5 = new int[4][20];
		
		try {
			MultiThread thread1 = new MultiThread(matrix1_a,matrix2,mul1);
			MultiThread thread2 = new MultiThread(matrix1_b,matrix2,mul2);
			MultiThread thread3 = new MultiThread(matrix1_c,matrix2,mul3);
			MultiThread thread4 = new MultiThread(matrix1_d,matrix2,mul4);
			MultiThread thread5 = new MultiThread(matrix1_e,matrix2,mul5);
		
			Thread th1 = new Thread(thread1);
			Thread th2 = new Thread(thread2);
			Thread th3 = new Thread(thread3);
			Thread th4 = new Thread(thread4);
			Thread th5 = new Thread(thread5);

			th1.start();
			th2.start();
			th3.start();
			th4.start();
			th5.start();

			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();

    }catch (Exception e) {
        e.printStackTrace();
    }
		
		int[][] MultiThreadMul = mergeMatrix(mul1, mul2, mul3, mul4, mul5);
		System.out.println("\nMultiThreaded Multiplaction result:");
		threads.printmatrix(MultiThreadMul);
	}
}
