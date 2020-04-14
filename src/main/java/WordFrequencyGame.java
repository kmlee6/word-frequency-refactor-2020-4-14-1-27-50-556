import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public List<WordInfo> sortByWordFrequency(List<WordInfo> wordCount){
        return wordCount
                .stream()
                .sorted(Comparator.comparingInt(WordInfo::getCount).reversed())
                .collect(Collectors.toList());
    }

    public List<WordInfo> countWordFrequency(List<String> inputStringArray){
        List<WordInfo> wordCount = new ArrayList<>();
        for(String word : new HashSet<String>(inputStringArray)){
            int count = Collections.frequency(inputStringArray, word);
            wordCount.add(new WordInfo(word, count));
        }
        return wordCount;
    }

    public String getResult(String inputStr) {
        final String SEPARATOR_PATTERN = "\\s+";
        final String LINE_BREAK = "\n";

        List<String> inputStringArray = Arrays.asList(inputStr.split(SEPARATOR_PATTERN));
        List<WordInfo> wordCount = countWordFrequency(inputStringArray);
        wordCount = sortByWordFrequency(wordCount);
        return wordCount
                .stream()
                .map(WordInfo::toString)
                .collect(Collectors.joining(LINE_BREAK));
    }
}