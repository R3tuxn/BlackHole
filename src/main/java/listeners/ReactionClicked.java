package listeners;

import commands.CMDServerStats;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class ReactionClicked extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);

        PrivateChannel channel1 = event.getMember().getUser().openPrivateChannel().complete();
        EmbedBuilder em = new EmbedBuilder();
        EmbedBuilder em2 = new EmbedBuilder();

        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("❌")) {
                channel1.sendMessage(em.setColor(Color.green).setAuthor("Suggestion: ", null, gs.Avatar).setDescription("You **reported** this suggestion!").setFooter("Thanks for reporting! \uD83C\uDF89 ", null).build()).queue();
                event.getReaction().removeReaction(event.getUser()).complete();

            }
        }

        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("\uD83D\uDC4D\uD83C\uDFFB")) {
              //  channel1.sendMessage(em.setColor(Color.yellow).setAuthor("Suggestion: ", null, gs.Avatar).setDescription("You voted for **Yes**!\n\n").setFooter("Thanks for voting!  \uD83C\uDF89", null).build()).queue();

            }
        }
        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("\uD83D\uDC4E\uD83C\uDFFB")) {
             //   channel1.sendMessage(em.setColor(Color.yellow).setAuthor("Suggestion: ",null, gs.Avatar).setDescription("You voted for **No**!\n\n").setFooter("Thanks for voting!  \uD83C\uDF89 ", null).build()).queue();

            }
           }

        if (event.getChannel().getId().equals("440913477641568287")) {
            if (event.getReactionEmote().getName().equals("✅")) {
                channel1.sendMessage(em.setTitle("Welcome to Black Hole!").setColor(Color.green)
                        .setDescription("You have successfully registered!")
                        .addField("Server:", "**[Comming Soon!]**", false)
                        .addField("Bot:", "**[Comming Soon!]**", false).build()).queue();
                event.getReaction().removeReaction(event.getUser()).complete();

                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("[Member]", true).get(0)).queue();

                event.getGuild().getTextChannelsByName("welcome", true).get(1).sendMessage(em2.setColor(Color.green).setDescription("Welcome " + event.getMember().getAsMention() + " at Black Hole! Have a lot fun on our Server!").setTimestamp(Instant.now()).build()).queue();

            }
        }
        }

}



