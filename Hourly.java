//  PROGRAMMER:  Melissa Martinez  3327216
//
//  CLASS:       COP 3337          TH 10:50am - 12:35pm
//
//  INSTRUCTOR:  Norman Pestaina   ECS 135
//
//  ASSIGNMENT:  #2 Inheritance   DUE Sunday 22/6
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//
public abstract class Hourly extends Employee
{
   public static final double MINIMUM_WAGE = 8.00;
   
   private TimeCard timecard = new TimeCard();
   private double pay = 0.0;
   private int hoursWorked = 0;
         
   public Hourly(double rate)
   {
      super(rate);
   }
   
   public Hourly()
   {
      super(MINIMUM_WAGE);
   }
   
   public void addHours(TimeCard.Day day, double hrs)
   {
       timecard.addHours(day, hrs);   
   }
  
   @Override
   public double grossPay()             //Will only calculate hours less than 41
   {
       hoursWorked = 0;
       pay = 0;
       
       for(TimeCard.Day a: TimeCard.Day.values())
       {
           hoursWorked += (int) this.timecard.getHours(a);
       } 
       if(hoursWorked <= MAX_WORK_WEEK)
       {
           pay = hoursWorked * this.getPayRate();
       }
       else
           pay = MAX_WORK_WEEK * this.getPayRate(); 
       
       return pay;
   }
   public int getHoursWorked()
   {
       int hours = 0;
       
       for(TimeCard.Day a: TimeCard.Day.values())
       {
           hours += (int) this.timecard.getHours(a);
       }
       return hours;
   }
   public TimeCard getTimeCard()
   {
       return this.timecard;
   }
   
   public abstract double overtime();       //Method to be implemented in both subclasses
   
   @Override
   public String toString()
   {
      return super.toString() + " Hours Worked: " + getHoursWorked() + " Gross Pay: $" + grossPay();
   }
   
   @Override
   public boolean equals(Object other)
   {
       if (!super.equals(other))
           return false;
         
       return this.timecard == ((Hourly)other).timecard &&
              this.pay == ((Hourly)other).pay && 
              this.hoursWorked == ((Hourly)other).hoursWorked;
   }
}
      
      