public abstract class Employee
{
   //Class Constants
   public static final int MAX_WORK_WEEK = 40;
   public static final int MAX_WORK_DAY = 9;
   
   //Instance Variables
   private String idNumber;   //Identification Number
   private double payRate;    //Pay-Rate: Weekly if SALARIED, or Hourly
   
   //Constructor
   public Employee(double payRate)
   {
      this.idNumber = newIdNumber();
      this.payRate = payRate;
   }
   
   //Accessor
   public String getIdNumber()
   {
      return this.idNumber;
   }
   
   //Accessor
   public double getPayRate()
   {
      return this.payRate;
   }
   
   //Specified for subclasses
   public abstract double grossPay();
   
   @Override
   public String toString()
   {
      return "ID Number: " + getIdNumber() + " Pay Rate: $" + getPayRate();
   }
   
   @Override
   public boolean equals(Object other)
   {
      return super.equals(other);
   }
   
   //Helper - Creates a new unique Identification Number
   private static int lastNumber = 999999;
   private String newIdNumber()
   {
      String id = "" + 9 + (++lastNumber);
      return id.substring(0, 1) + "-" + id.substring(1, 4)
                                + "-" + id.substring(4);
   }
}