package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

public class readyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        EmbedBuilder builder = new EmbedBuilder();

        String Avatar = event.getJDA().getSelfUser().getEffectiveAvatarUrl();

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
            f.getTextChannelsByName("online", true).get(0).sendMessage(
                    builder.setFooter("Black Hole Bot", Avatar).setTitle("Online :wave:").setDescription(out).setColor(Color.YELLOW).setTimestamp(Instant.now()).build()
            ).queue();
        }


    }

}

