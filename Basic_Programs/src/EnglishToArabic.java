import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EnglishToArabic {

    private static final Map<Character, Character> englishToArabicMap = new HashMap<>();

    static {
        char[][] mappings = {
            {'A', 'ا'}, {'B', 'ب'}, {'C', 'ج'}, {'D', 'د'}, {'E', 'ه'}, {'F', 'ف'}, {'G', 'غ'},
            {'H', 'ح'}, {'I', 'ى'}, {'J', 'ج'}, {'K', 'ك'}, {'L', 'ل'}, {'M', 'م'}, {'N', 'ن'},
            {'O', 'و'}, {'P', 'پ'}, {'Q', 'ق'}, {'R', 'ر'}, {'S', 'س'}, {'T', 'ت'}, {'U', 'ع'},
            {'V', 'ف'}, {'W', 'و'}, {'X', 'ش'}, {'Y', 'ي'}, {'Z', 'ز'},
            {'1', '١'}, {'2', '٢'}, {'3', '٣'}, {'4', '٤'}, {'5', '٥'},
            {'6', '٦'}, {'7', '٧'}, {'8', '٨'}, {'9', '٩'}, {'0', '٠'},
            {',', '،'}, {'?', '؟'}, {'!', '؛'}, {'.', '۔'}, {';', '؛'},
            {':', ':'}, {'(', '('}, {')', ')'}
        };
        
        for (char[] mapping : mappings) {
            englishToArabicMap.put(mapping[0], mapping[1]);
            englishToArabicMap.put(Character.toLowerCase(mapping[0]), mapping[1]); // Lowercase mapping
        }
    }

    public static String convertToArabic(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(c -> englishToArabicMap.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void convertFile(String inputFilePath, String outputFilePath) throws IOException {
        Path inputPath = Paths.get(inputFilePath);
        Path outputPath = Paths.get(outputFilePath);

        String content = new String(Files.readAllBytes(inputPath));
        String arabicContent = convertToArabic(content);

        Files.write(outputPath, arabicContent.getBytes());
        System.out.println("File converted successfully: " + outputFilePath);
    }

    public static void main(String[] args) {
    	
        String inputFile = "D:\\Practice\\TEST\\English.txt";
        String outputFile = "D:\\Practice\\TEST\\Arabic.txt";

        try {
            convertFile(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

}
