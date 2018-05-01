package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;

import java.awt.*;

public class JoinListener extends ListenerAdapter{

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        MessageChannel channel = event.getGuild().getTextChannelsByName("welcome", true).get(0);

        String NewMember = "Welcome " + event.getMember().getUser().getName() +"! :wave: ";
        String Regeln = event.getGuild().getTextChannelsByName("rules", true).get(0).getAsMention();

        RestAction<Message> action = channel.sendMessage(builder.setDescription("You are the " + "**" +
                event.getGuild().getMembers().size() + "**" +" Member! :tada: \n\nPlease read the " + Regeln + "! You can register your account by clicking the hook!")
                .setTitle(NewMember, null).setColor(Color.green).build());
        Message message = action.complete();
        message.addReaction("✅").complete();

    }
}
