package scoreboard;

import blocks.Block;
import game.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ScoreBoardMenuTest {
	ScoreBoardMenu sb1 = new ScoreBoardMenu();
	ScoreBoardMenu sb2;

	@Test
	public void ScoreBoardMenu(){
		try {
			sb2 = new ScoreBoardMenu(-1,null,null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			sb2 = new ScoreBoardMenu(10,"10","HARD");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void isAlphaOrDigit(){
		try {
			sb2 = new ScoreBoardMenu(10,"10","HARD");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Assert.assertEquals(true,sb2.isAlphaOrDigit("0"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("9999"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("999w"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("a"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("A"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("e"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("z"));
		Assert.assertEquals(true,sb2.isAlphaOrDigit("Z"));
		Assert.assertEquals(false,sb2.isAlphaOrDigit("안"));
		Assert.assertEquals(false,sb2.isAlphaOrDigit("+"));
		Assert.assertEquals(false,sb2.isAlphaOrDigit("#"));
		Assert.assertEquals(false,sb2.isAlphaOrDigit("#"));
		Assert.assertEquals(false,sb2.isAlphaOrDigit("ppp+"));

	}

	@Test
	public void tryWriteScoreboard(){
		try {
			sb2 = new ScoreBoardMenu(10,"10","HARD");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		sb2.nameEnter.setText("Hi");
		sb2.tryWriteScoreboard();
	}


}
