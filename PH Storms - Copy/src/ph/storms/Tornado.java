package ph.storms;


public class Tornado extends Disaster{
    
    public Tornado(String nameIn, int windSpeedIn, int temperatureIn)
    {
        super(nameIn, windSpeedIn, temperatureIn);
    }
    
    @Override
        public String classification()
    {
        if(windSpeed >= 40 && windSpeed <=72)
        {
            return "F0";
        }
        else if(windSpeed >72 && windSpeed <=112)
        {
            return "F1";
        }
        else if(windSpeed >112 && windSpeed <=157)
        {
            return "F2";
        }
        else if(windSpeed >157 && windSpeed <= 205)
        {
            return "F3";
        }
        else if(windSpeed >205 && windSpeed<= 260)
        {
            return "F4";
        }
        else if(windSpeed >260)
        {
            return "F5";
        }
        else
        {
            return "unclassified";
        }
        
    }
    
    public String advice()
    {
    	if(windSpeed >=40 && windSpeed <=112)
    	{
    		return "Find safe room/shelter, shield yourself from debris";
    	}
    	if(windSpeed >112 )
    	{
    		return "Find underground shelter, crouch near to the floor covering your head with your hands";
    	}
    	else
    	{
    		return "“There is no need to panic";
    	}
    }
    public String kindOfDisaster()
    {
    	return "Tornado";
    }
    
}
