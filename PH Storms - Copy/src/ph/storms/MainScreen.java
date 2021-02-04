package ph.storms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainScreen extends JFrame implements ActionListener{

    private GridBagConstraints constraints;
            
    private int ch=0;
    private Weather wr;
    
    private JLabel lblTitle;
    private JLabel lblCurrent;
    private JLabel lblClass;
    private JLabel lblDetail0;
    private JLabel lblDetail1;
    private JLabel lblDetail2;
    private JLabel lblHint;
    private JLabel lblAdvice;
    private JLabel lblStormName;
    private JLabel lblWindSpeed;
    private JLabel lblTemperature;
    private JLabel lblDisaster;
    
    private JTextField txtStormName;
    private JTextField txtWindSpeed;
    private JTextField txtTemperature;
    
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnEdition;
    private JButton btnCheck;
    
    private JRadioButton radBlizzard;
    private JRadioButton radTornado;
    private JRadioButton radHurricane;
    
    ButtonGroup J = new ButtonGroup();
    
    public MainScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLayout(new GridBagLayout()); 
        initComponents();
        constraints = new GridBagConstraints();
        windowLayout();
        wr = new Weather(20);
        btnEdition.setEnabled(false);
        
    }
    
    public void initComponents()
    {
        lblTitle = new JLabel("Storm Advice Centre");
        lblCurrent = new JLabel("Current Number of Storms: -");
        lblClass = new JLabel("Class: -");
        lblAdvice = new JLabel("Advice: -");
        lblStormName = new JLabel("Storm name:");
        lblWindSpeed = new JLabel("Wind speed(mph):");
        lblTemperature = new JLabel("Temperature(C):");
        lblHint = new JLabel();
        lblDetail0 = new JLabel("Name: -");
        lblDetail1 = new JLabel("Wind Speed: -");
        lblDetail2 = new JLabel("Temperautre: -");
        lblDisaster = new JLabel("Type: -");
        
        txtStormName = new JTextField();
        txtWindSpeed = new JTextField();
        txtTemperature = new JTextField();
        
        radBlizzard = new JRadioButton("Blizzard");
        radHurricane = new JRadioButton("Hurricane");
        radTornado = new JRadioButton("Tornado");
        
        J.add(radHurricane);
        J.add(radBlizzard);
        J.add(radTornado);
        
        btnAdd = new JButton("Add");
        btnAdd.addActionListener(this);
        btnRemove = new JButton("Remove");
        btnRemove.addActionListener(this);
        btnEdition = new JButton("Edit");
        btnEdition.addActionListener(this);
        btnCheck = new JButton("Check");
        btnCheck.addActionListener(this);
    }
    
    public void windowLayout()
    {
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(lblTitle, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(lblStormName, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        this.add(lblWindSpeed, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        this.add(lblTemperature, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        this.add(lblClass, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        this.add(lblDetail0,constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        this.add(lblDetail1, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.gridwidth = 1;
        this.add(lblDetail2, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        this.add(lblCurrent, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        this.add(lblDisaster, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        this.add(lblAdvice, constraints);    
        
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        this.add(lblHint, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 1;
        this.add(radBlizzard,constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 2;
        this.add(radHurricane,constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 3;
        this.add(radTornado,constraints);
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.add(txtStormName, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.add(txtWindSpeed, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.add(txtTemperature, constraints);
        constraints.fill = GridBagConstraints.NONE;
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        this.add(btnAdd, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        this.add(btnEdition, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        this.add(btnRemove, constraints);
        
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        this.add(btnCheck, constraints);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ev)
    {
    	
        if(ev.getSource().equals(btnAdd))
        {
        	btnEdition.setEnabled(false);
        	try {
        	String nameAdd = txtStormName.getText();
            int windSpeedAdd = Integer.parseInt(txtWindSpeed.getText());
            int temperatureAdd = Integer.parseInt(txtTemperature.getText());
        	
            
        	Disaster di = null;  
        	lblHint.setText("");
        	lblDetail0.setText("Name: -");
        	lblDetail1.setText("Wind: -");
        	lblDetail2.setText("Temp: -");
        	lblClass.setText("Class: -");
            
            	if(radHurricane.isSelected())
	            {		     
            		if(wr.validationAdd(nameAdd).equals("similar"))
            		{
            			lblHint.setText("Name already used");
            		}
            		if(wr.validationAdd(nameAdd).equals("tooManyCharacters"))
            		{
            			lblHint.setText("Name exceeds 20 characters limit!");
            		}
            		if(wr.validationAdd(nameAdd).equals("noCharacters"))
            		{
            			lblHint.setText("Insert name!");
            		}
            		if(wr.validationAdd(nameAdd).equals("pass"))
            		{
            			nameAdd.toUpperCase();
	            		if(wr.conditions(windSpeedAdd))
	            		{
	            			di = new Hurricane(nameAdd, windSpeedAdd, temperatureAdd);
		            		if(wr.addDisaster(di))
		            		{
		            			lblHint.setText("Hurricane Added!");
		            			lblCurrent.setText("Current Number of Storms: " + wr.countNumber("add"));
							}
		            		else 
		            		{
		            			lblHint.setText("No empty space");
		            		}
	            		}
	            		else
	            		{
	            			lblHint.setText("Check wind and temp");
	            		}
            		}
            		
	        		
	            }
	            else if(radBlizzard.isSelected())
	            {
	            	if(wr.validationAdd(nameAdd).equals("similar"))            	
	            	{
	            		lblHint.setText("Name already used");
	            	}
	            	if(wr.validationAdd(nameAdd).equals("tooManyCharacters"))
	            	{
	            		lblHint.setText("Exceeds 20 characters limit!");
	            	}
	            	if(wr.validationAdd(nameAdd).equals("noCharacters"))
	            	{
	            		lblHint.setText("Insert Name!");
	            	}
	            	else if(wr.validationAdd(nameAdd).equals("pass"))
	            	{
		            	if(wr.conditionsBlizzard(windSpeedAdd, temperatureAdd))
		            	{
			            	di = new Blizzard(nameAdd, windSpeedAdd, temperatureAdd);
			            	
			            	if(wr.addDisaster(di))
							{
			            		lblHint.setText("Blizzard Added!");
			            		lblCurrent.setText("Current Number of Storms: " + wr.countNumber("add"));
							}
		            		else
		            		{
		            			lblHint.setText("No empty space");
		            		}
		            	}
		            	else
		            	{
		            		lblHint.setText("Check wind and temperature");
		            	}
	            	}
	            	
	            }
	            else if(radTornado.isSelected())
	            {
	            	if(wr.validationAdd(nameAdd).equals("similar"))
	            	{
	            		lblHint.setText("Name already used");
	            	}
	            	if(wr.validationAdd(nameAdd).equals("tooManyCharacters"))
	            	{
	            		lblHint.setText("Name exceeds 20 characters limit!");
	            	}
	            	if(wr.validationAdd(nameAdd).equals("noCharacters"))
	            	{
	            		lblHint.setText("Insert Name!");
	            	}
	            	else if(wr.validationAdd(nameAdd).equals("pass"))
	            	{
		            	if(wr.conditions(windSpeedAdd))
		            	{
			            	di= new Tornado(nameAdd, windSpeedAdd, temperatureAdd);
			            	
			            	if(wr.addDisaster(di))
							{
			            		lblHint.setText("Tornado Added");
			            		lblCurrent.setText("Current Number of Storms: " + wr.countNumber("add"));
							}
		            		else
		            		{
		            			lblHint.setText("No empty space");
		            		}
		            	}
		            	else
		            	{
		            		lblHint.setText("Check wind speed");
		            	}
	            	}
	            }
	            else
	            {
	            	lblHint.setText("Choose Disaster");
	            }
        	}catch(Exception exAdd)
        	{
        		lblHint.setText("Error, check details!");
        	}
	            
        	
        }
        if(ev.getSource().equals(btnRemove))
        {
        	try {
        	btnEdition.setEnabled(false);
        	String nameRemove = txtStormName.getText();
        	
        	
        	lblHint.setText("");
        	lblDetail0.setText("Name: -");
        	lblDetail1.setText("Wind: -");
        	lblDetail2.setText("Temp: -");
        	lblClass.setText("Class: -");
        	
        	nameRemove.toUpperCase();
        	if(wr.removeDisaster(nameRemove))
        	{
        		lblHint.setText("Disaster Removed");
        		lblCurrent.setText("Current Number of Storms: " + wr.countNumber("remove"));
        	}
        	else
        	{
        		lblHint.setText("Not found");
        	}
        	}catch(Exception exRem)
        	{
        		lblHint.setText("Error, check details!");
        	}
        	
        
        }
    	
    	if (ev.getSource().equals(btnEdition))
        {
    		try {
	    		String nameEdit = txtStormName.getText();
	            int windSpeedEdit = Integer.parseInt(txtWindSpeed.getText());
	            int temperatureEdit = Integer.parseInt(txtTemperature.getText());
	            
	            
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("passB"))   					
	            {
	            	lblHint.setText("Blizzard details changed!");	
	            	for(int e=0;e<wr.Weather.length;e++)
	            	{
	            		if(wr.Weather[e]!=null)
	            		{
	            			if(wr.Weather[e].getName().equals(nameEdit))
	            			{
	            				lblDetail0.setText("Name: " + wr.Weather[e].getName());
	            				lblDetail1.setText("Wind: " + wr.Weather[e].getWindSpeed()+ "mph");
	            				lblDetail2.setText("Temp: " + wr.Weather[e].getTemperature()+ "C");
	            				lblClass.setText("Class: " + wr.Weather[e].classification());
	            				lblAdvice.setText("Advice: " + wr.Weather[e].advice());
	            				lblDisaster.setText("Type: " + wr.Weather[e].kindOfDisaster());
	            			}
	            		}
	            	}
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("passT"))
	            {
	            	lblHint.setText("Tornado details changed!");
	            	for(int e=0;e<wr.Weather.length;e++)
	            	{
	            		if(wr.Weather[e]!=null)
	            		{
	            			if(wr.Weather[e].getName().equals(nameEdit))
	            			{
	            				lblDetail0.setText("Name: " + wr.Weather[e].getName());
	            				lblDetail1.setText("Wind: " + wr.Weather[e].getWindSpeed()+ "mph");
	            				lblDetail2.setText("Temp: " + wr.Weather[e].getTemperature()+"C");
	            				lblClass.setText("Class: " + wr.Weather[e].classification());
	            				lblAdvice.setText("Advice: " + wr.Weather[e].advice());
	            				lblDisaster.setText("Type: " + wr.Weather[e].kindOfDisaster());
	            			}
	            		}
	            	}
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("passH"))
	            {
	            	lblHint.setText("Hurricane details changed!");
	            	for(int e=0;e<wr.Weather.length;e++)
	            	{
	            		if(wr.Weather[e]!=null)
	            		{
	            			if(wr.Weather[e].getName().equals(nameEdit))
	            			{
	            				lblDetail0.setText("Name: " + wr.Weather[e].getName());
	            				lblDetail1.setText("Wind: " + wr.Weather[e].getWindSpeed()+ "mph");
	            				lblDetail2.setText("Temp: " + wr.Weather[e].getTemperature()+ "C");
	            				lblClass.setText("Class: " + wr.Weather[e].classification());
	            				lblAdvice.setText("Advice: " + wr.Weather[e].advice());
	            				lblDisaster.setText("Type: " + wr.Weather[e].kindOfDisaster());
	            			}
	             		}
	            	}
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("noStorm"))
	            {
	            	lblHint.setText("Storm not found!");
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("wrongDetails"))
	            {
	            	lblHint.setText("Check wind speed!");
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("wrongDetailsB"))
	            {
	            	lblHint.setText("Check wind and temperature!");
	            }
	            if(wr.changeDisaster(nameEdit, windSpeedEdit, temperatureEdit).equals("fail"))
	            {
	            	lblHint.setText("Error!");
	            }
            }catch(Exception exEdit)
            {
            	lblHint.setText("Error, check details!");
            }
            
        }
    	if(ev.getSource().equals(btnCheck))
    	{
    		try {
    		String nameCheck = txtStormName.getText();
    		
    		lblHint.setText("");
			lblDetail0.setText("Name:" + wr.Weather[wr.checkDisaster(nameCheck)].getName());
			lblDetail1.setText("Wind:" + wr.Weather[wr.checkDisaster(nameCheck)].getWindSpeed() + " mph");
			lblDetail2.setText("Temp:" + wr.Weather[wr.checkDisaster(nameCheck)].getTemperature() + "C");
			lblClass.setText("Class:" + wr.Weather[wr.checkDisaster(nameCheck)].classification());
			lblAdvice.setText("Advice:" + wr.Weather[wr.checkDisaster(nameCheck)].advice());
			lblDisaster.setText("Type: -" + wr.Weather[wr.checkDisaster(nameCheck)].kindOfDisaster());
			btnEdition.setEnabled(true);
				
    		if(wr.checkDisaster(nameCheck)==-1)
    		{
    			lblHint.setText("Not found");
    		}
    		if(nameCheck.isEmpty())
    		{
    			lblHint.setText("Insert Name!");
    		}
    		}catch(Exception exCheck)
    		{
    		lblHint.setText("Error, check details!");	
    		}
    		
    	}
        
    }
}
