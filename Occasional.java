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
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Occasional extends Hourly
{
   private double otHrs = 0.0; 
   private double otPay = 0.0;
   
   public Occasional(double rate)
   {
      super(rate);
   }
   public double getOvertimeHours()
   {
       int hours = 0;
       
       for(TimeCard.Day a: TimeCard.Day.values())
       {
           if(getTimeCard().getHours(a) > MAX_WORK_DAY)
               hours += getTimeCard().getHours(a) - MAX_WORK_DAY;
       }
       return hours;
   }
    
   @Override
   public double overtime()
   {
       otHrs = 0;
       
       for(TimeCard.Day a: TimeCard.Day.values())
       {
           if(this.getTimeCard().getHours(a) > MAX_WORK_DAY)
               this.otHrs += this.getTimeCard().getHours(a) - MAX_WORK_DAY;
           else
               this.otHrs += 0;
       }
       otPay = otHrs * (this.getPayRate() * 1.5);
       return otPay;
   }
   
   @Override
   public String toString()
   {
       BigDecimal num1 = new BigDecimal(grossPay());
       BigDecimal num2 = new BigDecimal(overtime());
       
       DecimalFormat decimal = new DecimalFormat("0.00");            //In order to add doubles
       return "Type: " + this.getClass().getName() + " " + super.toString() + " Overtime Hours: " + this.getOvertimeHours() + " Total Pay: $" + super.grossPay() + " + $" + overtime() + " = $" + decimal.format(num1.add(num2));
   }
   
   @Override
   public boolean equals(Object other)
   {
       if (!super.equals(other))
           return false;
         
       return this.otPay == ((Occasional)other).otPay && 
              this.otHrs == ((Occasional)other).otHrs;
   }
}