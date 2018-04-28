package commands;

import core.permscore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class MessageBuilder implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        if (permscore.check(event)) {
            return;
        } else {

            /*EmbedBuilder em = new EmbedBuilder();
               event.getTextChannel().sendMessage("@everyone").queue();
            String Role1 = event.getGuild().getRolesByName("[OWNER]", true).get(0).getAsMention();
            String FirstRule = "Don't be toxic, racist, sexist or just mean to other people. If it is understood as a joke from both sides, maybe we can make an exception.\n";
            String SecondRule = "Do not advertise your Discord invite links anywhere, you will be banned for that. If DM-Advertising is reported, (which we want to be reported, if you see someone DM-Advertising, please contact any authority.) the advertising person will be banned. NO EXCEPTIONS!\n";
            String ThirdRule = "If you are having a fight/discussion with someone on this server and a staff member steps in to calm your moods, don't attack the staff member. If you still think the staff member wasn't on the right side, you can contact the " + Role1 + ".\n";
            event.getTextChannel().sendMessage(
                    em.setColor(Color.orange).setTitle("Rules :grin:", "https://discord.gg/tmEeBdz")
                            .addField("**First Rule**", FirstRule, false)
                            .addField("**Second Rule**", SecondRule, false)
                            .addField("**Third Rule**", ThirdRule, false)
                            .build()
            ).queue();

             MessageChannel channel = event.getChannel();

            RestAction<Message> action = channel.sendMessage("Test");
            Message message = action.complete();
            message.addReaction("✅").complete();
*/


            }

        EmbedBuilder builder = new EmbedBuilder();
        EmbedBuilder builder2 = new EmbedBuilder();

        event.getTextChannel().sendMessage(builder.setTitle(":wave:  Welcome on Black Hole!")
                .addField("We are a English Discord Server with great features!\n",
                        ":black_small_square:  *Rules, votes and giveaways* :clipboard: \n" +
                        ":black_small_square:  *Active support and members* :speech_balloon: \n" +
                        ":black_small_square:  *Game news* :loudspeaker: \n" +
                        ":black_small_square:  *Shop system* :shopping_cart: \n" +
                        ":black_small_square:  *Gaming and Talk channels* :loud_sound: \n" +
                        ":black_small_square:  *24/7 Music Bots* :headphones: \n"
                        , false).setColor(Color.green)
                .addField("", "",false)
                .addField(":warning: Rules:\n","" +
                        "**1.** Everyone is treated respectfully. Pornographic, racist, sexist or offensive content is forbidden!\n\n" +
                        "**2.** Spam and Caps are forbidden!\n\n" +
                        "**3.** Advertising in any form is forbidden! Excluded in the #Partner channel!\n\n" +
                        "**4.** All rules also apply to Avatar, game-status, names and nick-names!", false)
                .addField("", "",false)
                .build()).queue();

       String Partner = event.getGuild().getRolesByName("[PARTNER-MANAGER]", true).get(0).getAsMention();
           String Suggestion = event.getGuild().getTextChannelsByName("suggestions_reports", true).get(0).getAsMention();

        event.getTextChannel().sendMessage(builder2.setTitle(":question:  General Informations:")
                .addField("Partner:","Do you want to partner with us? Please contact a " + Partner + "!", false)
                .addField("", "", false)
                .addField("Suggestions and Reports:", "**Suggestion:** Use *!suggestion <Text>*\n**Report** User *!report <Name> <Reason>*\n\nFor the commands use " + Suggestion + "!", false)
                .addField("", "", false)
                .setColor(Color.blue).build()).queue();


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
    }

    @Override
    public String help() {
        return null;
    }


}
