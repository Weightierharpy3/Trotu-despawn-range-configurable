package org.trotu.despawnconfig;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DespawnConfig implements ModInitializer {
    public static final String MOD_ID = "despawnconfig";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private static final String CONFIG_FILE = "config/despawnconfig.properties";
    
    // Default vanilla values
    public static int softDespawnRange = 32;  // Default vanilla value
    public static int hardDespawnRange = 128; // Default vanilla value
    
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Despawn Range Config Mod");
        
        loadConfig();
        
        LOGGER.info("Despawn ranges configured - Soft: {}, Hard: {}", softDespawnRange, hardDespawnRange);
    }
    
    private void loadConfig() {
        File configDir = new File("config");
        if (!configDir.exists()) {
            configDir.mkdir();
        }
        
        File configFile = new File(CONFIG_FILE);
        Properties properties = new Properties();
        
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                properties.load(reader);
                
                // Load values from config, use defaults if not found
                softDespawnRange = Integer.parseInt(properties.getProperty("soft_despawn_range", "32"));
                hardDespawnRange = Integer.parseInt(properties.getProperty("hard_despawn_range", "128"));
            } catch (IOException | NumberFormatException e) {
                LOGGER.error("Error loading config file", e);
                createDefaultConfig(configFile);
            }
        } else {
            createDefaultConfig(configFile);
        }
    }
    
    private void createDefaultConfig(File configFile) {
        try (FileWriter writer = new FileWriter(configFile)) {
            Properties properties = new Properties();
            properties.setProperty("soft_despawn_range", String.valueOf(softDespawnRange));
            properties.setProperty("hard_despawn_range", String.valueOf(hardDespawnRange));
            
            properties.store(writer, "Despawn Range Configuration\n"
                    + "soft_despawn_range: Distance at which mobs have a random chance to despawn (vanilla default: 32)\n"
                    + "hard_despawn_range: Distance at which mobs always despawn instantly (vanilla default: 128)");
            
            LOGGER.info("Created default configuration file");
        } catch (IOException e) {
            LOGGER.error("Failed to create default config file", e);
        }
    }
}