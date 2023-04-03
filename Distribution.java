public class Distribution
{
   private int goodMeals;
   private int badMeals;
   private boolean sufficient;

   public Distribution(int g, int b, boolean s)
   {
      goodMeals = g;
      badMeals = b;
      sufficient = s;
   }
   
   public String toString()
   {
      return "good meals: "+goodMeals+", bad meals: "+badMeals+", is this sufficient? "+sufficient;
   }
}