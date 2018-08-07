package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class cmdUserStats implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();

        Member memb;

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }
        if (args.length > 1) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "userStats <Name>`").build()).queue();
        } else {

            if (args.length == 1) {
                try {
                    memb = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
                } catch (Exception e) {
                    event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nCouldn't find user!").build()).queue();
                    return;
                }
            } else if (args.length == 0) {
                memb = event.getMember();
            } else {
                event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "userStats <Name>`").build()).queue();
                return;
            }

            String NAME = memb.getUser().getName() + "#" + memb.getUser().getDiscriminator();
            String NICKNAME = memb.getNickname();
            String GUILD_JOIN_DATE = memb.getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME);
            String DISCORD_JOIN_DATE = memb.getUser().getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME);
            String ID = memb.getUser().getId();
            String STATUS = memb.getOnlineStatus().getKey();
            int Roles = memb.getRoles().size();
            String GAME;
            String AVATAR = memb.getUser().getEffectiveAvatarUrl();


            if (NICKNAME == null) {
                NICKNAME = "-/-";
            }
            try {
                GAME = memb.getGame().getName();
            } catch (Exception e) {
                GAME = "-/-";
            }

            String NewRoles = Integer.toString(Roles);
            if (Roles == 0) {
                NewRoles = "-/-";
            }

            event.getTextChannel().sendMessage(em1.setColor(Color.green)
                    .setFooter("Requested by " + event.getAuthor().getName() + "#" + event.getAuthor().getDiscriminator(), event.getAuthor().getEffectiveAvatarUrl())
                    .setThumbnail(AVATAR)
                    .setTitle(":spy: User-Stats", null)
                    .addField("Name",NAME,true)
                    .addField("Nickname", NICKNAME, true)
                    .addField("Guild joined", GUILD_JOIN_DATE, true)
                    .addField("Discord joined", DISCORD_JOIN_DATE, true)
                    .addField("ID", ID, true).addField("Online-Status", STATUS, true)
                    .addField("Game", GAME, true).addField("Roles", NewRoles, true)
                    .setTimestamp(Instant.now())
                    .build()).queue();

            System.out.println("[COMMAND] -> " + STATIC.Prefix + "userstats <" + NAME + ">");
        }
    }

        @Override
        public void executed ( boolean success, MessageReceivedEvent event){
        }
        @Override
        public String help () {
            return null;
        }
    }






