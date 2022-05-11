package game;

import java.io.IOException;

import blocks.GetRandomBlock;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import blocks.Block;

class itemModeTest {
	ItemGameBoard itemGameBoard;
	
	@Test
	public void getItemBlockEasy() {

		GetRandomBlock getRandomBlock = new GetRandomBlock();
		try {
			itemGameBoard = new ItemGameBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(itemGameBoard.getModeName());
		int[] countBlock = new int[11];
		int[] countPositionBlock = new int[6];
		int count = 1000000;

		for (int i = 0; i < count; i++) {
			Block block = getRandomBlock.getItemBlock("easy");
			switch (block.getClass().toString()) {
				case "class blocks.IBlock":
					++countBlock[0];
					break;
				case "class blocks.JBlock":
					++countBlock[1];
					break;
				case "class blocks.LBlock":
					++countBlock[2];
					break;
				case "class blocks.OBlock":
					++countBlock[3];
					break;
				case "class blocks.SBlock":
					++countBlock[4];
					break;
				case "class blocks.TBlock":
					++countBlock[5];
					break;
				case "class blocks.ZBlock":
					++countBlock[6];
					break;
				case "class blocks.WBlock":
					++countBlock[7];
					break;
				case "class blocks.CBlock":
					++countBlock[8];
					break;
				case "class blocks.BBlock":
					++countBlock[9];
					break;
				case "class blocks.EBlock":
					++countBlock[10];
					break;
			}

			int n = 0;
			for (int j = 0; j < block.height(); j++)
				for (int k = 0; k < block.width(); k++)
					if (block.getShape(k, j) != 0) {
						if (block.getShape(k, j) == 2) {
							++countPositionBlock[n];
							k = block.width();
							j = block.height();
						}
						n++;
					}
		}

		System.out.println("countBlock: ");
		int LItemNum = 0;
		for (int i = 0; i < 11; i++) {
			System.out.print("[" + i + "] " + countBlock[i] + " ");
			if (i < 7)
				LItemNum += countBlock[i];
		}

		System.out.println("\ncountPositionBlock: ");

		int LItemNumCompare = 0;
		for (int i = 0; i < 6; i++) {
			System.out.print("[" + i + "] " + countPositionBlock[i] + " ");
			LItemNumCompare += countPositionBlock[i];
		}

		Assert.assertEquals(LItemNum, LItemNumCompare, 5);
	}
	@Test
	public void getItemBlockNormal() {

		ItemGameBoard itemGameBoard = null;
		GetRandomBlock getRandomBlock = new GetRandomBlock();
		try {
			itemGameBoard = new ItemGameBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(itemGameBoard.getModeName());
		int[] countBlock = new int[11];
		int[] countPositionBlock = new int[6];
		int count = 1000000;

		for (int i = 0; i < count; i++) {
			Block block = getRandomBlock.getItemBlock("normal");
			switch (block.getClass().toString()) {
			case "class blocks.IBlock":
				++countBlock[0];
				break;
			case "class blocks.JBlock":
				++countBlock[1];
				break;
			case "class blocks.LBlock":
				++countBlock[2];
				break;
			case "class blocks.OBlock":
				++countBlock[3];
				break;
			case "class blocks.SBlock":
				++countBlock[4];
				break;
			case "class blocks.TBlock":
				++countBlock[5];
				break;
			case "class blocks.ZBlock":
				++countBlock[6];
				break;
			case "class blocks.WBlock":
				++countBlock[7];
				break;
			case "class blocks.CBlock":
				++countBlock[8];
				break;
			case "class blocks.BBlock":
				++countBlock[9];
				break;
			case "class blocks.EBlock":
				++countBlock[10];
				break;
			}

			int n = 0;
			for (int j = 0; j < block.height(); j++)
				for (int k = 0; k < block.width(); k++)
					if (block.getShape(k, j) != 0) {
						if (block.getShape(k, j) == 2) {
							++countPositionBlock[n];
							k = block.width();
							j = block.height();
						}
						n++;
					}
		}

		System.out.println("countBlock: ");
		int LItemNum = 0;
		for (int i = 0; i < 11; i++) {
			System.out.print("[" + i + "] " + countBlock[i] + " ");
			if (i < 7)
				LItemNum += countBlock[i];
		}

		System.out.println("\ncountPositionBlock: ");

		int LItemNumCompare = 0;
		for (int i = 0; i < 6; i++) {
			System.out.print("[" + i + "] " + countPositionBlock[i] + " ");
			LItemNumCompare += countPositionBlock[i];
		}

		Assert.assertEquals(LItemNum, LItemNumCompare, 5);
	}

	@Test
	public void getItemBlockHard() {

		ItemGameBoard itemGameBoard = null;
		GetRandomBlock getRandomBlock = new GetRandomBlock();
		try {
			itemGameBoard = new ItemGameBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(itemGameBoard.getModeName());
		int[] countBlock = new int[11];
		int[] countPositionBlock = new int[6];
		int count = 1000000;

		for (int i = 0; i < count; i++) {
			Block block = getRandomBlock.getItemBlock("hard");
			switch (block.getClass().toString()) {
				case "class blocks.IBlock":
					++countBlock[0];
					break;
				case "class blocks.JBlock":
					++countBlock[1];
					break;
				case "class blocks.LBlock":
					++countBlock[2];
					break;
				case "class blocks.OBlock":
					++countBlock[3];
					break;
				case "class blocks.SBlock":
					++countBlock[4];
					break;
				case "class blocks.TBlock":
					++countBlock[5];
					break;
				case "class blocks.ZBlock":
					++countBlock[6];
					break;
				case "class blocks.WBlock":
					++countBlock[7];
					break;
				case "class blocks.CBlock":
					++countBlock[8];
					break;
				case "class blocks.BBlock":
					++countBlock[9];
					break;
				case "class blocks.EBlock":
					++countBlock[10];
					break;
			}

			int n = 0;
			for (int j = 0; j < block.height(); j++)
				for (int k = 0; k < block.width(); k++)
					if (block.getShape(k, j) != 0) {
						if (block.getShape(k, j) == 2) {
							++countPositionBlock[n];
							k = block.width();
							j = block.height();
						}
						n++;
					}
		}

		System.out.println("countBlock: ");
		int LItemNum = 0;
		for (int i = 0; i < 11; i++) {
			System.out.print("[" + i + "] " + countBlock[i] + " ");
			if (i < 7)
				LItemNum += countBlock[i];
		}

		System.out.println("\ncountPositionBlock: ");

		int LItemNumCompare = 0;
		for (int i = 0; i < 6; i++) {
			System.out.print("[" + i + "] " + countPositionBlock[i] + " ");
			LItemNumCompare += countPositionBlock[i];
		}

		Assert.assertEquals(LItemNum, LItemNumCompare, 5);
	}
	
	@Test
	public void eraseLine() {
		GetRandomBlock getRandomBlock = new GetRandomBlock();
		try {
			itemGameBoard = new ItemGameBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		itemGameBoard.gamePane.eraseCurr(itemGameBoard.x,itemGameBoard.y,itemGameBoard.curr);
		itemGameBoard.drawBoard();
		String temp = itemGameBoard.gamePane.getText();
		int lines [][] = new int[10][10];
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				lines[i][j] = 1;
		itemGameBoard.gamePane.addLines(lines);
		itemGameBoard.eraseLine();
		Assert.assertEquals(temp, itemGameBoard.gamePane.getText());

		for(int i=0;i<100;i++){
			itemGameBoard.x = 5;
			itemGameBoard.y = 10;
			itemGameBoard.curr = getRandomBlock.getItemBlock("EASY");
			itemGameBoard.drawBoard();
			itemGameBoard.gamePane.addLines(lines);
			itemGameBoard.eraseLine();
		}
	}

	@Test
	public void setLines(){
		try {
			itemGameBoard = new ItemGameBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
