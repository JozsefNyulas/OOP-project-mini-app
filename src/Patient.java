public class Patient extends WriteToFile
{
    private String userId;
    private String password;
    public static int generalId = -1;
    private int patientId;
    private static String bmiIndex;
    private static String bloodPressure;
    private static String hearingResult;
    private static String visionResult;



    // private String occupation ;
    // ??  ha pl sofor es rosszul lat mas valaszt adjon ki vegul...
    // constructor overloadingra

    public Patient()
    {

    };
    public Patient(String userId, String password)
    {
        this.userId = userId;
        this.password = password;
        generalId++;
        patientId = generalId;

    }




    public void setPatientId(int patientId)
    {
        this.patientId = patientId;
    }

    public static String getBmiIndex()
    {
        return bmiIndex;
    }

    public static String getBloodPressure()
    {
        return bloodPressure;
    }

    public static String getHearingResult()
    {
        return hearingResult;
    }

    public static String getVisionResult()
    {
        return visionResult;
    }



    public static void setHearingResult(String hearingResult)
    {
        Patient.hearingResult = hearingResult;
    }



    public static void setVisionResult(String visionResult)
    {
        Patient.visionResult = visionResult;
    }

    public static void setBmiIndex(String index)
    {
        bmiIndex = index;
    }

    public static void setBloodPressure(String bloodResult)
    {
        bloodPressure = bloodResult;
    }


    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }



    @Override
    public String toString()
    {
        return "Patient: " + userId ;
    }



}
