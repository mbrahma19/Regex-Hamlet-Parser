import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private Pattern pattern;
    private Matcher matcher;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = findAndReplace("Horatio", "Tariq",scanner.nextLine());
                String secondLine = findAndReplace("Hamlet", "Leon",line);
                result.append(secondLine).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }


    public String findAndReplace(String item, String replacement, String sentence){
        String result;
        if(findString(item,sentence)){
            result = replacementString(item, replacement, sentence);
        }else{
            result = sentence;
        }
        return result;
    }

    public Boolean findString(String item, String sentence){
        String stringPattern = ".*"+ item +".*";
        pattern = Pattern.compile(stringPattern,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(sentence);
        return matcher.matches();
    }

    public String replacementString(String item, String replacement, String sentence){
        String stringPattern = "("+ item +")";
        pattern = Pattern.compile(stringPattern,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(sentence);
        String replaceAll = matcher.replaceAll(replacement);
        return replaceAll;
    }

    public String getHamletData(){
        return hamletData;
    }

//    public static void main(String[] args) {
//        HamletParser hp = new HamletParser();
//        System.out.println(hp.getHamletData());
//    }

}
