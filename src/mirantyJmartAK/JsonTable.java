package mirantyJmartAK;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;
import com.google.gson.*;

public class JsonTable <T> extends Vector {
    public String filepath;
    private static final Gson gson = new Gson();

    public <T> JsonTable (Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
        //T[] result = JsonTable.readJson(array, filepath);
    }

    public T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
        try {
            File f1 = new File(filepath);
            Scanner dataReader = new Scanner(f1);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        }

        catch (FileNotFoundException exception) {
            System.out.println("Unexpected error occured!");
            exception.printStackTrace();
        }
        return null;
    }

    public void writeJson() throws IOException{
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException{
        try {
            FileWriter fWrite = new FileWriter(filepath);
            fWrite.write(gson.toJson(object));
            fWrite.close();
        }
        catch (IOException e) {
            System.out.println("Unexpected error occured!");
            e.printStackTrace();
        }
    }
}