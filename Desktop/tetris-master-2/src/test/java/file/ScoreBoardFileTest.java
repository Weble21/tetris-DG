package file;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ScoreBoardFileTest {

	ScoreBoardFile scoreBoardFile = new ScoreBoardFile();
	
	@Test
	public void writeScoreBoard() {
		String previous = null;
		try {
			previous = scoreBoardFile.readScoreBoard().toString();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		try {
			scoreBoardFile.writeScoreBoard(null, 0, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
		String later = null;
		try {
			later = scoreBoardFile.readScoreBoard().toString();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		
		Assert.assertEquals(previous, later);
		
		try {
			scoreBoardFile.writeScoreBoard("gh", 120, "NORMAL", "item");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		try {
			later = scoreBoardFile.readScoreBoard().toString();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		}
		Assert.assertNotEquals(previous, later);
	}
	
	@Test
	public void readScoreBoard() {
		try {
			String score = scoreBoardFile.readScoreBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void eraseFile(){
		try {
			scoreBoardFile.writeScoreBoard("kkk", 3000, "HARD", "item");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String previous = null;
		String later = null;
		try {
			previous = scoreBoardFile.readScoreBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scoreBoardFile.eraseFile();
		try {
			later = scoreBoardFile.readScoreBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertNotEquals(previous, later);
		Assert.assertEquals("",later);
	}

}
