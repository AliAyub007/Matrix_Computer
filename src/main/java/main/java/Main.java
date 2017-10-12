package main.java;
import java.util.*;

public class Main {

	//my main class

    private static int rows1=0,rows2=0;
    private static int columns1=0,columns2=0;
    private static ArrayList<String> characters = new ArrayList<String>(10);
    static String read = "";
    private static String firstMatrix;
    private static String secondMatrix;
    private static Scanner input = new Scanner(System.in);
    private static int matrix1[][] = new int[100][100];
    private static int matrix2[][] = new int[100][100];

    public static void main(String[] args) {
        System.out.println("Instructions: \n - Enter your equation like \"A+B\" \n - User ^ this symbol for transpose i.e A^ - B \n - Separate with spaces");
        matrix matrix = new matrix();
        System.out.println("Enter your equation: ");
        String equation = input.nextLine();

        StringTokenizer stt = new StringTokenizer(equation," ");

        while (stt.hasMoreTokens()){
            String token = stt.nextToken();
            characters.add(token);
        }

        for (String character : characters) {
            System.out.println(character);
        }

        if(characters.size() == 3){
            if(isTranspose(characters.get(0))){
                firstMatrix = characters.get(0).replace(characters.get(0),"");
                initiateFirstMatrix();
                matrix1 = matrix.transposeMatrix(matrix1,rows1,columns1);

            } else if(isInverse(characters.get(0))){
                firstMatrix = characters.get(0).replace(characters.get(0),"");
                initiateFirstMatrix();
                matrix1 = matrix.transposeMatrix(matrix1,rows1,columns1);

            } else {
                firstMatrix = characters.get(2);
                initiateFirstMatrix();
            }

            if(isTranspose(characters.get(2))){
                secondMatrix = characters.get(2).replace(characters.get(2),"");
                initiateSecondMatrix();
                matrix2 = matrix.transposeMatrix(matrix2,rows2,columns2);
            } else if(isInverse(characters.get(2))){
                secondMatrix = characters.get(2).replace(characters.get(2),"");
                initiateSecondMatrix();
                matrix2 = matrix.transposeMatrix(matrix2,rows2,columns2);
            } else {
                secondMatrix = characters.get(2);
                initiateSecondMatrix();
            }

            switch (characters.get(1)) {
                case "+":
                    int addMatrix[][] = new int[rows1][columns1];
                    addMatrix = matrix.addMatrix(matrix1, matrix2, rows1, columns1, rows2, columns2);
                    display(addMatrix);
                    break;
                case "-":
                    int subMatrix[][] = new int[rows1][columns1];
                    subMatrix = matrix.subtractMatrix(matrix1, matrix2, rows1, columns1, rows2, columns2);
                    display(subMatrix);
                    break;
                case "*":
                    int mulMatrix[][] = new int[rows1][columns1];
                    mulMatrix = matrix.multiplyMatrix(matrix1, matrix2, rows1, columns1, rows2, columns2);
                    display(mulMatrix);
                    break;
            }
        }
    }

    private static boolean isTranspose(String name){
        return name.endsWith("^");
    }

    private static boolean isInverse(String name){
        return name.endsWith("^");
    }

    private static void initiateFirstMatrix(){
        System.out.println("First matrix:");
        System.out.println("Enter rows of matrix:");
        rows1 = input.nextInt();
        System.out.println("Enter columns of matrix:");
        columns1 = input.nextInt();
        System.out.println("Enter values for matrix: ");
        Random random = new Random();

        for (int i=0; i<rows1; i++){
            for (int j=0; j<columns1; j++){
                matrix1[i][j] = random.nextInt(50) + 1;
            }
        }
    }

    private static void initiateSecondMatrix(){
        System.out.println("Second matrix:");
        System.out.println("Enter rows of matrix:");
        rows2 = input.nextInt();
        System.out.println("Enter columns of matrix:");
        columns2 = input.nextInt();
        System.out.println("Enter values for matrix: ");
        Random random = new Random();

        for (int i=0; i<rows2; i++){
            for (int j=0; j<columns2; j++){
                matrix2[i][j] = random.nextInt(50) + 1;
            }
        }
    }

    private static void display(int[][] matrix){
        System.out.println("Resultant matrix is: ");
        if(matrix == null){
            return;
        }else {
            for (int i=0; i<rows2; i++){
                for (int j=0; j<columns2; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }
}