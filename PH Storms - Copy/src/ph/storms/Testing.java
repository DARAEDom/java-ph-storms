package ph.storms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	public void testBlizzard() {
		Disaster db = new Blizzard("Blizzard", 50, -20);
		
		
		assertEquals("Blizzard", db.getName());
		assertEquals(-20, db.getTemperature());
		assertEquals(50, db.getWindSpeed());
	}
	@Test
	public void testHurricane() {
		Disaster dh = new Hurricane("Hurricane", 60, 30);
		
		assertEquals("Hurricane", dh.getName());
		assertEquals(60, dh.getWindSpeed());
		assertEquals(30, dh.getTemperature());
	}
	@Test
	public void testTornado() {
		Disaster dt = new Tornado("Tornado", 70, 40);
		
		assertEquals("Tornado", dt.getName());
		assertEquals(70, dt.getWindSpeed());
		assertEquals(40, dt.getTemperature());
	}
	@Test
	public void testAddArry() {
		Disaster dt = new Tornado("Tornado", 70, 40);
		Disaster dh = new Hurricane("Hurricane", 60, 30);
		Disaster db = new Blizzard("Blizzard", 50, -20);
		Weather wr = new Weather(20);
		
		assertTrue(wr.addDisaster(dt));
		assertTrue(wr.addDisaster(dh));
		assertTrue(wr.addDisaster(db));
		
		for(int i=0;i<wr.Weather.length;i++)
		{
			if(wr.Weather[i]==null)
			{
				wr.addDisaster(dt);
			}
		}
		assertFalse(wr.addDisaster(db));
		assertFalse(wr.addDisaster(dh));
		assertFalse(wr.addDisaster(dt));
	}
	@Test
	public void testValidAdd() {
		Weather wr = new Weather(20);
		Disaster dt = new Tornado("Tornado", 30, 70);
		
		assertEquals("pass",wr.validationAdd("Tornado"));
		assertEquals("noCharacters",wr.validationAdd(""));
		assertEquals("tooManyCharacters",wr.validationAdd("ThisIsVeryLongNameAndItExceedsTheLimit"));
		assertEquals("pass", wr.validationAdd("QWERTYUIOPLKJHGFDSAZ")); //20 characters
		assertEquals("tooManyCharacters", wr.validationAdd("QWERTYUIOPASDFGHJKLZX"));//21 characters
		assertEquals("pass",wr.validationAdd("Space Test - ing"));
		
		wr.addDisaster(dt);
		for(int va=0;va<wr.Weather.length;va++)
		{
			if(wr.Weather[va]!=null)
			{
				assertEquals("similar", wr.validationAdd("Tornado"));
			}
		}
		
	}
	@Test
	public void testValidEdit() {
		Weather wr = new Weather(20);
		
		assertEquals("pass",wr.validationEdit("Tornado"));
		assertEquals("noCharacters",wr.validationEdit(""));
		assertEquals("tooManyCharacters",wr.validationEdit("ThisIsAnotherVeryLongNameWhichExceedsBeyondTheLimitAgain"));
		assertEquals("pass",wr.validationEdit("QWERTYUIOPLKJHGFDSAZ"));//20 characters
		assertEquals("tooManyCharacters", wr.validationEdit("QWERTYUIOPASDFGHJKLZX"));//21 characters
		assertEquals("pass",wr.validationEdit("Space Test - ing"));
	}
	@Test
	public void testConditionsBlizzard() {
		Weather wr = new Weather(20);
		
		assertTrue(wr.conditionsBlizzard(20, -20));
		assertTrue(wr.conditionsBlizzard(0, 0));
		assertFalse(wr.conditionsBlizzard(-20, -20));
		assertFalse(wr.conditionsBlizzard(20, 20));
		assertFalse(wr.conditionsBlizzard(250, -20));
		assertFalse(wr.conditionsBlizzard(20, -280));
		assertTrue(wr.conditionsBlizzard(1, -1));
		assertTrue(wr.conditionsBlizzard(10, 0));
	}
	@Test
	public void testConditions() {
		Weather wr = new Weather(20);
		
		assertTrue(wr.conditions(20));
		assertTrue(wr.conditions(1));
		assertTrue(wr.conditions(0));
		assertFalse(wr.conditions(-1));
		assertTrue(wr.conditions(249));
		assertFalse(wr.conditions(250));
	}
	@Test
	public void testCounting() {
		Weather wr = new Weather(20);
		
		assertEquals(1,wr.countNumber("add"));
		assertEquals(0,wr.countNumber("RandomName"));
		assertEquals(0,wr.countNumber("remove"));
		for(int tc=0;tc<wr.Weather.length;tc++)
		{
			wr.countNumber("add");					
		}
		assertEquals(wr.Weather.length,wr.countNumber("add"));
		for(int rem=0;rem<wr.Weather.length;rem++)
		{
			wr.countNumber("remove");
			
		}
		assertEquals(0, wr.countNumber("remove"));
	}
	@Test
	public void testRemoveArray() {
		Weather wr = new Weather(30);	
		Disaster dt = new Tornado("Tornado",50, 50);
		Disaster db = new Blizzard("Blizzard", 20, -20);
		Disaster dh = new Hurricane("Hurricane", 30, 30);
		
		for(int tra=0;tra<10;tra++)
		{
			if(wr.Weather[tra]==null)
			{
				wr.addDisaster(dt);
			}
		}
		for(int tra2=10;tra2<20;tra2++)
		{
			if(wr.Weather[tra2]==null)
			{
				wr.addDisaster(db);
			}
		}
		for(int tra3=20;tra3<30;tra3++)
		{
			if(wr.Weather[tra3]==null)
			{
				wr.addDisaster(dh);
			}
		}
		assertTrue(wr.removeDisaster("Tornado"));
		for(int tra4=0;tra4<wr.Weather.length;tra4++)
		{
			if(wr.Weather[tra4]!=null)
			{
				wr.removeDisaster("Tornado");
			}
		}
		
		assertFalse(wr.removeDisaster("Tornado"));
		assertTrue(wr.removeDisaster("Blizzard"));
		assertTrue(wr.removeDisaster("Hurricane"));
	}
	@Test
	public void testEdit() {
		Weather wr = new Weather(20);
		Disaster dh = new Hurricane("Hurricane", 30, 30);
		Disaster db = new Blizzard("Blizzard", 50, -50);
		Disaster dt = new Tornado("Tornado", 40,40);
		
		assertEquals("fail",wr.changeDisaster("Hurricane", 40, 40));
		
		assertTrue(wr.addDisaster(dh));
		assertTrue(wr.addDisaster(db));
		assertTrue(wr.addDisaster(dt));
		
		assertEquals("passH", wr.changeDisaster("Hurricane", 40, 40));
		assertEquals("passB", wr.changeDisaster("Blizzard", 60, -60));
		assertEquals("passT", wr.changeDisaster("Tornado", 80, 80));
		
		assertEquals("wrongDetails",wr.changeDisaster("Hurricane", -1, -5));
		assertEquals("passH",wr.changeDisaster("Hurricane", 0, 0));
		assertEquals("passH",wr.changeDisaster("Hurricane", 249, 50));
		assertEquals("wrongDetails",wr.changeDisaster("Hurricane", 250, -5));
		
		
		assertEquals("wrongDetails",wr.changeDisaster("Tornado", -1, -5));
		assertEquals("passT",wr.changeDisaster("Tornado", 0, -5));
		assertEquals("passT",wr.changeDisaster("Tornado", 249, -5));
		assertEquals("wrongDetails",wr.changeDisaster("Tornado", 250, -5));
		
		
		assertEquals("wrongDetailsB",wr.changeDisaster("Blizzard", -1, -5));
		assertEquals("wrongDetailsB",wr.changeDisaster("Blizzard", 0, -280));
		assertEquals("wrongDetailsB",wr.changeDisaster("Blizzard", 250, -50));
		assertEquals("passB",wr.changeDisaster("Blizzard", 249, -279));
		assertEquals("wrongDetailsB",wr.changeDisaster("Blizzard", 250, 280));
		
		
		
	}
	@Test
	public void testCheck() {
		Weather wr = new Weather(20);
		Disaster dt = new Tornado("Tornado",50, 50);
		Disaster db = new Blizzard("Blizzard", 20, -20);
		Disaster dh = new Hurricane("Hurricane", 30, 30);
		Disaster da = new Tornado("Tornado1",50, 50);
		Disaster dc = new Tornado("Tornado2",50, 50);
		Disaster dd = new Tornado("Tornado3",50, 50);
		Disaster de = new Tornado("Tornado4",50, 50);
		Disaster df = new Tornado("Tornado5",50, 50);
		Disaster dp = new Blizzard("Blizzard1", 20, -20);
		
		assertTrue(wr.addDisaster(dt));
		assertTrue(wr.addDisaster(db));
		assertTrue(wr.addDisaster(dh));
		assertTrue(wr.addDisaster(da));
		assertTrue(wr.addDisaster(dc));
		assertTrue(wr.addDisaster(dd));
		assertTrue(wr.addDisaster(de));
		assertTrue(wr.addDisaster(df));
		assertTrue(wr.addDisaster(dp));
		
		
		assertEquals(0,wr.checkDisaster("Tornado"));
		assertEquals(1,wr.checkDisaster("Blizzard"));
		assertEquals(2,wr.checkDisaster("Hurricane"));
		assertEquals(7,wr.checkDisaster("Tornado5"));
		assertEquals(5,wr.checkDisaster("Tornado3"));
		assertEquals(8,wr.checkDisaster("Blizzard1"));
		assertEquals(4,wr.checkDisaster("Tornado2"));
		
		assertTrue(wr.removeDisaster("Tornado1"));
		assertTrue(wr.removeDisaster("Tornado2"));
		assertTrue(wr.removeDisaster("Tornado3"));
		
		assertEquals(-1, wr.checkDisaster("Tornado1"));			//-1 stands for not found
		
	}
	
	
}
