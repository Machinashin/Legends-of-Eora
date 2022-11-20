/*
Code by Gabriel St. Cyr

Created 10/28/22

Last Update: Saturday, October 29, 2022 9:39 PM

Description: Runs a short RPG game.

Problems: Fix illegal start of expression compiler error;

To do: Finish dunggeons 2 and 3; create more abilities; MORE ENEMIES AND EVENTS;

Ideas: Relics: Liar's Silver Tongue = You can see through deception, Fae Whetstone = gives you a chance to crit (10% probably); Bosses:,Boss 2 = Fae Queen,
Boss 3 = King of Thieves;
*/

import java.util.Scanner;
import java.util.Random;

public class eora {
  public static void main(String[] args) {
    int loop = 0;
    while (loop == 0) {
      loop = runGame();
    }
  }

  public static int runGame() {
    System.out.println("XX          XXXXXX      XXXXXX      XXXXXX      XX  XX      XXXX        XXXXXX");
    System.out.println("XX          XX          XX          XX          XXX XX      XX  XX      XX");
    System.out.println("XX          XXXX        XX X        XXXX        XXXXXX      XX  XX      XXXXXX");
    System.out.println("XX          XXXX        XX  XX      XXXX        XXXXXX      XX  XX      XXXXXX");
    System.out.println("XX          XX          XX  XX      XX          XX XXX      XX  XX          XX");
    System.out.println("XXXXXX      XXXXXX      XXXXXX      XXXXXX      XX  XX      XXXX        XXXXXX");
    System.out.println("\n");
    System.out.println("XXXXXX      XXXXXX            XXXXXX      XXXXXX      XXXXXX      XXXXXX  XX");
    System.out.println("XX  XX      XX                XX          XX  XX      XX  XX      XX  XX  XX");
    System.out.println("XX  XX      XXXX              XXXX        XX  XX      XXXXXX      XXXXXX  XX");
    System.out.println("XX  XX      XX                XXXX        XX  XX      XXX         XX  XX  XX");
    System.out.println("XX  XX      XX                XX          XX  XX      XX XX       XX  XX    ");
    System.out.println("XXXXXX      XX                XXXXXX      XXXXXX      XX  XX      XX  XX  XX");
    System.out.println("\n\nYou are a young townsperson, who is roving out to seek adventure, exploring the wonderful realm of Eora.");
    System.out.println("You set out on your long quest to acquire exploring fame.");
    System.console().readLine();
    int[][] arrays = new int[4][];
    arrays = dayLoop();
    int loop = runDeath(arrays);
    return loop;
  }

  public static int[][] dayLoop() {
    int[][] arrays = new int[4][];
    arrays[0] = new int[5];
    arrays[1] = new int[4];
    arrays[2] = new int[5];
    arrays[3] = new int[2];
    Random rand = new Random();
    //hp, str, money, weapon dmg, healing stones
    arrays[0][0] = 10;
    arrays[0][1] = 1;
    arrays[0][2] = 20;
    arrays[0][3] = 1;
    arrays[0][4] = 1;
    //philo stone, shield, whetsone, tongue
    arrays[1][0] = 0;
    arrays[1][1] = 0;
    arrays[1][2] = 0;
    arrays[1][3] = 0;
    //superuser, cost algorithm, death, day, specific enemy
    arrays[2][0] = 0;
    arrays[2][1] = 0;
    arrays[2][2] = 0;
    arrays[2][3] = 1;
    arrays[2][4] = -1;
    //dodge, faith
    arrays[3][0] = 0;
    arrays[3][1] = 0;
    for (int i = 0; i == 0; i = arrays[2][2]) {    //loops stat diplay and event rolls as long as death = 0
      System.out.println("========================================================================================================================");
      //System.out.println("========================================================================================================================");
      System.out.println("\nDAY: " + arrays[2][3]);    // ^^^ creates a divider between days
      System.out.println("\nHP: " + arrays[0][0]);    //stat diplay
      System.out.println("HEALING STONES: " + arrays[0][4]);
      System.out.println("STR: " + arrays[0][1]);
      System.out.println("DMG: " + (arrays[0][1] + arrays[0][3]));
      System.out.println("MONEY: " + arrays[0][2]);
      System.out.println("\nYou wake up and walk around.");
      System.out.println("");
      arrays = rollEvent(arrays);
      String debug = System.console().readLine();
      if (debug.equals("sudo")) {
        arrays[2][0]++;
      }
      int costRand = rand.nextInt(101) + 1;
      if (costRand > 50) {
        arrays[2][1]++;
      }
      if (arrays[2][2] > 0) {    //if arrays[2][2], the death stat, is not 0, trigger death
        arrays[2][2] = arrays[2][2];
      }
      arrays[2][3]++;
    }
    return arrays;
  }

  public static int runDeath(int[][] arrays) {
    String deathMsg = "";    //displays different messages based on the way someone dies
    switch (arrays[2][2]) {
      case -1: deathMsg = "debug";
      break;
      case 1: deathMsg = "Shouldn't have triggered that trap.";
      break;
      case 2: deathMsg = "It seems they were too strong for you.";
      break;
      case 3: deathMsg = "That was a nasty affliction.";
      break;
      case 4: deathMsg = "That was quite a clever deception";
      break;
      case 5: deathMsg = "You really should prepare more before fighting such a powerful enemy.";
      break;
      default: deathMsg = "You seem to have died in an entirely new way.";
      break;
    }
    System.out.println("\n========================================================================================================================");
    //System.out.println("========================================================================================================================");
    System.out.println("\nWell you're dead. " + deathMsg);
    System.out.println("\nYou reached day " + arrays[2][3] + ". I'm sure you'll do better next time.");
    System.out.println("\nGAME OVER!");
    System.out.println("\nPLAY AGAIN? (y/n)");
    String prompt = System.console().readLine();
    int loop = 0;
    if (prompt.equals("y")) {
      loop = loop;
    } else {
      loop++;
    }
    return loop;
  }

  public static int[][] rollEvent(int[][] arrays) {
    int hp = arrays[0][0];
    int str = arrays[0][1];
    int m = arrays[0][2];    //unpacks arrays passed in array
    int stones = arrays[0][4];
    Random rand = new Random();
    int event = rand.nextInt(12) + 1;
    switch (event) {
      case 1: System.out.println("After walking for a while, you notice a treasure chest.");    //runs the mimic event
              System.out.println("Do you open it? (y/n)");
              String prompt1 = System.console().readLine();    //takes user input
              if (prompt1.equals("y")) {
                System.out.println("You approach the chest. Just as you touch it, the top of the chest opens, bares fangs, and bites your hand.");
                System.out.println("\nYou lose 5 HP.");
                hp = hp - 5;
                if (hp <= 0) {
                  arrays[2][2] = 4;    //changes the death stat to the monster death
                }
              } else if (prompt1.equals("n")) {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 2: System.out.println("You don't see anything interesting today.\n\nJust the road in front of you.");
      break;    // ^^^ runs nothing event
      case 3: System.out.println("As you walk, you pass through a strange, red mist.");    //mist event
              if (hp < 4) {
                if (arrays[2][1] == 1) {
                  System.out.println("\nYou feel a sense of restoration.");
                  System.out.println("You gain 6 HP.");
                  hp += 6;
                } else {
                  hp += 3;
                  System.out.println("\nYou feel a sense of restfulness.");
                  System.out.println("You gain 3 HP.");
                }
              } else {
                hp--;
                System.out.println("\nYou leave the mist with an eerie feeling.");
                System.out.println("You lose 1 HP");
              }
      break;
      case 4: Random rand1 = new Random();
              String loot = "";
              String[] lootTable = new String[7];    //sets up the loot table
              lootTable[0] = "Sword";
              lootTable[1] = "Mace";
              lootTable[2] = "Whip";
              lootTable[3] = "Bow";
              lootTable[4] = "Axe";
              lootTable[5] = "Spear";
              lootTable[6] = "Staff";
              System.out.println("After walking for a while, you notice a treasure chest.");    //Shows you've found a chest
              System.out.println("Do you open it? (y/n)");
              String prompt2 = System.console().readLine();
              if (prompt2.equals("y")) {
                loot = lootTable[rand1.nextInt(7)];    //randomizes loot display. doesn't actually give the player a sword
                arrays[0][3] = (rand1.nextInt(4) + 1) + arrays[0][3];    //randomizes weapon dmg, the actually important part
                System.out.println("You open the chest and find a " + arrays[0][3] + " damage " + loot + ".");
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 5: Random rand2 = new Random();    //Runs merchant scenario
              String forSale = "";
              String prompt3 = "";
              String[] saleTable = new String[8];
              saleTable[0] = "Sword";
              saleTable[1] = "Mace";
              saleTable[2] = "Whip";
              saleTable[3] = "Bow";
              saleTable[4] = "Halberd";
              saleTable[5] = "Spear";
              saleTable[6] = "Staff";
              saleTable[7] = "Healing Stone";
              int item = rand2.nextInt(8);
              int dmg = arrays[0][3] + (rand2.nextInt(6) + 2);
              int cost = arrays[2][1] + (rand2.nextInt(10) + 5);
              System.out.println("As you are walking, you notice a man sitting by the road, selling something");
              System.out.println("You approach the man, and look at his item.");
              System.out.println("It is a " + saleTable[item] + ".");
              if (item == 7) {
                System.out.println("\nThis Healing Stone will restore an unknown amount of HP.");
              } else {
                System.out.println("\nThis is a " + dmg + " damage " + saleTable[item] + ".");
              }
              System.out.println("It costs " + cost + " coins.");
              System.out.println("\nWould you like to buy it? (y/n)");
              prompt3 = System.console().readLine();
              if (prompt3.equals("y")) {
                if (m >= cost) {
                  m = m - cost;
                  if (item == 7) {
                    System.out.println("You look down at your new Healing Stone, admiring the red sheen.");
                    stones++;
                  } else {
                    arrays[0][3] = dmg;
                  }
                } else {
                  System.out.println("\nYou don't have the money to buy this.\n\nYou walk away.");
                }
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 6: Random rand3 = new Random();    //Runs charlatan scenario
              int harm = rand3.nextInt(6) + arrays[2][1];
              int cost2 = harm;
              System.out.println("As you are walking, you notice a man sitting by the road, selling something");
              System.out.println("You approach the man, and look at his item.");    //near identical setup to merchant
              System.out.println("It is a Healing Stone.");
              System.out.println("\nThis Healing Stone will restore an unknown amount of HP.");
              System.out.println("It costs " + cost2 + " coins.");
              System.out.println("\nWould you like to buy it? (y/n)");
              prompt3 = System.console().readLine();
              if (prompt3.equals("y")) {
                if (m >= cost2) {
                  m = m - cost2;
                  System.out.println("You look down at your new...");
                  System.out.println("Upon closer inspection you realise it is a Cursed Stone.");
                  System.out.println("\nYou lose " + harm + " HP.");
                  hp = hp - harm;
                  if (hp <= 0) {
                    arrays[2][2] = 4;
                  }
                } else {
                  System.out.println("\nYou don't have the money to buy this.\n\nYou walk away.");
                }
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 7: System.out.println("You see a mysterious silhouette just off of the road.");
              System.out.println("\nApproach? (y/n)");
              String prompt4 = System.console().readLine();
              if (prompt4.equals("y")) {
                arrays = combat(arrays);
                hp--;
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 8: System.out.println("You see a mysterious silhouette just off of the road.\n\nApproach? (y/n)");
              String prompt5 = System.console().readLine();
              if (prompt5.equals("y")) {
                arrays = combat(arrays);
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 9: //System.out.println("You find an unfinished dungeon. A worker gives you a healing stone. Come back later and try again.");
              //stones++;
              String prompt6 = "";
              if (arrays[1][3] != 1) {
                System.out.println("Slightly away from the road, you spot an ominous building.\n\nApproach? (y/n)");
                prompt6 = System.console().readLine();
                if (prompt6.equals("y")) {
                  arrays = dungeon(arrays);
                } else {
                  System.out.println("You walk away.\n\nNothing else happens.");
                }
              } else {
                System.out.println("You see nothing today but an old, rotting shack in the distance.");
                System.out.println("Investigate? (y/n)");
                prompt6 = System.console().readLine();
                if (prompt6.equals("y")) {
                  System.out.println("Approaching the shack, you see someone through the window...");
                  arrays[2][4] = 2;
                  arrays = combat(arrays);
                } else {
                  System.out.println("You decide to continue on your way.");
                }
              }
      break;
      case 10: Random rand4 = new Random();    //Runs charlatan scenario
              int cost3 = rand4.nextInt(6) + arrays[2][1];
              System.out.println("As you are walking, you notice a man sitting by the road, selling something");
              System.out.println("You approach the man, and look at his item.");    //near identical setup to merchant
              System.out.println("It is a Healing Stone.");
              System.out.println("\nThis Healing Stone will restore an unknown amount of HP.");
              System.out.println("It costs " + cost3 + " coins.");
              System.out.println("\nWould you like to buy it? (y/n)");
              prompt3 = System.console().readLine();
              if (prompt3.equals("y")) {
                if (m >= cost3) {
                  m = m - cost3;
                  if ((rand4.nextInt(101) + 1) <= 5 && arrays[1][0] == 0) {
                    System.out.println("You look down at your new.... Wait.");
                    System.out.println("Upon closer inspection, you realize it's a Philosopher's Stone!");
                    System.out.println("Healing efficacy increased!");
                    arrays[2][1]++;
                  } else {
                    stones++;
                    System.out.println("You look down at your new Healing Stone, admiring the red sheen.");
                  }
                } else {
                  System.out.println("\nYou don't have the money to buy this.\n\nYou walk away.");
                }
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 11: System.out.println("You spend the day training.\n\nYou feel stronger. You feel rejuvenated.");
              hp += 2;
              str++;
      break;
      case 12: Random rand5 = new Random();
              System.out.println("You see a mysterious silhouette just off of the road.\n\nAproach? (y/n)");
              String prompt7 = System.console().readLine();
              int ifCont = (rand5.nextInt(100) + 1);
              if (prompt7.equals("y") && ifCont <= 15 && arrays[3][0] == 0) {
                System.out.println("In the shadow of a tree sits a lone Thief.");
                System.out.println("Your hand goes to your weapon, but the Thief doesn't move to attack you.");
                System.out.println("After striking up a conversation, the Thief offers to teach you how to Dodge.");
                System.out.println("You accept. After training for the rest of the day, you have mastered Dodging.");
                /*Systen.out.println("You are slightly bruised from the strenuous activity.");
                System.out.println("HP -1");
                hp--;*/
                System.out.println("\nNew Ability: Dodge! Gives you a 10% chance to avoid damage in combat.");
                arrays[3][0]++;
              } else if (prompt7.equals("y") && (ifCont > 15 || arrays[3][0] != 0)) {
                System.out.println("There is nobody there. Just your imagination playing tricks.");
                if ((rand5.nextInt(10) + 1) > 5) {
                  System.out.println("Just before leaving, you notice something sparkling in the dirt.");
                  if ((rand5.nextInt(3) + 1) > 2) {
                    System.out.println("After digging for a few moments, you find a Healing Stone.");
                    stones++;
                  } else {
                    System.out.println("After digging for a little while, you discover a " + (arrays[0][3]++) + " damage Dagger.");
                    System.out.println("Perhaps a Thief left it here by accident.");
                    arrays[0][3]++;
                  }
                }
              } else {
                System.out.println("You walk away.\n\nNothing else happens.");
              }
      break;
      case 13: Random rand6 = new Random();
              String prompt8 = "";
              int ifCont2 = (rand.nextInt(100) + 1);
              if (ifCont2 <= 15 && arrays[3][1] == 0) {
                System.out.println("As you are walking, you come across a shrine.");
                System.out.println("Pray? (y/n)");
                prompt8 = System.console().readLine();
                if (prompt8.equals("y")) {
                  System.out.println("You pray at the shrine.");
                  System.out.println("New Ability: Faith! Recover some health every 2 days.");
                  arrays[3][1]++;
                } else {
                  System.out.println("You walk away.\n\nNothing else happens.");
                }
              } else if (ifCont2 <= 15) {
                System.out.println("You come across a beautiful mural. It depicts a person that looks similar to you praying at a shrine. You feel refreshed.");
                System.out.println("\nHP +3");
                hp += 3;
              } else {
                System.out.println("You don't see anything today, just the road in front of you.");
              }
      default: System.out.println("this will never show up. hey wait a minute...");
      break;
    }
    arrays[0][0] = hp;
    arrays[0][1] = str;
    arrays[0][2] = m;
    arrays[0][4] = stones;
    return arrays;
  }

  public static int[][] combat(int[][] arrays) {
    Random rand = new Random();
    int hp = arrays[0][0];
    int dmg = arrays[0][1] + arrays[0][3];
    int m = arrays[0][2];
    int hs = arrays[0][4];
    int blocking = 0;
    int stun = 0;
    int i = 0;
    if (arrays[2][4] > 0) {
      i = arrays[2][4];
    } else {
      i = rand.nextInt(4);
    }
    String[] enemyTable = new String[5];
    enemyTable[0] = "Troll";
    enemyTable[1] = "Giant Spider";
    enemyTable[2] = "Thief";
    enemyTable[3] = "Slime";
    enemyTable[4] = "Possessed Armor";
    String enemy = "";
    if (arrays[2][4] < 0) {
      enemy = enemyTable[i];
    } else {
      enemy = enemyTable[arrays[2][4]];
      arrays[2][4] = -1;
    }
    int[] eStats = new int[4];    //index 0 = health, index 1 = dmg, index 2 = stolen gold, index 3 = run
    String prompt = "";
    eStats[2] = 0; eStats[3] = 0;
    if (i == 0) {
      eStats[0] = 30;
      eStats[1] = 5;
    } else if (i == 1) {
      eStats[0] = 20;
      eStats[1] = 3;
    } else if (i == 2) {
      eStats[0] = 15;
      eStats[1] = 3;
    } else if (i == 3) {
      eStats[0] = 40;
      eStats[1] = 1;
    } else if (i == 4) {
      eStats[0] = 30;
      eStats[1] = 4;
    }
    System.out.println("It's a " + enemy + "!");
    while (eStats[0] > 0 && hp > 0 && eStats[3] == 0) {    //battle loop
      blocking = 0;
      for (int j = 0; j == 0; j = j) {    //Player turn
        System.out.println("\n========================================================================================================================");
        System.out.println("\nHP: " + hp + "\nDMG: " + dmg + "\nHEALING STONES: " + hs);    //displays arrays
        System.out.println("\n" + enemy + ": " + eStats[0] + " HP");
        if (arrays[1][1] == 1 || arrays[2][0] == 1) {
          System.out.println("\n\nAttack, Heal, or Block? (1, 2, or 3)");
        } else {
          System.out.println("\n\nAttack or Heal? (1 or 2)");    //prompts to move
        }
        prompt = System.console().readLine();
        if (prompt.equals("1")) {
          System.out.println("You attack the " + enemy + ".");    //subtracts dmg stat from enemy health
          if (arrays[1][2] == 1) {
            eStats[0] -= dmg*2;
            System.out.println("You land a critical hit.");
          } else {
            eStats[0] -= dmg;
          }
          j++;
        } else if (prompt.equals("2")) {
          System.out.println("You use a Healing Stone.");
          if (hs > 0) {
            if (arrays[1][0] == 1) {
              hp += (rand.nextInt(7) + 2);
              hs--;
              j++;
            } else {
              hp += (rand.nextInt(4) + 1);
              hs--;
              j++;
            }
          } else {
            System.out.println("You do not have any Healing Stones.");
          }
        } else if (prompt.equals("3") && (arrays[1][1] == 1 || arrays[2][0] == 1)) {
          System.out.println("You raise you shield to block the incoming attack.");
          blocking++;
          j++;
        } else {
          System.out.println("That is not an acceptable move.");
        }
        if (stun > 0) {
          stun--;
        }
      }
      if (eStats[0] > 0 && stun == 0) {
        if (i == 2 && m >= 4 && rand.nextInt(101) >= 50) {
          System.out.println("The Thief quickly strikes, stealing 4 coins");
          eStats[2] += 4;
          System.out.println("The Thief will run next turn.");
        } else if (i == 2 && eStats[2] != 0) {
          eStats[3]++;
        } else {
          System.out.println("\n\nThe " + enemy + " attacks for " + eStats[1] + " damage.");    //enemy turn
          if (arrays[3][0] == 1 && rand.nextInt(100) + 1 <= 10) {
            System.out.println("You take this as an oppurtunity to skillfully Dodge, avoiding all damage.");
          } else if (blocking == 1) {
            System.out.println("\nYou block against " + eStats[1] + " damage.");
            if (eStats[1] <= 5) {
              System.out.println("You take no damage.");
            } else {
              System.out.println("You take " + (eStats[1] - 10) + " damage.");
              hp -= (eStats[1] - 10);
            }
            if ((rand.nextInt(100) + 1) <= 33) {
              stun += 2;
              System.out.println("You stun the enemy for 2 turns.");
            }
          } else {
            hp -= eStats[1];
          }
        }
      } else {
        System.out.println("\nYou defeated the " + enemy + ".");
      }
      if (hp <= 0) {
        arrays[2][2] = 2;
      } else if (eStats[0] <= 0) {
        int mLoot = (rand.nextInt(10) + 3);
        System.out.println("The " + enemy + " was carrying " + (mLoot + eStats[2]) + " coins and 1 Healing Stone.");
        m = mLoot + m;
        hs++;
      } else if (eStats[3] == 1) {
        System.out.println("Thief ran away, taking your coins with it.");
      }
    }
    arrays[0][0] = hp;
    arrays[0][2] = m;
    arrays[0][4] = hs;
    return arrays;
  }

  public static int[][] dungeon(int[][] arrays) {
    Random rand = new Random();
    int hp = arrays[0][0];
    int str = arrays[0][1];
    int m = arrays[0][2];
    int dmg = arrays[0][3] + arrays[0][1];
    int hs = arrays[0][4];
    System.out.println("\n========================================================================================================================");
    if (arrays[1][1] == 0) {
      System.out.println("As you get closer, you notice that the building is an old castle. Perhaps some of the guards are still around...");
      System.out.println("Inside the first room, you here a clanking noise...");
      arrays[2][4] = 4;
      arrays = combat(arrays);
      System.out.println("In the second room on a pedestal lies a pristine " + (dmg + 2) + " damage Shortsword.");
      arrays[0][3] = arrays[0][3] + 2;
      System.out.println("Moving on to the second room, you once again hear the dreaded clanking sound...");
      arrays[2][4] = 4;
      arrays = combat(arrays);
      System.out.println("In the fourth room, you find a atrium with a fountain. You spend a while relaxing.");
      System.out.println("\nHP +10");
      hp = hp + 10;
      System.out.println("You enter the fifth and final room. As you step inside, the doors slam shut behind you.");
      System.out.println("In the center of the room is a glowing purple crystal.");
      System.out.println("\"Ah, so someone finally comes to this castle lost in time, to pay respects to their king,\" you here a voice say...");
      arrays[2][4] = 0;
      arrays = boss(arrays);
      System.out.println("\nJust before you leave the dungeon, you notice an old, ornate shield on the wall.");
      System.out.println("It must have been the king's. You take the shield, taking note of the elaborate depiction of the sun.");
      System.out.println("\nNew Artifact: Solar Shield! You can now block damage in combat, and blocking has a 33% chance to stun the enemy.");
      arrays[1][1]++;
    } else if (arrays[1][1] == 1) {

    } else if (arrays[1][2] == 1) {

    } else {

    }
    arrays[0][0] = hp;
    arrays[0][1] = str;
    arrays[0][2] = m;
    arrays[0][4] = hs;
    return arrays;
  }

  public static int[][] boss(int[][] arrays) {
    Random rand = new Random();
    int hp = arrays[0][0];
    int str = arrays[0][1];
    int m = arrays[0][2];
    int dmg = arrays[0][3] + arrays[0][1];
    int hs = arrays[0][4];
    int[] eStats = new int[3];
    String prompt = "";
    if (arrays[2][4] == 0) {
      System.out.println("Out of the crystal comes a violet, phantasmal projection. You can see it begin to solidify into a skeletal form.");
      System.out.println("It's a Lich!");
      System.out.println("Break the phylactery to kill the Lich King!");
      eStats[0] = 75;
      eStats[1] = 7;
      while (eStats[0] > 0 && hp > 0) {
        for (int j = 0; j == 0; j = j) {
          System.out.println("\n========================================================================================================================");
          System.out.println("\nHP: " + hp + "\nDMG: " + dmg + "\nHEALING STONES: " + hs);
          System.out.println("\nLich: " + eStats[0] + " HP");
          System.out.println("\n\nAttack or Heal? (1 or 2)");
          prompt = System.console().readLine();
          if (prompt.equals("1")) {
            System.out.println("You attack the Lich.");
            eStats[0] -= dmg;
            j++;
          } else if (prompt.equals("2")) {
            System.out.println("You use a Healing Stone.");
            if (hs > 0) {
              if (arrays[1][0] == 1) {
                hp += (rand.nextInt(7) + 2);
                hs--;
                j++;
              } else {
                hp += (rand.nextInt(4) + 1);
                hs--;
                j++;
              }
            } else {
              System.out.println("You do not have any Healing Stones.");
            }
          } else {
            System.out.println("That is not an acceptable move.");
          }
        }
        if (eStats[0] > 0) {
          System.out.println("\n\nThe Lich attacks for " + eStats[1] + " damage.");
          if (arrays[3][0] == 1 && rand.nextInt(100) + 1 <= 10) {
            System.out.println("You take an oppurtunity to skillfully Dodge, avoiding all damage.");
          } else {
            hp -= eStats[1];
          }
        }
      }
      if (hp <= 0) {
        arrays[2][2] = 5;
      } else if (eStats[0] <= 0) {
        System.out.println("Congratulations, you defeated the Lich King!");
      }
    } else if (arrays[2][4] == 1) {
    } else if (arrays[2][4] == 2) {
    } else {
      System.out.println("boss debug");
    }
    arrays[0][0] = hp;
    arrays[0][1] = str;
    arrays[0][2] = m;
    arrays[0][4] = hs;
    return arrays;
  }
}
