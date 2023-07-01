// пример метода на Java, который определит тип (расширение) файлов в текущей папке и выведет результат в указанном формате

import java.io.File;

public class FileExtensionDetector {
    public static void main(String[] args) {
        detectFileExtensions();
    }

    public static void detectFileExtensions() {
        File folder = new File(".");
        File[] files = folder.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    String filename = files[i].getName();
                    String extension = getFileExtension(filename);
                    System.out.println((i + 1) + " Расширение файла: " + extension);
                }
            }
        }
    }

    public static String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1);
        } else {
            return "";
        }
    }
}

