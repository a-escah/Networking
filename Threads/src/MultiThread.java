
public class MultiThread implements Runnable {
	 private int [][] A;
	 private int [][] B;
	 private int [][] C;
	 
	 public MultiThread(int[][] A, int[][] B, int[][] C) {
	     this.A = A;
	     this.B = B;
	     this.C = C;
	 }
	 
	 
	 public void run() {
		  for (int i = 0; i < 4; i++) {
		   for (int j = 0; j < 20; j++) {
		    for (int k = 0; k < 20; k++) {
		     C[i][j] += A[i][k] * B[k][j];
		    }
		   }
		  }
		 }
	 }
	 
