package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

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

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        PrivateChannel channel = event.getAuthor().openPrivateChannel().complete();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if (args.length > 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "invite`").build()).queue();
            return;
        }

        event.getMessage().delete().complete();

        channel.sendMessage(em1.setColor(Color.green).setTitle(":pushpin: Complexity DC | Invite-Links :round_pushpin:")
                .addField(":flag_us: Offical Complexity DC | English:","https://discord.gg/txuZ7Aj", false)
                .addField(":flag_de: Complexity DC | German:","*Comming Soon*", false)
                .build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
