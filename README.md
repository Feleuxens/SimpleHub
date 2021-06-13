# SimpleHub
A simple hub plugin for Spigot/Bukkit servers.

## Commands
- hub (Teleports player to hub after 3 seconds)
- sethub (Sets hub coordinates from current player position)
- clearhub (Clears hub if one is set)

## Installation
Download [SimpleHub-1.16.5-1.0-SNAPSHOT.jar](https://github.com/feleuxens/SimpleHub/releases/latest/download/SimpleHub-1.16.5-1.0-SNAPSHOT.jar) and 
drop it into the plugins folder of your Spigot/Bukkit server.

Releases are named after the scheme SimpleHub-[Minecraft-Version]-[Plugin-Version].jar

## Development
This project uses Maven. To import it clone the repository and in your ide select import Maven Project.

### Requirements
Up to version 1.16.5 Minecraft uses Java 8. For best compatibility this plugin is build with Java 8 as well.

### Building
To build the .jar file use maven's package phase.
```
mvn package -f pom.xml
```
