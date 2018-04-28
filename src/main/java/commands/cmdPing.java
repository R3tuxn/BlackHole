package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class cmdPing implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        String ping = String.valueOf(event.getJDA().getPing());

        if(args.length > 0) {
                    event.getTextChannel().sendMessage(
                            builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!ping*").build()).queue();
                    return;
        } else {
            event.getTextChannel().sendMessage(
                    builder.setColor(Color.pink).setTitle("Pong :ping_pong: ").setDescription("**" + ping + " ms**").setTimestamp(Instant.now()).build()).queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

        System.out.println("[COMMAND] -> !ping");
    }

    @Override
    public String help() {
        return null;
    }
}
