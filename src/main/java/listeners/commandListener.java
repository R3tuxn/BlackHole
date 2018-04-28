package listeners;

import commands.CMDSuggestions;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import core.commandHandler;
import sun.plugin2.message.Message;
import util.STATIC;

public class commandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentDisplay().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            commandHandler.handleCommand(commandHandler.parser.parse(event.getMessage().getContentDisplay(), event));
        }


    }

}