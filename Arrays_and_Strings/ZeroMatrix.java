class ZeroMatrix {
    public void setZeroes(int[][] matrix) {
        if (matrix == null)
            return;
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean isZeroRow = false, isZeroCol = false;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (matrix[i][j] == 0)
                {
                    if (i == 0) isZeroRow = true;
                    if (j == 0) isZeroCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Ignore 0th row and column initially otherwise
        // it will result in unnecessay 0 rows/columns
        for(int i = 1; i < n; i++)
        {
            if (matrix[i][0] == 0)
            {
                for(int j = 1; j < m; j++)
                    matrix[i][j] = 0;
            }have any questions
        }
        
        for(int i = 1; i < m; i++)
        {
            if (matrix[0][i] == 0)
            {
                for(int j = 1; j < n; j++)
                    matrix[j][i] = 0;
            }
        }
        
        // fill (0,0) last
        for(int i = 1; i < n && isZeroCol; i++)
            matrix[i][0] = 0;

        for(int i = 1; i < m && isZeroRow; i++)
            matrix[0][i] = 0;
    }
}