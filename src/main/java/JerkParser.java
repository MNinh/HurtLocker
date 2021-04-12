import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkParser {
    private String groceries;

    public JerkParser() throws IOException {
        this.groceries = readFile();
    }

    public String readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("RawData.txt"));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while(line != null){
            sb.append(line).append("\n");
            line = br.readLine();
        }
        String content = sb.toString();
        return content;
    }

    public String nameFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Nn][Aa][Mm][Ee]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Name");
    }

    public String milkFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Mm][Ii][Ll][Kk]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Milk");
    }

    public String breadFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Bb][Rr][Ee][Aa][Dd]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Bread");
    }

    public String cookieFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Cc][0Oo][0Oo][Kk][Ii][Ee][Ss]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Cookies");
    }

    public String appleFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Aa][Pp][Pp][Ll][Ee][Ss]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Apples");
    }

    public String priceFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Pp][Rr][Ii][Cc][Ee]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        return m.replaceAll("Price");
    }

}
