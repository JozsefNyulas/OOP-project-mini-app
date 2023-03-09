import java.util.HashMap;

public class IDandPasswords
{
    // hashmaps use a key and store data next to them

    HashMap<String,String> savedloginInfo = new HashMap<String, String>();

    public IDandPasswords()
    {
        savedloginInfo.put("Jozsef", "Password");
        savedloginInfo.put("Lidia", "Jelszo");
        savedloginInfo.put("Benjamin", "Cici");

    }

    protected HashMap getSavedloginInfo()
    {
        return savedloginInfo;
    }

    public void setSavedloginInfo(HashMap<String, String> savedloginInfo)
    {
        this.savedloginInfo = savedloginInfo;
    }
}

