package by.htp.example.controller;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.command.Command;
import by.htp.example.command.CommandHelper;
import by.htp.example.command.RequestParameterName;
import by.htp.example.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final CommandHelper helper = CommandHelper.getInstance();

    public ControllerServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName;
        Command command;
        commandName = request.getParameter(RequestParameterName.REQ_PARAM_COMMAND_NAME);
        System.out.println("Comm name: " + commandName);

        command = CommandHelper.getInstance().getCommand(commandName);

        try {
            command.execute(request, response);
        } catch (IOException | ServletException | ServiceException | DaoException e) {

            e.printStackTrace();
        }

    }
}
