package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import core.permscore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class cmdEmbedSay implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder em1 = new EmbedBuilder();
        EmbedBuilder Error = new EmbedBuilder();

        String Member = "By " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator();
        String Avatar = event.getAuthor().getEffectiveAvatarUrl();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        if (permscore.check(event)) {
            return;
        }

        if (args.length == 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "embedsay <Text>`").build()).queue();
            return;
        }
        event.getMessage().delete().complete();

        List argsList = Arrays.asList(args);
        StringBuilder sb = new StringBuilder();
        argsList.forEach(s -> sb.append(s + " "));
        send(sb.toString(), event);

        event.getTextChannel().sendMessage(em1.setColor(Color.WHITE).setDescription("**" + sb + "**").setFooter(Member, Avatar).build()).queue();

        System.out.println("[COMMAND] -> " + STATIC.Prefix + "embedsay <" + sb + ">");
    }


    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {return null;}
    public void send(String msg, MessageReceivedEvent event) {

    }
    }

