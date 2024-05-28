package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import static java.nio.file.Path.of;

@WebServlet(urlPatterns = {"/flowers"})
public class Servlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        JSONObject Json = new JSONObject();
        Json.put("name", req.getParameter("name"));
        Json.put("type", req.getParameter("type"));
        Json.put("color", req.getParameter("color"));
        Json.put("length", req.getParameter("length"));
        Json.put("price", req.getParameter("price"));




        // содержимое JSON

        // создаем JSONArray из строки JSON
        JSONArray Array = new JSONArray(new String(Files.readAllBytes(of(getJsonPath()))));

        Array.put(Json);
        // обновить локально
        try (FileWriter writer = new FileWriter(getJsonPath()))
        {
            writer.write(Array.toString(4));
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        // обновить на сервере
        try (FileWriter writer = new FileWriter("flowers.json"))
        {
            writer.write(Array.toString(4));
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        // обновить страницу для обновления таблицы
        updatePage(req, resp);
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

        return parentPath + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "flowers.json";
    }

    private void updatePage(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}