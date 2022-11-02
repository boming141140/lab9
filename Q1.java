import java.util.Scanner;

/*
BomingZheng
112203270
CSE114
Lab9_P1
 */
public class Q1 {
    public static void sort(int [][]m){
        m = helpSort(m,0);
        for(int i = 0; i < m.length; i++){
            System.out.println();
            for(int j =0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
        }
    }
    private static int[][] helpSort(int[][] m, int position) {
        if(m.length == 0 || m.length == 1 || position > m[0].length-1){
            return m;
        }
        int countB = 0;
        int countS = 0;
        int countM = 1;
        int[][] bigger = new int[m.length][1];
        int[][] smaller = new int[m.length][1];
        int[][] mid = new int[m.length][1];
        mid[0] = m[m.length -1];
        for(int i = 0; i < m.length-1; i++) {
            if(m[i][position] > mid[0][position])
                bigger[countB++] = m[i];
            else if(m[i][position] < mid[0][position]){
                smaller[countS++] = m[i];
            }else{
                mid[countM++] = m[i];
            }

        }
        int[][] biggerR = new int[countB][1];
        int[][] midR = new int[countM][1];
        int[][] smallerR = new int[countS][1];
        for(int i = 0; i < countB; i++){
            biggerR[i] = bigger[i];
        }
        for(int i = 0; i < countM; i++){
            midR[i] = mid[i];
        }
        for(int i = 0; i < countS; i++){
            smallerR[i] = smaller[i];
        }

        return combine(helpSort(smallerR,position), helpSort(midR,position+1), helpSort(biggerR,position));
    }

    private static int[][] combine(int[][] a,int[][] mid, int[][]b) {
        int[][] sum = new int[a.length+b.length+mid.length][2];
        System.arraycopy(a,0,sum,0,a.length);
        System.arraycopy(mid,0,sum,a.length, mid.length);
        System.arraycopy(b,0,sum,a.length+mid.length,b.length);
        return sum;
    }
    private static boolean isDigit(String inp) {
        if(inp.length() == 0)
            return false;
        if(inp.lastIndexOf("-") != 0 && inp.lastIndexOf("-") != -1){
            return false;
        }
        for(int i = 0; i < inp.length(); i++) {
            if(!Character.isDigit(inp.charAt(i)))
                return false;
        }
        return true;
    }
    public static void main(String []args) {
        int [][] m = new int[0][0];
        boolean key = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of element you want to enter(Please be even).");
        String number = input.nextLine();
        if(isDigit(number)){
            int amount = Integer.parseInt(number);
            if(amount % 2 == 0){
                int amountS = amount;
                m = new int[amount/2][1];
                for(int i = 0; i < amount/2; i++){
                    int[] box = new int[2];
                    int count = 0;
                    for(int j = 0; j < 2; j++){
                        System.out.println(amountS--+" left to enter");
                        String elements = input.nextLine();
                        if(isDigit(elements)){
                            box[count++] = Integer.parseInt(elements);
                        }else {
                            System.out.println("Invalid Input detected, Program Terminated");
                            System.out.println("wow");
                            key = false;
                            break;
                        }
                    }
                    m[i] = box;
                    if(!key)
                        break;
                }
            }else{
                System.out.println("PLease enter even amount of element.");
            }

        }else{
            System.out.println("Invalid Input detected, Program Terminated.");
        }
        sort(m);

    }
}
