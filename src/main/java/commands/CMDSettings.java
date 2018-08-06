package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Objects;

public class CMDSettings implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        EmbedBuilder em1 = new EmbedBuilder();
        EmbedBuilder em2 = new EmbedBuilder();
        EmbedBuilder Error = new EmbedBuilder();

        String Scanner = event.getMessage().getContentDisplay();

        if (permscore.check(event)) {
            return;
        }

        if (Objects.equals(Scanner, STATIC.Prefix + "settings help")) {
            event.getTextChannel().sendMessage(em1.setColor(Color.orange).setTitle(":clipboard: Settings Menu")
                    .addField("", STATIC.Prefix + "`settings commands <on/off>` *Activate or deactivate the commands!*", false)
                    .addField("", "", false)
                    .build()).queue();

            System.out.println("[COMMAND] -> " + STATIC.Prefix + "settings help");

        } else if (Objects.equals(Scanner, STATIC.Prefix + "settings commands on")) {

            STATIC.Switch1 = "on";
            event.getTextChannel().sendMessage(em2.setColor(Color.green).setTitle("Commands activated :white_check_mark: ").setDescription(":warning:  You activated the commands successfully!").setTimestamp(Instant.now()).build()).queue();
            System.out.println("[COMMAND] -> " + STATIC.Prefix + "settings commands on");

        } else if (Objects.equals(Scanner, STATIC.Prefix + "settings commands off")) {

            STATIC.Switch1 = "off";
            event.getTextChannel().sendMessage(em2.setColor(Color.green).setTitle("Commands deactivated :white_check_mark: ").setDescription(":warning:  You deactivated the commands successfully!").setTimestamp(Instant.now()).build()).queue();
            System.out.println("[COMMAND] -> " + STATIC.Prefix + "settings commands off");

        } else {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "settings help`").build()).queue();
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
