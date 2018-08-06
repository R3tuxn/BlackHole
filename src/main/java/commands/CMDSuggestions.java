package commands;

import core.permscore;
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

    public static class Suggestion1 {
        public String Avatar,Name,Report,ID, Name2;

        public Suggestion1(User event) {
            this.Name = "By " + event.getName() + "#" + event.getDiscriminator();
            this.Name2 = "by " + event.getName() + "#" + event.getDiscriminator();
            this.Avatar = event.getEffectiveAvatarUrl();
            this.Report = "This text is against the rules? Report it with ❌!";
            this.ID = event.getDiscriminator();


        }

    }

    public static StringBuilder SuggestionText;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();


        User user = event.getMember().getUser();
        CMDSuggestions.Suggestion1 ga = new Suggestion1(user);

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if (permscore.check(event)) {
            return;
        }

        if (args.length == 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "suggestion <Text>`").build()).queue();
            return;
        }
        try {
            if (args.length > 0) {
                List argsList = Arrays.asList(args);
                StringBuilder sb = new StringBuilder();
                argsList.forEach(s -> sb.append(s + " "));
                SuggestionText = sb;

                event.getMessage().delete().complete();
                MessageChannel channel = event.getGuild().getTextChannelsByName("\uD83D\uDCE9suggestions_reports", false).get(0);

                RestAction<Message> action = channel.sendMessage(em1.setColor(Color.green).setTitle("Suggestion:").setDescription("`" + SuggestionText + "`").addField("", ga.Report, false).setFooter(ga.Name, ga.Avatar).build());
                Message message = action.complete();
                message.addReaction("\uD83D\uDC4D\uD83C\uDFFB").complete();
                message.addReaction("\uD83D\uDC4E\uD83C\uDFFB").complete();
                message.addReaction("❌").complete();

                System.out.println("[COMMAND] -> " + STATIC.Prefix + "suggestion < " + SuggestionText + " > By " + event.getAuthor().getName() + ga.ID);

            }
        } catch (Exception e) {
            System.out.println("");
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
