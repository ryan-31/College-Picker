import javax.swing.*;
import javax.swing.ImageIcon;

public class CollegePicker {
        public static void main(String[] args)
        {

            JFrame frame = new JFrame("College Picker");
            ImageIcon icon = new ImageIcon("D:\\Programming Projects\\CollegePickerGUI\\schoolicon.png");
            frame.setIconImage(icon.getImage());

            JOptionPane.showMessageDialog(frame, "Hi! This program will help you decide what college to go to based on factors that are important to you.");
            String numOfFactors = JOptionPane.showInputDialog("How many factors are important to you? Ex. if affordability,academics, social, and location are the main important factors, type 4");

            int numFactors = Integer.parseInt(numOfFactors);

            String[] factors = new String[numFactors];

            for (int i = 0; i < numFactors; i++){
                factors[i] = JOptionPane.showInputDialog("Please enter one factor that is important to you in the college picking process: (Affordability, Academics, Social, etc");
            }

            JOptionPane.showMessageDialog(frame,"Next, you are going to be asked to rank the importance of each factor out of 10. For example, if academics is the main factor, then enter 10.\n");

            int[] initWeight = new int[numFactors];
            String[] initWeightStr = new String[numFactors];

            for (int x = 0; x < factors.length; x++){
                initWeightStr[x] = JOptionPane.showInputDialog("How would you rank the importance of " + factors[x] + " out of 10?");
                initWeight[x] = Integer.parseInt(initWeightStr[x]);
            }

            String numSchoolsStr = JOptionPane.showInputDialog("Thanks! Now it's time to start 'grading' each school!\nHow many schools are you considering?");
            int numSchools = Integer.parseInt(numSchoolsStr);

            String[] schoolNames = new String[numSchools];

            for (int y = 0; y < numSchools; y++){
                System.out.println("Enter the name of school #" + (y+1));
                schoolNames[y] = JOptionPane.showInputDialog("Enter the name of school #" + (y+1));
            }


            if (numSchools >= 5)
                JOptionPane.showMessageDialog(frame,"Wow! That's a lot to choose from - hopefully this program will help narrow it down!");

            int[] scoreList = new int[numSchools];

            for (int z = 0; z < numSchools; z++){
                scoreList[z] = schoolRank(z, numFactors, schoolNames, factors, initWeight);
            }

            //determine index of highest score
            int highAt = 0;
            for (int d = 0; d < scoreList.length; d++) {
                highAt = scoreList[d] > scoreList[highAt] ? d : highAt;
            }

            JOptionPane.showMessageDialog(frame,"We have determined that " + schoolNames[highAt] + " may be best for you based on your criteria. It had a the highest score, with a final score of "+ scoreList[highAt]);

        }

        public static int schoolRank(int b, int facts, String[] schools, String[] criteria, int[] initCrit){
            int[] scores = new int[facts];
            String[] scoresStr = new String[facts];
            int finScore = 0;

            for (int c = 0; c <= facts - 1; c++) {
                scoresStr[c] = JOptionPane.showInputDialog("Out of 10, how would you rank " + schools[b] + "'s " + criteria[c] + "?\nEnter the number (Ex. Type 7 if it was 7/10)");
                scores[c] = Integer.parseInt(scoresStr[c]);
            }

            for (int ctr = 0; ctr < scores.length; ctr++){
                finScore += scores[ctr] * initCrit[ctr];
            }

            return finScore;
        }
    }

