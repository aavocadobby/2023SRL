public class Experiment
{
   private static final double badCost = 2.43; // for a bad meal
   private static final double goodCost = 4.85; // for a good meal
   private static final double countyCost = 3.50; //$3.50 for a county meal, we assume is good
   

   public static Distribution totalDiet(double budget, int numMeals)
   {
      int good = 0;
      int bad = 0;
      double x = budget;
      while( (good + bad) < numMeals)
      {
         //first, check if can afford good meal. if yes, increase good meals and subtract from budget
         if(x >= goodCost)
         {
            good++;
            x -= goodCost;
         }
         //if can affort a bad meal, buy that, subtract from budget
         else if(x >= badCost)
         {
            bad++;   
            x -= badCost;
         }
         else
         {
            //if there are a nonzero number of good meals, replace a good meal with a bad meal
            if(good > 0)
            {
               good--;
               x += goodCost;
               x -= badCost;
               bad++;
            }
            
            //else: no more money, break
            else
               break;
         }
      }
      
      if( (good+bad) == numMeals)
         return new Distribution(good, bad, true);
      
      //insufficient budget
      return new Distribution(good, bad, false);
      
   }
   
   public static double calculateMinBudget(int numMeals)
   {
      return numMeals*badCost;
   }
   
   
   public static void main(String[] args)
   {
      //if a family has a weekly food budget of $50 to provide 11 meals, this is their distribution of good and bad
      Distribution d = totalDiet(calculateMinBudget(11), 11);
      System.out.println(calculateMinBudget(11));
      System.out.println(d.toString());
   
   }
}