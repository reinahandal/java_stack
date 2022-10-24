import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        String greeting = String.format("Hello, %s. Lovely to see you.", name);
        return greeting;
    }
    // NINJA BONUS - OVERLOADING
    public String guestGreeting(String name, String dayPeriod) {
        String greeting = String.format("Good %s, %s, Lovely to see you.", dayPeriod, name);
        return greeting;
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        if(a > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if(b > -1) {
            return "At your service. As you wish, naturally.";
        }
        else {
            return "Right. And with that I shall retire.";
        }
    }
    
    // SENSEI BONUS - my own method using a String method
    public String alfredMood() {
        boolean angry = false;
        String angryResponse = "What do you want from me?";
        String happyResponse = "It's fun being a bot!";
        if(angry) {
            return angryResponse.toUpperCase();
        }
        else {
            return happyResponse;
        }
    }
}

