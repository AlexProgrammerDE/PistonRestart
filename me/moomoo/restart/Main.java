package me.moomoo.restart;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
public class Main extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();

    public static String restarttimerdone = "false";
    String playerslow = "false";

    public void onEnable() {
        saveDefaultConfig();
        System.out.println("[ENABLED] moomoo's 2b2t restart notifications plugin");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(getConfig().getString("Timezone")));
        ZonedDateTime nextRun = now.withHour(getConfig().getInt("Hour")).withMinute(getConfig().getInt("Minute")).withSecond(getConfig().getInt("Seconds"));
        if(now.compareTo(nextRun) > 0)
            nextRun = nextRun.plusDays(1);

        Duration duration = Duration.between(now, nextRun);
        long initalDelay = duration.getSeconds();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            Thread t = new Thread(() -> {
                try {
                    restarttimerdone = "true";
                    if(Bukkit.getServer().getOnlinePlayers().size() > getConfig().getInt("MinimumPlayersToRestart")){
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                        sleep(300000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                        sleep(300000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                        sleep(180000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                        sleep(105000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 14 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 13 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 12 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 11 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 9 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 8 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 7 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 6 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 4 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 3 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 1 second...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting...");
                        Bukkit.shutdown();
                    } else {
                        sleep(432000000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                        sleep(300000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                        sleep(300000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                        sleep(180000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                        sleep(105000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 14 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 13 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 12 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 11 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 9 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 8 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 7 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 6 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 4 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 3 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 seconds...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 1 second...");
                        sleep(1000);
                        Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting...");
                        Bukkit.shutdown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            t.start();
        }, initalDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent evt){
        int count = Bukkit.getServer().getOnlinePlayers().size();
        if(restarttimerdone == "true"){
            if(count == 0){
                Bukkit.shutdown();
            } else {
                if(playerslow != "true"){
                    if(count > getConfig().getInt("MinimumPlayersToRestart")){
                        Thread t = new Thread(() -> {
                            try {
                                playerslow = "true";
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 minutes...");
                                sleep(300000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 minutes...");
                                sleep(300000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 minutes...");
                                sleep(180000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 minutes...");
                                sleep(105000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 15 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 14 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 13 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 12 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 11 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 10 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 9 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 8 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 7 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 6 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 5 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 4 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 3 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 2 seconds...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting in 1 second...");
                                sleep(1000);
                                Bukkit.broadcastMessage("§e" + "[SERVER] Server restarting...");
                                Bukkit.shutdown();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        });

                        t.start();
                    }
                }
            }

        }
    }
}
