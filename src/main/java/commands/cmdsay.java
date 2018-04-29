package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class cmdsay implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

                if(args.length == 0){
                event.getTextChannel().sendMessage(
                        builder.setColor(Color.red).setTitle(":x: **Error**\n\nUse *!say >Text<").build()
                ).queue();
                    return;

            } else {
                List argsList = Arrays.asList(args);
                StringBuilder sb = new StringBuilder();
                argsList.forEach(s -> sb.append(s + " "));
                send(sb.toString(), event);

                    System.out.println("[COMMAND] -> !say < "+ sb + ">");
            }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
    public void send(String msg,MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(msg).queue();
    }

}
