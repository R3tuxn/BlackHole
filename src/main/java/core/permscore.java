package core;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.util.Arrays;

public class permscore {

    public static boolean check(MessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        for (Role r : event.getGuild().getMember(event.getAuthor()).getRoles()) {

                if (Arrays.stream(STATIC.ADMINPERMS).parallel().anyMatch(r.getName()::contains))
                    return false;
                else
                    event.getTextChannel().sendMessage(
                            builder.setDescription(":warning: Sorry, " + event.getAuthor().getAsMention() + ", you don't have the permissions to use this command!").setColor(Color.red).build()
                    ).queue();
            return true;
            }
        return true;
    }
    }

