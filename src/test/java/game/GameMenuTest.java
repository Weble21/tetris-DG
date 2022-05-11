package game;

import blocks.Block;
import org.junit.Assert;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class GameMenuTest {
    GameMenu gameMenu = new GameMenu(false);
	GameMenu itemGameMenu = new GameMenu(true);
    public GameMenuTest() throws IOException {}

   @Test
	public void moveDown(){
		for(int i=0;i<100;i++) {
			assertTimeout(ofMillis(1000), () -> {
				gameMenu.moveDown();
			});
		}

	   for(int i=0;i<100;i++) {
		   assertTimeout(ofMillis(1000), () -> {
			   itemGameMenu.moveDown();
		   });
	   }
   }

}
