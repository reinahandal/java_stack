import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Jackie and Wilson", "So tired trying to see from behind the red in my eyes No better version of me I could pretend to be tonight So deep in this swill with the most familiar of swine For reasons wretched and divine");
        trackList.put("Someone New", "Theres an art to lifes distractions To somehow escape the burning weight, the art of scraping through Some like to imagine The dark caress of someone else, I guess any thrill will do");
        trackList.put("From Eden", "Babe, theres something tragic about you Something so magic about you Dont you agree? Babe, theres something lonesome about you Something so wholesome about you Get closer to me");
        trackList.put("Work Song", "Boys workin on empty Is that the kinda way to face the burning heat? I just think about my baby Im so full of love I could barely eat Theres nothing sweeter than my baby Id never want once from the cherry tree Cause my babys sweet as can be Shed give me toothaches just from kissin me");
        
        String song = trackList.get("From Eden");
        System.out.println(song);

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}
