//  PROGRAMMER:  Melissa MArtinez  3327216
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
public class Administrator extends Salaried
{      
   public Administrator(double salary)
   {
       super(salary);
   }
   
   @Override
   public String toString()
   {
       return "Type: " + this.getClass().getName() + " Pay Rate: $" + getPayRate() + " Total Pay: $" + grossPay();// + super.toString();
   }
}