package model;

import controller.Servlet;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Flowers
{
    public void addFlower(Flower flower) throws IOException
    {
        JSONObject flowers = new JSONObject();

        flowers.put("name", flower.getName());
        flowers.put("type", flower.getType());
        flowers.put("length", flower.getLength());
        flowers.put("color", flower.getColor());
        flowers.put("price", flower.getPrice());

        // путь к файлу JSON
        String path = getJsonPath();

        // содержимое JSON
        String jsonContent = new String(Files.readAllBytes(Path.of(path)));

        // создаем JSONArray из строки JSON
        JSONArray jsonArray = new JSONArray(jsonContent);
        jsonArray.put(flower);

        // обновить локально
        try (FileWriter writer = new FileWriter(path))
        {
            writer.write(jsonArray.toString(4));
        }

        // обновить на сервере
        try (FileWriter writer = new FileWriter("cars.json"))
        {
            writer.write(jsonArray.toString(4));
        }
    }

    private String getJsonPath()
    {
        String parentPath;
        try
        {
            parentPath = new File(Servlet.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParent();
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }

        return parentPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "cars.json";
    }
}