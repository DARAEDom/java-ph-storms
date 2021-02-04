package ph.storms;


public class Blizzard extends Disaster {
    
    public Blizzard(String nameIn, int windSpeedIn, int temperatureIn)
    {
        super(nameIn, windSpeedIn, temperatureIn);
    }
    
    
    @Override
    public String classification()
    {
        if(windSpeed >= 35 && temperature <=0 && windSpeed <45)
        {
            return "Blizzard";
        }
        else if(windSpeed >= 45 && temperature <=-12)
        {
            return "Severe Blizzard";
        }
        else
        {
            return "Snow Storm";
        }
    }
    
    public String advice()
    {
    	if(windSpeed >= 35 && temperature <=0 && windSpeed<45)
    	{
    		return "Keep warm, Do not travel unless absolutely essential";
    	}
    	else if(windSpeed >= 45 && temperature <=-12)
    	{
    		return "Keep warm, avoid all travel";
    	}
    	else
    	{
    		return "Take care and avoid travel if possible";
    	}
    }
    public String kindOfDisaster()
    {
    	return "Blizzard";
    }
}
