public class Main {

    public static void main(String[] args) {
        String[][] array ={
                {"1","2","4","5"},
                {"1","","4","5"},
                {"1","2","4","5"},
                {"1","2","4","5"}
        };
        try {
            System.out.println(calculateSumOfNumbers(array));
        }catch (MyArraySizeException | MyArrayDataException ex){
            ex.getMessage();
        }
    }

    static double calculateSumOfNumbers(String [][] array) throws MyArraySizeException,MyArrayDataException{
        if (array.length==4){
            for(int i=0;i<array.length;i++){
                if (array[i].length!=4){
                    throw new MyArraySizeException("Ай-ай-ай, размер массива не 4х4");
                }
            }
        }
        else{
            throw new MyArraySizeException("Ай-ай-ай, размер массива не 4х4");
        }
        double sum=0;
        for(int i=0;i<array.length;i++) {
            for (int j = 0; j < array.length; j++) {
                char[] arrayChar = array[i][j].toCharArray();
                if (arrayChar.length==0){
                    throw new MyArrayDataException("Упс! В массиве встретилось пустое значение, в ячейке под номером: " + i + ", " + j);
                }
                for (int c = 0; c < arrayChar.length; c++) {
                    if (isNumber(arrayChar[c]) == false) {
                        throw new MyArrayDataException("Упс! В массиве встретилось что-то отличное от числа, в ячейке под номером: " + i + ", " + j);
                    }
                }
                int number = Integer.parseInt(String.valueOf(array[i][j]));
                sum = sum + number;
            }
        }
        return sum;
    }
    static boolean isNumber(char i) throws NumberFormatException{
        try {
            Integer.parseInt(String.valueOf(i));
            return true;
        } catch (NumberFormatException e) { return false; }
    }
}

