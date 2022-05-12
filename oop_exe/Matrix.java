import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Matrix implements BinaryOperator {


    public double[][] mat;

    public int row;
    public int col;
    public int size;

    private static Matrix res;
    private static double temp;

    public Matrix(int row, int col) {
        this.setDim(row, col);
    }

    public Matrix(int row, int col, double numToFill) {
        this.setDim(row, col);
        this.fill(numToFill);
    }

    public void fill(double num) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = num;
            }
        }
    }

    public Matrix(double[]... rows_cols) {
        ArrayList<double[]> row_lists = new ArrayList<>();
        ArrayList<Double> elements = new ArrayList<>();
        int row_count = 0;
        int col_count = 0;
        int row_length = 0;
        int col_length = 0;

        for (double[] row_list : rows_cols) {
            row_lists.add(row_list);
            row_count++;

            for (double eles : row_list) {
                col_count++;
                elements.add(eles);
            }

            col_length = col_count;
            col_count = 0;

        }

        row_length = row_count;

        this.setDim(row_length, col_length);
        this.getDim();

        int ele_count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp = elements.get(ele_count);
                this.set(i, j, temp);
                ele_count++;
            }
        }
    }

    public void setDim(int row, int col) {
        this.row = row;
        this.col = col;
        this.size = row * col;
        this.mat = new double[row][col];
    }

    public int[] getDim() {
        return new int[]{row, col};
    }

    public void set(int row, int col, double newNum) {
        mat[row][col] = newNum;
    }

    public double get(int row, int col) {
        return mat[row][col];
    }

    public static Matrix add(Matrix mat1, Matrix mat2) {
        if (mat1.size != mat2.size || ((mat1.row != mat2.row) && (mat1.col != mat2.col))) {
            System.out.println("Matrices cannot be added");
            ArrayIndexOutOfBoundsException error = new ArrayIndexOutOfBoundsException();
            throw error;
        }

        res = new Matrix(mat1.row, mat1.col);

        for (int i = 0; i < mat1.row; i++) {
            for (int j = 0; j < mat1.col; j++) {
                temp = mat1.get(i, j) + mat2.get(i, j);
                res.set(i, j, temp);
            }
        }

        return res;
    }

    public static Matrix minus(Matrix mat1, Matrix mat2) {
        if (mat1.size != mat2.size || ((mat1.row != mat2.row) && (mat1.col != mat2.col))) {
            System.out.println("Matrices cannot be added");
            ArrayIndexOutOfBoundsException error = new ArrayIndexOutOfBoundsException();
            throw error;
        }

        res = new Matrix(mat1.row, mat1.col);

        for (int i = 0; i < mat1.row; i++) {
            for (int j = 0; j < mat1.col; j++) {
                temp = mat1.get(i, j) - mat2.get(i, j);
                res.set(i, j, temp);
            }
        }

        return res;
    }

    public static Matrix timesEleWise(Matrix mat1, Matrix mat2) {
        if (mat1.size != mat2.size || ((mat1.row != mat2.row) && (mat1.col != mat2.col))) {
            System.out.println("Matrices cannot be added");
            ArrayIndexOutOfBoundsException error = new ArrayIndexOutOfBoundsException();
            throw error;
        }

        res = new Matrix(mat1.row, mat1.col);

        for (int i = 0; i < mat1.row; i++) {
            for (int j = 0; j < mat1.col; j++) {
                temp = mat1.get(i, j) * mat2.get(i, j);
                res.set(i, j, temp);
            }
        }

        return res;
    }

    public static Matrix times(Matrix mat1, Matrix mat2, double decimal) {

        double roundoff = Math.pow(10, decimal);

        res = new Matrix(mat1.row, mat2.col);

        for (int i = 0; i < mat1.row; i++) {
            for (int j = 0; j < mat2.col; j++) {
                double sum = 0;
                for (int k = 0; k < mat1.col; k++) {
                    sum += mat1.get(i, k) * mat2.get(k, j);
                }
                double rounded_sum = Math.round(sum * roundoff) / roundoff;
                res.set(i, j, rounded_sum);
            }
        }

        return res;
    }

    public static Matrix divideEleWise(Matrix mat1, Matrix mat2) {
        if (mat1.size != mat2.size || ((mat1.row != mat2.row) && (mat1.col != mat2.col))) {
            System.out.println("Matrices cannot be added");
            ArrayIndexOutOfBoundsException error = new ArrayIndexOutOfBoundsException();
            throw error;
        }

        res = new Matrix(mat1.row, mat1.col);

        for (int i = 0; i < mat1.row; i++) {
            for (int j = 0; j < mat1.col; j++) {
                temp = mat1.get(i, j) / mat2.get(i, j);
                res.set(i, j, temp);
            }
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();


        for (int i = 0; i < row; i++) {
            str.append("(");
            for (int j = 0; j < col; j++) {
                str.append(mat[i][j]);
                if (j < col - 1) str.append(",\t");
                if (j == col - 1) str.append(")");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public static void printMatrices(Matrix... args) {
        int len = args.length;
        for (int i = 0; i < len; i++) {
            System.out.printf("Matrix %d:\n", i + 1);
            System.out.println(args[i]);
        }
    }

    public static Matrix generateRandom(int m, int n, double generateRange, double decimal) {
        /** generateRange = 10; // range between 1~10
         * m: row number
         * n: col number
         * initialize empty matrix
         */
        ArrayList<Double> temp = new ArrayList<>();
        ArrayList<ArrayList<Double>> res = new ArrayList<>();

        double roundoff = Math.pow(10, decimal);
        double[][] mat = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = Math.round(1 + generateRange * Math.random() * roundoff) / roundoff;
            }
        }

        return new Matrix(mat);
    }

    @Override
    public BiFunction andThen(Function after) {
        return BinaryOperator.super.andThen(after);
    }

    @Override
    public Matrix apply(Object mat1, Object mat2) {
        Matrix a = (Matrix) mat1;
        Matrix b = (Matrix) mat2;
        return Matrix.times(a, b, 1);
    }

    BiFunction<Matrix,Matrix, Matrix> times = (mat1,mat2) -> apply(mat1,mat2);

    public static void main(String[] args) {
        double[][] list = {{3, 4}, {7, 2}, {5, 9}};
        double[][] list2 = {{3, 1, 5}, {6, 9, 7}};

        Matrix mat1 = new Matrix(list);
        Matrix mat2 = new Matrix(list2);

        printMatrices( mat1, mat2, Matrix.times(mat1,mat2,1) , new Matrix(new double[][]{{1},{1}}) );

    }


}
