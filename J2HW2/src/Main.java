import java.util.Arrays;

public class Main {
    public static String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static String[] str;
    public static String[][] multiStr = new String[4][4];
    public static int [][] intArray = new int [multiStr[0].length][];


    public static void makeArray (String regex) throws MisMatchSizeOfArray {
        int x = 0, y = 0;
        String[] str = s.split("\n");
        for (int i = 0; i < multiStr.length; i++) {
            for (int j = 0; j < multiStr[i].length; j++)
                multiStr[i][j] = str[i++];
        }
        while (true) {
            try{
                multiStr[x][y] = multiStr[x][y];

            } catch (MisMatchSizeOfArray e){
                e.printStackTrace();
            }
        }

    }
    public static void toInt (){
        for (int i = 0; i < multiStr.length; i++) {
            for (int j = 0; j < multiStr[i].length; j++)
                intArray[i][j] = Integer.parseInt(Arrays.deepToString(multiStr));
        }
    }

    public static int sumEl(int [][] intArray){
        int sum = 0;
        for (int[] ints : intArray) {
            for (int j = 0; j < intArray[0].length; j++) {
                sum = (sum + ints[j]) / 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws MisMatchSizeOfArray {
        makeArray("10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0");

        System.out.println(Arrays.toString(str));
        
        System.out.println(Arrays.deepToString(multiStr));

        toInt();

        System.out.println(Arrays.deepToString(intArray));

        sumEl(intArray);

        System.out.println(sumEl(intArray));
    }
}




