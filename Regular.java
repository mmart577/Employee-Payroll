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

public class Regular extends Hourly
{   
   private double otHours = 0.0;
   private double otPay = 0.0;

   public Regular(double rate)
   {
      super(rate);
   }
   public int getOvertimeHours()
   {         
       if(this.getHoursWorked() > MAX_WORK_WEEK)
       {
           return this.getHoursWorked() - MAX_WORK_WEEK;
       }
       else
           return 0;
   }
   
   @Override
   public double overtime()
   {  
       return otPay = getOvertimeHours() * (this.getPayRate() * 1.5);
   }
   
   @Override
   public String toString()
   { 
       BigDecimal num1 = new BigDecimal(grossPay());
       BigDecimal num2 = new BigDecimal(overtime());
       
       DecimalFormat decimal = new DecimalFormat("0.00");             //In order to add doubles
       return "Type: " + this.getClass().getName() + " " + super.toString() + " Overtime Hours: " + this.getOvertimeHours() + " Total Pay: $" + this.grossPay() + " + $" + overtime() + " = $" + decimal.format(num1.add(num2));
   }
   
   @Override
   public boolean equals(Object other)
   {
      if (!super.equals(other))
         return false;
         
      return this.otPay == ((Regular)other).otPay &&
             this.otHours == ((Regular)other).otHours;
   }
}