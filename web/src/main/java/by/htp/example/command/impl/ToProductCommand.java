package by.htp.example.command.impl;

import by.htp.example.ServiceException;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.command.Command;
import by.htp.example.command.CommandHelper;
import by.htp.example.command.CommandName;
import by.htp.example.command.JSPPageName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToProductCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException, DaoException {
        CommandHelper.getInstance().getCommand(String.valueOf(CommandName.GET_ALL_FOOD)).execute(request, response);
    }
}
