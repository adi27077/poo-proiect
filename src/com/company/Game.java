package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static Game instance;
    private final HashMap<String, Pokemon> pokemons = new HashMap<>();
    private final HashMap<String, Item> items = new HashMap<>();

    private Game() {
    }

    public static Game getInstance() {
        if(instance == null)
            instance = new Game();
        return instance;
    }

    public void initializePokemons() {
        /*initializare neutrel1 si neutrel2*/
        Pokemon pokemon = new PokemonBuilder().withName("Neutrel1")
                .withHp(10).withNormalAtk(3).withSpecialAtk(0)
                .withDef(1).withSpecialDef(1).build();
        pokemons.put("Neutrel1", pokemon);

        pokemon = new PokemonBuilder().withName("Neutrel2")
                .withHp(20).withNormalAtk(4).withSpecialAtk(0)
                .withDef(1).withSpecialDef(1).build();
        pokemons.put("Neutrel2", pokemon);

        /*initializare ceilalti pokemoni*/
        try (BufferedReader br = new BufferedReader(new FileReader("pokemons.in"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                pokemon = new PokemonBuilder().withName(tokens[0])
                        .withHp(Integer.parseInt(tokens[1]))
                        .withNormalAtk(Integer.parseInt(tokens[2]))
                        .withSpecialAtk(Integer.parseInt(tokens[3]))
                        .withDef(Integer.parseInt(tokens[4]))
                        .withSpecialDef(Integer.parseInt(tokens[5]))
                        .withAbility1(new AbilityBuilder()
                                .withDmg(Integer.parseInt(tokens[6]))
                                .withStun(Boolean.parseBoolean(tokens[7]))
                                .withDodge(Boolean.parseBoolean(tokens[8]))
                                .withCd(Integer.parseInt(tokens[9]))
                                .build())
                        .withAbility2(new AbilityBuilder()
                                .withDmg(Integer.parseInt(tokens[10]))
                                .withStun(Boolean.parseBoolean(tokens[11]))
                                .withDodge(Boolean.parseBoolean(tokens[12]))
                                .withCd(Integer.parseInt(tokens[13]))
                                .build())
                        .build();
                pokemons.put(tokens[0], pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeItems() {
        ItemFactory itemFactory = ItemFactory.getInstance();
        items.put("Scut", itemFactory.createItem(ItemFactory.ItemType.Scut));
        items.put("Vestă", itemFactory.createItem(ItemFactory.ItemType.Vesta));
        items.put("Săbiuță", itemFactory.createItem(ItemFactory.ItemType.Sabiuta));
        items.put("Baghetă Magică", itemFactory.createItem(ItemFactory.ItemType.Bagheta));
        items.put("Vitamine", itemFactory.createItem(ItemFactory.ItemType.Vitamine));
        items.put("Brad de Crăciun", itemFactory.createItem(ItemFactory.ItemType.Brad));
        items.put("Pelerină", itemFactory.createItem(ItemFactory.ItemType.Pelerina));

    }

    public void listPokemons() {
        pokemons.forEach((key, value) -> System.out.println(value));
    }

    public void listItems() {
        items.forEach((key, value) -> System.out.println(value));
    }

    public void startGame() {
        File path = new File(".");
        File[] fileList = path.listFiles((dir, name) -> name.startsWith("Test"));
        BattleLogger bl = BattleLogger.getInstance();
        if(fileList != null) {
            for(File file : fileList) {
                try (Scanner sc = new Scanner(new FileReader(file))) {
                    String line, name, pokemon1, pokemon2, pokemon3;
                    String[] pokemonItems;
                    int age;
                    Trainer trainer1 = null, trainer2;
                    ArrayList<Item> itemList1 = new ArrayList<>();
                    ArrayList<Item> itemList2 = new ArrayList<>();
                    ArrayList<Item> itemList3 = new ArrayList<>();
                    line = sc.nextLine();
                    if(line.equals("Trainer 1:")) {
                        name = sc.next();
                        age = sc.nextInt();
                        pokemon1 = sc.next();
                        pokemon2 = sc.next();
                        pokemon3 = sc.next();
                        line = sc.nextLine();
                        while(!line.equals("Trainer 2:")) {
                            if (line.equals("Pokemon 1 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList1.add(items.get(itemName));
                                }
                            }
                            if (line.equals("Pokemon 2 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList2.add(items.get(itemName));
                                }
                            }
                            if (line.equals("Pokemon 3 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList3.add(items.get(itemName));
                                }
                            }
                            line = sc.nextLine();
                        }

                        trainer1 = new TrainerBuilder().withName(name)
                                .withAge(age)
                                .withPokemon1(pokemons.get(pokemon1).getClone())
                                .withPokemon2(pokemons.get(pokemon2).getClone())
                                .withPokemon3(pokemons.get(pokemon3).getClone())
                                .withItems1((itemList1.isEmpty()) ? null : itemList1.toArray(new Item[0]))
                                .withItems2((itemList2.isEmpty()) ? null : itemList2.toArray(new Item[0]))
                                .withItems3((itemList3.isEmpty()) ? null : itemList3.toArray(new Item[0]))
                                .build();

                    }

                    itemList1.clear();
                    itemList2.clear();
                    itemList3.clear();

                    if(line.equals("Trainer 2:")) {
                        name = sc.next();
                        age = sc.nextInt();
                        pokemon1 = sc.next();
                        pokemon2 = sc.next();
                        pokemon3 = sc.next();
                        line = sc.nextLine();
                        while(sc.hasNextLine()) {
                            if (line.equals("Pokemon 1 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList1.add(items.get(itemName));
                                }
                            }
                            if (line.equals("Pokemon 2 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList2.add(items.get(itemName));
                                }
                            }
                            if (line.equals("Pokemon 3 Items:")) {
                                line = sc.nextLine();
                                pokemonItems = line.split(", ");
                                for (String itemName : pokemonItems) {
                                    itemList3.add(items.get(itemName));
                                }
                            }
                            line = sc.nextLine();
                        }

                        trainer2 = new TrainerBuilder().withName(name)
                                .withAge(age)
                                .withPokemon1(pokemons.get(pokemon1).getClone())
                                .withPokemon2(pokemons.get(pokemon2).getClone())
                                .withPokemon3(pokemons.get(pokemon3).getClone())
                                .withItems1((itemList1.isEmpty()) ? null : itemList1.toArray(new Item[0]))
                                .withItems2((itemList2.isEmpty()) ? null : itemList2.toArray(new Item[0]))
                                .withItems3((itemList3.isEmpty()) ? null : itemList3.toArray(new Item[0]))
                                .build();

                        int logNo = Integer.parseInt(file.getName().replaceAll("[\\D]", ""));
                        bl.newLog("log" + logNo + ".txt", logNo);
                        bl.setLogToFile(true);
                        bl.setLogToSout(true);

                        Adventure adventure = new Adventure(trainer1, trainer2);
                        adventure.printAdventureInfo();
                        adventure.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Pokemon getNeutrel1() {
        return pokemons.get("Neutrel1").getClone();
    }

    public Pokemon getNeutrel2() {
        return pokemons.get("Neutrel2").getClone();
    }

}
