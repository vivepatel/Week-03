package linearsearch.linearsearchsentence;
public class LinearSearchSentence {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {"The quick brown fox", "Java is fun", "I love programming", "This is a test sentence"};
        String word = "programming";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);
    }
}
