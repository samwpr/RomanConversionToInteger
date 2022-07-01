import java.util.*;

class solution {
    public static int romanToInt(String s) {

        String upperS = s.toUpperCase();
        int result = 0;

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        if(upperS.length() < 1 || upperS.length() > 15){
            System.out.println("Length of Roman numeral need to be 1 to 15");
        }

        for(int j = 0; j < upperS.length(); j++){
            if(roman.containsKey(upperS.charAt(j)) == false){
                System.out.println("Only enter the following characters: I, V, X, L, C, D, M");
                System.exit(0);
            }
        }

        for(int i = 0; i < upperS.length(); i++){
            if(i > 0 && roman.get(upperS.charAt(i)) > roman.get(upperS.charAt(i - 1))){
                result += roman.get(upperS.charAt(i)) - 2 * roman.get(upperS.charAt(i - 1));
            } else {
                result += roman.get(upperS.charAt(i));
            }
        }


        return result;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Roman Characters: ");

        String enterRoman = input.nextLine();
        System.out.println(romanToInt(enterRoman));
    }
}

