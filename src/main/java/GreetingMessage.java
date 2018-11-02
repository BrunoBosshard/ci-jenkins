public class GreetingMessage {
  
     private String message;
     private int hours;

     // constructor
     public GreetingMessage(){
      
      DateTime var = new DateTime();
        this.hours = var.dateTime();

      if (hours < 12)
      this.message = "Good Morning!";
      else if (hours < 17 && !(hours == 12))
      this.message = "Good Afternoon!";
      else if (hours == 12)
      this.message = "Good Noon!";
      else
      this.message = "Good Evening!";
     }
      
     // return message 
     public String printMessage(){
        System.out.println(message);
        return message;
     }   
  } 
