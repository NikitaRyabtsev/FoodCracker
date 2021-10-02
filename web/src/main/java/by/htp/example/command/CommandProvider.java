package by.htp.example.command;

import by.htp.example.command.impl.AuthorizationCommand;
import by.htp.example.command.impl.GetAllMealsCommand;
import by.htp.example.command.impl.NoSuchCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final CommandProvider instance = new CommandProvider();

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider() {

        commands.put(CommandName.NO_SUCH_COMMAND,new NoSuchCommand());
        commands.put(CommandName.AUTHORIZATION,new AuthorizationCommand());
        commands.put(CommandName.GET_ALL_MEALS,new GetAllMealsCommand());
    }
    public static CommandProvider getInstance(){
        return instance;
    }

    public Command getCommand(String commandName){

        CommandName name = null;
        Command command = null;

        try{
            name = CommandName.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e){
            name = CommandName.NO_SUCH_COMMAND;
        }
        command = commands.get(name);
        return command;
    }
}
