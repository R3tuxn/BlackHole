package util;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.awt.*;

public class Save  {

    public static void SelectTopic(MessageReceivedEvent event) {

        EmbedBuilder builder = new EmbedBuilder();
        TextChannel tc = event.getTextChannel();

        tc.sendMessage(builder.setColor(Color.cyan)
                .addField(":pushpin: Select your Topics!", "Click on the reaction!", false)
                //.addField(":small_orange_diamond:  Select-Topics :small_orange_diamond: ", "", false)
                .addField("Game News", ":video_game:", true)
                .addField("Bot News", ":robot:", true)
                .addField("Memes", ":frog:", true)
                .addField("", "If you are a Gamer, click on the reaction!", false)
                .addField("Gamer", ":space_invader: ", true)
                .setFooter("➡️ If you have a question, type !Questions", event.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .build()).queue();
    }
    public static void Informations(MessageReceivedEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        EmbedBuilder builder2 = new EmbedBuilder();

        event.getTextChannel().sendMessage(builder.setTitle(":wave:  Welcome on Black Hole!")
                .addField("We are a English and German Discord Server with great features!\n",
                        ":black_small_square:  *Rules, votes and giveaways* :clipboard: \n" +
                                ":black_small_square:  *Active support and members* :speech_balloon: \n" +
                                ":black_small_square:  *Game news* :loudspeaker: \n" +
                                ":black_small_square:  *Own Bot with great features!* :robot:\n" +
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
    public static void WelcomeMessage(MessageReceivedEvent event) {
      /*  String Server = "We are a English and German Discord server with active support and members, Gaming and Talk channels, game news, many great bots and much more! If you have any questions, please contact an " +
                "**[CO-OWNER]** or **[OWNER]**! For more informations, read **#informations**!";
        String Bot = "If you want to use our bot, go to **#bot_commands** and type **!help** to get the commands! If you have suggestions for the bot, go to **#suggestions_reports** and type **!suggestion <Text>**!";
        String Bot2 = "The bot is programmed by !я3тυχη#7145!";
        if (event.getChannel().getId().equals("406907194228080652")) {
            if (event.getReactionEmote().getName().equals("✅")) {
                channel1.sendMessage(em.setTitle("Welcome to Black Hole!").setColor(Color.green)
                        .setDescription("You have successfully registered!")
                        .addField("Server:", Server, false)
                        .addField("", "", false)
                        .addField("Bot:", Bot, false)
                        .setFooter(Bot2, event.getGuild().getMemberById("285480119575904256").getUser().getEffectiveAvatarUrl())
                        .build()).queue();
                event.getReaction().removeReaction(event.getUser()).complete();

                event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Member", true).get(0)).queue();

                event.getGuild().getTextChannelsByName("blackholebot_log2", true).get(1).sendMessage(em2.setColor(Color.green).setDescription("Welcome " + event.getMember().getAsMention() + " at Black Hole! Have a lot fun on our Server!").setTimestamp(Instant.now()).build()).queue();
*/
    }
}
// }
//}
