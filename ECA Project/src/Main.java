//Elementary
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        //rule number
        int c = s.nextInt();

        //converting to 8 bit binary
        String result= "00000000";
        int i=result.length()-1;
        while(c!=0)
        {
            char a[]=result.toCharArray();
            a[i--]= String.valueOf(c%2).charAt(0);
            result=new String(a);
            c=c/2;

        }
        System.out.println("The number converted in binary is: " + result);

        //placing the string into an array
        char array[] = new char[result.length()];
        for (int ii = 0; ii < result.length(); ii++) {
            array[ii] = result.charAt(ii);
        }
        /*for(char x : array){
            //System.out.println(x);
        }*/


        char [] firstGen = {'0','0','0','0','0','1', '0','0', '0','0','0'};
        System.out.println(firstGen);

        //number of generations
        for (int l=1; l<11 ; l++)
        {
            char [] nextGen = new char[11];

            for(int k=0; k<firstGen.length; k++){
                if (k == 0){
                    nextGen[k] = rules(array,firstGen[firstGen.length -1],firstGen[k], firstGen[k+1]);
                } else if(k == firstGen.length -1){
                    nextGen[k] = rules(array,firstGen[k-1], firstGen[k], firstGen[0]);
                }else{
                    nextGen[k] = rules(array, firstGen[k-1],firstGen[k],firstGen[k+1]);
                }
            }
            System.out.println(nextGen);
            firstGen = nextGen;
        }



    }

    //(the binary number => RULES)
    public static char rules(char arr[], char ln, char x, char rn){

        //Rule1 1 1 1
        if(ln == '1' && x == '1' && rn == '1'){
            return arr[0];
        }

        //Rule2 1 1 0
        if(ln == '1' && x == '1' && rn == '0'){
            return arr[1];
        }

        //Rule3 1 0 1

        if(ln == '1' && x == '0' && rn == '1'){
            return arr[2];
        }
        //Rule4 1 0 0

        if(ln == '1' && x == '0' && rn == '0'){
            return arr[3];
        }
        //Rule5 0 1 1

        if(ln == '0' && x == '1' && rn == '1'){
            return arr[4];
        }
        //Rule6 0 1 0

        if(ln == '0' && x == '1' && rn == '0'){
            return arr[5];
        }
        //Rule7 0 0 1
        if(ln == '0' && x == '0' && rn == '1'){
            return arr[6];
        }
        //Rule8 0 0 0
        else
            return arr[7];

    }

}