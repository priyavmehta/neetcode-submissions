class NumMatrix {
    private int sum[][];

    public NumMatrix(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];

        sum[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            if (i > 0) {
                sum[i][0] = sum[i - 1][0] + matrix[i][0];
            }

            for (int j = 1; j < matrix[0].length; j++) {
                sum[i][j] = sum[i][j-1] + matrix[i][j];
                if (i > 0) {
                    sum[i][j] += sum[i-1][j] - sum[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = sum[row2][col2];
        if (row1 > 0) {
            totalSum -= sum[row1 - 1][col2];
        }

        if (col1 > 0) {
            totalSum -= sum[row2][col1 - 1];
        }

        if (row1 > 0 && col1 > 0) {
            totalSum += sum[row1 - 1][col1 - 1];
        }

        return totalSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */