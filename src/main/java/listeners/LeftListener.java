package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;
import java.time.Instant;

public class LeftListener extends ListenerAdapter {

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getGuild().getTextChannelsByName("\uD83D\uDC4Bwelcome", false).get(0).sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        event.getGuild().getTextChannelsByName("\uD83D\uDC4Bwelcome", false).get(0).sendMessage(em1.setColor(Color.orange).setDescription("Oh no, **" + event.getMember().getUser().getName() + "** left the server! :slight_frown:").setTimestamp(Instant.now()).build()).queue();
    }
    }
