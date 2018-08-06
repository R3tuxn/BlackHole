package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class MessageBuilder implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        MessageChannel channel = event.getTextChannel();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        if (permscore.check(event)) {
            return;
        }

        RestAction<Message> action = channel.sendMessage(em1.setColor(Color.cyan)
                .addField(":pushpin: Select your Topics!", "Click on the reaction!", false)
                //.addField(":small_orange_diamond:  Select-Topics :small_orange_diamond: ", "", false)
                .addField("Game News", ":video_game:", true)
                .addField("Bot News", ":robot:", true)
                .addField("Memes", ":frog:", true)
                .addField("", "If you are a Gamer, click on the reaction!", false)
                .addField("Gamer", ":space_invader: ", true)
                .setFooter("➡️ If you have a question, type !Questions", event.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .build());
        Message message = action.complete();
        message.addReaction("\uD83C\uDFAE").complete();
        message.addReaction("\uD83E\uDD16").complete();
        message.addReaction("\uD83D\uDC38").complete();
        message.addReaction("\uD83D\uDC7E").complete();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }

    @Override
    public String help() {
        return null;
    }


}
