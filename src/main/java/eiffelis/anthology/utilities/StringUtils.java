package eiffelis.anthology.utilities;

public class StringUtils {

    public static String slugify(String text) {
        String[] words = text
                .toLowerCase()
                .replace("\n", " ")
                .replaceAll("[^a-z\\d\\s]", " ")
                .split(" ");

        text = String.join("-", words);
        return text.replaceAll("-+", "-");
    }
}
