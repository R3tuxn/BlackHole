package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.time.Instant;


public class cmdmembercount implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);

        String M = Long.toString(gs.all);
        String U = Long.toString(gs.users);
        String OU = Long.toString(gs.onlineUsers);
        String B = Long.toString(gs.bots);

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if(args.length > 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "membercount`").build()).queue();
            return;
        }

        event.getTextChannel().sendMessage(
                em1.setColor(Color.GREEN).setFooter(gs.Name, gs.Avatar)
                        .setTitle(":chart_with_upwards_trend:  Member-Counter")
                        .addField("Members", M, true)
                        .addField("Users", U, true)
                        .addField("Online-Users", OU, true)
                        .addField("Bots", B, true)
                        .setTimestamp(Instant.now()).build()).queue();

        System.out.println("[COMMAND] -> " + STATIC.Prefix + "membercount");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }

    @Override
    public String help() {
        return null;
    }
}
