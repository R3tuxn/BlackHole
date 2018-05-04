package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class LeftListener extends ListenerAdapter {

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        event.getGuild().getTextChannelsByName("welcome", true).get(1).sendMessage(builder.setColor(Color.red).setDescription("Oh no, " + event.getMember().getAsMention() + " left the server! :slight_frown:").setTimestamp(Instant.now()).build()).queue();
    }
}
