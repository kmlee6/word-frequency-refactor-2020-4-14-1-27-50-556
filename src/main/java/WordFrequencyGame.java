import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    private final String SEPARATOR_PATTERN = "\\s+";
    private final String LINE_BREAK = "\n";

    private List<String> splitInputString(String inputString){
        return Arrays.asList(inputString.split(SEPARATOR_PATTERN));
    }

    private List<WordInfo> sortByWordFrequency(List<WordInfo> wordCount){
        return wordCount
                .stream()
                .sorted(Comparator.comparingInt(WordInfo::getCount).reversed())
                .collect(Collectors.toList());
    }

    private List<WordInfo> countWordFrequency(List<String> inputStringArray){
        List<String> uniqueInputString = new ArrayList<String>(new HashSet<String>(inputStringArray));
        return uniqueInputString
                .stream()
                .map(word -> {return new WordInfo(word, Collections.frequency(inputStringArray, word));})
                .collect(Collectors.toList());
    }

    public String getResult(String inputString) {
        List<String> inputStringArray = splitInputString(inputString);
        List<WordInfo> wordCount = countWordFrequency(inputStringArray);
        wordCount = sortByWordFrequency(wordCount);
        return wordCount
                .stream()
                .map(WordInfo::toString)
                .collect(Collectors.joining(LINE_BREAK));
    }
}