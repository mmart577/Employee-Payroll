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

public class Manager extends Salaried
{
   private double bonus = 0.0;        //total hours worked
   private double otPay = 0.0;        //total overtime pay
   private int otHours = 0;           //total overtime hours
   
   public Manager(double salary)
   {
       super(salary);
   }
   
   public void setBonus(double b)       //sets the amount of weekly hours
   {
       bonus = b;
   }
   
   public int getOvertimeHours()
   {
       if(bonus > MAX_WORK_WEEK)
           otHours = (int) bonus - MAX_WORK_WEEK;

       return otHours;
   }
   
   public double overtime()
   {
       if(bonus > MAX_WORK_WEEK)           //If hours greater than 40, calculate overtime pay
           return otPay = getOvertimeHours() * getPayRate()/40 * 1.5;
       
       else
           return otPay = 0.0;
   }
   
   @Override
   public String toString()
   {
       BigDecimal num1 = new BigDecimal(grossPay());
       BigDecimal num2 = new BigDecimal(overtime());
       
       DecimalFormat decimal = new DecimalFormat("0.00");          //In order to add doubles
       return "Type: " + this.getClass().getName() + " " + super.toString() + " Overtime Hours: " + getOvertimeHours() + " Total Pay: $" + decimal.format(grossPay()) + " + $" + overtime() + " = $" + decimal.format(num1.add(num2));
   }
   
}  