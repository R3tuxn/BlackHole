package listeners;

import commands.CMDServerStats;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class ReactionClicked extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);

        PrivateChannel channel1 = event.getMember().getUser().openPrivateChannel().complete();
        EmbedBuilder em = new EmbedBuilder();


        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("\uD83D\uDC4D\uD83C\uDFFB")) {
                channel1.sendMessage(em.setColor(Color.yellow).setAuthor("Suggestion: ", null, gs.Avatar).setDescription("You voted for **Yes**!\n\n").setFooter("Thanks for voting!  \uD83C\uDF89", null).build()).queue();

            }
        }
        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("\uD83D\uDC4E\uD83C\uDFFB")) {
                channel1.sendMessage(em.setColor(Color.yellow).setAuthor("Suggestion: ",null, gs.Avatar).setDescription("You voted for **No**!\n\n").setFooter("Thanks for voting!  \uD83C\uDF89 ", null).build()).queue();

            }
        }
        if (event.getChannel().getId().equals("425198107790409728")) {
            if (event.getReactionEmote().getName().equals("❌")) {
                channel1.sendMessage(em.setColor(Color.green).setAuthor("Suggestion: ", null, gs.Avatar).setDescription("You **reported** this suggestion!").setFooter("Thanks for reporting! \uD83C\uDF89 ", null).build()).queue();
                event.getReaction().removeReaction(event.getUser()).complete();

            }
        }
        }
    }




