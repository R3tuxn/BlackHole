package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.time.Instant;

   class VoiceLogListener extends ListenerAdapter {

        public static void VoiceJoin(GuildVoiceJoinEvent event) {
            EmbedBuilder em1 = new EmbedBuilder();
            event.getGuild().getTextChannelsByName("voicelog", false).get(0).sendMessage(em1.setColor(Color.green)
                    .setTitle(":arrow_up_small:  Joined Voice-Channel", null)
                    .setDescription("Joined `" + event.getChannelJoined().getName() + "` !")
                    .setFooter(event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator(), event.getMember().getUser().getEffectiveAvatarUrl())
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }

        public static void VoiceMove(GuildVoiceMoveEvent event) {
            EmbedBuilder em1 = new EmbedBuilder();
            VoiceChannel j = event.getChannelJoined();
            VoiceChannel l = event.getChannelLeft();

            event.getGuild().getTextChannelsByName("voicelog", false).get(0).sendMessage(em1.setColor(Color.cyan)
                    .setTitle(":arrow_forward:  Moved to Voice-Channel", null)
                    .setDescription("Moved from `" + l.getName() + "` to `" + j.getName() + "` !")
                    .setTimestamp(Instant.now())
                    .setFooter(event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator(), event.getMember().getUser().getEffectiveAvatarUrl())
                    .build()).queue();
        }

        public static void VoiceLeave(GuildVoiceLeaveEvent event) {
            EmbedBuilder em1 = new EmbedBuilder();
            event.getGuild().getTextChannelsByName("voicelog", false).get(0).sendMessage(em1.setColor(Color.orange)
                    .setTitle(":arrow_down_small:  Left Voice-Channel", null)
                    .setDescription(" Left `" + event.getChannelLeft().getName() + "` !")
                    .setTimestamp(Instant.now())
                    .setFooter(event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator(), event.getMember().getUser().getEffectiveAvatarUrl())
                    .build()).queue();
        }
    }

