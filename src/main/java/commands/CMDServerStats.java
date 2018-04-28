package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.text.ParseException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CMDServerStats implements Command {

    public static class GuildStats {

        private String ID, Region, Roles, Owner, CreationTime;
        private int TextChannels, VoiceChannels, Categories;
        public  long all, users, onlineUsers, bots;
        public String Avatar, Name;


        public GuildStats(Guild g) {

            List<Member> l = g.getMembers();

            this.Name = g.getName();
            this.ID = g.getId();
            this.Region = g.getRegion().getName();
            this.Roles = " ";
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

            for (Role r : g.getRoles()) {
                this.Roles += r.getName() + ", ";
            }
            if (this.Roles.length() > 0)
                this.Roles = this.Roles.substring(0, this.Roles.length() - 2);
            else
                this.Roles = "No roles on this server.";

            this.Roles = g.getRoles().stream()
                    .filter(r -> !r.getName().contains("everyone"))
                    .map(r -> String.format(r.getName()))
                    .collect(Collectors.joining(", "));

        }
        }



    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException {

        EmbedBuilder aw = new EmbedBuilder();

        if (args.length > 0) {
            event.getTextChannel().sendMessage(
                    aw.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!serverstats*").build()).queue();
            return;
        } else {

            Guild g = event.getGuild();
            CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);

            String AvatarString = gs.Name + " | Server Stats";

            System.out.println("[COMMAND] -> !serverstats <" + g.getName() + ">");

            event.getTextChannel().sendMessage(aw.setColor(Color.green).setThumbnail(gs.Avatar).setTitle(AvatarString).setDescription("Name: " + "`" + gs.Name + "`" + "\nCreation-Time: " + "`" + gs.CreationTime + "`" + "\nOwner: " + "`" + gs.Owner + "`" + "\nID: " + "`" + gs.ID + "`" + "\nRegion: " + "`" + gs.Region + "`" + "\nRoles: " + "`" + gs.Roles + "`" + "\nText-Channels: " + "`" + gs.TextChannels + "`" +
                    "\nVoice-Channels: " + "`" + gs.VoiceChannels + "`" + "\nCategories: " + "`" + gs.Categories + "`" + "\n\n*Requested by " + event.getAuthor().getName() + "*").setTimestamp(Instant.now()).build()).queue();


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

