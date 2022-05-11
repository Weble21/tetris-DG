package game;

import org.junit.Test;

import java.io.IOException;

public class FightMenuTest {
    FightMenu fightMenu;

	{
		try {
			fightMenu = new FightMenu(false,false);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public FightMenuTest(){}

	@Test
	public void moveDown(){
	}

}
