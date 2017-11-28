# Dungeon-Builder
Generates a custom format file that describes a dungeon structure to generate in a Minecraft map.

# How to use this project ?
To generate the structure in a Minecraft world, you will need to use filters in MCEdit (http://www.mcedit.net/). MCEdit allows the user to do all kind of stuff in a Minecraft world given a python script called a filter.
This little java application just generates an MCEdit filter in the MCEdit folder, and this filter will generate a structure in your Minecraft world when applying it. You may have to change the path specified in Main.java.

# WIP
This is work in progress. The generated structure only includes rooms connected with corridors, and they are all made of stone blocks.

# TODO
The result is pretty basic at the moment, but it would be relevant to have :
- auto generated piston doors
- auto generated mob spawners and enigmas
- auto generated decoration and ambience (music and look according to a theme)
- auto generated looked doors and various key systems to introduce a progression mechanic in the dungeon
- auto generated loot chests
- gestion of difficulty (increasing the right way)

# Author
Emmanuel aka Exifers
This project is kind of old though.
