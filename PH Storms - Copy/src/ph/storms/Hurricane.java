package ph.storms;


public class Hurricane extends Disaster {
    
    public Hurricane( String nameIn, int windSpeedIn, int temperatureIn)
    {
        super(nameIn, windSpeedIn, temperatureIn);
    }
    
    @Override
    public String classification()
    {
        if(windSpeed>=74&&windSpeed<=95)
        {
            return "Cat 1";
        }
        if(windSpeed>95&&windSpeed<=110)
        {
            return "Cat 2";
        }
        if(windSpeed>110&&windSpeed<=129)
        {
            return "Cat 3";
        }
        if(windSpeed>129&&windSpeed<=156)
        {
            return "Cat 4";
        }
        if(windSpeed>156)
        {
            return "Cat 5";
        }
        else
        {
            return "Tropical storm";
        }
    }
    @Override
    public String advice()
    {
    	if(windSpeed > 40 && windSpeed <= 110)
    	{
    		return "Close storm shutters and stay away from window";   
    	}
    	if(windSpeed>110&&windSpeed<=129)
    	{
    		return "Coastal regions are encouraged to evacuate";
    	}
    	if(windSpeed >=0)
    	{
    		return "Take care!";
    	}
    	else
    	{
    		return "Evacuate";
    	}
    }
    public String kindOfDisaster()
    {
    	return "Hurricane";
    }
}
