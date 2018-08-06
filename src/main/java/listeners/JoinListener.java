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

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getGuild().getController().addSingleRoleToMember(event.getMember(),event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).queue();
            event.getGuild().getTextChannelsByName("\uD83D\uDC4Bwelcome", false).get(0).sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        event.getGuild().getTextChannelsByName("\uD83D\uDC4Bwelcome", true).get(0).sendMessage(em1.setColor(Color.green).setDescription("Welcome **" + event.getMember().getUser().getName() + "** at Black Hole!\nYou are the **" + event.getGuild().getMembers().size() + "** Member! :tada:\n\nHave a lot fun on our Server!").setTimestamp(Instant.now()).build()).queue();
        event.getGuild().getController().addSingleRoleToMember(event.getMember(), event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).queue();
    }
}
