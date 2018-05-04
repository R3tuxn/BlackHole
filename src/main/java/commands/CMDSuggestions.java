package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class CMDSuggestions implements Command {

    public static class Suggestion {

        public String Name, Avatar, ID;

        public Suggestion(User user) {

            this.Name = user.getName();
            this.Avatar = user.getEffectiveAvatarUrl();
            this.ID = user.getDiscriminator();
        }
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(em1.setDescription("Bot disabled!").setColor(Color.red).build()).queue();
            return;
        }

        EmbedBuilder builder = new EmbedBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        CMDReport.Grund gs = new CMDReport.Grund(stringBuilder);

        String Avatar = event.getAuthor().getEffectiveAvatarUrl();
        String Name = "By " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator();
        String text = "*Vote now with* \uD83D\uDC4D\uD83C\uDFFB *or*  \uD83D\uDC4E\uD83C\uDFFB ";
        String Report = "This text is against the rules? Report it with ❌!";

        if (args.length == 0) {
            event.getTextChannel().sendMessage(
                    builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!suggestion >Text<*").build()
            ).queue();
        } else {

        }
        if (args.length > 0) {
            List argsList = Arrays.asList(args);
            StringBuilder sb = new StringBuilder();
            argsList.forEach(s -> sb.append(s + " "));
            gs.Suggestion = sb;

            event.getMessage().delete().complete();
            String ID = event.getAuthor().getDiscriminator();

            MessageChannel channel = event.getGuild().getTextChannelsByName("suggestions_reports", false).get(0);

            RestAction<Message> action = channel.sendMessage(builder.setColor(Color.green).setTitle("Suggestion:").setDescription(gs.Suggestion).addField("", text, false).addField("", Report, false).setFooter(Name, Avatar).build());
            Message message = action.complete();
            message.addReaction("\uD83D\uDC4D\uD83C\uDFFB").complete();
            message.addReaction("\uD83D\uDC4E\uD83C\uDFFB").complete();
            message.addReaction("❌").complete();

            System.out.println("[COMMAND] -> !suggestion < " + gs.Suggestion + " > By " + event.getAuthor().getName() + ID);

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
    }

}
