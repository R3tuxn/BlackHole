package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.*;

public class CMDPrefix implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        EmbedBuilder Error = new EmbedBuilder();
        EmbedBuilder em1 = new EmbedBuilder();
        EmbedBuilder em2 = new EmbedBuilder();

        String Scanner = event.getMessage().getContentDisplay();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
            return;
        }

        if (permscore.check(event)) {
            return;
        }

        if (args.length == 0) {
            event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "prefix help`").build()).queue();
        } else {

            if (Objects.equals(Scanner, STATIC.Prefix + "prefix help")) {

                event.getTextChannel().sendMessage(
                        em2.setColor(Color.orange)
                                .setDescription(":clipboard: Prefix Help Menu")
                                .addField("", STATIC.Prefix + "`prefix help` *Open the Prefix-Help-Menu!*\n" + STATIC.Prefix +"`prefix new <PREFIX>` *Change the bot Prefix!*", false)
                                .addField("", "", false)
                                .addField("", "The current prefix is " + "`" + STATIC.Prefix + "`", false)
                                .addField("", "You can use `!  §  &  /  .  , -` !", false)
                                .build()
                ).queue();

                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix help");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new")) {

                event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "prefix help`").build()).queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new !")) {

                STATIC.Prefix  = "!";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new §")) {

                STATIC.Prefix = "§";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new &")) {

                STATIC.Prefix  = "&";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new /")) {

                STATIC.Prefix  = "/";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new .")) {

                STATIC.Prefix  = ".";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new ,")) {

                STATIC.Prefix = ",";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new -")) {

                STATIC.Prefix = "-";
                event.getTextChannel().sendMessage(em1.setColor(Color.green).setTitle("Prefix changed :white_check_mark: ").setDescription("You changed the prefix successfully to `" + STATIC.Prefix + "` !").setTimestamp(Instant.now()).build()).queue();
                System.out.println("[COMMAND] -> " + STATIC.Prefix + "prefix new");

            } else {
                event.getTextChannel().sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nUse `" + STATIC.Prefix + "prefix help`").build()).queue();

            }
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







