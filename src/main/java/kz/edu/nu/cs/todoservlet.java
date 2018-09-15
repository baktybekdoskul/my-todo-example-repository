package kz.edu.nu.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/todo" })
public class todoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> list = new ArrayList<String>();
       

    public todoservlet() {
        super();
        list.add("Welcome, start adding items!");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		Gson gson = new Gson();
		out.append(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getParameter("action").equals("add")) {
	    	String myText = request.getParameter("texttosend");
		    list.add(myText);
	    } else if(request.getParameter("action").equals("delete")) {
	    	int delInd = Integer.parseInt(request.getParameter("deleteIndex"));
			list.remove(delInd);
	    } else if(request.getParameter("action").equals("edit")) {
	    	int editInd = Integer.parseInt(request.getParameter("editIndex"));
	    	String myText = request.getParameter("texttoedit");
			list.set(editInd, myText);
	    }
		
	}
	
}
