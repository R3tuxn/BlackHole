package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import sun.plugin2.message.Message;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CMDPrefix implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        EmbedBuilder builder = new EmbedBuilder();


        if (args.length == 0) {
            event.getTextChannel().sendMessage(builder.setColor(Color.red).setDescription(":x: **Error**\n\nUse *!prefix help*").build()).queue();
            return;
        } else {

            if (args.length == 1) {

                String Prefix;


                /* switch (event.getMessage().getContentDisplay()) {
                    case help:
                        event.getTextChannel().sendMessage("Help").queue();
                        break;
                    case new1:
                        event.getTextChannel().sendMessage("New").queue();
                        break;
                    default:
                        event.getTextChannel().sendMessage("?").queue();
*/

                }
            }
        }


    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() { return null; }
    public void send(String msg, MessageReceivedEvent event) {
    }
    }
