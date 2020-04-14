import java.util.*;

public class WordFrequencyGame {
    private final String SEPARATER_PATTERN = "\\s+";
    private final String LINE_BREAK = "\n";

    public String getResult(String inputStr) {
            try {
                //split the input string with 1 to n pieces of spaces
                String[] inputStringArray = inputStr.split(SEPARATER_PATTERN);

                List<Input> inputList = new ArrayList<>();
                for (String word : inputStringArray) {
                    Input input = new Input(word, 1);
                    inputList.add(input);
                }

                //get the map for the next step of sizing the same word
                Map<String, List<Input>> map = getListMap(inputList);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

                StringJoiner joiner = new StringJoiner(LINE_BREAK);
                for (Input word : inputList) {
                    String wordCountString = word.getValue() + " " + word.getWordCount();
                    joiner.add(wordCountString);
                }
                return joiner.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }
}
