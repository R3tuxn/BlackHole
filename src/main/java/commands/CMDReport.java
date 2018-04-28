package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import core.permscore;

import java.awt.*;
import java.io.IOException;
import net.dv8tion.jda.core.entities.Member;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class CMDReport implements Command {
    public static class Grund {

        public StringBuilder Grund, Vorschlag;

        public Grund(StringBuilder builder) {

            this.Grund = builder.append("");
            this.Vorschlag = builder.append("");

        }
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        String Ersteller = event.getAuthor().getName();

        if (permscore.check(event)) {
           return;
        }

        EmbedBuilder em = new EmbedBuilder();
        StringBuilder builder = new StringBuilder();
        CMDReport.Grund gs = new CMDReport.Grund(builder);

        Member member = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));

        if (args.length == 0) {
            event.getTextChannel().sendMessage(em.setDescription(":x: **Error**\n\nUse !report <Name> <Reason>!").setColor(Color.red).build()).queue();
            return;
        }
        if (args.length == 1) {
            member.getUser().getName();
        }
        if (args.length > 1) {
            List argsList = Arrays.asList(args);
            StringBuilder sb = new StringBuilder();
            argsList.forEach(s -> sb.append(s + " "));
            gs.Grund = sb;

            event.getGuild().getTextChannelsByName("blackholebot_log2", false).get(0).sendMessage("Your message has been sent succesfully!").queue();
            event.getGuild().getTextChannelsByName("online", false).get(0).sendMessage(em.setDescription("**Report!**\n\nMelder: " + Ersteller + "\nVerbrecher: " + member + "\nGrund: " + gs.Grund).build()).queue();

        } else {
            event.getTextChannel().sendMessage(em.setDescription(":x: **Error**\n\nUse !report <Name> <Reason>!").setColor(Color.red).build()).queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() { return null; }

}
