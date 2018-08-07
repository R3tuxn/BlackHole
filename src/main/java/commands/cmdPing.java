package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.time.Instant;

public class cmdPing implements Command{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        long ping = event.getJDA().getPing();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if (args.length > 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "ping`").build()).queue();
            return;
        }
        if (ping > 499) {
            event.getTextChannel().sendMessage(em1.setColor(Color.red).setTitle("Pong :ping_pong: ").setDescription("**" + ping + " ms**").setTimestamp(Instant.now()).build()).queue();
        } else if (ping > 99) {
            event.getTextChannel().sendMessage(em1.setColor(Color.orange).setTitle("Pong :ping_pong: ").setDescription("**" + ping + " ms**").setTimestamp(Instant.now()).build()).queue();
        } else {
            event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Pong :ping_pong: ").setDescription("**" + ping + " ms**").setTimestamp(Instant.now()).build()).queue();
        }
        System.out.println("[COMMAND] -> " + STATIC.Prefix + "ping");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }
    @Override
    public String help() {
        return null;
    }
}
