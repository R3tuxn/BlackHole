package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;
import util.STATIC;

import java.awt.*;
import java.time.Instant;

public class JoinListener extends ListenerAdapter{

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

            EmbedBuilder builder = new EmbedBuilder();

        event.getGuild().getTextChannelsByName("welcome", true).get(0).sendMessage(builder.setColor(Color.green).setDescription("Welcome **" + event.getMember().getUser().getName() + "** at Black Hole!\nYou are the **" + event.getGuild().getMembers().size() + "** Member! :tada:\n\nHave a lot fun on our Server!").setTimestamp(Instant.now()).build()).queue();

    }
}
