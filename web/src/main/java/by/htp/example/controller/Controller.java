package by.htp.example.controller;

import by.htp.example.command.Command;
import by.htp.example.command.CommandHelper;
import by.htp.example.command.RequestParameterName;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final CommandHelper helper = CommandHelper.getInstance();

    public Controller() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName;
        Command command;

        commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
        command = CommandHelper.getInstance().getCommand(commandName);
        try {
            command.execute(request,response);
        } catch (IOException | ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
