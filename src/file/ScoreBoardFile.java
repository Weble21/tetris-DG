package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ScoreBoardFile {
	
	private Vector<Pair> v;
	private File file;
	private int index = 0;
	
	public ScoreBoardFile() throws NumberFormatException, IOException{
		v = new Vector<Pair>();
		file = new File("scoreboard.txt");
		if(!file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		BufferedReader br;
		try {
			 String line=null;
			br = new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null) {
				String[] splited = line.split(" ");
				if(splited.length==2 && splited[1].matches("[+-]?\\d*(\\.\\d+)?")) {
					Pair p = new Pair(splited[0],Integer.parseInt(splited[1]));
					v.add(p);
				}
			}
			br.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Collections.sort(v, new PairComparator());
	}
	
	public Vector<Pair> getScoreBoard() {
		return v;
	}
	
	public String readScoreBoard() throws IOException {
		String sb = new String();
		for(int i = 0; i < Math.min(v.size(),20) ; i++) {
			sb += ("  "+String.format("%02d", i+1) +"      "+v.get(i).name + "      " + String.format("%04d", v.get(i).score)+"\n");
		}
		return sb;
	}
	
	public int getIndex(String name, int score) {
		for(int i = 0; i < Math.min(v.size(),20) ; i++) {
			if(v.get(i).name==name && v.get(i).score==score)
				index = i;
		}
		return index;
	}
	
	public String writeScoreBoard(String name, String score) throws IOException {
		v.add(new Pair(name,Integer.parseInt(score)));
		Collections.sort(v, new PairComparator());
		
        BufferedReader br;
        String sb = new String();
		try {
			 String line=null;
			br = new BufferedReader(new FileReader(file));
			while((line=br.readLine())!=null) {
				sb += line;
				sb += "\n";
			}
			br.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        String temp = name+" "+score;
        bw.write(sb);
        bw.write(temp);
        bw.newLine();
        bw.close();
        
		return null;
	}
	
	public void eraseScoreFile() throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        bw.newLine();
        bw.close();
	}
	

	public int isWritable() throws IOException {
		if(!v.isEmpty()) {
			if(v.size()<20) {
				return 0;
			} else {
				return v.get(Math.min(v.size()-1,19)).score;
			}
		}
		return 0;
	}
}


class Pair {
	String name;
	Integer score;
	
	public Pair(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	public Integer getScore() {
		return score;
	}
	public String getName() {
		return name;
	}
	
}

class PairComparator implements Comparator<Pair> { 
	public int compare(Pair arg0, Pair arg1) { 
		return arg1.score.compareTo(arg0.score);
	}
}
		