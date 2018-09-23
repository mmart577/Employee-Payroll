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
public abstract class Salaried extends Employee
{
   public static final double MINIMUM_WAGE = 455.00;
      
   public Salaried(double salary)
   {
      super(salary);
   }
   
   public Salaried()
   {
      super(MINIMUM_WAGE);
   }
   
   @Override
   public double grossPay()
   {
       return this.getPayRate();
   }
   
   @Override
   public String toString()
   {
       return super.toString() + " Gross Pay: $" + this.grossPay();
   }
}
