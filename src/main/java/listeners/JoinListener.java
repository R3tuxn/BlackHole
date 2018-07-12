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

        EmbedBuilder em1 = new EmbedBuilder();
        String ID1 = event.getGuild().getMemberById("285480119575904256").getUser().getDiscriminator();
        String ID2 = event.getGuild().getMemberById("306782515040092171").getUser().getDiscriminator();
        String CoOwner = event.getGuild().getMemberById("285480119575904256").getUser().getName() + "#" + ID1;
        String Owner = event.getGuild().getMemberById("306782515040092171").getUser().getName() + "#" + ID2;

        if (STATIC.Switch1.equals("off")) {
            event.getGuild().getTextChannelsByName("welcome", true).get(0).sendMessage(em1.setDescription("Bot disabled!").setFooter("Please contact " + CoOwner + " or " + Owner + "!", null).setColor(Color.red).build()).queue();
            return;
        }


        EmbedBuilder builder = new EmbedBuilder();

        try {
            event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("[MEMBERS]", true).get(0)).queue();
        } catch (Exception e) {
            event.getGuild().getTextChannelsByName("welcome", true).get(1).sendMessage(builder.setDescription(":x: *Error* \n\nRole **[MEMBER]** was deleted or renamed !").setColor(Color.red).build()).queue();
        }


        event.getGuild().getTextChannelsByName("owner-lounge", true).get(1).sendMessage(builder.setColor(Color.green).setDescription("Welcome " + event.getMember().getUser().getAsMention() + " at Black Hole! You are the **" + event.getGuild().getMembers().size() + "** Member! :tada:\nHave a lot fun on our Server!").setTimestamp(Instant.now()).build()).queue();


        /*MessageChannel channel = event.getGuild().getTextChannelsByName("welcome", true).get(0);

        String NewMember = "Welcome " + event.getMember().getUser().getName() +"! :wave: ";
        String Regeln = event.getGuild().getTextChannelsByName("rules", true).get(0).getAsMention();

        RestAction<Message> action = channel.sendMessage(builder.setDescription("You are the " + "**" +
                event.getGuild().getMembers().size() + "**" +" Member! :tada: \n\nPlease read the " + Regeln + "! You can register your account by clicking the hook!")
                .setTitle(NewMember, null).setColor(Color.green).build());
        Message message = action.complete();
        message.addReaction("✅").complete();
*/
    }
}
