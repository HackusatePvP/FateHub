# FateHub

**Dependencies**
The plugin reqiures the following plugins and or api's.
*[Vault](https://dev.bukkit.org/projects/vault)*,
*[Lombok](https://projectlombok.org/download)*,
*[Azazel Tablist](https://github.com/bizarre/Azazel)*,
*[Assymble Scoreboard](https://github.com/ThatKawaiiSam/Assemble)*,
*EzQueue Bungee and Spigot (You must get these by your own means)*,

**Features**
*PlayerPop*,
*Enderbutts*,
*Cosmetics*,
*Scoreboard*,
*Tablist*,
*Server Selector*,
*Player Info*,
*Login/Registration system*,
*Profile Manager*.


**Configurations**

config.yml
```
DoubleJump:
  Multiplier: 6.0
```
cosmetic.yml
```
Test:
  Name: "&9&lTest &bCosmetic"
  Material: "PAPER"
  Lore:
    - ""
    - "&7&oDevelopment Item!"
    - ""
Fly:
  Name: "&9&lFly &b&lCosmetic"
  Material: "FEATHER"
  Lore:
    - ""
    - "&7&oFly with the wind!"
    - ""
Adventure:
  Name: "&9&lAdventure &b&lCosmetic"
  Material: "WOOD_SWORD"
  Lore:
    - ""
    - "&7&oTired of the queue"
    - "&7&ogo out build and explore"
    - ""
PlayerPop:
  Name: "&9&lPopper"
  Material: "GOLD_SWORD"
  Lore:
    - ""
    - "&7&oHit a player and pop them!"
    - ""
```
info.yml
```
Player:
  Lore:
    - "&7&m------------------------"
    - "&9&lName: &b%NAME%"
    - "&9&lUUID: &b%UUID%"
    - "&9&lID: &b%ID%"
    - ""
    - "&4&lPermissions/Punishments"
    - "&c&lRank: &7%RANK%"
    - "&c&lBanned: &7%BAN%"
    - "&c&lBlacklisted: &7%BLACKLIST%"
    - "&7&m------------------------"
```
scoreboard.yml
```
Board:
  Title: "&6&lDevelopment"
  Type:
    Register:
      - "&7&m--------------------"
      - ""
      - "&4&lRegistration:  "
      - " &cYou need to register "
      - "&cyour account before you"
      - "&ccan play on the server."
      - ""
      - "&c/register <pass> <pass>"
      - "&7&m--------------------"
    Login:
      - "&7&m--------------------"
      - ""
      - "&4&lLogin: "
      - "   &cYou need to login to"
      - "&cyour account before you "
      - "&ccan play on the server."
      - ""
      - "&c/login <pass>"
      - "&7&m--------------------"
    Queue:
      - "&7&m--------------------"
      - "&9&lPlayers: &c%ONLINE%/500"
      - "&9&lRank: &c%RANK%"
      - ""
      - "&9&l%QUEUE%: &c%POSITION%&f/&c%PLAYERSINQUEUE%"
      - ""
      - "&6&ofatekits.net"
      - "&7&m--------------------"
    Hub:
      - "&7&m--------------------"
      - "&9&lPlayers: &c%ONLINE%/500"
      - "&9&lRank: &c%RANK%"
      - ""
      - "&9&l%QUEUE%: &c%POSITION%&f/&c%PLAYERSINQUEUE%"
      - ""
      - "&6&ofatekits.net"
      - "&7&m--------------------"
```
server_data.yml
```
HCF:
  Name: "&9&lHCF"
  Material: "DIAMOND_SWORD"
  Status: "Offline"
  MaxPlayers: 120
  Lore:
    - "&7----------------------"
    - "&9Online: &c%online%&f/&c%hcfmaxplayers%"
    - "&9Queue: &c%hcfplayersinqueue%"
    - ""
    - "&9Map: &cI"
    - "&9MapKit: &cProt 2: Sharp: 2"
    - "&a&lSOTW was on 3/4/2019"
    - "&c&lEOTW was on 3/25/2019"
    - "&7----------------------"
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
KitPvP:
  Name: "&9&lKitPVP"
  Material: "DIAMOND_SWORD"
  Status: "Offline"
  MaxPlayers: 500
  Lore:
  - "&7----------------------"
  - "&9Online: &c%online%&f/&c%kitpvpmaxplayers%"
  - "&9Queue: &c%kitpvpplayersinqueue%"
  - ""
  - "&9Season: &cI"
  - "&a&lSeason starts on 3/4/2019"
  - "&c&lSeason ends on 3/4/2020"
  - "&7----------------------"
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
```
settings.yml
```
Tablist:
  Name: "&9&lTablist"
  Material: "PAINTING"
  Lore:
  - ""
  - "&b&lTab: %tabstatus%"
  - ""
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
Scoreboard:
  Name: "&9&lScoreboard"
  Material: "ITEM_FRAME"
  Lore:
  - ""
  - "&b&lScoreboard: %sstatus%"
  - ""
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
Vanish:
  Name: "&9&lVanish"
  Material: "POTION"
  Lore:
  - ""
  - "&b&lVisibility: %vanstatus%"
  - ""
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
DJ:
  Name: "&9&lDoubleJump"
  Material: "IRON_BOOTS"
  Lore:
  - ""
  - "&b&lDoubleJump: %djstatus%"
  - ""
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
Chat:
  Name: "&9&lChatting"
  Material: "PAPER"
  Lore:
  - ""
  - "&b&lChatting: %cstatus%"
  - ""
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
```
status.yml
```
HCF:
  Name: "&9&lHCF"
  Material: "DIAMOND_SWORD"
  MaxPlayers: 120
  Lore:
  - "&7&m----------------------"
  - "&b&lStatus: %hcfstatus%"
  - "&7&m----------------------"
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
KitPvP:
  Name: "&9&lKitPVP"
  Material: "DIAMOND_SWORD"
  Lore:
  - "&7&m----------------------"
  - "&b&lStatus: %kitstatus%"
  - "&7&m----------------------"
  Enchantment:
    Type: "DAMAGE_ALL"
    Level: 2
```
