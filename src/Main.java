public class Main {

    public static void main(String[] args) {
        String[][] array ={
                {"1","2","4","5"},
                {"1","2","4","5"},
                {"1","2","4","5"},
                {"1","2","4","а"}
        };
        try {
            System.out.println(calculateSumOfNumbers(array));
        }catch (MyArraySizeException | MyArrayDataException ex){
            ex.getMessage();
        }
    }

    static double calculateSumOfNumbers(String [][] array) throws MyArraySizeException,MyArrayDataException{
        if (array.length!=4 || array[0].length!=4){
            throw new MyArraySizeException("Ай-ай-ай, размер массива не 4х4");
        }
        double sum=0;
        for(int i=0;i<array.length;i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    int number = Integer.parseInt(String.valueOf(array[i][j]));
                    sum = sum + number;
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Упс! В массиве встретилось что-то отличное от числа, в ячейке под номером: "+i+", "+j);
                }

            }
        }
        return sum;
    }
}

