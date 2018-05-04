package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CMDPrefix implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException, InterruptedException {

        EmbedBuilder em1 = new EmbedBuilder();

        if (STATIC.Switch1.equals("off")) {
            event.getTextChannel().sendMessage(em1.setDescription("Bot disabled!").setColor(Color.red).build()).queue();
            return;
        }

        if (permscore.check(event)) {
            return;
        }

        EmbedBuilder builder = new EmbedBuilder();

        if (args.length == 0) {
            event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!prefix help*").build()).queue();
            return;
        } else {


            String Scanner = event.getMessage().getContentDisplay();

            if (Objects.equals(Scanner, STATIC.Prefix + "prefix help")) {

                event.getTextChannel().sendMessage(
                        builder.setColor(Color.orange)
                                .setDescription(":clipboard: Prefix Help")
                                .addField("", "`" + STATIC.Prefix + "`" + "`prefix help` *Open this message!*\n" + "`" + STATIC.Prefix + "`" + "`prefix new <PREFIX>` *Change the bot Prefix!*", false)
                                .addField("", "", false)
                                .addField("", "The current prefix is " + "`" + STATIC.Prefix + "`", false)
                                .addField("", "You can use `!  §  $  &  /  .  +  ?` !", false)
                                .build()
                ).queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new")) {

                event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *prefix help*").build()).queue();
                return;

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new !")) {

                STATIC.Prefix  = "!";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new §")) {

                STATIC.Prefix = "§";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new $")) {

                STATIC.Prefix  = "$";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new &")) {

                STATIC.Prefix  = "&";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new /")) {

                STATIC.Prefix  = "/";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new .")) {

                STATIC.Prefix  = ".";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new +")) {

                STATIC.Prefix = "+";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();

            } else if (Objects.equals(Scanner, STATIC.Prefix + "prefix new ?")) {

                STATIC.Prefix = "?";
                event.getTextChannel().sendMessage("Your Prefix changed!").queue();


            } else {
                event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!prefix help*").build()).queue();

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







