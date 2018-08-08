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
/*
package listeners;

        import commands.CMDAutoChannelFriends;
        import net.dv8tion.jda.core.EmbedBuilder;
        import net.dv8tion.jda.core.Permission;
        import net.dv8tion.jda.core.entities.*;
        import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
        import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
        import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
        import net.dv8tion.jda.core.hooks.ListenerAdapter;
        import util.STATIC;
        import java.awt.*;
        import java.time.Instant;
        import java.util.HashMap;
        import java.util.concurrent.TimeUnit;

public class AutoChannelFriendsListener extends ListenerAdapter {

    private String Friend1 = "[Friend Lounge] 1";
    private String Friend2 = "[Friend Lounge] 2";
    private String Friend3 = "[Friend Lounge] 3";

    private String Friend1ID = "";
    private String Friend2ID = "";
    private String Friend3ID = "";

    private int Position = 0;

    private void WaitTimer1Join(GuildVoiceJoinEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 31, "Could not start WaitTimer for Join Member!");
        }
    }

    private void WaitTimer2Join(GuildVoiceJoinEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 47, "Could not start WaitTimer for Join Member!");
        }
    }

    private void WaitTimer3Join(GuildVoiceJoinEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 63, "Could not start WaitTimer for Join Member!");
        }
    }

    private void WaitTimer1JoinMove(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 79, "Could not start WaitTimer for Join-Move Member!");
        }
    }

    private void WaitTimer2JoinMove(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 95, "Could not start WaitTimer for Join-Move Member!");
        }
    }

    private void WaitTimer3JoinMove(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 111, "Could not start WaitTimer for Join-Move Member!");
        }
    }

    private void WaitTimer1Move(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 127, "Could not start WaitTimer for Leave-Move Member!");
        }
    }

    private void WaitTimer2Move(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 143, "Could not start WaitTimer for Leave-Move Member!");
        }
    }

    private void WaitTimer3Move(GuildVoiceMoveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 159, "Could not start WaitTimer for Leave-Move Member!");
        }
    }

    private void WaitTimer1Leave(GuildVoiceLeaveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 175, "Could not start WaitTimer for Leave Member!");
        }
    }

    private void WaitTimer2Leave(GuildVoiceLeaveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 191, "Could not start WaitTimer for Leave Member!");
        }
    }

    private void WaitTimer3Leave(GuildVoiceLeaveEvent event) {
        VoiceChannel nvc = event.getJDA().getVoiceChannelById(CMDAutoChannelFriends.idscanner2);
        try {
            try {
                nvc.createPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            } catch (Exception e) {
                nvc.putPermissionOverride(event.getMember()).setDeny(Permission.VOICE_CONNECT).queue();
            }
            TimeUnit.SECONDS.sleep(5);
            nvc.putPermissionOverride(event.getMember()).setAllow(Permission.VOICE_CONNECT).queue();
        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 207, "Could not start WaitTimer for Leave Member!");
        }
    }

    //----------------------------------------------------------------------------------------------------
    //VoiceJoin - JoinEvent
    //----------------------------------------------------------------------------------------------------

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {

        PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
        //TextChannel tc = event.getGuild().getTextChannelsByName("voicelog", false).get(0);

        HashMap<VoiceChannel, Guild> autochannels2 = CMDAutoChannelFriends.getAutochannels2();
        VoiceChannel vc = event.getChannelJoined();
        VoiceChannel nvc;
        Guild g = event.getGuild();

        if (autochannels2.containsKey(vc)) {

            try {

                if (!STATIC.Checker.contains(Friend1) && Friend1ID.equalsIgnoreCase("")) {

                    STATIC.Checker.add(Friend1);
                    Position = 2;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend1).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend1ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    // tc.sendMessage(new EmbedBuilder().setDescription(":white_check_mark:  **" + event.getMember().getUser().getName() + "**# created Voice Channel `[Friend Lounge] 1`").setFooter(event.getGuild().getName(), event.getGuild().getIconUrl()).setTimestamp(Instant.now()).setColor(Color.green).build()).queue();

                    WaitTimer1Join(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 1!");

                } else if (!STATIC.Checker.contains(Friend2) && Friend2ID.equalsIgnoreCase("")) {
                    STATIC.Checker.add(Friend2);
                    Position = 3;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend2).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend2ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    WaitTimer2Join(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 2!");

                } else if (!STATIC.Checker.contains(Friend3) && Friend3ID.equalsIgnoreCase("")) {
                    STATIC.Checker.add(Friend3);
                    Position = 4;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend3).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend3ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    WaitTimer3Join(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 3!");

                } else {
                    pc.sendMessage(new EmbedBuilder().setColor(Color.orange).setTitle("AutoChannel Full!").setDescription("Maximum number of voice channels reached! Please wait for a new channel or create a public or private channel!").setFooter(null, event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setTimestamp(Instant.now()).build()).queue();
                    return;
                }
                try {
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL, Permission.CREATE_INSTANT_INVITE, Permission.MANAGE_WEBHOOKS, Permission.MANAGE_PERMISSIONS)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("[FRIENDS]", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_SPEAK, Permission.VOICE_MOVE_OTHERS)).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 311, "Could not find role [MEMBERS] or [FRIENDS]!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                util.Logger.ErrorMessage("AutoChannelFriendsListener", 391, "Could not create Voice-Channel(s)!");
            }
        }
    }

    //----------------------------------------------------------------------------------------------------
    //VoiceMove - LeftEvent
    //----------------------------------------------------------------------------------------------------

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {

        HashMap<VoiceChannel, Guild> autochannels2 = CMDAutoChannelFriends.getAutochannels2();
        //  TextChannel tc = event.getGuild().getTextChannelsByName("voicelog", false).get(0);
        VoiceChannel vc = event.getChannelLeft();
        VoiceChannel nvc;
        PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
        Guild g = event.getGuild();

        try {
            if (vc.getMembers().size() == 0 && Friend1ID.contains(vc.getId())) {

                Friend1ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend1);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 340, "Could not delete Voice-Channel!");
                }

                WaitTimer1Move(event);

            } else if (vc.getMembers().size() == 0 && Friend2ID.contains(vc.getId())) {
                Friend2ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend2);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 354, "Could not delete Voice-Channel!");
                }

                WaitTimer2Move(event);

            } else if (vc.getMembers().size() == 0 && Friend3ID.contains(vc.getId())) {

                Friend3ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend3);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 369, "Could not delete Voice-Channel!");
                }

                WaitTimer3Move(event);

            }
        } catch(Exception e){
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 332, "Could not delete Voice-Channel(s)!");
        }

        //----------------------------------------------------------------------------------------------------
        //VoiceMove-JoinEvent
        //----------------------------------------------------------------------------------------------------

        vc = event.getChannelJoined();

        if (autochannels2.containsKey(vc)) {

            try {

                if (!STATIC.Checker.contains(Friend1) && Friend1ID.equalsIgnoreCase("")) {
                    STATIC.Checker.add(Friend1);
                    Position = 2;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend1).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend1ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    WaitTimer1JoinMove(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 1!");

                } else if (!STATIC.Checker.contains(Friend2) && Friend2ID.equalsIgnoreCase("")) {
                    STATIC.Checker.add(Friend2);
                    Position = 3;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend2).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend2ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    WaitTimer2JoinMove(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 2!");

                } else if (!STATIC.Checker.contains(Friend3) && Friend3ID.equalsIgnoreCase("")) {
                    STATIC.Checker.add(Friend3);
                    Position = 4;

                    nvc = (VoiceChannel) g.getController().createVoiceChannel(Friend3).setUserlimit(10).setBitrate(vc.getBitrate()).complete();
                    Friend3ID = nvc.getId();
                    g.getController().modifyVoiceChannelPositions().selectPosition(nvc).moveTo(vc.getPosition() + Position).queue();

                    STATIC.active2.add(nvc);

                    if (vc.getParent() != null) {
                        nvc.getManager().setParent(vc.getParent()).queue();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    g.getController().moveVoiceMember(event.getMember(), nvc).queue();

                    WaitTimer3JoinMove(event);

                    util.Logger.ListenerdMessage("AutoChannel-Friends", event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator() + " created Voice Channel [Friend Lounge] 3!");

                } else {
                    pc.sendMessage(new EmbedBuilder().setColor(Color.orange).setTitle("AutoChannel Full!").setDescription("Maximum number of voice channels reached! Please wait for a new channel or create a public or private channel!").setFooter(null, event.getJDA().getSelfUser().getEffectiveAvatarUrl()).setTimestamp(Instant.now()).build()).queue();
                    return;
                }
                try {
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("[MEMBERS]", false).get(0)).setDeny(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_DEAF_OTHERS, Permission.VOICE_MUTE_OTHERS, Permission.MANAGE_CHANNEL, Permission.CREATE_INSTANT_INVITE, Permission.MANAGE_WEBHOOKS, Permission.MANAGE_PERMISSIONS)).queue();
                    nvc.createPermissionOverride(event.getJDA().getRolesByName("[FRIENDS]", false).get(0)).setAllow(Permission.getRaw(Permission.VOICE_CONNECT, Permission.VOICE_SPEAK, Permission.VOICE_MOVE_OTHERS)).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 311, "Could not find role [MEMBERS] or [FRIENDS]!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                util.Logger.ErrorMessage("AutoChannelFriendsListener", 391, "Could not create Voice-Channel(s)!");
            }
        }
    }

    //----------------------------------------------------------------------------------------------------
    //VoiceLeft - LeftEvent
    //----------------------------------------------------------------------------------------------------

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {

        VoiceChannel vc = event.getChannelLeft();
        // TextChannel tc = event.getGuild().getTextChannelsByName("voicelog", false).get(0);

        try {
            if (vc.getMembers().size() == 0 && Friend1ID.contains(vc.getId())) {

                Friend1ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend1);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 498, "Could not delete Voice-Channel!");
                }

                WaitTimer1Leave(event);

            } else if (vc.getMembers().size() == 0 && Friend2ID.contains(vc.getId())) {
                Friend2ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend2);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 512, "Could not delete Voice-Channel!");
                }

                WaitTimer2Leave(event);

            } else if (vc.getMembers().size() == 0 && Friend3ID.contains(vc.getId())) {

                Friend3ID = "";

                STATIC.active2.remove(vc);
                STATIC.Checker.remove(Friend3);

                try {
                    vc.delete().queue();
                } catch (Exception e) {
                    util.Logger.ErrorMessage("AutoChannelFriendsListener", 527, "Could not delete Voice-Channel!");
                }

                WaitTimer3Leave(event);

            }

        } catch (Exception e) {
            e.printStackTrace();
            util.Logger.ErrorMessage("AutoChannelFriendsListener", 490, "Could not delete Voice-Channel(s)!");
        }

*/



