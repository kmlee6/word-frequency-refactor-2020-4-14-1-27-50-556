import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        final String SEPARATOR_PATTERN = "\\s+";
        final String LINE_BREAK = "\n";

        //split the input string with 1 to n pieces of spaces
        String[] inputStringArray = inputStr.split(SEPARATOR_PATTERN);

        List<WordInfo> wordInfoList = new ArrayList<>();
        for (String word : inputStringArray) {
            WordInfo wordInfo = new WordInfo(word, 1);
            wordInfoList.add(wordInfo);
        }

        //get the map for the next step of sizing the same word
        Map<String, List<WordInfo>> map = getListMap(wordInfoList);

        List<WordInfo> list = new ArrayList<>();
        for (Map.Entry<String, List<WordInfo>> entry : map.entrySet()) {
            WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue().size());
            list.add(wordInfo);
        }
        wordInfoList = list;

        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

        StringJoiner joiner = new StringJoiner(LINE_BREAK);
        for (WordInfo word : wordInfoList) {
            String wordCountString = word.getValue() + " " + word.getWordCount();
            joiner.add(wordCountString);
        }
        return joiner.toString();
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList) {
            if (!map.containsKey(wordInfo.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getValue(), arr);
            } else {
                map.get(wordInfo.getValue()).add(wordInfo);
            }
        }
        return map;
    }
}
