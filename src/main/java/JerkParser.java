import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkParser {
    private String groceries;

    public JerkParser() throws IOException {
        groceries = loadFile();
    }


    private String loadFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }

        return result.toString();
    }


    public String getGroceries(){
        return groceries;
    }

    public String nameFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Nn][Aa][Mm][Ee]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("name");
        }

        return fix;
    }

    public String milkFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Mm][Ii][Ll][Kk]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("Milk");
        }

        return fix;
    }

    public String breadFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Bb][Rr][Ee][Aa][Dd]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("Bread");
        }

        return fix;
    }

    public String cookieFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Cc][0Oo][0Oo][Kk][Ii][Ee][Ss]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("Cookies");
        }

        return fix;
    }

    public String appleFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Aa][Pp][Pp][Ll][Ee][Ss]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("Apples");
        }

        return fix;
    }

    public String priceFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[Pp][Rr][Ii][Cc][Ee]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll("Price");
        }

        return fix;
    }

    public String specialCharFix(String groceries) throws Exception{
        Pattern p = Pattern.compile("[!@&*^]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(groceries);
        String fix = groceries;
        if(m.find()) {
            fix = m.replaceAll(";");
        }

        return fix;
    }



//    public void writeCorrected() throws Exception {
//        FileWriter writer = new FileWriter("/Users/mike/Projects/HurtLocker/src/main/resources/RawData.txt");
//        writer.write(nameFix(loadFile()));
//        writer.write(milkFix(loadFile()));
//        writer.write(breadFix(loadFile()));
//        writer.write(cookieFix(loadFile()));
//        writer.write(appleFix(loadFile()));
//        writer.write(specialCharFix(loadFile()));
//        writer.write(priceFix(loadFile()));
//        writer.close();
//
//        System.out.println(loadFile());
//    }

    public String[] arrayItem(String text){
        String[] itemArr = text.split("##");
        return itemArr;
    }

}
