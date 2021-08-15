# Instructions are down in the text :

# This plugin use Spigot 1.16.3, Worlguard 7.0.4, WGRegionEvents 1.5

# Download all plugins Simply : https://mega.nz/folder/SVkSQTCA#aDL81tWO-TO9dUPi5rprXA

# - Right Click on a NPC which is already configured with the Citizen’s API for launching the quest. Dialogue line (modular) for all of the players in the region of x blocks  nearly the NPC. Then a general message (modular) is posted for all of the players in the dungeons (Worldguard region) -> execute once the first message ! Once the quest is launched, add a dialogue line when you right click on the npc. (As long as the quest is not finish)

# Appearance of a scoreboard for all the players in the dungeon (WorldGuard Region)
# Create a modular scoreboard :

# Line 1 : “Quête de Messis”
# Line 2 : “Liste des ingrédients.”
# Line 3 : Ingredient 1 + quantity
# Line 4 : Ingredient 2 + quantity
# Line 5 : Ingredient 3 + quantity

# Create a command for adding an ingredient 1 of 1. This command is placed for different ingredients (blocs) with the help of the Plugin : “Block CMD”. Block CMD execute the list # of the commands :

# Bloc command : Playsound
# Once : Broadcast in the dungeons to tell at all of the recuperation of an ingredient.
# Once : Execute the command for add an ingredient in the scoreboard (Command to develop)
# Once : Cut the bloc (autodelete)

# All of the parts of block CMD are develop, but all that's missing is "Execute the command for add an ingredient in the scoreboard”.

# If all ingredients are found -> Scoreboard is completed.

# Send a message for all Players in the Worldguard Region. This is the Final announcement. The NPC is a clickable renewal.The first person who clicks on the NPC ends the quest. The NPC gives a material. (modular) The NPC is lock (The Quest is not repeatable)

# Note : (Block CMD is setup for all places next the quantity)
