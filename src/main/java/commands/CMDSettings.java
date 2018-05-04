package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

public class CMDSettings implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        if (permscore.check(event)) {
            return;
        }

        EmbedBuilder builder = new EmbedBuilder();

        String Scanner = event.getMessage().getContentDisplay();

        if (Objects.equals(Scanner, STATIC.Prefix + "settings")) {
            event.getTextChannel().sendMessage(builder.setColor(Color.orange).setTitle(":clipboard: Settings")
                    .addField("", "`" + STATIC.Prefix + "settings bot <on/off>` *Turn the bot online or offline*", false)
                    .addField("", "", false)
                    .build()).queue();
        } else if(Objects.equals(Scanner, STATIC.Prefix + "settings bot on")) {

            STATIC.Switch1 = "on";
            event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":warning: " + event.getMessage().getAuthor().getAsMention() + ", you activated the bot!").build()).queue();

        } else if (Objects.equals(Scanner, STATIC.Prefix + "settings bot off")) {

            STATIC.Switch1 = "off";
            event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":warning: " + event.getMessage().getAuthor().getAsMention() + ", you disabled the bot!").build()).queue();

        } else {
            event.getTextChannel().sendMessage(
                    builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!settings*").build()).queue();
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
