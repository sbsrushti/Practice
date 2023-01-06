package practice2021.salesforce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputFileParser {
    Map<Character, String> patternMap;
    List<String> dictionaryWords;
    List<String> inputQueryStrings;

    InputFileParser(String inputFilePath) throws IOException {
        this.patternMap = new HashMap<>();
        this.dictionaryWords = new ArrayList<>();
        this.inputQueryStrings = new ArrayList<>();

        parseInputFile(inputFilePath);
    }

    public void parseInputFile(String inputFilePath) throws IOException {

        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(inputFilePath))) {
            parsePatternMap(bufferedFileReader);
            parseDictionaryWords(bufferedFileReader);
            parseInputQuery(bufferedFileReader);

        } catch (IOException ex) {
            System.out.println("Error while parsing input file");
            throw ex;
        }
    }

    private void parsePatternMap(BufferedReader bufferedFileReader) throws IOException {
        try {
            String line = bufferedFileReader.readLine();

            while (line != null) {
                if (line.trim().equals("*")) return;

                this.patternMap.put(line.charAt(0), line.substring(1).trim());
                line = bufferedFileReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error while parsing pattern map");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void parseDictionaryWords(BufferedReader bufferedFileReader) throws IOException {
        try {
            String line = bufferedFileReader.readLine();

            while (line != null) {
                if (line.trim().equals("*")) return;

                this.dictionaryWords.add(line.trim());
                line = bufferedFileReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error while parsing dictionary words");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void parseInputQuery(BufferedReader bufferedFileReader) throws IOException {
        try {
            String line = bufferedFileReader.readLine();

            while (line != null) {
                if (line.trim().equals("*")) return;

                int idx = line.indexOf(" ");
                int stIdx = 0;

                while (stIdx < line.length() && idx != -1) {
                    String trim = line.substring(stIdx, idx).trim();

                    if (!trim.isEmpty())
                        this.inputQueryStrings.add(trim);
                    stIdx = idx + 1;
                    idx = line.indexOf(" ", idx+1);
                }

                if (stIdx < line.length() && !line.substring(stIdx).trim().isEmpty()) {
                    this.inputQueryStrings.add(line.substring(stIdx).trim());
                }
                line = bufferedFileReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error while parsing input query");
            ex.printStackTrace();
            throw ex;
        }
    }
}
