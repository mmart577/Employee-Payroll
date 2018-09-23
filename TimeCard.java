public class TimeCard
{
   
   //Instance Variable
   private double[] hours;
   
   //Constructor
   public TimeCard()
   {
       this.hours = new double[Day.values().length];
       
       //Initially, there are no hours on this timecard
       for (int x = 0; x < this.hours.length; x++)
       {
           this.hours[x] = 0.0;
       }
   }
   
   //Accessor
   public double getHours(Day day)            //Access hours for any single day
   {
       switch(day)
      {
           case SUNDAY:    return hours[0];
           case MONDAY:    return hours[1];
           case TUESDAY:   return hours[2];
           case WEDNESDAY: return hours[3];
           case THURSDAY:  return hours[4];
           case FRIDAY:    return hours[5];
           case SATURDAY:  return hours[6];
           default:        return 0.0;
      }
   }
   
   //Accessor
   public double[] getHours()                    //Access hours for all the days
   {
      return hours;
   }
   
   //Mutator: Update the recorded hours for any single day
   public void addHours(Day day, double hrs)
   {
       if(hours[day.ordinal()] != 0.0)
           this.hours[day.ordinal()] = hrs;    //Checks if the location is empty
       
       else
           this.hours[day.ordinal()] += hrs;
   }
   
   //Mutator: Clear recorded hours for all days to 0.0
   public void reset()
   {
      for(Day d : Day.values())
      {
         this.hours[d.ordinal()] = 0.0;
      }
   }
   
   //Override
   public String toString()
   {
      String image = "";
      for (Day d : Day.values())
          image += d + ": " + this.hours[d.ordinal()] + " hours, ";

      
      return "Time Card: \n" + image.trim();
   }
   
   public enum Day
   {
      SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
      
      public String abbreviated()
      {
         return this.toString().toUpperCase().substring(0, 2);
      }
   }
}


