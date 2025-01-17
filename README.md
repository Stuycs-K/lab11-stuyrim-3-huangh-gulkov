[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

##### Guide
Make a clear list of features that work/dont work:

- :white_check_mark: This feature works.

- :question: This feature works partially.

- :ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

- :x: This required feature does not work.

- :beetle: This is a bug that affects the game.

<br>

##### Actual Features

1. :white_check_mark: The Quiet Kid tested.
2. :white_check_mark: Young Karen tested.
3. :white_check_mark: Draw screen exists, but not tested
4. ✅: Boss class done;
5. ☑️: sparkles done
6. :white_check_mark: party member turn done
7. ✅: game loop done
8. ✅ end screen done


## Adventurer Subclasses
| Character Name | Starting HP | Attack            | Special Attack  | Support   | Points |
| -------------- | ----------- | ----------------- | --------------- | --------- | ------ |
|  :gun: Quiet Kid| 25 HP      | Silence (2 DMG)   | AK47 (5 DMG/mark) | Hoodie Up | Marks    |
|:lotion_bottle: Young Karen | 30 HP | HydroFlask (4 DMG) | Fury (10 DMG) | Perfume | Starbuck |
| :interrobang: Boss | 50 HP   |  WhackingLadle(5 (+5) DMG) | Morph (10 (+5) DMG) / Money (10 (+5) DMG)| Regen Health | Wage |


### The Kid in the Corner
+ Starts with 25 HP.
+ He attacks with his silence (2 DMG). For every time he attacks, he writes down the name of the one being attacked in his Death Note. Once the number of times reaches 3 (on any enemy), he automatically unleashes his special attack.
+ His special attack is him pulling out his hidden AK47 from his backpack and attacking all enemies, dealing damage based on the number of times he documented the enemies' name (5 DMG/time).
+ He supports himself through pulling up his hood and erasing himself from other's perception. In this status, he's untargetable. Last one round.
+ When he supports others, he deals 2 DMG to the target because he can not support others.

### The Young Karen
- Starts with 30 HP.
- She attacks by accidentally dropping her metal thermo on the ground, making a ruckus (4 DMG).
- Her special attack is getting her Starbucks/Pumpkin Spice Latte taken away, and she releases her fury on a random enemy (10 DMG). She must possesses a Starbuck drink in order for her to use this attack.
- She supports others by spraying perfume on herself, increasing the probability of herself getting attacked by enemies.
- She supports herself by buying herself a Starbucks drink. She can have at max 2 Starbucks.

### Boss: The Lady
- Starts with 50 HP.
- They attacks by whacking enemies with a ladle. (5 (+5) DMG)
- Her special attack is morphing into Mr. Moran and yell at kids. She also gains an extra-5-DMG buff, lasting one round. This move is automatically triggered when her wage reaches 0. (10 (+5) DMG).
- Her second special attack is if her wage is high enough, she buries the target adventurer under a pile of money.
- She doesn't support others because she's a boss.
- She supports herself by restoring 10 HP to herself.
