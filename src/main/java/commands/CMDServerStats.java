package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.text.ParseException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CMDServerStats implements Command {

    public static class GuildStats {

        private String ID, Region, Owner, CreationTime;
        private int TextChannels, VoiceChannels, Categories, Roles;
        public   long all, users, onlineUsers, bots;
        public String Avatar, Name;


        public GuildStats(Guild g) {

            List<Member> l = g.getMembers();

            this.Name = g.getName();
            this.ID = g.getId();
            this.Region = g.getRegion().getName();
            this.Roles = g.getRoles().size();
            this.TextChannels = g.getTextChannels().size();
            this.VoiceChannels = g.getVoiceChannels().size();
            this.Categories = g.getCategories().size();
            String OwnerID = this.Owner = g.getOwner().getUser().getDiscriminator();
            this.Owner = g.getOwner().getUser().getName() + "#" + OwnerID;
            this.Avatar = g.getController().getGuild().getIconUrl();
            this.CreationTime = g.getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME);

            this.all = l.size();
            this.users = l.stream().filter(m -> !m.getUser().isBot()).count();
            this.onlineUsers = l.stream().filter(m -> !m.getUser().isBot() && !m.getOnlineStatus().equals(OnlineStatus.OFFLINE)).count();
            this.bots = l.stream().filter(m -> m.getUser().isBot()).count();

        }
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);

        String Roles = Integer.toString(gs.Roles);
        String TextChannels = Integer.toString(gs.TextChannels);
        String VoiceChannels = Integer.toString(gs.VoiceChannels);
        String Categories = Integer.toString(gs.Categories);

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if (args.length > 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "serverStats`").build()).queue();
        } else {

            event.getTextChannel().sendMessage(em1.setColor(Color.green)
                    .setFooter(gs.Name,gs.Avatar)
                    .setTimestamp(Instant.now())
                    .setTitle(":chart_with_upwards_trend:  Server-Stats", null)
                    .addField("Name",gs.Name, true)
                    .addField("Creation-Time",gs.CreationTime,true)
                    .addField("Owner",gs.Owner,true)
                    .addField("ID", gs.ID,true)
                    .addField("Region",gs.Region,true)
                    .addField("Roles", Roles, true)
                    .addField("Text-Channels", TextChannels,true)
                    .addField("Voice-Channels", VoiceChannels, true)
                    .addField("Categories", Categories, true)
                    .setThumbnail(gs.Avatar)
                    .build()).queue();

            System.out.println("[COMMAND] -> " + STATIC.Prefix + "serverstats <" + g.getName() + ">");
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

