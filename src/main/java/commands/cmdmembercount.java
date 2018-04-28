package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;


public class cmdmembercount implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);
        String U = " Users";
        String UO = " Online-Users";
        String M = " Members";
        String B = " Bots";

        if(gs.all < 2) {
            M = " Member";
        }
        if (gs.users < 2) {
            U = " User";
        }
        if (gs.onlineUsers < 2) {
            UO = " Online-User";
        }
        if (gs.bots < 2) {
            B = " Bot";
        }

        EmbedBuilder builder = new EmbedBuilder();

        if(args.length > 0) {
            event.getTextChannel().sendMessage(
                    builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!membercount*").build()).queue();
            return;
        } else {
        event.getTextChannel().sendMessage(
                builder.setColor(Color.gray).setFooter(gs.Name, gs.Avatar)
                .setTitle(":clipboard:   Membercount")
                .setDescription(":small_blue_diamond:  " + gs.all + " **" + M + "**\n" + ":small_blue_diamond:  " + gs.users + " **" + U + "**\n" + ":small_blue_diamond:  " + gs.onlineUsers + " **" + UO + "**\n" + ":small_blue_diamond:  " + gs.bots + " **" + B + "**")
                .setTimestamp(Instant.now()).build()).queue();

        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

        System.out.println("[COMMAND] -> !membercount");

    }

    @Override
    public String help() {
        return null;
    }
}
