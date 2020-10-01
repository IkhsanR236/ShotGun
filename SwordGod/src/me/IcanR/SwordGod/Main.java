package me.IcanR.SwordGod;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	
	public List<String> list = new ArrayList<String>();
	
	@Override
	public void onEnable() {
		
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable( ) {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("combatsword")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "Sorry console masuk server untuk melakukanya.");
				return true;
			}
			Player player = (Player) sender;
			if (player.getInventory().firstEmpty() == -1) {
				// inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getItem());
				player.sendMessage(ChatColor.GOLD + "Equipment for fighting has been provided");
				return true;
			}
			player.getInventory().addItem(getItem());
			player.sendMessage(ChatColor.GOLD + "Equipment for fighting has been provided");
			return true;
		}
		return false;
	}
	
	
	public ItemStack getItem() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Legend Sword");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "The sword of the legendary hero");
		lore.add("");
		lore.add(ChatColor.translateAlternateColorCodes('&', "&7Throw a Fireball"));
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
		meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
		meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		item.setItemMeta(meta);
		
		
		return item;
	}

	@EventHandler()
	public void onClick(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD))
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				Player player = (Player) event.getPlayer();
				//Right click
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					player.launchProjectile(Fireball.class);
				}
				//Right click
				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					
				}
					if (!list.contains(player.getName()))
						list.add(player.getName());
					return;
					}
				}
	}













