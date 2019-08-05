import java.time.LocalDate;

public class Quote {
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };
    public static void main(String... args) {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfYear();
        int dayrel = day % 6; //To get the relative day. Apparently the 5th of August is the 217th day, which is in turn the 1st day of the 37th set of 6 days, and thus gets the 1st quote.
        
        String author = quotes[dayrel][0];
        String quote = quotes[dayrel][1];

        String[] authorsplit = author.split(" ");
        String authorcap = "";
        String quotecap = "";
        
        for(String names : authorsplit){
            authorcap += names.substring(0,1).toUpperCase() + names.substring(1) + " ";
        }
        
        if(quote.substring(quote.length()-1).equals("!")){ //The quote that has an exclamation mark at the end doesn't get anything at the end, whereas the rest does.
            quotecap = quote.substring(0,1).toUpperCase() + quote.substring(1); //Likely has to be changed if any quotes ever get added; if one that ends with a period is added it'll just get another one.
        }
        else{
            quotecap = quote.substring(0,1).toUpperCase() + quote.substring(1) + ".";
        }

        System.out.println("The quote of " + LocalDate.now() + " day #" + day + " of the year is: ");
        System.out.println("\"" + quotecap + "\"" + " by " + authorcap);
    }
}