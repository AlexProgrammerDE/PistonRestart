package me.alexprogrammerde.pistonrestart;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class PistonRestart extends JavaPlugin implements Listener {
    private boolean restartTimerDone = false;
    private boolean playersLow = false;

    public void onEnable() {
        Logger log = getLogger();

        log.info(ChatColor.GOLD + "Loading config");
        saveDefaultConfig();

        log.info(ChatColor.GOLD + "Registering listeners");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        int hour = getConfig().getInt("Hour");
        int minutes = getConfig().getInt("Minute");
        int seconds = getConfig().getInt("Seconds");

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(getConfig().getString("Timezone")));
        ZonedDateTime nextRun = now.withHour(hour).withMinute(minutes).withSecond(seconds);

        if (now.compareTo(nextRun) > 0)
            nextRun = nextRun.plusDays(1);

        Duration duration = Duration.between(now, nextRun);
        long initialDelay = duration.getSeconds();

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            Thread t = new Thread(() -> {
                try {
                    restartTimerDone = true;

                    if (Bukkit.getServer().getOnlinePlayers().size() >= getConfig().getInt("MinimumPlayersToRestart")) {
                        sleep(432000000);
                    }

                    restart();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            t.start();
        }, initialDelay, TimeUnit.DAYS.toSeconds(1), TimeUnit.SECONDS);

        log.info(ChatColor.GOLD + "Loading metrics");
        new Metrics(this, 8987);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent evt){
        int count = Bukkit.getServer().getOnlinePlayers().size();

        if (restartTimerDone) {
            if (count == 0){
                Bukkit.shutdown();
            } else {
                if (!playersLow){
                    if (count < getConfig().getInt("MinimumPlayersToRestart")){
                        Thread t = new Thread(() -> {
                            try {
                                playersLow = true;
                                restart();
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

    public void restart() throws InterruptedException {
        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 15 minutes...");
        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 15 minutes...");
        sleep(300 * 1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 10 minutes...");
        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 10 minutes...");
        sleep(300 * 1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 5 minutes...");
        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 5 minutes...");
        sleep(180 * 1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 2 minutes...");
        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 2 minutes...");
        sleep(105 * 1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 15 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 14 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 13 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 12 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 11 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 10 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 9 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 8 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 7 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 6 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 5 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 4 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 3 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 2 seconds...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting in 1 second...");
        sleep(1000);

        Bukkit.broadcastMessage(ChatColor.YELLOW + "[SERVER] Server restarting...");

        Bukkit.shutdown();
    }
}
