package file;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ScoreBoardFile {

	private List<Score> list;
	private ObjectMapper mapper;

	public ScoreBoardFile(){
		list = new ArrayList<>();
		mapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			getScoreBoard();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void getScoreBoard() throws IOException {
		list = Arrays.asList(mapper.readValue(new File("scoreBoardFile.json"), Score[].class));
		Collections.sort(list, new ScoreComparator());
	}

	public int writeScoreBoard(String name, int score, String level, String mode) throws IOException {
		if(name==null||score<0||level==null||mode==null)
			return -1;
		Score p = new Score(name,score,level,mode);
		ArrayList<Score> List = new ArrayList<Score>(list);
		List.add(p);
		try {
			mapper.writeValue(new File("scoreBoardFile.json"), List);
		} catch (IOException e) {
			e.printStackTrace();
		}
		list = Arrays.asList(mapper.readValue(new File("scoreBoardFile.json"), Score[].class));
		Collections.sort(List, new ScoreComparator());
		Collections.sort(list, new ScoreComparator());
		int index = List.indexOf(p);

		return index;
	}
	public String readScoreBoard() throws IOException {
		String sb = new String();
		for (int i = 0; i < Math.min(list.size(), 20); i++) {
			sb += " " + String.format("%02d", i + 1) + list.get(i).toWritableString();
		}
		return sb;
	}
	public int isWritable() throws IOException {
		if (!list.isEmpty()) {
			if (list.size() < 20) {
				return 0;
			} else {
				return list.get(Math.min(list.size() - 1, 19)).score;
			}
		}
		return 0;
	}
	public void eraseFile() {
		list = new ArrayList<>();
		try {
			mapper.writeValue(new File("scoreBoardFile.json"), list);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
