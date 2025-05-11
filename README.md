# Despawn Range Configurable

A Minecraft Fabric mod that allows you to configure the despawn ranges for mob entities on fabric servers similar to Paper.

## Description

This mod allows servers to customize both the soft and hard despawn ranges for mobs in Minecraft. By default, Minecraft uses fixed values for when mobs start to despawn (soft despawn) and when they immediately despawn (hard despawn). This mod makes these values configurable.

## Features

- Configure the soft despawn range (the distance at which mobs have a chance to despawn)
- Configure the hard despawn range (the distance at which mobs immediately despawn)
- Simple configuration with no runtime overhead

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for the appropriate Minecraft version
2. Download the latest release of this mod from the [Releases page](https://github.com/your-username/Trotu-despawn-range-configurable/releases)
3. Place the downloaded JAR file in your mods folder
4. Launch Minecraft with the Fabric profile

## Configuration

The mod configuration is handled through the `despawnconfig.properties` config file located in the `/config` folder. Default values are:
- Soft despawn range: 32 blocks (vanilla default)
- Hard despawn range: 128 blocks (vanilla default)

You can modify these values in the config file that will be generated on first launch.

## Requirements

- Minecraft 1.21.5
- Fabric Loader 0.16.14
- Java 21

## License

This project is licensed under the MIT License - see the LICENSE file for details.