package com.mirantyJmartAK.dbjson;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * This class acts as parser for JsonTable,
 * aka all of the classes' data will be stored in a Json file.
 * Thus this class is created, so the file can be accessed, read,
 * written, and edited.
 *
 * @author Miranty Anjani Putri
 */

public class JsonTable<T> extends Vector<T>
{
    private static final Gson gson = new Gson();
    public final String filepath;

    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType,filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e) {
            File file = new File(filepath);
            File parent = file.getParentFile();
            if (parent != null) {
                parent.mkdirs();
            }
            file.createNewFile();
        }
    }

    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}