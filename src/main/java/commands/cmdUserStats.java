package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
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

        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(em1.setDescription("Bot disabled!").setColor(Color.red).build()).queue();
            return;
        }

            EmbedBuilder builder = new EmbedBuilder();

            Member memb;

            if (args.length > 1) {
                event.getTextChannel().sendMessage(builder.setDescription(":x: **Error**\n\nUse !userstats <Name>!").setColor(Color.red).build()).queue();
                return;
            }

            if (args.length == 1) {
                memb = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
            } else if (args.length == 0) {
                memb = event.getMember();
            } else {
                event.getTextChannel().sendMessage(builder.setDescription(":x: **Error**\n\nUse *!userstats <Name>*!").setColor(Color.red).build()).queue();
                return;
            }

            String NAME = memb.getEffectiveName();
            String NICKNAME = memb.getNickname();
            String GUILD_JOIN_DATE = memb.getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME);
            String DISCORD_JOIN_DATE = memb.getUser().getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME);
            String ID = memb.getUser().getId();
            String STATUS = memb.getOnlineStatus().getKey();
            String ROLES = "";
            String GAME;
            String AVATAR = memb.getUser().getEffectiveAvatarUrl();


            if (NICKNAME == null) {
                NICKNAME = "No Nickname";
            }
            try {
                GAME = memb.getGame().getName();
            } catch (Exception e) {
                GAME = "-/-";
            }

            for (Role r : memb.getRoles()) {
                ROLES += r.getName() + ", ";
            }
            if (ROLES.length() > 0)
                ROLES = ROLES.substring(0, ROLES.length() - 2);
            else
                ROLES = "No roles on this server.";

            if (AVATAR == null) {
                AVATAR = "No Avatar";
            }

            EmbedBuilder em = new EmbedBuilder().setColor(Color.GREEN);
            em.setDescription(":spy:   **User information for " + memb.getUser().getName() + ":**\n\nName: " + "`" + NAME + "`" + "\nNickname: " + "`" + NICKNAME + "`" + "\nID: " + "`" + ID + "`" + "\nOnline Status: " + "`" + STATUS + "`" + "\nGame: " + "`" + GAME + "`" + "\nRoles: " + "`" + ROLES + "`" +
                    "\nGuild joined " + "`" + GUILD_JOIN_DATE + "`" + "\nDiscord joined " + "`" + DISCORD_JOIN_DATE + "`" + "\n\n*Requested by " + event.getAuthor().getName() + "*").setTimestamp(Instant.now());


            if (AVATAR != "No Avatar") {
                em.setThumbnail(AVATAR);
            }

            event.getTextChannel().sendMessage(
                    em.build()
            ).queue();

            memb.getUser().getName();

            System.out.println("[COMMAND] -> !userstats <" + memb + ">");
    }


        @Override
        public void executed ( boolean success, MessageReceivedEvent event){



        }


        @Override
        public String help () {
            return null;
        }
    }






