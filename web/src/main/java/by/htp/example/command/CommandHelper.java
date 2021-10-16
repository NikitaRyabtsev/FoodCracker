package by.htp.example.command;

import by.htp.example.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private static final CommandHelper instance = new CommandHelper();

    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper() {
//User
        commands.put(CommandName.LOG_OUT , new LogoutCommand());
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandName.REGISTRATION,new RegistrationCommand());
        commands.put(CommandName.GO_TO_REGISTRATION,new ToRegistrationCommand());
        commands.put(CommandName.TO_EDIT_PROFILE,new ToEditProfileCommand());
        commands.put(CommandName.GET_ALL_USERS,new GetUsersCommand());
        commands.put(CommandName.BLOCK_USER,new BlockUserCommand());
        commands.put(CommandName.DELETE_USER, new DeleteUserCommand());
//Meal
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.GET_ALL_MEALS , new GetAllMealsCommand());
        commands.put(CommandName.ADD_NEW_MEAL,new AddNewMealCommand());
        commands.put(CommandName.CHANGE_MEAL,new ChangeMealCommand());
        commands.put(CommandName.DELETE_MEAL,new DeleteMealCommand());
        commands.put(CommandName.GET_MEAL_BY_ID,new GetMealByIdCommand());
        commands.put(CommandName.GET_MEAL_BY_DATE,new GetMealByDateCommand());
//Food
        commands.put(CommandName.GET_ALL_FOOD,new GetAllFoodCommand());


    }
    public static CommandHelper getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        Command command;
        if(null!=name) {
            command = commands.get(name);
        }else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }

        return command;
    }

}
