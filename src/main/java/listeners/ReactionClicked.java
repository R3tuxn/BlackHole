package listeners;

import commands.CMDServerStats;
import commands.CMDSuggestions;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;
import java.time.Instant;

public class ReactionClicked extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

        Guild g = event.getGuild();
        CMDServerStats.GuildStats gs = new CMDServerStats.GuildStats(g);
        try {
            PrivateChannel channel1 = event.getMember().getUser().openPrivateChannel().complete();

            EmbedBuilder Error = new EmbedBuilder();
            EmbedBuilder em1 = new EmbedBuilder();

            if (STATIC.Switch1.equals("off")) {
                channel1.sendMessage(Error.setColor(Color.red).setDescription("**Error** :x:\n\nBot disabled!").build()).queue();
                return;
            }

            try {
                if (event.getChannel().getId().equals("425198107790409728")) {
                    if (event.getReactionEmote().getName().equals("❌")) {
                        channel1.sendMessage(em1.setColor(Color.green).setAuthor("Suggestion: ", null, gs.Avatar).setDescription("You **reported** this suggestion!").setFooter("Thanks for reporting! \uD83C\uDF89 ", null).build()).queue();
                        event.getReaction().removeReaction(event.getUser()).complete();

                        String Error1 = "*Couldn't find the suggestion!*";
                        EmbedBuilder em2 = new EmbedBuilder();
                        if (CMDSuggestions.SuggestionText == null) {
                            event.getGuild().getTextChannelsByName("bot_reports", false).get(0).sendMessage(em2.setColor(Color.GRAY).setAuthor("Report by " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator(),null, event.getMember().getUser().getEffectiveAvatarUrl())
                                    .setDescription(Error1).setTimestamp(Instant.now()).build()).queue();
                            return;
                        }
                        event.getGuild().getTextChannelsByName("bot_reports", false).get(0).sendMessage(em2.setColor(Color.GRAY).setAuthor("Report by " + event.getMember().getUser().getName() + "#" + event.getMember().getUser().getDiscriminator(),null, event.getMember().getUser().getEffectiveAvatarUrl())
                                .setDescription(CMDSuggestions.SuggestionText).setTimestamp(Instant.now()).build()).queue();
                    }
                }

                //Game-News
                if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
                    if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83C\uDFAE")) {
                        Role r = event.getGuild().getRolesByName("Game-News", false).get(0);
                        Guild s = event.getGuild();
                        if (event.getMember().getRoles().contains(r)) {
                            s.getController().removeSingleRoleFromMember(event.getMember(), r).queue();
                        } else
                            try {
                                s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                            } catch (Exception e) {
                                System.out.println("Could not add Role [" + r.getName() + "] !");
                            }
                    }

                }

                //Bot-News
                if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
                    if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83E\uDD16")) {
                        Role r = event.getGuild().getRolesByName("Bot-News", false).get(0);
                        Guild s = event.getGuild();
                        if (event.getMember().getRoles().contains(r)) {
                            s.getController().removeSingleRoleFromMember(event.getMember(), r).queue();
                        } else
                            try {
                                s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                            } catch (Exception e) {
                                System.out.println("Could not add Role [" + r.getName() + "] !");
                            }

                    }
                }

                //Memes
                if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
                    if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83D\uDC38")) {
                        Role r = event.getGuild().getRolesByName("Memes", false).get(0);
                        Guild s = event.getGuild();
                        if (event.getMember().getRoles().contains(r)) {
                            s.getController().removeSingleRoleFromMember(event.getMember(), r).queue();
                        } else
                            try {
                                s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                            } catch (Exception e) {
                                System.out.println("Could not add Role [" + r.getName() + "] !");
                            }
                    }


                }

                //Gamer
                if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
                    if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83D\uDC7E")) {
                        Role r = event.getGuild().getRolesByName("Gamer", false).get(0);
                        Guild s = event.getGuild();
                        if (event.getMember().getRoles().contains(r)) {
                            s.getController().removeSingleRoleFromMember(event.getMember(), r).queue();
                        } else
                            try {
                                s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                            } catch (Exception e) {
                                System.out.println("Could not add Role [" + r.getName() + "] !");
                            }
                    }
                }

            } catch (Exception e) {
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent event) {

        //Game-News
        if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
            if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83C\uDFAE")) {
                Role r = event.getGuild().getRolesByName("Game-News", false).get(0);
                Guild s = event.getGuild();
                if (event.getMember().getRoles().contains(r)) {
                    s.getController().removeSingleRoleFromMember(event.getMember(),r).queue();
                } else
                    try {
                        s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                    } catch (Exception e) {
                        System.out.println("Could not add Role [" + r.getName() + "] !");
                    }
            }

        }

//Bot-News
        if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
            if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83E\uDD16")) {
                Role r = event.getGuild().getRolesByName("Bot-News", false).get(0);
                Guild s = event.getGuild();
                if (event.getMember().getRoles().contains(r)) {
                    s.getController().removeSingleRoleFromMember(event.getMember(),r).queue();
                } else
                    try {
                        s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                    } catch (Exception e) {
                        System.out.println("Could not add Role [" + r.getName() + "] !");
                    }

            }
        }

//Memes
        if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
            if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83D\uDC38")) {
                Role r = event.getGuild().getRolesByName("Memes", false).get(0);
                Guild s = event.getGuild();
                if (event.getMember().getRoles().contains(r)) {
                    s.getController().removeSingleRoleFromMember(event.getMember(), r).queue();
                } else
                    try {
                        s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                    } catch (Exception e) {
                        System.out.println("Could not add Role [" + r.getName() + "] !");
                    }
            }


        }

        //Gamer
        if (event.getChannel().getId().equalsIgnoreCase("457914367095078913")) {
            if (event.getReactionEmote().getName().equalsIgnoreCase("\uD83D\uDC7E")) {
                Role r = event.getGuild().getRolesByName("Gamer", false).get(0);
                Guild s = event.getGuild();
                if (event.getMember().getRoles().contains(r)) {
                    s.getController().removeSingleRoleFromMember(event.getMember(),r).queue();
                } else
                    try {
                        s.getController().addSingleRoleToMember(event.getMember(), r).queue();
                    } catch (Exception e) {
                        System.out.println("Could not add Role [" + r.getName() + "] !");
                    }
            }
        }
    }
        }




