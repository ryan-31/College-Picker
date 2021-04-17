public class CollegePicker
{
   public static void main(String[] args)
   {
       Scanner input = new Scanner(System.in);
       
       System.out.println("Hi! This program will help you decide what college to go to based on factors that are important to you.\nHow many factors are important to you? Ex. if affordability,academics, social, and location are the main important factors, type 4"); 
       int numFactors = input.nextInt(); 
       
       String[] factors = new String[numFactors]; 
       
       input.nextLine(); 
       
       for (int i = 0; i < numFactors; i++){
           System.out.println("Please enter one factor that is important to you in the collge picking process: (Affordability, Academics, Social, etc)"); 
           factors[i] = input.nextLine(); 
        }
       
       System.out.println("Next, you are going to be asked to rank the importance of each factor out of 10. For example, if academics is the main factor, then enter 10.\n");
       
       int[] initWeight = new int[numFactors]; 
       
       for (int x = 0; x < factors.length; x++){
           System.out.println("How would you rank the importance of " + factors[x] + " out of 10?");
           initWeight[x] = input.nextInt(); 
        }
        
       System.out.println("Thanks! Now it's time to start 'grading' each school!\nHow many schools are you considering?");
       int numSchools = input.nextInt(); 
       
       String[] schoolNames = new String[numSchools];
       input.nextLine();          
       for (int y = 0; y < numSchools; y++){
           System.out.println("Enter the name of school #" + (y+1)); 
           schoolNames[y] = input.nextLine(); 
        }
       
       
       if (numSchools >= 5)
        System.out.println("Wow! That's a lot to choose from - hopefully this program will help narrow it down!"); 
        
       int[] scoreList = new int[numSchools];
       
       for (int z = 0; z < numSchools; z++){ 
         scoreList[z] = schoolRank(z, numFactors, schoolNames, factors, initWeight);
        }
        
       //determine index of highest score
       int highAt = 0;
       for (int d = 0; d < scoreList.length; d++) {
           highAt = scoreList[d] > scoreList[highAt] ? d : highAt;
        }
       
       System.out.println("We have determined that " + schoolNames[highAt] + " may be best for you based on your criteria. It had a the highest score, with a final score of "+ scoreList[highAt]);
       
   }
   public static int schoolRank(int b, int facts, String[] schools, String[] criteria, int[] initCrit){
       int[] scores = new int[facts]; 
       int finScore = 0;
       Scanner in = new Scanner(System.in);
       
       for (int c = 0; c <= facts - 1; c++) {
           System.out.println("Out of 10, how would you rank " + schools[b] + "'s " + criteria[c] + "?\nEnter the number (Ex. Type 7 if it was 7/10)");
           scores[c] = in.nextInt(); 
       }
       
       int ctr = 0; 
       for (ctr = 0; ctr < scores.length; ctr++){
           finScore += scores[ctr] * initCrit[ctr];
        }
       
       return finScore;
   }
}