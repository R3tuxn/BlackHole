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

    }
}

