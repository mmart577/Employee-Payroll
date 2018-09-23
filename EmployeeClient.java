import java.util.*;
import java.text.*;
public class EmployeeClient 
{
   public static void main(String[] args)
   {
      ArrayList<Employee> payrol = new ArrayList<>();
      Random generator = new Random();
      for (int k = 1; k <= 100; k++)
         payrol.add( randomEmployee() );

      //Add hours for Managers and HourlyEmployees
      int size = TimeCard.Day.values().length;

      for(int x = 0; x < payrol.size(); x++)
      {
          if(payrol.get(x) instanceof Hourly)
          {
              if(payrol.get(x) instanceof Regular)
              {
                  ((Regular)payrol.get(x)).addHours(TimeCard.Day.MONDAY, generator.nextInt(15));
                  ((Regular)payrol.get(x)).addHours(TimeCard.Day.TUESDAY, generator.nextInt(15));
                  ((Regular)payrol.get(x)).addHours(TimeCard.Day.WEDNESDAY, generator.nextInt(15));
                  ((Regular)payrol.get(x)).addHours(TimeCard.Day.THURSDAY, generator.nextInt(15));
                  ((Regular)payrol.get(x)).addHours(TimeCard.Day.FRIDAY, generator.nextInt(15));
              }
              if(payrol.get(x) instanceof Occasional)
              {
                  ((Occasional)payrol.get(x)).addHours(TimeCard.Day.values()[generator.nextInt(size)], generator.nextInt(15));
                  ((Occasional)payrol.get(x)).addHours(TimeCard.Day.values()[generator.nextInt(size)], generator.nextInt(15));
                  ((Occasional)payrol.get(x)).addHours(TimeCard.Day.values()[generator.nextInt(size)], generator.nextInt(15));
                  ((Occasional)payrol.get(x)).addHours(TimeCard.Day.values()[generator.nextInt(size)], generator.nextInt(15));
              }
          }
          if(payrol.get(x) instanceof Manager) 
          {
              ((Manager)payrol.get(x)).setBonus(generator.nextInt(50));
          }
      }
      
      Collections.sort(payrol, new CategoryOrder());
      
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      for (Employee emp : payrol)
          System.out.println(emp.toString());
   }
   
   private static Employee randomEmployee()
   {
       Random generator = new Random();
       int key = generator.nextInt(100);
       Employee emp;
       if ( key <= 5)
          return new Administrator(600.00 + generator.nextInt(400));
       if (key <= 15)
          return new Manager(Salaried.MINIMUM_WAGE + generator.nextInt(200));
       if (key <= 85)
          return new Regular(Hourly.MINIMUM_WAGE + generator.nextInt(8));
       
       return new Occasional(Hourly.MINIMUM_WAGE + generator.nextInt(5));              
   }
  
   //Compare Employees by category: Administrator < Manager < Regular < Occasional
   //Within categories, Employees are compared by identification number
   public static class CategoryOrder implements Comparator<Employee>
   {
      @Override
      public int compare(Employee one, Employee two)
      { 
      
      String num1[] = one.getIdNumber().split("-");
      String num2[] = two.getIdNumber().split("-");

      int id1 = Integer.parseInt(num1[2]);           //Gets the last 4 digits of the id
      int id2 = Integer.parseInt(num2[2]);
      
      if(one instanceof Occasional && two instanceof Regular)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Occasional && one instanceof Regular)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      if(one instanceof Occasional && two instanceof Manager)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Occasional && one instanceof Manager)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      if(one instanceof Occasional && two instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Occasional && one instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      
      if(one instanceof Regular && two instanceof Manager)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Regular && one instanceof Manager)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      if(one instanceof Regular && two instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Regular && one instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      
      if(one instanceof Manager && two instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return -1;
      }
      if(two instanceof Manager && one instanceof Administrator)
      {
          if(one.getClass().equals(two.getClass()))
              return id1 - id2;
          return 1;
      }
      
      return 0;
      }
   }
   }
     
 
  