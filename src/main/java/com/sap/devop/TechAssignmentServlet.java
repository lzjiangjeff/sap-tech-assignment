package com.sap.devop;

import sun.misc.ClassLoaderUtil;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 * Created by Jeff Jiang on 2018/11/1.
 */

@WebServlet(
        name = "TechAssignmentServlet",
        urlPatterns = "/"
)

public class TechAssignmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fileName = "/WEB-INF/classes/resume.txt";
        ServletContext context = getServletContext();
        InputStream inputStream = context.getResourceAsStream(fileName);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        List contents = new ArrayList();
        for (String line; (line = reader.readLine()) != null;) {
            contents.add(line);
        }
        reader.close();
        req.setAttribute("contents", contents);
        RequestDispatcher view = req.getRequestDispatcher("display.jsp");
        view.forward(req, resp);

    }

}
