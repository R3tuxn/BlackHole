package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class CMDInvite implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder em = new EmbedBuilder();

        String invite = "https://discord.gg/tmEeBdz";

        if (args.length > 0) {
            event.getTextChannel().sendMessage(em.setDescription(":x: **Error**\n\nUse *!invite*!").setColor(Color.red).build()).queue();
            return;
        }

      PrivateChannel channel = event.getAuthor().openPrivateChannel().complete();

        event.getMessage().delete().complete();

        RestAction<Message> action =  channel.sendMessage(em.setColor(Color.green).addField("Discord Link: ", invite, false).build());
        Message message = action.complete();
        message.addReaction("✅").complete();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
