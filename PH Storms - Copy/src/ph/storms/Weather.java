package ph.storms;

public class Weather {
    
    protected Disaster[] Weather; 
    protected Disaster di;
    private int number=0;
    public Weather(int D)
    {
        Weather = new Disaster[D];
    }
    
    public boolean addDisaster(Disaster Storm)
    {
        for(int i=0; i<Weather.length ;i++)
        {
        	
            if(Weather[i]==null)
            {
                Weather[i] = Storm;
                return true;
            }
        }
    return false;
    }
    
    public boolean removeDisaster(String name)
    {
        for(int i=0; i< Weather.length;i++)
        {
            if(Weather[i]!=null)
            {
                if(Weather[i].getName().equals(name))
                {
                    Weather[i] = null;
                    return true;
                }
            }
        }
    return false;
    }
    
    public String changeDisaster(String stormName, int stormWind, int stormTemp)
    {
        for(int i=0; i< Weather.length;i++)
        {
        	if(Weather[i]!=null)
        	{
	            if(Weather[i].getName().equals(stormName))
	            {
	                if(Weather[i].kindOfDisaster().equals("Hurricane"))
	                {
	                	if(validationEdit(stormName).equals("pass"))
	                	{
	                		if(conditions(stormWind)==true)
	                		{
	                			Weather[i]=null;
	                			di = new Hurricane(stormName, stormWind, stormTemp);
	    	                	Weather[i]= di;
	    	                	return "passH";
	                		}
	                		if(conditions(stormWind)==false)
	                		{
	                			return "wrongDetails";
	                		}
	                	}
	                }
	                if(Weather[i].kindOfDisaster().equals("Blizzard"))
	                {
	                	if(validationEdit(stormName).equals("pass"))
	                	{
	                		if(conditionsBlizzard(stormWind, stormTemp)==true)
	                		{
	                			Weather[i]=null;	                			
	                			di = new Blizzard(stormName, stormWind, stormTemp);	                			
	                        	Weather[i]=di;	   
	                        	return "passB";
	                		}
	                		if(conditionsBlizzard(stormWind, stormTemp)==false)
	                		{
	                			return "wrongDetailsB";
	                		}
	                	}
	                	
	                }
	                if(Weather[i].kindOfDisaster().equals("Tornado"))
	                {
	                	if(validationEdit(stormName).equals("pass"))
	                	{
	                		if(conditions(stormWind)==true)
	                		{
	                			Weather[i]=null;
	                			di = new Tornado(stormName, stormWind, stormTemp);
	                        	Weather[i]=di;
	                        	return "passT";
	                		}
	                		if(conditions(stormWind)==false)
	                		{
	                			return "wrongDetails";
	                		}
	                	}  
	                }
	                
	            }
        	}
        }
        
        
    return "fail";
    }
    
    
    public int checkDisaster(String stormName)
    {
    	for(int i=0;i < Weather.length; i++)
    	{
    		if(Weather[i]!=null)
    		{
	    		if(Weather[i].getName().equals(stormName))
	    		{
	    			return i;
	    		}
    		}
    	}	
    	return -1;
    }
    
    public String validationAdd(String validAdd)
    {
		validAdd.toUpperCase();
		if(validAdd.length()==0)
		{
			return "noCharacters";
		}
		else if(validAdd.length()>20)
		{
			return "tooManyCharacters";
		}
		else 
		{
		for(int v=0;v<Weather.length;v++)
		{
			if(Weather[v]!=null)
			{
				if(Weather[v].getName().equals(validAdd))
				{
					return "similar";
				}
			}
		}
		}
    	return "pass";
    }
    public String validationEdit(String validEdit)
    {
    	validEdit.toUpperCase();
    	if(validEdit.length()==0)
    	{
    		return "noCharacters";
    	}
    	if(validEdit.length()>20)
    	{
    		return "tooManyCharacters";
    	}
    	return "pass";
    }
    
    
    public boolean conditionsBlizzard(int windSpeed, int temp)	//this condition is for logic of the program
    {
    	if(windSpeed >= 0 && temp <= 0)
    	{
    		if(windSpeed <250 && temp >= -279)   //it would not make sense to have more than 250 mph speed of wind
    		{
    			return true;
    		}
    		
    	}
    	return false;
    }
    public boolean conditions(int windSpeed)
    {
    	if(windSpeed >=0&&windSpeed<250)
    	{
    		return true;
    	}
    	return false;
    }
    public int countNumber(String function)
    {
    	for(int n=0;n<Weather.length;n++)
    	{
    		if(function.equals("add"))
    		{
    			if(number==Weather.length)
    				{
    				number=Weather.length;
    				return number;
    				}
    			else
    			{
    				number++;
            		return number;
    			}	
    		}
    		else if(function.equals("remove"))
    		{
    			if(number==0)
    			{
    				number=0;
    				return number;
    			}
    			else
    			{
    				number--;
        			return number;
    			}
    		}
    		
    	}
    	return 0;
    }
    
}
