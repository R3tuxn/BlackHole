package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;
import java.time.Instant;
import java.util.List;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        String Avatar = event.getJDA().getSelfUser().getEffectiveAvatarUrl();
        event.getJDA().getTextChannelsByName("workstation", false).get(0).sendMessage("!reset").queue();
        event.getJDA().getTextChannelsByName("workstation", false).get(0).sendMessage("-").queue();

        List<Message> msgs;
        MessageHistory history = new MessageHistory(event.getJDA().getTextChannelsByName("workstation", false).get(0));

        msgs = history.retrievePast(2).complete();
        event.getJDA().getTextChannelsByName("workstation", false).get(0).deleteMessages(msgs).queue();

        for (Guild s : event.getJDA().getGuildsByName("Black Hole", true)) {
            //s.getTextChannelsByName("blackholebot_log2", true).get(0).sendMessage(
                 //   builder.setFooter("Black Hole Bot", Avatar).setTitle("Online :wave:").setColor(Color.green).setTimestamp(Instant.now()).build()).queue();

        }

        String out = "\n";
        for (Guild g : event.getJDA().getGuilds()) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }


        System.out.println(out);

        for (Guild f : event.getJDA().getGuildsByName("Bot-Test-Server", true)) {
            f.getTextChannelsByName("welcome", true).get(0).sendMessage(
                    builder.setFooter("Black Hole Bot", Avatar).setTitle("Online :wave:").setDescription(out).setColor(Color.YELLOW).setTimestamp(Instant.now()).build()
            ).queue();
        }


    }

}

